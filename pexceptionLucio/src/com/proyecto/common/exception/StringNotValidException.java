package com.proyecto.common.exception;

//creo que la tengo que extender de exception no se
public class StringNotValidException extends Exception{
	
	//Paso 1.Indicar atributo protegido de tipo String llamado "code"
	protected String code;

			
	//Paso 2. Implementar un contructor, que tenga por parametro un valor para code
	// y un mensaje para el constructor del padre
	public StringNotValidException(String code, String str) {
		super(str);
		this.code = code;
	}
	
	
	

}
