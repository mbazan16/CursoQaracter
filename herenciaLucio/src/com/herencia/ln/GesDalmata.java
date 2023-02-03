package com.herencia.ln;

import com.herencia.data.Dalmata;
import com.herencia.ln.interfaces.IPerro;

public class GesDalmata implements IPerro{

	public Dalmata dalmata;
	
	@Override
	public void comer() {
		System.out.println("GesDalamta: comer()");
	}

	@Override
	public void amamantar() {
		System.out.println("GesDalamta: amamantar()");
		
	}

	@Override
	public void nacer() {
		System.out.println("GesDalamta: nacer()");
		
	}

	@Override
	public void vivir() {
		System.out.println("GesDalamta: vivir()");
		
	}

	@Override
	public void morir() {
		System.out.println("GesDalamta: morir()");
		
	}

	@Override
	public void ladrar() {
		System.out.println("GesDalamta: ladrar()");
		
	}
	
}
