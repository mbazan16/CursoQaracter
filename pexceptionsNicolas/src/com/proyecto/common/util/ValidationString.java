package com.proyecto.common.util;

import com.proyecto.common.Constantes;
import com.proyecto.common.exception.CodeErrors;
import com.proyecto.common.exception.StringNotValidException;
import com.proyecto.common.exception.StringTooLongException;
import com.proyecto.common.exception.StringTooShortException;

public class ValidationString {

	// Paso 1. Implementar un m�todo est�tico "validLenght"que valide
	// si una cadena tiene mas tama�ano de 25 posiciones y menos de 1 posici�n
	// El m�todo tiene que devolver void, utilizar excepciones, declarar las
	// necesarias
	public static void validLength(String s) throws
	/*
	 * StringTooLongException, StringTooShortException,
	 */
	StringNotValidException {
		// Paso 1.1. Validar si la cadena no es nula y no esta vac�a

		if (s == null || s.isEmpty())
			throw new StringNotValidException(CodeErrors.NO_STRING, "La cadena es null o está vacía");

		// Paso 1.2 Validar si es mayor que el tama�o maximo (Constantes)

		if (s.length() > Constantes.TAMANIO_MAX)
			throw new StringTooLongException(CodeErrors.STRING_TOO_LONG, "La cadena es muy larga", s.length());

		// Paso 1.3 Validar si es menor que el tama�o minimo (Constantes)

		if (s.length() < Constantes.TAMANIO_MIN)
			throw new StringTooShortException(CodeErrors.STRING_TOO_SHORT, "La cadena es muy corta", s.length());

		// Paso 1.4 Validar si no contiene palabras no permitidas;
		
		
	}

	// Paso 2: Sobrecargar el m�todo anterior para que realize las
	// validaciones con dos valores m�ximo y m�nimo pasados por par�metros

	// Paso 1.1. Validar si la cadena no es nula y no esta vac�a
	// Paso 1.2 Validar si es mayor que el tama�o maximo (Constantes)
	// Paso 1.3 Validar si es menor que el tama�o minimo (Constantes)
	// Paso 1.4 Validar si no contiene palabras no permitidas;

	// Paso 3. Si alguna funcionalidad se repitiese extraerla en un m�todo privado

}
