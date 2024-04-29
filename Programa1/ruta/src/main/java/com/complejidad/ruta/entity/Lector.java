package com.complejidad.ruta.entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

/**
 * Método que lee el archivo .txt y obtendrá la gráfica de ésta
 * 
 * @author Kevin Ricardo Villegas Salvador
 */
public class Lector{
    
    private LinkedList<String> lista;
    private Grafica grafica;

    /**
     * Constructor de la clase
     *
     * @param archivo El archivo a procesar
     */
    public Lector(String archivo){
    	grafica = new Grafica();
    	lista = new LinkedList<>();
    	leeArchivo(archivo);
    	creaGrafica();
    }

    private void leeArchivo(String archivo){
    	try(BufferedReader br = new BufferedReader(new FileReader("./Ejemplares/"+archivo))){
    		String l;
    		while((l = br.readLine()) != null)
    			lista.add(l);
    		br.close();
    	}catch(Exception e){
    	    System.err.println("Error en la entrada de datos");
    	}
    }

    /**
     * Se crea la gráfica con el archivo procesado
     */
    public void creaGrafica(){
    	String[] vertices = lista.get(0).split(",");
    	System.out.println("vertices: " + vertices.length);
    	if (vertices.length < 10 || vertices.length > 20) {
    		System.err.println("La |V| = n, donde n debe ser: 10 ≤ n ≤ 20");
    		throw new ArrayIndexOutOfBoundsException();
    	}
    	if ((lista.size() - 1) < (2 * vertices.length)) {
    		System.err.println("La |V| = n y |A| = m, donde m debe ser: m > 2n");
    		throw new ArrayIndexOutOfBoundsException();
    	}
    	for(String s: vertices)
    	    grafica.agrega(Integer.parseInt(s));
    	for(int i = 1; i < lista.size(); i++){
    	    String[] aristas = lista.get(i).split(",");
    	    int j = Integer.parseInt(aristas[0]);
    	    int k = Integer.parseInt(aristas[1]);
    	    grafica.agregaArista(j, k);
    	}
    }

    /**
     * Obtiene la lista de vértices y aristas contenidas en el archivo
     */
    public LinkedList<String> getLista(){
    	return lista;
    }

    /**
     * Obtiene la gráfica creada
     */
    public Grafica getGrafica(){
    	return grafica;
    }
}