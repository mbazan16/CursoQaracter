package com.proyecto.common.exception;

public class StringNotValidException extends Exception
{
	
	//Paso 1.Indicar atributo protegido de tipo String llamado "code"

	protected String code;
	
	//Paso 2. Implementar un contructor, que tenga por parametro un valor para code
	// y un mensaje para el constructor del padre
	
	public StringNotValidException(String x,String mensj) 
	{
		super(mensj);
		this.code = x;
	}

	
	

}
