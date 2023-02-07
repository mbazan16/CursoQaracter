package com.proyecto;

import java.util.Scanner;

import com.proyecto.common.exception.NotAllowedWordsException;
import com.proyecto.common.exception.StringNotValidException;
import com.proyecto.common.exception.StringTooLongException;
import com.proyecto.common.exception.StringTooShortException;
import com.proyecto.common.util.ValidationString;

public class Test {

	// Todo el c�digo excepto las declaraciones debe estar en un bloque try-catch
	public static void main(String[] args)  {
		// Declarar las variables necesarias		
		Scanner scanner;
		String cadenaIngresada;
			System.out.println("AAA");
			// Paso 1. Realizar un bucle infinito, que �nicamente se pare
			// cuando el c�digo lance una excepcion de cadena nula o vac�a o 
			// de palabra no permitida introducida
			try 
			{
				while(true)
				{
					// Paso 2. Pedir una cadena por consola al usuario
					scanner = new Scanner(System.in);
					cadenaIngresada = scanner.nextLine();
					try 
					{
						// Paso 3. Validar si la cadena es correcta con los valores por defecto
						// Si no es correcta mostrar al usuario el mensaje adecuado por cada caso
						// Implementar otro bloque try/catch anidado que solo capture las excepciones
				        // de tama�o.
						
						ValidationString.validLenght(cadenaIngresada);
						System.out.println("Cadena valida");
					}catch(StringTooLongException e) 
					{
						System.out.println(e.getMessage());
					}catch(StringTooShortException e) 
					{
						System.out.println(e.getMessage());
					}
				}
					
					
			}catch (StringNotValidException e) 
			{
				System.out.println(e.getMessage());
			}
			
					
							
							// Paso 3.1. Se muestra un mensaje de cadena v�lida
				
				
				
				
		//Paso 4. Cuando se recojan todas las excepciones (de ambos bloques try/cach)
		//mostrar un mensaje adecuado a la  excepci�n recogida				
			
											
	}			
	

}
