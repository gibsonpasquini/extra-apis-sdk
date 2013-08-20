package br.com.extra.api.resources;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import org.codehaus.jackson.map.ObjectMapper;

import br.com.extra.api.core.AppToken;
import br.com.extra.api.core.AuthToken;
import br.com.extra.api.core.CoreAPIImpl;
import br.com.extra.api.core.Hosts;
import br.com.extra.api.core.exception.ServiceDataManipulationException;
import br.com.extra.api.core.exception.ServiceException;
import br.com.extra.api.pojo.loads.LoadConfirmation;
import br.com.extra.api.pojo.loads.LoadResponse;
import br.com.extra.api.pojo.loads.ProductLoad;
import br.com.extra.api.pojo.loads.ProductLoadResponse;
import br.com.extra.api.utils.Utils;

import com.sun.jersey.api.client.ClientResponse;

/**
 * 
 * ExtraAPI-SDK - Loads.java
 * 
 * Implementação do Serviço Restful /loads.
 * 
 * Serviço que possibilita ao lojista realizar cargas.
 * 
 * @author Gibson Pasquini Nascimento
 * 
 *         17/07/2013
 */
public class Loads extends CoreAPIImpl<ProductLoad> implements LoadsResource {

	/**
	 * Construtor que instancia um objeto do serviço que consome a API /loads.
	 * 
	 * @param host
	 *            Host do serviço.
	 * @param appToken
	 *            Token de Aplicação.
	 * @param authToken
	 *            Token de Autenticação.
	 */
	public Loads(Hosts host, AppToken appToken, AuthToken authToken) {
		super(host, appToken, authToken);
	}

	/**
	 * Método utilizado para comprimir o conteúdo do request.
	 * 
	 * O conteúdo pode ser um arquivo JSON ou uma String que contém o JSON.
	 * 
	 * @param products
	 *            Objeto que contém o arquivo JSON ou a String que deverá ser
	 *            compactada.
	 * @return Array de bytes compactado.
	 * @throws IOException
	 *             Exceção lançada caso haja algum problema na compactação do
	 *             conteúdo.
	 * @throws ServiceDataManipulationException
	 *             Exceção lançada caso haja problemas na mapipulação das
	 *             informações.
	 */
	private byte[] compress(ProductLoad products) throws IOException,
			ServiceDataManipulationException {
		// Array de bytes que será enviado para o serviço
		byte[] compressedByteArray = null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			GZIPOutputStream gzos = new GZIPOutputStream(baos);
			byte[] bytesToCompress = null;

			// Tratamento para compactar o arquivo JSON
			if (!Utils.isEmpty(products.getJsonFile())) {
				bytesToCompress = getBytesFromFile(products.getJsonFile());
			} else if (!Utils.isEmpty(products.getProductsJson())) {
				bytesToCompress = products.getProductsJson().getBytes();
				// Lançamento de Exceção caso não seja enviado nem o arquivo nem
				// a String.
			} else {
				throw new ServiceDataManipulationException(
						"Error while trying gziping content. There is no content to be compressed.");
			}

			// Compactação do Array de Bytes
			gzos.write(bytesToCompress);

			gzos.finish();
			gzos.close();

			// Recuperação do Array de Bytes
			compressedByteArray = baos.toByteArray();
			baos.close();

		} catch (IOException e) {
			throw e;
		}
		return compressedByteArray;
	}

	private byte[] getBytesFromFile(File file) throws FileNotFoundException,
			IOException {
		byte[] bytesToCompress;
		// Criação do InputStream do Arquivo
		FileInputStream stream = new FileInputStream(file);
		byte[] buffer = new byte[8192];
		int bytesRead;
		// Conversão do arquivo em um Array de Bytes para ser compactado
		// via GZip
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		while ((bytesRead = stream.read(buffer)) != -1) {
			output.write(buffer, 0, bytesRead);
		}
		bytesToCompress = output.toByteArray();
		// Tratamento para compactar a String que contém o JSON
		return bytesToCompress;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<ProductLoad> getPojoClass() {
		return ProductLoad.class;
	}

	/**
	 * {@inheritDoc}
	 */
	public LoadResponse getLoadStatus(String importerInfoId)
			throws ServiceException {
		if (!Utils.isEmpty(importerInfoId)) {
			setResource("/loads/products/" + importerInfoId);
		} else {
			throw new ServiceException(
					"Parameters importerInfoId is mandatory.");
		}

		ClientResponse response = get();

		LoadResponse loadStatus = null;
		if (response.getStatus() == ClientResponse.Status.OK.getStatusCode()) {
			try {
				loadStatus = new ObjectMapper().readValue(
						response.getEntityInputStream(), LoadResponse.class);
			} catch (IOException e) {
				throw new ServiceDataManipulationException(
						"Error handling response. ", e);
			}
		}

		return loadStatus;
	}

	/**
	 * {@inheritDoc}
	 */
	public ProductLoadResponse getProductLoadStatus(String importerInfoId,
			String skuOrigin) throws ServiceException {

		if (!Utils.isEmpty(importerInfoId) && !Utils.isEmpty(skuOrigin)) {
			setResource("/loads/products/" + importerInfoId + "/" + skuOrigin);
		} else {
			throw new ServiceException(
					"Parameters importerInfoId and skuOrigin are mandatories.");
		}

		ClientResponse response = get();

		ProductLoadResponse productStatus = null;
		if (response.getStatus() == ClientResponse.Status.OK.getStatusCode()) {
			try {
				productStatus = new ObjectMapper().readValue(
						response.getEntityInputStream(),
						ProductLoadResponse.class);
			} catch (IOException e) {
				throw new ServiceException("Error handling response. ", e);
			}
		}

		return productStatus;
	}

	/**
	 * {@inheritDoc}
	 */
	public LoadConfirmation loadProducts(ProductLoad products)
			throws ServiceException {

		setResource("/loads/products");

		byte[] compressedByteArray;
		try {
			if (!Utils.isEmpty(products.getGzFile())) {
				compressedByteArray = getBytesFromFile(products.getGzFile());
			} else {
				compressedByteArray = compress(products);
			}
		} catch (IOException e1) {
			throw new ServiceException("Error while trying compact content.",
					e1);
		}

		ClientResponse response = setMediaType("application/gzip").post(
				compressedByteArray);

		if (response.getStatus() != ClientResponse.Status.CREATED
				.getStatusCode()) {
			throw errorHandler(response,
					"Error on your request. " + response.toString());
		}

		LoadConfirmation load = new LoadConfirmation();
		load.setLocation(response.getLocation().toString());
		return load;
	}
}
