package com.front.pTipoAnt.data;

import java.util.Objects;

public class Direccion {
	private Long id;
	private String calle;
	private String codigoPostal;
	private String ciudad;
	private String estado;
	private String idPais;

	public Direccion() {
		super();
	}

	public Direccion(Long id, String calle, String codigoPostal, String ciudad, String estado, String idPais) {
		super();
		this.id = id;
		this.calle = calle;
		this.codigoPostal = codigoPostal;
		this.ciudad = ciudad;
		this.estado = estado;
		this.idPais = idPais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIdPais() {
		return idPais;
	}

	public void setIdPais(String idPais) {
		this.idPais = idPais;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direccion other = (Direccion) obj;
		return Objects.equals(calle, other.calle) && Objects.equals(ciudad, other.ciudad)
				&& Objects.equals(codigoPostal, other.codigoPostal) && Objects.equals(estado, other.estado)
				&& Objects.equals(id, other.id) && Objects.equals(idPais, other.idPais);
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", codigoPostal=" + codigoPostal + ", ciudad=" + ciudad
				+ ", estado=" + estado + ", pais=" + idPais + "]";
	}
}
