package com.front.pTipoAnt.bussines;

import java.util.List;

import org.apache.log4j.Logger;

import com.front.pTipoAnt.bussines.interfaces.IServicio;
import com.front.pTipoAnt.common.exceptions.DAOException;
import com.front.pTipoAnt.common.exceptions.ServicioException;
import com.front.pTipoAnt.common.exceptions.TipoException;
import com.front.pTipoAnt.dao.DepartamentoDAO;
import com.front.pTipoAnt.dao.DireccionDAO;
import com.front.pTipoAnt.dao.interfaces.IDAO;
import com.front.pTipoAnt.data.Departamento;
import com.front.pTipoAnt.data.Direccion;

public class ServDepartamento implements IServicio<Long, Departamento> {

	private static final Logger log = Logger.getLogger(ServDepartamento.class);

	IDAO<Long, Departamento> iDao;
	IDAO<Long, Direccion> iDaoDireccion;

	public ServDepartamento() {
		super();
		this.iDao = new DepartamentoDAO();
		this.iDaoDireccion = new DireccionDAO();
	}

	@Override
	public List<Departamento> findAll() throws ServicioException {
		log.debug("findAll");

		try {
			List<Departamento> departamentos = this.iDao.findAll();
			for (Departamento departamento : departamentos) {
				Direccion direccion = this.iDaoDireccion.findOne(departamento.getDireccion().getId());
				departamento.setDireccion(direccion);
			}
			return departamentos;
		} catch (DAOException daoe) {
			throw new ServicioException(daoe);
		} catch (Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}
	}

	@Override
	public Departamento findOne(Long key) throws ServicioException {
		log.debug("findOne");

		try {
			Departamento departamento = this.iDao.findOne(key);
			Direccion direccion = this.iDaoDireccion.findOne(departamento.getDireccion().getId());
			departamento.setDireccion(direccion);
			return departamento;
		} catch (DAOException daoe) {
			throw new ServicioException(daoe);
		} catch (Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}
	}

	@Override
	public void create(Departamento item) throws ServicioException {
		// TODO Auto-generated method stub
		log.debug("Create");

		try {
			this.iDao.create(item);
		} catch (DAOException daoe) {
			throw new ServicioException(daoe);
		} catch (Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}
	}

	@Override
	public void update(Departamento item) throws ServicioException {
		log.debug("update");

		try {
			this.iDao.update(item);
		} catch (DAOException daoe) {
			throw new ServicioException(daoe);
		} catch (Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}
	}

	@Override
	public void delete(Long key) throws ServicioException {
		log.debug("delete");

		try {
			this.iDao.delete(key);
		} catch (DAOException daoe) {
			throw new ServicioException(daoe);
		} catch (Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}
	}

}
