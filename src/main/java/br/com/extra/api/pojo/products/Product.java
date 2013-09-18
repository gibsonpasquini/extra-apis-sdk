package br.com.extra.api.pojo.products;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import br.com.extra.api.pojo.Pojos;

public class Product extends Pojos {

	private static final long serialVersionUID = 3360690043290012739L;

	private String skuId;

	private String skuIdOrigin;

	private String prodId;

	private String sellingTitle;

	private String description;

	private String[] GTIN;

	private String ISBN;

	private double defaultPrice;

	private double salePrice;

	private List<ProductUDA> productUdaList;

	private int[] levelIdList;

	private double weight;

	private double length;

	private double width;

	private double height;

	private String variantName;

	private int handlingTime;

	private String installmentId;

	private Media media;

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getSellingTitle() {
		return sellingTitle;
	}

	public void setSellingTitle(String sellingTitle) {
		this.sellingTitle = sellingTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getGTIN() {
		return GTIN;
	}

	public void setGTIN(String[] gTIN) {
		GTIN = gTIN;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public double getDefaultPrice() {
		return defaultPrice;
	}

	public void setDefaultPrice(double defaultPrice) {
		this.defaultPrice = defaultPrice;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public List<ProductUDA> getProductUdaList() {
		return productUdaList;
	}

	public void setProductUdaList(List<ProductUDA> productUdaList) {
		this.productUdaList = productUdaList;
	}

	public int[] getLevelIdList() {
		return levelIdList;
	}

	public void setLevelIdList(int[] levelIdList) {
		this.levelIdList = levelIdList;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getVariantName() {
		return variantName;
	}

	public void setVariantName(String variantName) {
		this.variantName = variantName;
	}

	public int getHandlingTime() {
		return handlingTime;
	}

	public void setHandlingTime(int handlingTime) {
		this.handlingTime = handlingTime;
	}

	public String getInstallmentId() {
		return installmentId;
	}

	public void setInstallmentId(String installmentId) {
		this.installmentId = installmentId;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public String getSkuIdOrigin() {
		return skuIdOrigin;
	}

	public void setSkuIdOrigin(String skuIdOrigin) {
		this.skuIdOrigin = skuIdOrigin;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
