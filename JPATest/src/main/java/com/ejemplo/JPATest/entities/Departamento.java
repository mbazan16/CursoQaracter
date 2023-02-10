package com.ejemplo.JPATest.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the departments database table.
 * 
 */
@Entity
@Table(name = "departments")
@NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "department_id")
	private int Id;

	@Column(name = "department_name")
	private String Nombre;

	// @Column(name = "location_id")

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id", referencedColumnName = "location_id")
	private Direccion direccion;

	@Column(name = "manager_id")
	private int managerId;

	public Departamento() {
	}

	public Departamento(int id, String nombre, int direccion, int managerId) {
		super();
		Id = id;
		Nombre = nombre;
		this.direccion = new Direccion();
		this.direccion.setId(direccion);
		this.managerId = managerId;
	}

	
	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
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