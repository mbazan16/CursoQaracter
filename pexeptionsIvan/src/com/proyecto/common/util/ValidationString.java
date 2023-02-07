package com.proyecto.common.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Matcher;

import com.proyecto.common.Constantes;
import com.proyecto.common.NotAllowedWord;
import com.proyecto.common.exception.CodeErrors;
import com.proyecto.common.exception.NotAllowedWordsException;
import com.proyecto.common.exception.StringNotValidException;
import com.proyecto.common.exception.StringTooLongException;
import com.proyecto.common.exception.StringTooShortException;
import java.util.regex.Pattern;


public class ValidationString {

	// Paso 1. Implementar un método estático "validLenght"que valide
	// si una cadena tiene mas tamañano de 25 posiciones y menos de 1 posición
	// El método tiene que devolver void, utilizar excepciones, declarar las
	// necesarias
		// Paso 1.1. Validar si la cadena no es nula y no esta vacía
		// Paso 1.2 Validar si es mayor que el tamaño maximo (Constantes)
		// Paso 1.3 Validar si es menor que el tamaño minimo (Constantes)
		
		// Paso 1.4 Validar si no contiene palabras no permitidas;
	
	public static void validLenght(String x) throws StringNotValidException
	{
		validString(x,Constantes.TAMANIO_MAX,Constantes.TAMANIO_MIN);
	}

	// Paso 2: Sobrecargar el método anterior para que realize las
	// validaciones con dos valores máximo y mínimo pasados por parámetros
	
		// Paso 1.1. Validar si la cadena no es nula y no esta vacía
		// Paso 1.2 Validar si es mayor que el tamaño maximo (Constantes)
		// Paso 1.3 Validar si es menor que el tamaño minimo (Constantes)
		// Paso 1.4 Validar si no contiene palabras no permitidas;		
		
	public static void validLenght(String x,int max,int min) throws StringNotValidException
	{
		validString(x,max,min);
	}

	// Paso 3. Si alguna funcionalidad se repitiese extraerla en un método privado
	
	private static String checkNotAllowedWords(String x) 
	{
		Matcher restriction;
		for(NotAllowedWord words : NotAllowedWord.values()) 
		{
			String expression = "(^|\\s)" + words.name() + "(\\s|$)";
			restriction = Pattern.compile(expression).matcher(x);
			if(restriction.find()) 
				return words.name();
		}
		
		return null;
	}
	
	private static void validString(String x, int max,int min) throws StringNotValidException
	{
		if(x == null || x.length() == 0) 
			throw new StringNotValidException(CodeErrors.NO_STRING, "Cadena invalida");
		if(x.length() < min) 
			throw new StringTooShortException(x.length(),
					CodeErrors.STRING_TOO_SHORT, 
					"Cadena muy corta");
		if(x.length() > max) 
			throw new StringTooLongException(x.length(), 
					CodeErrors.STRING_TOO_LONG
					, "Cadena muy larga");
		String checkNotAllowedWord = checkNotAllowedWords(x);
		if(checkNotAllowedWord != null) 
				throw new NotAllowedWordsException(NotAllowedWord.valueOf(checkNotAllowedWord), 
						CodeErrors.WORD_NOT_ALLOWED_FOUND , "Palabra invalida");
	}
	

}
