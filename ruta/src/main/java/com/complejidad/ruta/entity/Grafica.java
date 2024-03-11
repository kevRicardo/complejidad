package com.complejidad.ruta.entity;

import java.util.LinkedList;
import java.util.Random;

/**
 * Clase que simula una gráfica.
 *
 * @author Kevin Ricardo Villegas Salvador
 */
public class Grafica {
    
    private LinkedList<Vertice> vertices;
    private LinkedList<Vertice> ruta;

    /**
     * Constructor único de la clase
     */
    public Grafica() {
    	vertices = new LinkedList<>();
    	this.ruta = new LinkedList<>();
    }

    /**
     * Agrega un nuevo elemento a la gráfica
     *
     * @param id El identificador del vértice..
     */
    public void agrega(int id) {
    	Vertice v = new Vertice(id);
    	vertices.add(v);
    }

    public LinkedList<Vertice> verticeG() {
    	return vertices;
    }

    /**
     * Obtiene el vértice buscado.
     *
     * @param id El identificador del vértice a buscar
     * @return El vértice correspondiente al id, null en otro caso
     */
    public Vertice getVertice(int id) {
    	Vertice v = new Vertice(id);
    	for(Vertice e: vertices)
    	    if(v.equals(e))
    		return e;
    	return null;
    }

    /**
     * Agrega una arista
     * Se simula agregando los vértice en cada vecindad
     *    de cada arista respectivamente
     *
     * @param idI El identificador de un vértice del extremo de la arista
     * @param idD El identificador de un vértice del extremo de la arista
     */
    public void agregaArista(int idI, int idD) {
    	Vertice vI = getVertice(idI);
    	Vertice vD = getVertice(idD);
    	vI.agregaVecino(vD);
    	vD.agregaVecino(vI);
    }
    
    @Override
    public String toString() {
    	String s = "";
    	for(Vertice v: vertices)
    	    s += v.toString() + "->" + v.vecinos.toString() + "\n";
    	return s;
    }
    
    public void generaRuta() {
    	Random random = new Random();
    	for (Vertice v : vertices)
    		if (random.nextBoolean())
    			this.ruta.add(v);
    }

    public boolean verificaRuta(Vertice u, Vertice v, int k) {
    	if (!ruta.contains(u) || !ruta.contains(v) || this.ruta.size() > k)
    		return false;
    	LinkedList<Vertice> l = vertices;
    	LinkedList<Vertice> cola = new LinkedList<>();
    	l.remove(u);
	    LinkedList<Vertice> rutaEncontrada = new LinkedList<>();
	    
	    Vertice w = u;
	    rutaEncontrada.add(w);
	    if (w.equals(v) && rutaEncontrada.size() <= k)
	    	return true;
	    cola.add(w);
	    w.visitado = true;
	    while(!(cola.size() == 0)){
	    	Vertice x = cola.remove();
    		for(Vertice y: x.vecinos)
    		    if(y.visitado == false && this.ruta.contains(y)){
    		    	l.removeFirstOccurrence(y);
        			rutaEncontrada.add(y);
        			if (y.equals(v) && rutaEncontrada.size() <= k)
        		    	return true;
        			cola.add(y);
        			y.visitado = true;
    		    }
	    }
    	return false;
    }

    /**
     * Obtiene la lista de vértices de la gráfica
     *
     * @return La lista de vertices
     */
    public LinkedList<Vertice> getVertices() {
    	return vertices;
    }
    
    /**
     * Obtiene la lista de vértices del conjunto de vertices elegidos
     *
     * @return La lista de vertices aleatorios
     */
    public LinkedList<Vertice> getRuta() {
    	return ruta;
    }
}