package com.proyecto.common.exception;

import com.proyecto.common.Constantes;

//Paso 1. Identificar esta clase commo hija de StringNotValidException
public class StringTooLongException extends StringNotValidException {

	// Paso 2. Indicar un atributo inmutable tipo int llamado "tamanyo"
	private final int tamanyo;

	// Paso 3. Implementar el constructor adecuado para asignar valor a todos
	// los atributos de esta clase incluidos los heredados
	public StringTooLongException(String message, String code) {
		super(message, code);
		this.tamanyo = Constantes.TAMANIO_MAX;
	}

	// Paso 4. Implementar un metodo para conseguir el valor del atributo "tamanyo"
	public int getTamanyo() {
		return tamanyo;
	}

}
