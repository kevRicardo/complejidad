package com.fciencias.complejidad.entity;

import java.util.Arrays;
import java.util.List;

public class Clausula {
	
	private Literal[] literales = new Literal[3];

	public Clausula() {}
	
	public Clausula(Literal[] literales) {
		this.literales = literales;
	}
	
	public boolean procesaClausula() {
		boolean valor = false;
		for (Literal l : literales)
			valor = valor || l.isValor();
		return valor;
	}
	
	public static boolean SAT(List<Clausula> clausulas) {
		boolean sat = true;
		for (Clausula c : clausulas)
			sat = sat && c.procesaClausula();
		return sat;
	}

	public Literal[] getLiterales() {
		return literales;
	}

	public void setLiterales(Literal[] literales) {
		this.literales = literales;
	}

	@Override
	public String toString() {
		return "Clausula [literales=" + Arrays.toString(literales) + "]";
	}
}