package com.complejidad.ruta.entity;

import java.util.LinkedList;

/**
 * Clase que simula un vértice
 * 
 * @author Kevin Ricardo Villegas Salvador
 */
public class Vertice {
	
	/** El identificador */
	public int id;
	/** El elemento del vértice */
	public String nombre;
	/** El valor si ya fue visitado */
	public boolean visitado;
	/** El padre del vértice */
	public Vertice padre;
	/** La lista de vecinos del vértice */
	public LinkedList<Vertice> vecinos;
	
	/**
	 * Construye un nuevo vértice en la gráfica
	 *
	 * @param id El identificador del vértice
	 */
	public Vertice(int id){
	    this.id = id;
	    this.nombre = "v" + id;
	    this.visitado = false;
	    this.padre = null;
	    this.vecinos = new LinkedList<>();
	}
	
	@Override
	public boolean equals(Object obj){
	    if(obj instanceof Vertice){
	    	Vertice v = (Vertice)obj;
    		if(v.id == this.id)
    		    return true;
	    }
	    return false;
	}
	
	@Override
	public String toString(){
	    return nombre;
	}
	
	/**
	 * Agrega un vértice a su lista de vecinos.
	 *
	 * @param vertice El vértice a agregar a los vecinos.
	 */
	public void agregaVecino(Vertice vertice){
	    if(!vecinos.contains(vertice))
	    	vecinos.add(vertice);
	}
}