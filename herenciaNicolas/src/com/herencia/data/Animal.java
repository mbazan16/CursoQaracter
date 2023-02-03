package com.herencia.data;

public abstract class Animal {
	protected boolean mcaGenero;
	protected int edad;

	protected Animal(boolean mcaGenero, int edad) {
		this.mcaGenero = mcaGenero;
		this.edad = edad;
	}

	public boolean isMcaGenero() {
		return mcaGenero;
	}

	public void setMcaGenero(boolean mcaGenero) {
		this.mcaGenero = mcaGenero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}
