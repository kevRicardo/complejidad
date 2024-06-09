package com.fciencias.complejidad.entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

/**
 * Clase que simula un procesador de archivos
 * 
 * @author Villegas Salvador Kevin Ricardo
 */
public class Lector {
	
	private int suma;
	private double delta;
	private LinkedList<String> conjunto;
	private LinkedList<String> lista;
	private int[] conjuntoArreglo;

	/**
	 * Procesador de archivo
	 * 
	 * @param archivo El archivo a procesar
	 */
	public Lector(String archivo) {
		this.conjunto = new LinkedList<>();
		this.lista = new LinkedList<>();
		leeArchivo(archivo);
		procesaConjunto();
		procesaConjuntoArreglo();
	}
	
	// Inicia la lectura del archivo
	private void leeArchivo(String archivo) {
		try(BufferedReader br = new BufferedReader(new FileReader("./Ejemplares/"+archivo))){
			String l;
		    while((l = br.readLine()) != null)
		    	lista.add(l);
		    br.close();
		} catch(Exception e) {
			System.out.println("Error en la entrada de datos");
		}
	}
	
	// Procesa las lineas del archivo 
	private void procesaConjunto() throws NumberFormatException{
		String[] vertices = lista.get(0).trim().split("\\s*,\\s*");
		suma = Integer.parseInt(vertices[0]);
		delta = Double.parseDouble(vertices[1]);
		
		String[] numeros = lista.get(1).trim().split("\\s*,\\s*");
		for(String s : numeros)
			conjunto.add(s);
	}
	
	// Pasa de una lista a un arreglo
	private void procesaConjuntoArreglo() {
		this.conjuntoArreglo = new int[conjunto.size()];
		for (int i = 0; i < conjunto.size(); i++)
			conjuntoArreglo[i] = Integer.parseInt(conjunto.get(i));
	}

	/**
	 * Obtiene la suma a encontrar
	 * 
	 * @return La suma a encontrar
	 */
	public int getSuma() {
		return suma;
	}

	/** Obtiene la delta
	 * 
	 * @return La preción de la suma
	 */
	public double getDelta() {
		return delta;
	}

	/**
	 * Obtiene la lista de lineas procesadas en el archivo
	 * 
	 * @return La lista de lineas del archivo
	 */
	public LinkedList<String> getLista() {
		return lista;
	}

	/**
	 * Obtiene el arreglo del conjunto obtenido
	 * 
	 * @return El arreglo con el conjunto
	 */
	public int[] getConjuntoArreglo() {
		return conjuntoArreglo;
	}
}