package com.complejidad.ruta;

import com.complejidad.ruta.entity.Grafica;
import com.complejidad.ruta.entity.Lector;
import com.complejidad.ruta.entity.Vertice;

/**
 * Ruta mas corta
 * 
 * @author Villegas Salvador Kevin Ricardo
 */
public class Ruta {

	public static void main(String[] args) {
		try {
			System.out.println("Fase adivinadora\n");
			Lector lector = new Lector("ruta.txt");
			Grafica ruta = lector.getGrafica();
			// Obtiene un conjunto aleatoriamente
			ruta.generaRuta();
			System.out.println("\tConjunto de vertices de la ruta elejida: \n\tR: " + ruta.getRuta());
			
			System.out.println("\nFase verificadora\n");
			
			// Empieza a verificar si la ruta propuesta es menor o igual a k
			if (ruta.verificaRuta(ruta.getVertices().get(3), ruta.getVertices().get(5), 20))
				System.out.println("\tLa ruta anterior es una ruta menor o igual a 20");
			else

				System.err.println("\tLa ruta anterior no es una ruta menor igual a k");
		} catch(Exception e) {
			System.err.println("La gráfica no cumple las características establecidas");
		}
	}
}