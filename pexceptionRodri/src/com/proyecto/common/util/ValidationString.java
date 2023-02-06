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
	public static void validLenght(String cadena) {
		// Paso 1.1. Validar si la cadena no es nula y no esta vac�a
		// Paso 1.2 Validar si es mayor que el tama�o maximo (Constantes)
		// Paso 1.3 Validar si es menor que el tama�o minimo (Constantes)
		
		// Paso 1.4 Validar si no contiene palabras no permitidas;
		validLenght(cadena, Constantes.TAMANIO_MAX, Constantes.TAMANIO_MIN);
	
	}
	// Paso 2: Sobrecargar el m�todo anterior para que realize las
	// validaciones con dos valores m�ximo y m�nimo pasados por par�metros
	public static void validLenght(String cadena, int max, int min) {
		// Paso 1.1. Validar si la cadena no es nula y no esta vac�a
		if (cadena == null || cadena.length() == 0) 
			throw new StringNotValidException(CodeErrors.NO_STRING, "Cadena nula o tamanyo 0");
		// Paso 1.2 Validar si es mayor que el tama�o maximo (Constantes)
		if (cadena.length() > max) 
			throw new StringTooLongException(CodeErrors.STRING_TOO_LONG, 
					"Cadena con tamanyo mayor a " + max, 
					cadena.length());
		// Paso 1.3 Validar si es menor que el tama�o minimo (Constantes)
		if (cadena.length() < min) 
			throw new StringTooShortException(CodeErrors.STRING_TOO_SHORT, 
					"Cadena con tamanyo menor a " + min, 
					cadena.length());
		// Paso 1.4 Validar si no contiene palabras no permitidas;	
		NotAllowedWord[] x = NotAllowedWord.values();
		if (x.)
			throw new NotAllowedWordsException(CodeErrors.STRING_TOO_SHORT, 
					"Cadena con tamanyo menor a " + min);
	}
	

	// Paso 3. Si alguna funcionalidad se repitiese extraerla en un m�todo privado
	

}
