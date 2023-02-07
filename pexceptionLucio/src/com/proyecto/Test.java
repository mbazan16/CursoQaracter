package com.proyecto;

import java.util.Scanner;

import com.proyecto.common.exception.NotAllowedWordsException;
import com.proyecto.common.exception.StringNotValidException;
import com.proyecto.common.exception.StringTooLongException;
import com.proyecto.common.exception.StringTooShortException;
import com.proyecto.common.util.ValidationString;

public class Test {

	// Todo el c�digo excepto las declaraciones debe estar en un bloque try-catch
	public static void main(String[] args)  {
		// Declarar las variables necesarias		
			// Paso 1. Realizar un bucle infinito, que �nicamente se pare
			// cuando el c�digo lance una excepcion de cadena nula o vac�a o 
			// de palabra no permitida introducida
			// Paso 2. Pedir una cadena por consola al usuario
			
			// Paso 3. Validar si la cadena es correcta con los valores por defecto
			// Si no es correcta mostrar al usuario el mensaje adecuado por cada caso
			// Implementar otro bloque try/catch anidado que solo capture las excepciones
	        // de tama�o.	
					// Paso 3.1. Se muestra un mensaje de cadena v�lida
			//Paso 4. Cuando se recojan todas las excepciones (de ambos bloques try/cach)
			//mostrar un mensaje adecuado a la  excepci�n recogida				
			
		Scanner scr = new Scanner(System.in);
		String str;	
		
		try {
			while(true) {
				System.out.print("Coloque su usuario: ");
				str = scr.nextLine();
				try {
					ValidationString.validLenght(str); 
					System.out.println("Palabra valida.");
				} catch (StringTooLongException e) {
					System.out.println("El tamanio del String es muy largo.");
				} catch (StringTooShortException e) {
					System.out.println("El tamanio del String es muy corto.");
				}
			}
			
		} catch (StringNotValidException e) {
			System.out.println("El String pasado es nulo o esta vacio.");
		}
		
											
	}			
	

}
