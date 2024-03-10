package com.fciencias.complejidad.entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Clase que simula un procesador de archivos
 */
public class Lector {
	
	private List<Literal> literales;
	private List<Clausula> clausulas;
	private LinkedList<String> lista;
	
	public Lector(String archivo) {
		this.literales = new ArrayList<>();
		this.clausulas = new ArrayList<>();
		this.lista = new LinkedList<>();
		leeArchivo(archivo);
		creaClausula();
	}
	
	private void leeArchivo(String archivo) {
		try(BufferedReader br = new BufferedReader(new FileReader("./Ejemplares/"+archivo))){
			String l;
			while((l = br.readLine()) != null)
				lista.add(l.replace('(', ' ').replace(')', ' ').trim());
			br.close();
		} catch(Exception e) {
			System.out.println("Error en la entrada de datos");
		}
	}
	
	private void creaClausula() {
		String[] clausulasEntrada = lista.get(0).trim().split("\\*");
		for (String c : clausulasEntrada)
			transformaClausula(c);
	}
	
	private void transformaClausula(String cla) {
		String[] literales = cla.split("\\+");
		if(literales.length != 3) {
			System.err.println("(" + cla.trim() + ")");
			throw new ArrayIndexOutOfBoundsException();
		}
		Literal[] literalesClausula = new Literal[3];
		for (int i = 0; i < literales.length; i++) {
			if (literales[i].trim().substring(0, 1).equals("-")) {
				Literal l = new Literal();
				Literal existe = existeLiteral(literales[i].trim().substring(1, 2));
				l.setName(existe.getName());
				l.setValor(!existe.isValor());
				literalesClausula[i] = l;
			} else
				literalesClausula[i] = existeLiteral(literales[i].trim().substring(0, 1));
		}
		this.clausulas.add(new Clausula(literalesClausula));
 	}
	
	private Literal existeLiteral(String name) {
		Random random = new Random();
		for(Literal l : this.literales)
			if (l.getName().equals(name))
				return l;
		Literal l = new Literal(name, random.nextBoolean());
		this.literales.add(l);
		return l;
	}

	/**
	 * Obtiene la lista de clausulas de una fórmula
	 * 
	 * @return La lista de clausulas
	 */
	public List<Clausula> getClausulas() {
		return clausulas;
	}

	/**
	 * Modifica la lista de clausulas de una fórmula
	 * 
	 * @param clausulas La nueva lisa de fórmulas
	 */
	public void setClausulas(List<Clausula> clausulas) {
		this.clausulas = clausulas;
	}

	/**
	 * Obtiene la lista de cadenas que obtiene del archivo
	 * 
	 * @return La lista de cadenas que obtiene del archivo
	 */
	public LinkedList<String> getLista() {
		return lista;
	}

	/**
	 * Modifica la lista de cadenas que obtiene del archivo
	 * 
	 * @param lista La nueva lista de cadenas de un archivo
	 */
	public void setLista(LinkedList<String> lista) {
		this.lista = lista;
	}

	/**
	 * Obtiene la lista de literales obtenidas una vez que se procesa el archivo
	 * 
	 * @return La lista de literales
	 */
	public List<Literal> getLiterales() {
		return literales;
	}

	public void setLiterales(List<Literal> literales) {
		this.literales = literales;
	}
}