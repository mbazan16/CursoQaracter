package com.ejemplo.JPATest.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ejemplo.JPATest.entities.Departamento;
import com.ejemplo.JPATest.entities.Direccion;
import com.ejemplo.JPATest.exceptions.DAOException;
import com.ejemplo.JPATest.interfaces.IDAO;

public class DireccionDAO implements IDAO<Integer, Direccion> {

	private static final Logger log = LoggerFactory.getLogger(DireccionDAO.class);
	EntityManagerFactory factory;
	EntityManager manager;

	@Override
	public List<Direccion> findAll() throws DAOException {
		init();
		List<Direccion> dep3 = manager.createNamedQuery("Direccion.findAll", Direccion.class).getResultList();
		return dep3;
	}

	@Override
	public Direccion findOne(Integer key) throws DAOException {
		init();
		Direccion dep = manager.find(Direccion.class, key);
		return dep;
	}

	@Override
	public void create(Direccion item) throws DAOException {
//		init();
//		manager.persist(item);
		log.info("Method: [Crear]");
		log.debug("Parmetros:[Direccion element:" + item + "]");

		try {
			init();

			try {
				log.debug("[Crear]Iniciamos transaccion");
				manager.getTransaction().begin();

				manager.persist(item);

				manager.getTransaction().commit();
				log.debug("[Crear]Commit - Creamos direccion");
			} catch (Exception e) {
				log.error("Error", e);
				manager.getTransaction().rollback();
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
	public void update(Direccion item) throws DAOException {
		init();
		// manager.merge(item);
		//Direccion dir = findOne(item.getId());
		//dep2.setNombre(item.getNombre());
		
		try {
			init();
			try {
				log.debug("[Crear]Iniciamos transaccion");
				manager.getTransaction().begin();
				
				Direccion dir = findOne(item.getId());
				dir.setCiudad(item.getCiudad());
				manager.merge(item);
				manager.getTransaction().commit();
				log.debug("[Crear]Commit - Actualizamos direccion");
			} catch (Exception e) {
				log.error("Error", e);
				manager.getTransaction().rollback();
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
	public void delete(Integer key) throws DAOException {
		//init();
		//Direccion depto = findOne(key);
		//manager.remove(depto);
		
		try {
			init();
			Direccion depto = findOne(key);
			try {
				log.debug("[Crear]Iniciamos transaccion");
				manager.getTransaction().begin();

				manager.remove(depto);

				manager.getTransaction().commit();
				log.debug("[Crear]Commit - Borramos direccion");
			} catch (Exception e) {
				log.error("Error", e);
				manager.getTransaction().rollback();
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

	private void init() {
		if (factory == null)
			factory = Persistence.createEntityManagerFactory("JPATest");
		if (manager == null)
			manager = factory.createEntityManager();
	}
}
