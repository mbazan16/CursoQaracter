package com.herencia.data;

public class Conejo extends Mamifero{
	private int tipoConejo;

	public Conejo(boolean mcaGenero, int edad, boolean mcaPelo, boolean mcaPatas, boolean mcaDomestico,
			int tipoConejo) {
		super(mcaGenero, edad, mcaPelo, mcaPatas, mcaDomestico);
		this.tipoConejo = tipoConejo;
	}

	public int getTipoConejo() {
		return tipoConejo;
	}

	public void setTipoConejo(int tipoConejo) {
		this.tipoConejo = tipoConejo;
	}
	
	
}
