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

@SuppressWarnings("unused")
public class ValidationString {

	// Paso 1. Implementar un m�todo est�tico "validLenght"que valide
	// si una cadena tiene mas tama�ano de 25 posiciones y menos de 1 posici�n
	// El m�todo tiene que devolver void, utilizar excepciones, declarar las
	// necesarias
		// Paso 1.1. Validar si la cadena no es nula y no esta vac�a
		// Paso 1.2 Validar si es mayor que el tama�o maximo (Constantes)
		// Paso 1.3 Validar si es menor que el tama�o minimo (Constantes)
		
		// Paso 1.4 Validar si no contiene palabras no permitidas;

	public static void validLenght(String cadena) throws StringNotValidException  {
		validador(cadena, new Constantes().TAMANIO_MAX, new Constantes().TAMANIO_MIN);
	}
	

	// Paso 2: Sobrecargar el m�todo anterior para que realize las
	// validaciones con dos valores m�ximo y m�nimo pasados por par�metros
	
		// Paso 1.1. Validar si la cadena no es nula y no esta vac�a
		// Paso 1.2 Validar si es mayor que el tama�o maximo (Constantes)
		// Paso 1.3 Validar si es menor que el tama�o minimo (Constantes)
		// Paso 1.4 Validar si no contiene palabras no permitidas;		
		
	public static void validLenght(String cadena, int max, int min) throws StringNotValidException {
		validador(cadena, max, min);
	}

	// Paso 3. Si alguna funcionalidad se repitiese extraerla en un m�todo privado
	private static void validador(String cadena, int max, int min) throws StringNotValidException {
		if (cadena.isEmpty() || cadena == null) throw new StringNotValidException(CodeErrors.NO_STRING, "Cadena vac�a o nula.");
		if(cadena.length() > max) throw new StringTooLongException(CodeErrors.STRING_TOO_LONG, "Cadena demasiado larga", cadena.length());
		if(cadena.length() < min) throw new StringTooShortException(CodeErrors.STRING_TOO_SHORT, "Cadena demasiado corta", cadena.length());
		
		for(NotAllowedWord word: NotAllowedWord.values()){
			if(cadena.toUpperCase().contains(word.name())) throw new NotAllowedWordsException(CodeErrors.WORD_NOT_ALLOWED_FOUND, "Palabra prohibida usada", word);
			
		}
	}

}