package com.herencia.ln;

import com.herencia.data.Perro;
import com.herencia.ln.interfaces.IPerro;

public class GesPerro implements IPerro {

	Perro perro;

	@Override
	public void comer() {
		System.out.println("Perro -> comer()");
	}

	@Override
	public void amamantar() {
		System.out.println("Perro -> amamantar()");
	}

	@Override
	public void nacer() {
		System.out.println("Perro -> nacer()");
	}

	@Override
	public void vivir() {
		System.out.println("Perro -> vivir()");
	}

	@Override
	public void morir() {
		System.out.println("Perro -> morir()");
	}

	@Override
	public void ladrar() {
		System.out.println("Perro -> ladrar()");
	}

}
