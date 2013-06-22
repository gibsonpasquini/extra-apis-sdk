package br.com.extra.api.utils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 
 * ExtraAPI-SDK - Utils.java
 * 
 * Classe com métodos utilitários.
 * 
 * @author Gibson Pasquini Nascimento
 * 
 *         22/06/2013
 */
public abstract class Utils {

	/**
	 * Validador de campo vazio.
	 * 
	 * @param param
	 *            Parâmetro para validação
	 * @return <boolean> Vazio ou não.
	 */
	public static boolean isEmpty(final Object param) {
		if (param == null) {
			return true;
		} else if (param instanceof String) {
			return param == null || ((String) param).isEmpty();
		} else if (param instanceof BigDecimal) {
			return param == null;
		} else if (param instanceof Integer) {
			return param == null;
		} else if (param instanceof Double) {
			return param == null;
		} else if (param instanceof Date) {
			return param == null;
		} else if (param instanceof List) {
			return param == null || ((List<?>) param).isEmpty();
		}
		return false;
	}
}
