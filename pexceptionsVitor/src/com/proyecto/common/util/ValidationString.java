package com.proyecto.common.util;

import com.proyecto.common.Constantes;
import com.proyecto.common.NotAllowedWord;
import com.proyecto.common.exception.CodeErrors;
import com.proyecto.common.exception.NotAllowedWordsException;
import com.proyecto.common.exception.StringNotValidException;
import com.proyecto.common.exception.StringTooLongException;
import com.proyecto.common.exception.StringTooShortException;

public class ValidationString {

	// Paso 1. Implementar un m�todo est�tico "validLenght"que valide
	// si una cadena tiene mas tama�ano de 25 posiciones y menos de 1 posici�n
	// El m�todo tiene que devolver void, utilizar excepciones, declarar las
	// necesarias
	// Paso 1.1. Validar si la cadena no es nula y no esta vac�a
	// Paso 1.2 Validar si es mayor que el tama�o maximo (Constantes)
	// Paso 1.3 Validar si es menor que el tama�o minimo (Constantes)

	// Paso 1.4 Validar si no contiene palabras no permitidas;

	public static void validLength(String word) throws StringNotValidException {
		if (validateNullOrEmptyString(word)) {
			throw new StringNotValidException("Empty or null string", CodeErrors.NO_STRING);
		}

		if (validateMaxSizeString(word, Constantes.TAMANIO_MAX)) {
			throw new StringTooLongException("String length too long", CodeErrors.STRING_TOO_LONG);
		}

		if (validateMinSizeString(word, Constantes.TAMANIO_MIN)) {
			throw new StringTooShortException("String length too short", CodeErrors.STRING_TOO_SHORT);
		}

		if (validateNotAllowedWord(word)) {
			throw new NotAllowedWordsException("Not allowed word", CodeErrors.WORD_NOT_ALLOWED_FOUND,
					NotAllowedWord.valueOf(word.toUpperCase()));
		}
	}

	// Paso 2: Sobrecargar el m�todo anterior para que realize las
	// validaciones con dos valores m�ximo y m�nimo pasados por par�metros

	// Paso 1.1. Validar si la cadena no es nula y no esta vac�a
	// Paso 1.2 Validar si es mayor que el tama�o maximo (Constantes)
	// Paso 1.3 Validar si es menor que el tama�o minimo (Constantes)
	// Paso 1.4 Validar si no contiene palabras no permitidas;
	
	public static void validLength(String word, int maxSize, int minSize) throws StringNotValidException {
		if (validateNullOrEmptyString(word)) {
			throw new StringNotValidException("Empty or null string", CodeErrors.NO_STRING);
		}

		if (validateMaxSizeString(word, maxSize)) {
			throw new StringTooLongException("String length too long", CodeErrors.STRING_TOO_LONG);
		}

		if (validateMinSizeString(word, minSize)) {
			throw new StringTooShortException("String length too short", CodeErrors.STRING_TOO_SHORT);
		}

		if (validateNotAllowedWord(word)) {
			throw new NotAllowedWordsException("Not allowed word", CodeErrors.WORD_NOT_ALLOWED_FOUND,
					NotAllowedWord.valueOf(word.toUpperCase()));
		}
	}

	// Paso 3. Si alguna funcionalidad se repitiese extraerla en un m�todo privado

	private static boolean validateNullOrEmptyString(String value) {
		if (value == null || value.isEmpty()) {
			return true;
		}

		return false;
	}

	private static boolean validateMaxSizeString(String value, int maxSize) {
		if (value.length() > maxSize) {
			return true;
		}

		return false;
	}

	private static boolean validateMinSizeString(String value, int minSize) {
		if (value.length() < minSize) {
			return true;
		}

		return false;
	}

	private static boolean validateNotAllowedWord(String value) {
		NotAllowedWord[] notAllowedWords = NotAllowedWord.values();
		for (NotAllowedWord word : notAllowedWords) {
			if (word.name().equalsIgnoreCase(value)) {
				return true;
			}
		}

		return false;
	}

}
