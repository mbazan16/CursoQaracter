package com.ejemplo.JPATest.DAO;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ejemplo.JPATest.entities.Departamento;
import com.ejemplo.JPATest.exceptions.DAOException;

class DepartamentoDAOTest {

	DepartamentoDAO depDAO;

	private static final Logger log = LoggerFactory.getLogger(DepartamentoDAOTest.class);

	@BeforeEach
	public void configurarDepDao() {
		depDAO = new DepartamentoDAO();
	}

	@Test
	@Disabled
	@DisplayName("Comprobar la nulidad")
	void test() {
		DepartamentoDAO depDAO = new DepartamentoDAO();
		// assertNotNull(depDAO.init());
	}

	@Test
	@Disabled
	@DisplayName("Encontrar el departamento 80")
	void testFindOne() throws DAOException {
		// DepartamentoDAO depDAO = new DepartamentoDAO();

		log.info("--------------Departamento: TestFindOne--------------");
		assertEquals(80, depDAO.findOne(80).getId());
		assertEquals("Oxford", depDAO.findOne(80).getDireccion().getCiudad());
	}

	@Test
	@Disabled
	@DisplayName("Mostrar todos los departamentos de Oxford")
	void findAllByCity() throws DAOException {
		// DepartamentoDAO depDAO = new DepartamentoDAO();
		List<Departamento> dep = depDAO.findAllByCity("Oxford");
		assertNotNull(dep);
	}

	@Test
	@Disabled
	@DisplayName("Encontrar el departamento 1000 y comprobar si lo ha creado")
	void testCreate() throws DAOException {
		// DepartamentoDAO depDAO = new DepartamentoDAO();
		Departamento dep = new Departamento(1000, "Dep x", 1700, 100);
		depDAO.create(dep);
		assertNotNull(depDAO.findOne(1000));
		assertEquals(1000, depDAO.findOne(1000).getId());
	}

	@Test
	@Disabled
	@DisplayName("Actualizar departamento")
	void testUpdate() throws DAOException {
		// DepartamentoDAO depDAO = new DepartamentoDAO();
		Departamento dep = new Departamento(1000, "Dep x", 1700, 100);
		// depDAO.create(dep);
		assertEquals("Dep x", depDAO.findOne(1000).getNombre());
		assertEquals("Dep x", dep.getNombre());
		dep.setNombre("Dep y");
		depDAO.update(dep);
		assertEquals("Dep y", depDAO.findOne(1000).getNombre());
	}

	@Test
	@Disabled
	@DisplayName("Departamento borrado")
	void testDelete() throws DAOException {
		// DepartamentoDAO depDAO = new DepartamentoDAO();
		Departamento dep = new Departamento(1000, "Dep y", 1700, 100);
//		depDAO.create(dep);
		depDAO.delete(1000);
		assertNull(depDAO.findOne(1000));
	}

	@Test
	@DisplayName("Mostrar todos los departamentos")
	void findAll() throws DAOException {
		// DepartamentoDAO depDAO = new DepartamentoDAO();
		List<Departamento> dep = depDAO.findAll();
		assertNotNull(dep);
	}
}
