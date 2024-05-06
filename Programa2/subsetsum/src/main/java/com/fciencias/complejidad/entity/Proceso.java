package com.fciencias.complejidad.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Procesos para el subset sum
 * 
 * @author Villegas Salvador Kevin Ricardo
 */
public class Proceso {
	
	private int suma;
	private List<Integer> conjunto = new ArrayList<>();

	public int exactSubsetSum(int[] conjunto, int t) {
		int n = conjunto.length;
		List<Integer> lista0 = new ArrayList<>();
		lista0.add(0);
		
		for(int i = 1; i <= n; i++) {
			List<Integer> listai = ordena(lista0, agregaSuma(lista0, conjunto[i - 1]));
			lista0 = eliminaMasGrande(listai, t);
		}
		
		lista0 = lista0.stream().distinct().collect(Collectors.toList());
		return Collections.max(lista0);
	}
	
	// Ordena la integración de dos listas
	private List<Integer> ordena(List<Integer> x, List<Integer> y) {
		List<Integer> resultado = new ArrayList<>(x);
		resultado.addAll(y);
		Collections.sort(resultado);
		return resultado;
	}
	
	// Suma un entero e a una lista de elementos
	private List<Integer> agregaSuma(List<Integer> lista, int e) {
		List<Integer> resultado = new ArrayList<>(lista);
		for(int i : lista)
			resultado.add(i + e);
		return resultado;
	}
	
	// Elimina los elementos de una lista que sean mas grandes que t
	private List<Integer> eliminaMasGrande(List<Integer> lista, int t) {
		List<Integer> l = new ArrayList<>();
		for (int i : lista)
			if (i <= t)
				l.add(i);
		return l;
	}
	
	// Eliminación de elementos según a una delta, para ver la precisión de la suma
	public List<Integer> trim(List<Integer> lista, double delta) {
		List<Integer> resultado = new ArrayList<>();
		if(lista.size() > 0) {
			resultado.add(lista.get(0));
			int last = lista.get(0);
			for(int i = 1; i < lista.size(); i++) {
				if (lista.get(i) > last * (1 + delta)) {
					resultado.add(lista.get(i));
					last = lista.get(i);
				}
			}
		}
		return resultado;
	}
	
	public void approxSubsetSum(int[] conjunto, int t, double delta) {
		int n = conjunto.length;
		List<Integer> lista0 = new ArrayList<>();
		lista0.add(0);
		
		for(int i = 1; i <= n; i++) {
			List<Integer> listai = ordena(lista0, agregaSuma(lista0, conjunto[i - 1]));
			listai = trim(listai, delta/(2*n));
			lista0 = eliminaMasGrande(listai, t);
		}
		
		lista0 = lista0.stream().distinct().collect(Collectors.toList());
		this.conjunto = getSumaConjunto(lista0, Collections.max(lista0));
		this.suma = Collections.max(lista0);
	}
	
	// Obtiene la lista de elementos que corresponden a la suma
	private List<Integer> getSumaConjunto(List<Integer> lista, int suma) {
		int sumaValor = 0;
		List<Integer> resultado = new ArrayList<>();
		for (int i = 1; i < lista.size(); i++) 
			if (sumaValor != suma) {
				sumaValor += lista.get(i);
				resultado.add(lista.get(i));
			}
		return resultado;
	}

	/**
	 * Obtiene la máxima suma obtenida según la delta
	 * 
	 * @return La máxima suma
	 */
	public int getSuma() {
		return suma;
	}

	/**
	 * Obtiene el conjunto correpondiente a la suma obtenida
	 * 
	 * @return Lista de elementos según a la máxima suma obtenida
	 */
	public List<Integer> getConjunto() {
		return conjunto;
	}
}