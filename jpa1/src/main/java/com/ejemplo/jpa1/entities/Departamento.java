package com.ejemplo.jpa1.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the departments database table.
 * 
 */
@Entity
@Table(name="departments")
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="department_id")
	private int id;

	@Column(name="department_name")
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "location_id")
	private Direccion direccion;
	
	@Column(name="manager_id")
	private int managerId;

	public Departamento() {
	}

	public Departamento(int id, String nombre, Direccion direccion, int managerId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.managerId = managerId;
	}
	
	public Departamento(int id, String nombre, int idDireccion, int managerId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = new Direccion();
		this.direccion.setId(idDireccion);
		this.managerId = managerId;
	}
	

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public int getManagerId() {
		return this.managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

}