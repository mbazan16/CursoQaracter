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

		long m2Totales = casas.stream().mapToInt(a -> a.getNumHabitaciones()).sum();
		System.out.println("M2 Totales:" + m2Totales);

		// Paso2 Conseguir los m2 totales de las casas del listado que tengan un nombre
		// de menos de 4 caracteres
		long m2TotalesNombreMenor4Caracteres = casas.stream().filter(a -> a.getNombre().length() < 4)
				.mapToInt(a -> a.getNumHabitaciones()).sum();
		System.out.println("M2 Totales de las Casas de menos de 4 caracteres:" + m2TotalesNombreMenor4Caracteres);

		// Paso3 Conseguir un listado de las casa que tengan un salon de m�s de 20 m2
		List<Casa> casas2 = casas.stream().filter(a -> a.getSalon().getM2() > 20).collect(Collectors.toList());
	   System.out.println("Casas con sal�n de m�s de 20 m2:" + casas2);
		
	   
	   // Paso4 Conseguir un listado de Salones con las casas de m�s de una habitaci�n
		List<Salon> salones = casas.stream().filter(a -> a.getNumHabitaciones() < 1).map(a -> a.getSalon())
				.collect(Collectors.toList());
		System.out.println("Salones:" + salones);

		// Paso5 Conseguir los m2 de todos los salones de las casas

		// Suma de m2:
		//int m2Salones = casas.stream().mapToInt(a -> a.getSalon().getM2()).sum();
		int m2Salones = casas.stream()
						.filter(a -> a.getNumHabitaciones() > 1)
				        .map(Casa::getSalon)
				        .peek(System.out::println)
						.mapToInt(Salon::getM2)
						.sum();
		System.out.println("M2 totales de los salonessdsds:" + m2Salones);

		// long m2Salones = casas.stream()
		// .map(a -> a.getSalon().getM2())
		// .reduce(0, (a, b) -> a + b, Integer::sum);

		// Listado de los m2 de los salones
		List<Integer> m2SalonesListado = casas.stream().map(a -> a.getSalon().getM2()).collect(Collectors.toList());

		System.out.println("M2 de cada salon:" + m2SalonesListado);

		// Paso6 Imprimir todas las casas

		// Equivalentes:
		casas.stream().forEach(a -> System.out.println(a));
		casas.forEach(System.out::println);

		// Paso7 Conseguir el numero total de habitaciones de las casas de mas de una 1
		// habitaci�n,
		// imprimiendo las casas que se han seleccionado.

		int numHabitacionesTotales = casas.stream().filter(a -> a.getNumHabitaciones() > 1).peek(System.out::println)
				.mapToInt(a -> a.getNumHabitaciones()).sum();
		System.out.println("Habitaciones totales:" + numHabitacionesTotales);

		numHabitacionesTotales = 0;
		for (Casa casaAux : casas) {
			if (casaAux.getNumHabitaciones() > 1) { // filter
				System.out.println(casaAux); // peek
				int numHabitaciones = casaAux.getNumHabitaciones(); // mapToInt
				numHabitacionesTotales += numHabitaciones; // sum, m�todo acumulador
			}
		}
	}

}
