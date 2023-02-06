package com.proyecto.common.exception;

//Paso 1. Identificar esta clase commo hija de StringNotValidException
public class StringTooShortException extends StringNotValidException {

	// Paso 2. Indicar un atributo inmutable tipo int llamado "tamanyo"
	private int tamanyo;

	// Paso 3. Implementar el constructor adecuado para asignar valor a todos
	// los atributos de esta clase incluidos los heredados
	public StringTooShortException(String code, String message, int tamanyo) {
		super(code, message);
		this.tamanyo = tamanyo;
	}

	// Paso 4. Implementar un metodo para conseguir el valor del atributo "tamanyo"
	public int getTamanyo() {
		return tamanyo;
	}

}
