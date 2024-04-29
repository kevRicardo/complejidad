package com.fciencias.complejidad.entity;

/**
 * Clase que simula una literal
 * 
 * @author Villegas Salvador Kevin Ricardo
 */
public class Literal {

	private String name;
	private boolean valor;
	
	/**
	 * Constructor sin paámetros
	 */
	public Literal() {}
	
	/**
	 * Constructor para una literal
	 * 
	 * @param name El nombre de la literal
	 * @param valor El valor de verdad de la literal
	 */
	public Literal(String name, boolean valor) {
		this.name = name;
		this.valor = valor;
	}

	/**
	 * Obtiene el nombre de una literal
	 * 
	 * @return El nombre de una lteral
	 */
	public String getName() {
		return name;
	}

	/**
	 * Modifica el nombre de la literal
	 * 
	 * @param name El nuevo nombre
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Obtiene el valor de la literal
	 * 
	 * @return El valor de la literal
	 */
	public boolean isValor() {
		return valor;
	}

	/**
	 * Modifica el valor de la literal 
	 * 
	 * @param valor El nuevo valor de verdad de la literal
	 */
	public void setValor(boolean valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Literal [name = " + name + ", valor = " + valor + "]";
	}
	
}