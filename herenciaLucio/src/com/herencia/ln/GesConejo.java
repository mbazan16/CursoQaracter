package com.herencia.ln;

import com.herencia.data.Conejo;
import com.herencia.ln.interfaces.IConejo;

public class GesConejo implements IConejo{
	public Conejo conejo;

	@Override
	public void comer() {
		System.out.println("GesConejo: comer()");
		
	}

	@Override
	public void amamantar() {
		System.out.println("GesConejo: amamantar()");
		
	}

	@Override
	public void nacer() {
		System.out.println("GesConejo: nacer()");
		
	}

	@Override
	public void vivir() {
		System.out.println("GesConejo: vivir()");
		
	}

	@Override
	public void morir() {
		System.out.println("GesConejo: morir()");
		
	}

	@Override
	public void saltar() {
		System.out.println("GesConejo: saltar()");
		
	}
	
	
	
}
