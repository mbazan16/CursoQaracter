package com.herencia.data;

public class Dalmata extends Perro {
	private int tipoMoteado;

	public Dalmata(boolean mcaGenero, int edad, boolean mcaPelo, boolean mcaPatas, boolean mcaDomestico, int tamanio,
			int tipoHocico, int tipoPelo, int tipoMoteado) {
		super(mcaGenero, edad, mcaPelo, mcaPatas, mcaDomestico, tamanio, tipoHocico, tipoPelo);
		this.tipoMoteado = tipoMoteado;
	}

	public int getTipoMoteado() {
		return tipoMoteado;
	}

	public void setTipoMoteado(int tipoMoteado) {
		this.tipoMoteado = tipoMoteado;
	}
}
