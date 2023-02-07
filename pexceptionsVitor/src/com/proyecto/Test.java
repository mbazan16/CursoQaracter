package com.proyecto;

import java.util.Scanner;

import com.proyecto.common.exception.NotAllowedWordsException;
import com.proyecto.common.exception.StringNotValidException;
import com.proyecto.common.exception.StringTooLongException;
import com.proyecto.common.exception.StringTooShortException;
import com.proyecto.common.util.ValidationString;

public class Test {

	// Todo el c�digo excepto las declaraciones debe estar en un bloque try-catch
	public static void main(String[] args) {
		// Declarar las variables necesarias
		Scanner sc = null;
		String word;
		try {
			while (true) {
				System.out.println("Type a word: ");
				sc = new Scanner(System.in);
				word = sc.nextLine();
				System.out.println(word);
				try {
					ValidationString.validLength(word);
					System.out.println("Valid String: " + word);
				} catch (StringTooLongException e) {
					System.out.println("String too long max size allowed: " + e.getTamanyo());
				} catch (StringTooShortException e) {
					System.out.println("String too short min size allowed: " + e.getTamanyo());
				}

			}
		} catch (NotAllowedWordsException e) {
			System.out.println("Not Allowed word: " + e.getWord());
		} catch (StringNotValidException e) {
			System.out.println("String not valid: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Generic Exception: " + e.getMessage());
		} finally {
			sc.close();
		}

		// Paso 1. Realizar un bucle infinito, que �nicamente se pare
		// cuando el c�digo lance una excepcion de cadena nula o vac�a o
		// de palabra no permitida introducida
		// Paso 2. Pedir una cadena por consola al usuario

		// Paso 3. Validar si la cadena es correcta con los valores por defecto
		// Si no es correcta mostrar al usuario el mensaje adecuado por cada caso
		// Implementar otro bloque try/catch anidado que solo capture las excepciones
		// de tama�o.

		// Paso 3.1. Se muestra un mensaje de cadena v�lida
		// Paso 4. Cuando se recojan todas las excepciones (de ambos bloques try/cach)
		// mostrar un mensaje adecuado a la excepci�n recogida

	}


}
