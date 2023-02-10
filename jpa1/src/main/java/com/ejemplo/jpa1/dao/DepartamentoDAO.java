package com.ejemplo.jpa1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ejemplo.jpa1.dao.exceptions.DAOException;
import com.ejemplo.jpa1.dao.interfaces.IDAO;
import com.ejemplo.jpa1.entities.Departamento;

public class DepartamentoDAO implements IDAO<Integer,Departamento>
{
	private static final Logger log = LoggerFactory.getLogger(DepartamentoDAO.class);
	EntityManagerFactory factory;
	EntityManager manager;
	
	@Override
	public List<Departamento> findAll() throws DAOException 
	{
		init();
		List<Departamento> deptos = manager.createNamedQuery
				("Departamento.findAll",Departamento.class).getResultList();
		return deptos;
	}

	@Override
	public Departamento findOne(Integer key) throws DAOException 
	{
		init();
		Departamento depto = manager.find(Departamento.class,key);
		return depto;
	}

	@Override
	public void create(Departamento item) throws DAOException 
	{
		log.info("Method:[crear]");
		log.debug("Parmetros:[Departamento item:" + item+"]");

		try 
		{
			init();

			try 
			{
				log.debug("[crear]Iniciamos transaccion");
				manager.getTransaction().begin();
				manager.persist(item);
				manager.getTransaction().commit();
				log.debug("[crear]Commit - Creamos departamento");
			} catch (Exception e) 
			{
				log.error("Error", e);
				manager.getTransaction().rollback();
				log.debug("[crear]Rollback");
				throw new DAOException(e);
			}finally 
			{
				manager.close();
			}

		} catch (DAOException daoe) {
			throw daoe;
		}catch (Exception e) {
			log.error("Error", e);
			throw new DAOException(e);
		}
	}

	@Override
	public void update(Departamento item) throws DAOException 
	{
		log.info("Method:[update]");
		log.debug("Parmetros:[Departamento item:" + item+"]");

		try 
		{
			init();

			try 
			{
				log.debug("[update]Iniciamos transaccion");
				manager.getTransaction().begin();
				//manager.merge(item);
				Departamento depto = findOne(item.getId());
				depto.setNombre(item.getNombre());
				manager.getTransaction().commit();
				log.debug("[crear]Commit - Creamos departamento");
			} catch (Exception e) 
			{
				log.error("Error", e);
				manager.getTransaction().rollback();
				log.debug("[crear]Rollback");
				throw new DAOException(e);
			}finally 
			{
				manager.close();
			}

		} catch (DAOException daoe) {
			throw daoe;
		}catch (Exception e) {
			log.error("Error", e);
			throw new DAOException(e);
		}
		
	}

	@Override
	public void delete(Integer key) throws DAOException 
	{
		init();
		Departamento depto = findOne(key);
		manager.remove(depto);
	}

	private void init() 
	{
		if(factory==null) factory = Persistence.createEntityManagerFactory("jpa1");
		if(manager== null) manager =  factory.createEntityManager();
	}
}
