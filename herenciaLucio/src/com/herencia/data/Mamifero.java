package com.herencia.data;

public abstract class Mamifero extends Animal{

	protected boolean mcaPelo, mcaPatas, mcaDomestico;

	public Mamifero(boolean mcaGenero, int edad, boolean mcaPelo, boolean mcaPatas, boolean mcaDomestico) {
		super(mcaGenero, edad);
		this.mcaPelo = mcaPelo;
		this.mcaPatas = mcaPatas;
		this.mcaDomestico = mcaDomestico;
	}

	public boolean isMcaPelo() {
		return mcaPelo;
	}

	public void setMcaPelo(boolean mcaPelo) {
		this.mcaPelo = mcaPelo;
	}

	public boolean isMcaPatas() {
		return mcaPatas;
	}

	public void setMcaPatas(boolean mcaPatas) {
		this.mcaPatas = mcaPatas;
	}

	public boolean isMcaDomestico() {
		return mcaDomestico;
	}

	public void setMcaDomestico(boolean mcaDomestico) {
		this.mcaDomestico = mcaDomestico;
	}
	
	

}
