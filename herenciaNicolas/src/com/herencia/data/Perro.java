package com.herencia.data;

public class Perro extends Mamifero {
	protected int tamanio;
	protected int tipoHocico;
	protected int tipoPelo;

	public Perro(boolean mcaGenero, int edad, boolean mcaPelo, boolean mcaPatas, boolean mcaDomestico, int tamanio,
			int tipoHocico, int tipoPelo) {
		super(mcaGenero, edad, mcaPelo, mcaPatas, mcaDomestico);
		this.tamanio = tamanio;
		this.tipoHocico = tipoHocico;
		this.tipoPelo = tipoPelo;
	}

	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}

	public int getTipoHocico() {
		return tipoHocico;
	}

	public void setTipoHocico(int tipoHocico) {
		this.tipoHocico = tipoHocico;
	}

	public int getTipoPelo() {
		return tipoPelo;
	}

	public void setTipoPelo(int tipoPelo) {
		this.tipoPelo = tipoPelo;
	}

}
