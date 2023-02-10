package com.ejemplo.jpa1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ejemplo.jpa1.dao.exceptions.DAOException;
import com.ejemplo.jpa1.dao.interfaces.IDAO;
import com.ejemplo.jpa1.entities.Departamento;

public class DepartamentoDAO implements IDAO<Integer,Departamento>
{

	EntityManagerFactory factory;
	EntityManager manager;
	
	@Override
	public List<Departamento> findAll() throws DAOException {
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
		init();
		manager.persist(item);
		
	}

	@Override
	public void update(Departamento item) throws DAOException 
	{
		init();
		//manager.merge(item);
		Departamento depto = findOne(item.getId());
		depto.setNombre(item.getNombre());
		
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
