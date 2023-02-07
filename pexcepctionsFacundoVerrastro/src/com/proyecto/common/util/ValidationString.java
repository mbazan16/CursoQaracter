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

	public static void validLenght(String cadena) throws StringNotValidException{
//		1.1
		noStringException(cadena);
//		1.2
		tamanyoMaxException(cadena,Constantes.TAMANIO_MAX);
//		1.3
		tamanyoMinException(cadena, Constantes.TAMANIO_MIN);
//		1.4
		wordNotAllowedException(cadena);
	}
	

	// Paso 2: Sobrecargar el m�todo anterior para que realize las
	// validaciones con dos valores m�ximo y m�nimo pasados por par�metros
	
		// Paso 1.1. Validar si la cadena no es nula y no esta vac�a
		// Paso 1.2 Validar si es mayor que el tama�o maximo (Constantes)
		// Paso 1.3 Validar si es menor que el tama�o minimo (Constantes)
		// Paso 1.4 Validar si no contiene palabras no permitidas;		
		public static void validLenght(String cadena, int tamanyoMin, int tamanyoMax) throws StringNotValidException {
//			1.1
			noStringException(cadena);
//			1.2
			tamanyoMaxException(cadena,tamanyoMax);
//			1.3
			tamanyoMinException(cadena,tamanyoMin);
//			1.4
			wordNotAllowedException(cadena);
		}
	

	// Paso 3. Si alguna funcionalidad se repitiese extraerla en un m�todo privado
	private static void noStringException(String cadena) throws StringNotValidException {
		if(cadena.equals(null) || cadena.equals("")) throw new StringNotValidException(CodeErrors.NO_STRING, " String vacio ");
	}
	private static void tamanyoMaxException(String cadena, int tamanyoMax) throws StringTooLongException {
		if (cadena.length() > tamanyoMax) throw new StringTooLongException(CodeErrors.STRING_TOO_LONG, " String muy largo ", cadena.length());
	}
	private static void tamanyoMinException(String cadena, int tamayoMin) throws StringTooShortException {
		if(cadena.length() < tamayoMin ) throw new StringTooShortException(CodeErrors.STRING_TOO_SHORT, " String muy corto ", cadena.length());
	}
	private static void wordNotAllowedException(String cadena) throws NotAllowedWordsException {
		for(NotAllowedWord n : NotAllowedWord.values()) {
			if (cadena.contains(n.name())) throw new NotAllowedWordsException(CodeErrors.WORD_NOT_ALLOWED_FOUND, " String contiene una palabra no permitida ", n);
		}
	}
}
