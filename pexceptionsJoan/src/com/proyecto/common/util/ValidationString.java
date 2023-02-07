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
	public static void validLength(String s) throws StringNotValidException {
		// Paso 1.1. Validar si la cadena no es nula y no esta vac�a

		validarBasico(s);

		// Paso 1.2 Validar si es mayor que el tama�o maximo (Constantes)

		validarMaximaLongitud(s, Constantes.TAMANIO_MAX);

		// Paso 1.3 Validar si es menor que el tama�o minimo (Constantes)

		validarMinimaLongitud(s, Constantes.TAMANIO_MIN);

		// Paso 1.4 Validar si no contiene palabras no permitidas;

		validarPalabrasNoPermitidas(s);
	}

	// Paso 2: Sobrecargar el m�todo anterior para que realize las
	// validaciones con dos valores m�ximo y m�nimo pasados por par�metros

	public static void validLength(String s, int maxLength, int minLength) throws StringNotValidException {
		// Paso 1.1. Validar si la cadena no es nula y no esta vac�a

		validarBasico(s);

		// Paso 1.2 Validar si es mayor que el tama�o maximo (Constantes)

		validarMaximaLongitud(s, maxLength);

		// Paso 1.3 Validar si es menor que el tama�o minimo (Constantes)

		validarMinimaLongitud(s, minLength);

		// Paso 1.4 Validar si no contiene palabras no permitidas;

		validarPalabrasNoPermitidas(s);
	}

	// Paso 3. Si alguna funcionalidad se repitiese extraerla en un m�todo privado

	private static void validarBasico(String s) throws StringNotValidException {
		if (s == null)
			throw new StringNotValidException(CodeErrors.NO_STRING, "La cadena es null");

		if (s.isEmpty())
			throw new StringNotValidException(CodeErrors.NO_STRING, "La cadena está vacía");
	}

	private static void validarMaximaLongitud(String s, int maxLength) throws StringTooLongException {
		if (s.length() > maxLength)
			throw new StringTooLongException(CodeErrors.STRING_TOO_LONG, "La cadena es muy larga", s.length());
	}

	private static void validarMinimaLongitud(String s, int minLength) throws StringTooShortException {
		if (s.length() < minLength)
			throw new StringTooShortException(CodeErrors.STRING_TOO_SHORT, "La cadena es muy corta", s.length());
	}

	/**
	 * 
	 * @param s
	 * @throws NotAllowedWordsException
	 */
	private static void validarPalabrasNoPermitidas(String s) throws NotAllowedWordsException {
		s = s.toUpperCase();
		for (NotAllowedWord value : NotAllowedWord.values())
			if (s.contains(value.toString()))
				throw new NotAllowedWordsException(CodeErrors.WORD_NOT_ALLOWED_FOUND,
						"La cadena contiene palabras no permitidas", value);
	}
}
