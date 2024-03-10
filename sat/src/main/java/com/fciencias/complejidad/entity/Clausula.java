package com.fciencias.complejidad.entity;

import java.util.Arrays;
import java.util.List;

/**
 * Clase que simula una clausula
 * 
 * @author Villegas Salvador Kevin Ricardo
 */
public class Clausula {
	
	private Literal[] literales = new Literal[3];

	/**
	 * Constructor sin paámetros
	 */
	public Clausula() {}
	
	/**
	 * Constructor para una clausula
	 * 
	 * @param literales Las literales que conforman una clausula
	 */
	public Clausula(Literal[] literales) {
		this.literales = literales;
	}
	
	/**
	 * Valida las literales de una clausula
	 * 
	 * @return True si al validar las literales de la clausula son satisfacibles, False en otro caso
	 */
	public boolean procesaClausula() {
		boolean valor = false;
		for (Literal l : literales)
			valor = valor || l.isValor();
		return valor;
	}
	
	/**
	 * Valida si una clausula es 3SAT
	 * 
	 * @param clausulas Las clausulas que conforman la fórmula
	 * @return True si es 3SAT, False en otro caso
	 */
	public static boolean SAT(List<Clausula> clausulas) {
		boolean sat = true;
		for (Clausula c : clausulas)
			sat = sat && c.procesaClausula();
		return sat;
	}

	/**
	 * Obtiene la lista de literales que conforman una clausula
	 * 
	 * @return la lista de literales de la clausula
	 */
	public Literal[] getLiterales() {
		return literales;
	}

	/**
	 * Modifica la lista de literales de la clausula
	 * 
	 * @param literales La nueva lista de literales
	 */
	public void setLiterales(Literal[] literales) {
		this.literales = literales;
	}

	@Override
	public String toString() {
		return "Clausula [literales=" + Arrays.toString(literales) + "]";
	}
}