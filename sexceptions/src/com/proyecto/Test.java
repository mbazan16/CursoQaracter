package com.proyecto;

import java.util.Scanner;

import com.proyecto.common.exception.NotAllowedWordsException;
import com.proyecto.common.exception.StringNotValidException;
import com.proyecto.common.exception.StringTooLongException;
import com.proyecto.common.exception.StringTooShortException;
import com.proyecto.common.util.ValidationString;

public class Test {

	// Todo el código excepto las declaraciones debe estar en un bloque try-catch
	public static void main(String[] args) throws StringNotValidException {
		// Declarar las variables necesarias
		String cadena = null;
		
		try (Scanner sc = new Scanner(System.in)){

			
			// Paso 1. Realizar un bucle infinito, que únicamente se pare
			// cuando el código lance una excepcion de cadena nula o vacía o 
			// de palabra no permitida introducida
			while(true) {
				// Paso 2. Pedir una cadena por consola al usuario
				System.out.println("Por favor, introduzca una cadena");
				cadena = sc.nextLine();
				System.out.println("CADENA INTRODUCIDA:"+cadena+".");				

				// Paso 3. Validar si la cadena es correcta con los valores por defecto
				// Si no es correcta mostrar al usuario el mensaje adecuado por cada caso
				// Implementar otro bloque try/catch anidado que solo capture las excepciones
		        // de tamaño.
				try {
					ValidationString.validLenght(cadena);
					
					// Paso 3.1 Se muestra un mensaje de cadena válida
					System.out.println("La cadena es válida. Felicidades¡¡");
	//Paso 4. Cuando se recojan todas las excepciones (de ambos bloques try/cach)
	//mostrar un mensaje adecuado a la  excepción recogida				
				} catch (StringTooLongException stle) {
					System.out.println("La cadena tiene más de " + stle.getTamanyo() + " caracteres");
				} catch (StringTooShortException stse) {
					System.out.println("La cadena tiene menos de " + stse.getTamanyo() + " caracteres");
				}

			} 

		} catch (NotAllowedWordsException nawe) {
				System.out.println("Se ha introducido una palabra no permitida:"
						+ nawe.getWord());
				System.out.println("Fin de ejecución");
				//throw nawe;
			
		}catch (StringNotValidException snve) {
			System.out.println("La cadena introducida no es válida");
			System.out.println("Fin de ejecución");
			throw snve;
		}catch (Exception e) {			
			System.out.println("Se ha producido una excepción general");
			System.out.println("Fin de ejecución");
		}



	}

}
