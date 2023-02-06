package com.proyecto.common.util;

import java.io.NotActiveException;
import java.util.Arrays;
import java.util.Iterator;

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
	// El método tiene que devolver void, utilizar excepciones, declarar las
	// necesarias
		// Paso 1.1. Validar si la cadena no es nula y no esta vacía
		// Paso 1.2 Validar si es mayor que el tamaño maximo (Constantes)
		// Paso 1.3 Validar si es menor que el tamaño minimo (Constantes)
		
		// Paso 1.4 Validar si no contiene palabras no permitidas;
	private static void validador(String cadena, int max, int min) throws StringNotValidException {
		if (cadena.isEmpty() || cadena == null) throw new StringNotValidException("NO_STRING", "Cadena vacía o nula.");
		if(cadena.length() > max) throw new StringTooLongException("STRING_TOO_LONG", "Cadena demasiado larga", cadena.length());
		if(cadena.length() < min) throw new StringTooShortException("STRING_TOO_SHORT", "Cadena demasiado corta", cadena.length());
		notAllowedValidador(cadena);
	}
	
	private static void notAllowedValidador(String cadena) throws NotAllowedWordsException {
		if(cadena.toUpperCase().contains(NotAllowedWord.DELETE.name())) throw new NotAllowedWordsException("WORD_NOT_ALLOWED_FOUND", "Palabra prohibida usada", NotAllowedWord.DELETE);
		if(cadena.toUpperCase().contains(NotAllowedWord.DROP.name())) throw new NotAllowedWordsException("WORD_NOT_ALLOWED_FOUND", "Palabra prohibida usada", NotAllowedWord.DROP);
		if(cadena.toUpperCase().contains(NotAllowedWord.INSERT.name())) throw new NotAllowedWordsException("WORD_NOT_ALLOWED_FOUND", "Palabra prohibida usada", NotAllowedWord.INSERT);
		if(cadena.toUpperCase().contains(NotAllowedWord.SELECT.name())) throw new NotAllowedWordsException("WORD_NOT_ALLOWED_FOUND", "Palabra prohibida usada", NotAllowedWord.SELECT);
		if(cadena.toUpperCase().contains(NotAllowedWord.TRUNCATE.name())) throw new NotAllowedWordsException("WORD_NOT_ALLOWED_FOUND", "Palabra prohibida usada", NotAllowedWord.TRUNCATE);
		if(cadena.toUpperCase().contains(NotAllowedWord.UPDATE.name())) throw new NotAllowedWordsException("WORD_NOT_ALLOWED_FOUND", "Palabra prohibida usada", NotAllowedWord.UPDATE);
		
	}
	
	
	public static void validLenght(String cadena) throws StringNotValidException  {
		validador(cadena, new Constantes().TAMANIO_MAX, new Constantes().TAMANIO_MIN);
	}
	

	// Paso 2: Sobrecargar el método anterior para que realize las
	// validaciones con dos valores máximo y mínimo pasados por parámetros
	
		// Paso 1.1. Validar si la cadena no es nula y no esta vacía
		// Paso 1.2 Validar si es mayor que el tamaño maximo (Constantes)
		// Paso 1.3 Validar si es menor que el tamaño minimo (Constantes)
		// Paso 1.4 Validar si no contiene palabras no permitidas;		
		
	public static void validLenght(String cadena, int max, int min) throws StringNotValidException {
		validador(cadena, max, min);
	}

	// Paso 3. Si alguna funcionalidad se repitiese extraerla en un método privado
	

}
