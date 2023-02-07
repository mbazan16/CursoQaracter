package com.proyecto.common.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
	public static void validLenght(String cadena) throws StringNotValidException {
		// Paso 1.1. Validar si la cadena no es nula y no esta vacía
		// Paso 1.2 Validar si es mayor que el tamaño maximo (Constantes)
		// Paso 1.3 Validar si es menor que el tamaño minimo (Constantes)
		// Paso 1.4 Validar si no contiene palabras no permitidas;
		validLenght(cadena, Constantes.TAMANIO_MAX, Constantes.TAMANIO_MIN);
	
	}
	// Paso 2: Sobrecargar el método anterior para que realize las
	// validaciones con dos valores máximo y mínimo pasados por parámetros
	public static void validLenght(String cadena, int max, int min) throws StringNotValidException{
		String cadenaUpper;
		
		// Paso 1.1. Validar si la cadena no es nula y no esta vacía
		if (cadena == null || cadena.length() == 0) 
			throw new StringNotValidException(CodeErrors.NO_STRING, "Cadena nula o tamanyo 0");
		
		// Paso 1.2 Validar si es mayor que el tamaño maximo (Constantes)
		if (cadena.length() > max) 
			throw new StringTooLongException(CodeErrors.STRING_TOO_LONG, 
					"Cadena con tamanyo mayor a " + max, 
					cadena.length());
		
		// Paso 1.3 Validar si es menor que el tamaño minimo (Constantes)
		if (cadena.length() < min) 
			throw new StringTooShortException(CodeErrors.STRING_TOO_SHORT, 
					"Cadena con tamanyo menor a " + min, 
					cadena.length());
		
		// Paso 1.4 Validar si no contiene palabras no permitidas;	
		cadenaUpper = cadena.toUpperCase();
		List<NotAllowedWord> words = Arrays.asList(NotAllowedWord.values())
				.stream()
				.filter(t -> cadenaUpper.contains(t.toString()
						.subSequence(0, t.toString().length()-1)))
				.collect(Collectors.toList());
		if (!words.isEmpty())
			throw new NotAllowedWordsException(CodeErrors.WORD_NOT_ALLOWED_FOUND, 
					"Cadena con palabra no permitida",
					words.get(0));
	}
	

	// Paso 3. Si alguna funcionalidad se repitiese extraerla en un método privado
	

}
