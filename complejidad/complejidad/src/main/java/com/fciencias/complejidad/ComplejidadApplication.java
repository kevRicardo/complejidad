package com.fciencias.complejidad;

import com.fciencias.complejidad.entity.Clausula;
import com.fciencias.complejidad.entity.Lector;
import com.fciencias.complejidad.entity.Literal;

public class ComplejidadApplication {

	public static void main(String[] args) {
		try {
			Lector lector = new Lector("3SAT1.txt");
			
			System.out.println("Fase adivinadora\n");
			
			System.out.println("Valores asignados a las literales:");
			
			for(Literal l : lector.getLiterales())
				System.out.println("\t" + l);
			
			System.out.println("\nFase verificadora\n");
			
			System.out.println("La fórmula: " + lector.getLista().get(0));
			
			if(Clausula.SAT(lector.getClausulas()))
				System.out.println("Es 3-SAT satisfacible");
			else
				System.err.println("No es 3-SAT satisfacible");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("La clausula no cumple con tener 3 literales");
		}
	}
}