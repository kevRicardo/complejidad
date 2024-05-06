package com.fciencias.complejidad;

import java.util.Arrays;
import java.util.stream.IntStream;

import com.fciencias.complejidad.entity.Lector;
import com.fciencias.complejidad.entity.Proceso;

/**
 * Subset Sum
 * 
 * @author Villegas Salvador Kevin Ricardo
 */
public class SubsetSum {

	public static void main(String[] args) {
		try {
			
			// Se procesa la lectura del archivo
			Lector lector = new Lector("Subset.txt");
			
			System.out.println("Valores de entrada\n");
			
			System.out.println("\tSuma a encontrar: " + lector.getSuma());
			System.out.println("\tDelta: " + lector.getDelta());
			System.out.println("\tConjunto: " + Arrays.toString(lector.getConjuntoArreglo()));
			
			// Se inicia el proceso para la suma del subconjunto
			Proceso proceso = new Proceso();
			proceso.approxSubsetSum(lector.getConjuntoArreglo(), lector.getSuma(), lector.getDelta());
			
			// Si la suma a encontrar es mayor que la suma de los elementos del conjunto, como resultado se dará el mismo conjunto
			if (proceso.getSuma() >= IntStream.of(lector.getConjuntoArreglo()).sum()) {
				System.out.println("\nEl valor de la suma máxima es: " + IntStream.of(lector.getConjuntoArreglo()).sum());
				System.out.println("La lista del subconjunto es: " + Arrays.toString(lector.getConjuntoArreglo()));
			} else {
				// Se realiza el proceso para encontrar el subconjunto
				System.out.println("\nEl valor de la suma máxima es: " + proceso.getSuma());
				System.out.println("La lista del subconjunto es: " +  proceso.getConjunto());
			}
		} catch (NumberFormatException e) {
			System.out.println("Error en la lectura de las variables");
		}
	}
}