package com.fciencias.complejidad;

import com.fciencias.complejidad.entity.Clausula;
import com.fciencias.complejidad.entity.Lector;
import com.fciencias.complejidad.entity.Literal;

public class SAT {

	public static void main(String[] args) {
		try {
			System.out.println("Fase adivinadora\n");
			
			// Empieza con la asignación de valores al azar de las literales
			Lector lector = new Lector("3SAT1.txt");
			
			System.out.println("Valores asignados a las literales:");
			
			for(Literal l : lector.getLiterales())
				System.out.println("\t" + l);
			
			System.out.println("\nFase verificadora\n");
			
			System.out.println("La fórmula: " + lector.getLista().get(0));
			
			// Empieza a verificar si la clausula es 3SAT
			if(Clausula.SAT(lector.getClausulas()))
				System.out.println("Es 3-SAT satisfacible");
			else
				System.err.println("No es 3-SAT satisfacible");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("La clausula no cumple con tener 3 literales");
		}
	}
}