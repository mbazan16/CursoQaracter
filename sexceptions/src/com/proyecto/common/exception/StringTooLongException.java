package com.proyecto.common.exception;

//Paso 1. Identificar esta clase commo hija de StringNotValidException
public class StringTooLongException extends StringNotValidException {

	//Paso 2. Indicar un atributo inmutable tipo int llamado "tamanyo"
	private int tamanyo;
	
	//Paso 3. Implementar el constructor adecuado	
	public StringTooLongException(String code, int tamanyo, String message) {
		super(code,message);
		this.tamanyo = tamanyo;
	}

	public int getTamanyo() {
		return tamanyo;
	}	
	
}
