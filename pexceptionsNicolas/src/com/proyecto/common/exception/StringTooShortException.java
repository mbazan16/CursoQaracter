package com.proyecto.common.exception;

//Paso 1. Identificar esta clase commo hija de StringNotValidException
public class StringTooShortException extends StringNotValidException {

	// Paso 2. Indicar un atributo inmutable tipo int llamado "tamanyo"

	private final int tamanyo = 10;

	// Paso 3. Implementar el constructor adecuado para asignar valor a todos
	// los atributos de esta clase incluidos los heredados

	public StringTooShortException(String code, String message) {
		super(code, message);
	}

	// Paso 4. Implementar un metodo para conseguir el valor del atributo "tamanyo"

	public int getTamanyo() {
		return tamanyo;
	}
}
