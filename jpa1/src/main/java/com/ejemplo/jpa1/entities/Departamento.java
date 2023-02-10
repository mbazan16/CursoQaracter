package com.ejemplo.jpa1.entities;

import java.io.Serializable;
import javax.persistence.*;


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

	@Column(name="location_id")
	private int locationId;

	@Column(name="manager_id")
	private int managerId;

	public Departamento() {
	}

	public Departamento(int id, String nombre, int locationId, int managerId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.locationId = locationId;
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

	public int getLocationId() {
		return this.locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getManagerId() {
		return this.managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

}