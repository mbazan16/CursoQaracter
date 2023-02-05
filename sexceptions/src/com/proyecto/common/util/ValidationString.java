package com.proyecto.common.util;

import com.proyecto.common.Constantes;
import com.proyecto.common.NotAllowedWord;
import com.proyecto.common.exception.CodeErrors;
import com.proyecto.common.exception.NotAllowedWordsException;
import com.proyecto.common.exception.StringNotValidException;
import com.proyecto.common.exception.StringTooLongException;
import com.proyecto.common.exception.StringTooShortException;

public class ValidationString {

	// Paso 1. Implementar un método estático "validLenght"que valide
	// si una cadena tiene mas tamañano de 25 posiciones y menos de 1 posición
	// El método tiene que devolver void, utilizar excepciones.

	public static void validLenght(String cadena) throws StringNotValidException {
		try {
			stringIsNotNullOrEmpty(cadena);
			// Paso 1.2 Validar si es mayor que el tamaño maximo (Constantes)
			if (cadena.length() > Constantes.TAMANIO_MAX)
				throw new StringTooLongException(CodeErrors.STRING_TOO_LONG, Constantes.TAMANIO_MAX, "");
			// Paso 1.3 Validar si es menor que el tamaño minimo (Constantes)
			if (cadena.length() < Constantes.TAMANIO_MIN)
				throw new StringTooShortException(CodeErrors.STRING_TOO_SHORT, Constantes.TAMANIO_MIN, "");
			// Paso 1.4 Validar si no contiene palabras no permitidas;
			stringNoContainsWordsNotAllowed(cadena);

		}catch(StringNotValidException snve) {
			throw snve;
		}catch (Exception e) {
			System.out.println("Excepción general");
			
		}
	}

	// Paso 2: Sobrecargar el método anterior para que realize las
	// validaciones con dos valores máximo y mínimo pasados por parámetros
	public static void validLenght(String cadena, int valorMaximo, int valorMinimo) throws StringNotValidException {
		// Paso 1.1. Validar si es nula o vacía, si es así lanzar excepción adecuada
		stringIsNotNullOrEmpty(cadena);

		// Paso 1.2 Validar si es mayor que el tamaño maximo (Constantes)
		if (cadena.length() > valorMaximo)
			throw new StringTooLongException(CodeErrors.STRING_TOO_LONG, valorMaximo, "");
		// Paso 1.3 Validar si es menor que el tamaño minimo (Constantes)
		if (cadena.length() < valorMinimo)
			throw new StringTooShortException(CodeErrors.STRING_TOO_SHORT, valorMinimo, "");
		// Paso 1.4 Validar si no contiene palabras no permitidas;
		stringNoContainsWordsNotAllowed(cadena);
	}

	// Paso 3. Si alguna funcionalidad se repitiese extraerla en un método privado
	private static void stringIsNotNullOrEmpty(String cadena) throws StringNotValidException {
		if (cadena == null || cadena.isEmpty())
			throw new StringNotValidException(CodeErrors.NO_STRING, "");

	}

	private static void stringNoContainsWordsNotAllowed(String cadena) throws NotAllowedWordsException {
		cadena = cadena.toUpperCase();
		for (NotAllowedWord word : NotAllowedWord.values()) {
			if (cadena.contains(word.toString()))
				throw new NotAllowedWordsException(CodeErrors.WORD_NOT_ALLOWED_FOUND, word, "");
		}
	}

}
