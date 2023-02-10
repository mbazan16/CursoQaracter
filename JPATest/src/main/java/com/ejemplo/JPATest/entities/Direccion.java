package com.ejemplo.JPATest.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the locations database table.
 * 
 */
@Entity
@Table(name = "locations")
@NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d")
public class Direccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "location_id")
	private int Id;

	@Column(name = "city")
	private String ciudad;

	@Column(name = "country_id")
	private String countryId;

	@Column(name = "postal_code")
	private String codigoPostal;

	@Column(name = "state_province")
	private String stateProvince;

	@Column(name = "street_address")
	private String numeroCcalle;

	@OneToMany(mappedBy = "direccion")
	private List<Departamento> departamentos;

	public Direccion() {
	}

	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCountryId() {
		return this.countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getStateProvince() {
		return this.stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getNumeroCcalle() {
		return this.numeroCcalle;
	}

	public void setNumeroCcalle(String numeroCcalle) {
		this.numeroCcalle = numeroCcalle;
	}

	public List<Departamento> getDepartamento() {
		return departamentos;
	}

	public void setDepartamento(List<Departamento> departamento) {
		this.departamentos = departamento;
	}

}