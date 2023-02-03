package com.herencia.ln;

import com.herencia.data.Perro;
import com.herencia.ln.interfaces.IPerro;

public class GesPerro implements IPerro{

	public Perro perro;
	
	@Override
	public void comer() {
		System.out.println("GesPerro: comer()");
		
	}

	@Override
	public void amamantar() {
		System.out.println("GesPerro: amamantar()");
		
	}

	@Override
	public void nacer() {
		System.out.println("GesPerro: nacer()");
		
	}

	@Override
	public void vivir() {
		System.out.println("GesPerro: vivir()");
		
	}

	@Override
	public void morir() {
		System.out.println("GesPerro: morir()");
		
	}

	@Override
	public void ladrar() {
		System.out.println("GesPerro: ladrar()");
		
	}
	
}
