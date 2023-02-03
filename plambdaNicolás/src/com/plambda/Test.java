package com.plambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.plambda.beans.Casa;
import com.plambda.beans.Salon;

public class Test {

	public static void main(String[] args) {
		Casa casa1 = new Casa(3, 90, "una", new Salon(25));
		Casa casa2 = new Casa(2, 50, "dos", new Salon(15));
		Casa casa3 = new Casa(1, 50, "tres", new Salon(20));

		List<Casa> casas = new ArrayList<Casa>();
		casas.add(casa1);
		casas.add(casa2);
		casas.add(casa3);
		
		// Paso1 Conseguir los m2 totales de las casas del listado
		
		int m2Totales = casas.stream()
				.mapToInt(Casa::getM2)
				.sum();
		System.out.println("1. m2 totales: " + m2Totales);

		// Paso2 Conseguir los m2 totales de las casas del listado
		// que tengan un nombre de menos de 4 caracteres
		
		int m2TotalesNombreCorto = casas.stream()
				.filter(a -> (a.getNombre().length() < 4))
				.mapToInt(Casa::getM2)
				.sum();
		System.out.println(
				"\n2. m2 totales de las casas con un nombre de menos de 4 caracteres: " + m2TotalesNombreCorto);

		// Paso3 Conseguir un listado de las casa que tengan un salon de m�s de 20 m2

		List<Casa> casasConSalonGrande = casas.stream()
				.filter(a -> (a.getSalon().getM2() > 20))
				.collect(Collectors.toList());
		// .collect(Collectors.toCollection(ArrayList::new));
		System.out.println("\n3. Casas que tienen un salon de mas de 20 m2: " + casasConSalonGrande);

		// Paso4 Conseguir un listado de Salones con las casas de m�s de una habitaci�n
		
		List<Salon> salonesDeCasasGrandes = casas.stream()
				.filter(a -> (a.getNumHabitaciones() > 1))
				.map(Casa::getSalon)
				.collect(Collectors.toList());
		System.out.println("\n4. Salones de las casas de mas de una habitacion: " + salonesDeCasasGrandes);

		// Paso5 Conseguir los m2 de todos los salones de las casas
		
		
		int m2SalonesTotales = casas.stream()
				.map(Casa::getSalon)
				.mapToInt(Salon::getM2)
				.sum();
		System.out.println("\n5. m2 de todos los salones: " + m2SalonesTotales);

		// Paso6 Imprimir todas las casas
		System.out.println("\n6. Todas las casas:\n");
		casas.forEach(System.out::println);

		// Paso7 Conseguir el numero total de habitaciones de las casas de mas de 1
		// habitaci�n, imprimiendo las casas que se han seleccionado.
		
		System.out.println("\n7. Casas con mas de 1 habitacion:\n");
		int habitacionesTotales = casas.stream()
				.filter(a -> (a.getNumHabitaciones() > 1))
				.peek(System.out::println)
				.mapToInt(Casa::getNumHabitaciones)
				.sum();
		System.out.println("\nHabitaciones totales de las casas de mas de 1 habitacion: " + habitacionesTotales);

	}

}
