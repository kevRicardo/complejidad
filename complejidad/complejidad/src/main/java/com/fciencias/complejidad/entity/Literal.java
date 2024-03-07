package com.fciencias.complejidad.entity;

public class Literal {

	private String name;
	private boolean valor;
	
	public Literal(String name, boolean valor) {
		this.name = name;
		this.valor = valor;
	}
	
	public Literal() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isValor() {
		return valor;
	}

	public void setValor(boolean valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Literal [name = " + name + ", valor = " + valor + "]";
	}
	
}