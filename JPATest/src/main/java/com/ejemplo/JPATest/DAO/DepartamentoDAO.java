package com.ejemplo.JPATest.DAO;

import java.util.List;

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

	@Override
	public Departamento findOne(Integer key) throws DAOException {
		init();
		Departamento dep = manager.find(Departamento.class, key);
		return dep;
	}

	@Override
	public void create(Departamento item) throws DAOException {
		init();
		manager.persist(item);

		try {
			init();

			try {
				log.debug("[crear]Iniciamos transacciï¿½n");
				manager.getTransaction().begin();
				manager.persist(item);
				manager.getTransaction().commit();
				log.debug("[crear]Commit - Creamos departamento");
			} catch (Exception e) {
				log.error("Error", e);
				manager.getTransaction().rollback();
				log.debug("[crear]Rollback");
				throw new DAOException(e);
			}finally{
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
		init();
		Departamento depto = findOne(key);
		manager.remove(depto);
	}

	private void init() {
		if (factory == null)
			factory = Persistence.createEntityManagerFactory("JPATest");
		if (manager == null)
			manager = factory.createEntityManager();
	}
}
