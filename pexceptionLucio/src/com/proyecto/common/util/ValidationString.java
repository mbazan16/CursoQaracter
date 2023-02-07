package com.proyecto.common.util;

import java.util.Arrays;
import java.util.Iterator;

import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;   
import java.util.function.Supplier;   
import java.util.stream.Stream;

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
	
	public static void validLenght (String str) throws StringNotValidException {
		validarNulo(str);
		validarMaximaLongitud(str, Constantes.TAMANIO_MAX);
		validarMinimaLongitud(str, Constantes.TAMANIO_MIN);
		validarPalabrasNoPermitidas(str);
	}

	// Paso 2: Sobrecargar el m�todo anterior para que realize las
	// validaciones con dos valores m�ximo y m�nimo pasados por par�metros
	
		// Paso 1.1. Validar si la cadena no es nula y no esta vac�a
		// Paso 1.2 Validar si es mayor que el tama�o maximo (Constantes)
		// Paso 1.3 Validar si es menor que el tama�o minimo (Constantes)
		// Paso 1.4 Validar si no contiene palabras no permitidas;		
	public static void validLenght (String str, int minValor, int maxValor) throws StringNotValidException {
		validarNulo(str);
		if(str.length() > maxValor) throw new StringTooLongException(CodeErrors.STRING_TOO_LONG, "La cadena es muy larga",Constantes.TAMANIO_MAX);
		if(str.length() < minValor) throw new StringTooShortException(CodeErrors.STRING_TOO_SHORT, "La cadena es muy corta",Constantes.TAMANIO_MIN);
		
		validarPalabrasNoPermitidas(str);
	}	

	// Paso 3. Si alguna funcionalidad se repitiese extraerla en un m�todo privado
	private static void validarNulo(String str) throws StringNotValidException {
		if(str == null) throw new StringNotValidException(CodeErrors.NO_STRING, "La cadena es Null");
		if(str.isEmpty()) throw new StringNotValidException(CodeErrors.NO_STRING, "La cadena esta vacía");
	}
	
	private static void validarMinimaLongitud(String str, int minValor) throws StringTooShortException {
		if(str.length() < minValor) throw new StringTooShortException(CodeErrors.STRING_TOO_SHORT, "La cadena es muy corta",Constantes.TAMANIO_MIN);
	}

	private static void validarMaximaLongitud(String str,int maxValor) throws StringTooLongException {
		if(str.length() > maxValor) throw new StringTooLongException(CodeErrors.STRING_TOO_LONG, "La cadena es muy larga",Constantes.TAMANIO_MAX);
	}

	/**
	 * 
	 * @param str
	 * @throws NotAllowedWordsException
	 */
	private static void validarPalabrasNoPermitidas(String str) throws NotAllowedWordsException {
		NotAllowedWord[] pNoPermitidas = NotAllowedWord.values();
		str = str.toUpperCase();
		for (int i = 0; i< pNoPermitidas.length; i++) {
			if(str.contains(pNoPermitidas[i].toString())) throw new NotAllowedWordsException(CodeErrors.WORD_NOT_ALLOWED_FOUND, 
					"La cadena contiene palabras no permitidas", 
					pNoPermitidas[i]);			
		}
	}

}
