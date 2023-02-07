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
		Scanner sc = new Scanner(System.in);
		String ingresoNoValido="";
		String ingreso;
		StringNotValidException exceptionRecogida=null;
		// Paso 1. Realizar un bucle infinito, que �nicamente se pare
		// cuando el c�digo lance una excepcion de cadena nula o vac�a o 
		// de palabra no permitida introducida

		//		try {
		//			while(true) {
		//				ValidationString.validLenght(ingresoNoValido);
		//			}
		//		} catch (StringNotValidException e) {
		//			// TODO Auto-generated catch block
		//			exceptionRecogida = e;
		//		}
		// Paso 2. Pedir una cadena por consola al usuario
		System.out.println("Ingrese una cadena:");
		ingreso = sc.nextLine();
		// Paso 3. Validar si la cadena es correcta con los valores por defecto
		// Si no es correcta mostrar al usuario el mensaje adecuado por cada caso
		// Implementar otro bloque try/catch anidado que solo capture las excepciones
		// de tama�o.
		try {
			ValidationString.validLenght(ingreso);
			// Paso 3.1. Se muestra un mensaje de cadena v�lida
			System.out.println("Ingreso Valido: "+ingreso);
		}
		catch(StringTooLongException e) {
			exceptionRecogida = e;
		}catch(StringTooShortException e) {
			exceptionRecogida = e;
		}catch (StringNotValidException e) {
			exceptionRecogida = e;
		}

		//Paso 4. Cuando se recojan todas las excepciones (de ambos bloques try/cach)
		//mostrar un mensaje adecuado a la  excepci�n recogida				
		finally {
			if (exceptionRecogida!=null) {
				System.out.println("Se ha encontrado un error:");
				System.out.println(exceptionRecogida.getMessage());
			}
		}
	}			


}
