package com.ejemplo.jpa1.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ejemplo.jpa1.dao.exceptions.DAOException;
import com.ejemplo.jpa1.entities.Departamento;

class DepartamentoDAOTest {

	DepartamentoDAO depDAO;
	
	@BeforeEach
	public void configurarDepDAO() 
	{
		depDAO = new DepartamentoDAO();
	}
	
	@Test
	@Disabled
	void testInit() 
	{
		DepartamentoDAO depDAO = new DepartamentoDAO();
		//assertNotNull(depDAO.init());
	}
	
	@Test
	@DisplayName("Encontrar el departamento 80")
	void testFindOne() throws DAOException 
	{
		assertEquals(80, depDAO.findOne(80).getId());
	}
	
	@Test
	@DisplayName("Crear un departamento")
	void testCreate() throws DAOException 
	{
		Departamento depto = new Departamento(1000,"Depto X",1700,100);
		depDAO.create(depto);
		assertEquals(1000, depDAO.findOne(1000).getId());
		assertNotNull(depDAO.findOne(1000));
	}
	
	@Test
	@DisplayName("Borrar un departamento")
	void testDelete() throws DAOException 
	{
		Departamento depto = new Departamento(1000,"Depto X",1700,100);
		depDAO.create(depto);
		depDAO.delete(1000);
		assertNull(depDAO.findOne(1000));
	}
	
	@Test
	@DisplayName("Update departamento")
	void testUpdate() throws DAOException
	{
		
		Departamento depto = new Departamento(1000,"Depto X",1700,100);
		depDAO.create(depto);
		assertEquals("Depto X", depDAO.findOne(1000).getNombre());
		
		depto.setNombre("Depto B");
		depDAO.update(depto);
		assertEquals("Depto B", depDAO.findOne(1000).getNombre());
	}
	
	@Test
	@DisplayName("Encontrar todos los departamentos")
	void testFindAll() throws DAOException 
	{
		List<Departamento> deptos= depDAO.findAll();
		assertNotNull(deptos);
	
	}
	
}
