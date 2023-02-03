package com.herencia.ln;

import com.herencia.data.Dalmata;
import com.herencia.ln.interfaces.IPerro;

public class GesDalmata implements IPerro {

	Dalmata dalmata;

	@Override
	public void comer() {
		System.out.println("Dalmata -> comer()");
	}

	@Override
	public void amamantar() {
		System.out.println("Dalmata -> amamantar()");
	}

	@Override
	public void nacer() {
		System.out.println("Dalmata -> nacer()");
	}

	@Override
	public void vivir() {
		System.out.println("Dalmata -> vivir()");
	}

	@Override
	public void morir() {
		System.out.println("Dalmata -> morir()");
	}

	@Override
	public void ladrar() {
		System.out.println("Dalmata -> ladrar()");
	}

}
