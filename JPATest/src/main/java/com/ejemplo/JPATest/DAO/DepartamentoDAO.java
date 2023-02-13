package com.ejemplo.JPATest.DAO;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ejemplo.JPATest.entities.Departamento;
import com.ejemplo.JPATest.exceptions.DAOException;
import com.ejemplo.JPATest.interfaces.IDAO;

public class DepartamentoDAO implements IDAO<Integer, Departamento> {

	private static final Logger log = LoggerFactory.getLogger(DepartamentoDAO.class);
	EntityManagerFactory factory;
	EntityManager manager;

	@Override
	public List<Departamento> findAll() throws DAOException {
		init();
		List<Departamento> dep3 = manager.createNamedQuery("Departamento.findAll", Departamento.class).getResultList();
		return dep3;
	}

	public List<Departamento> findAllByCity(String City) throws DAOException {
		init();
		String query = "SELECT d FROM Departamento d WHERE d.direccion.ciudad = :ciudad";
		List<Departamento> dep3 = manager.createQuery(query, Departamento.class).setParameter("ciudad", City)
				.getResultList();
		// .createNamedQuery("Departamento.findAll",
		// Departamento.class).getResultList();
		dep3.stream().map(Departamento::toString).forEach(log::info);
		return dep3;
	}
	
//	public List<Departamento> findAllByProvince(String Province) throws DAOException {
//		init();
//		String query = "SELECT department_id, department_name, manager_id, location_id FROM DEPARTMENTS d NATURAL JOIN LOCATIONS l WHERE l.state_province =?";
//		List<Departamento> dep3 = (List<Departamento>) manager.
//				createNativeQuery(query, Departamento.class)
//				.setParameter(1, Province).getResultStream()
//				.map(s -> (Departamento)s).collect(Collectors.toList());
//		// .createNamedQuery("Departamento.findAll",
//		// Departamento.class).getResultList();
//		dep3.stream().map(Departamento::toString).forEach(log::info);
//		return dep3;
//	}
	
	public List<Departamento> findAllByProvince(String province) throws DAOException 
	{
		init();
		
		String sql = "SELECT D.DEPARTMENT_ID, D.DEPARTMENT_NAME FROM "
				+ " DEPARTMENTS D NATURAL JOIN LOCATIONS L "
				+ " WHERE L.STATE_PROVINCE = ?";
		List<Departamento> dep = manager.createNativeQuery
				(sql,Departamento.class)
				.setParameter(1,province)
				.getResultList();
		log.info("Departamentos:");
		if(dep.isEmpty()) log.info("No hay departamentos");
		dep.forEach(s-> log.info(s.toString()));
		return dep;
	}

	@Override
	public Departamento findOne(Integer key) throws DAOException {
		init();
		Departamento dep = manager.find(Departamento.class, key);
		return dep;
	}

	@Override
	public void create(Departamento item) throws DAOException {
//		init();
//		manager.persist(item);
		log.info("Method: [Crear]");
		log.debug("Parmetros:[Departamento element:" + item + "]");

		try {
			init();

			try {
				log.debug("[Crear]Iniciamos transaccion");
				//manager.getTransaction().begin();

				//manager.persist(item);

				//manager.getTransaction().commit();
				log.debug("[Crear]Commit - Creamos departamento");
			} catch (Exception e) {
				log.error("Error", e);
				//manager.getTransaction().rollback();
				log.debug("[Crear]Rollback");
				throw new DAOException(e);
			} finally {
				manager.close();
			}

		} catch (DAOException daoe) {
			throw daoe;
		} catch (Exception e) {
			log.error("Error", e);
			throw new DAOException(e);
		}
	}

	@Override
	public void update(Departamento item) throws DAOException {
		init();
		// manager.merge(item);
		Departamento dep2 = findOne(item.getId());
		dep2.setNombre(item.getNombre());

	}

	@Override
	public void delete(Integer key) throws DAOException {
		// init();
		// Departamento depto = findOne(key);
		// manager.remove(depto);

		try {
			init();
			//Departamento depto = findOne(key);
			try {
				log.debug("[Crear]Iniciamos transaccion");
				//manager.getTransaction().begin();

				//manager.remove(depto);

				//manager.getTransaction().commit();
				log.debug("[Crear]Commit - Creamos departamento");
			} catch (Exception e) {
				log.error("Error", e);
				//manager.getTransaction().rollback();
				log.debug("[Crear]Rollback");
				throw new DAOException(e);
			} //finally {
				//manager.close();
			//}

		} catch (DAOException daoe) {
			throw daoe;
		} catch (Exception e) {
			log.error("Error", e);
			throw new DAOException(e);
		}
	}

	private void init() {
		if (factory == null)
			factory = Persistence.createEntityManagerFactory("JPATest");
		if (manager == null)
			manager = factory.createEntityManager();
	}
}
