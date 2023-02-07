package com.proyecto.common.util;

import java.util.Arrays;

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
	
	public static void validLenght (String str) throws StringNotValidException, NotAllowedWordsException, StringTooLongException, StringTooShortException{
		if(str == null || str.isEmpty()) throw new StringNotValidException(CodeErrors.NO_STRING);
		if(str.length() > Constantes.TAMANIO_MAX) throw new StringTooLongException(CodeErrors.STRING_TOO_LONG, Constantes.TAMANIO_MAX);
		if(str.length() < Constantes.TAMANIO_MIN) throw new StringTooShortException(CodeErrors.STRING_TOO_SHORT, Constantes.TAMANIO_MIN);
		try {
			NotAllowedWord.valueOf(str);
			throw new StringNotValidException(CodeErrors.WORD_NOT_ALLOWED_FOUND);
		} catch (IllegalArgumentException e) {
			
		}
		
		
	}
	
	

	// Paso 2: Sobrecargar el m�todo anterior para que realize las
	// validaciones con dos valores m�ximo y m�nimo pasados por par�metros
	
		// Paso 1.1. Validar si la cadena no es nula y no esta vac�a
		// Paso 1.2 Validar si es mayor que el tama�o maximo (Constantes)
		// Paso 1.3 Validar si es menor que el tama�o minimo (Constantes)
		// Paso 1.4 Validar si no contiene palabras no permitidas;		
		
	

	// Paso 3. Si alguna funcionalidad se repitiese extraerla en un m�todo privado
	

}
