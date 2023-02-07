package com.proyecto;

import java.util.Scanner;

import com.proyecto.common.exception.NotAllowedWordsException;
import com.proyecto.common.exception.StringNotValidException;
import com.proyecto.common.exception.StringTooLongException;
import com.proyecto.common.exception.StringTooShortException;
import com.proyecto.common.util.ValidationString;

public class Test {

	// Todo el código excepto las declaraciones debe estar en un bloque try-catch
	@SuppressWarnings({ "static-access"})
	public static void main(String[] args){
		// Declarar las variables necesarias
		String cadena;
		
		try (Scanner sc = new Scanner(System.in)) {
			while (true) {
				try {
					System.out.println("Por favor, introduzca una palabra.");
					cadena = sc.nextLine();

					ValidationString.validLenght(cadena);
					
					System.out.println("Cadena introducida correcta.");
					
				} catch (StringTooShortException e) {
					System.out.println("Cadena demasiado corta. Tiene " + e.getTamanyo() + " caracteres.");
				} catch (StringTooLongException e1) {
					System.out.println("Cadena demasiado larga. Tiene " + e1.getTamanyo() + " caracteres.");
				}
			}
		} catch (NotAllowedWordsException e2) {
			System.out.println("Cadena con palabras prohibidas. Usa " + e2.getWord());
		} catch (StringNotValidException e3) {
			System.out.println("Cadena nula o vacia");
		}

		// Paso 1. Realizar un bucle infinito, que únicamente se pare
		// cuando el código lance una excepcion de cadena nula o vacía o
		// de palabra no permitida introducida
		// Paso 2. Pedir una cadena por consola al usuario

		// Paso 3. Validar si la cadena es correcta con los valores por defecto
		// Si no es correcta mostrar al usuario el mensaje adecuado por cada caso
		// Implementar otro bloque try/catch anidado que solo capture las excepciones
		// de tamaño.

		// Paso 3.1. Se muestra un mensaje de cadena válida
		// Paso 4. Cuando se recojan todas las excepciones (de ambos bloques try/cach)
		// mostrar un mensaje adecuado a la excepción recogida

	}

}
