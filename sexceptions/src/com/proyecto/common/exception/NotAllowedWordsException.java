package com.proyecto.common.exception;

import com.proyecto.common.NotAllowedWord;

//Paso 1. Identificar esta clase commo hija de StringNotValidException
public class NotAllowedWordsException extends StringNotValidException {

	// Paso 2. Indicar un atributo inmutable tipo NotAllowedWord llamado "word"
	private NotAllowedWord word;
	
	private String cadena;
	
	public NotAllowedWordsException(String code, NotAllowedWord word,String message) {
		super(code,message);
		this.word=word;
	}

	public NotAllowedWord getWord() {
		return word;
	}
	
	
}
