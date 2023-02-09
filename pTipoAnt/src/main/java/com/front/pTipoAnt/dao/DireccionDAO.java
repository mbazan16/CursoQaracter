package com.front.pTipoAnt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.front.pTipoAnt.common.exceptions.DAOException;
import com.front.pTipoAnt.common.exceptions.TipoException;
import com.front.pTipoAnt.dao.interfaces.IDAO;
import com.front.pTipoAnt.data.Direccion;

public class DireccionDAO implements IDAO<Long, Direccion> {

	DriverManagerOracle driverManager;

	private static final Logger log = Logger.getLogger(DireccionDAO.class);

	public DireccionDAO() {
		this.driverManager = DriverManagerOracle.getInstancia();
	}

	@Override
	public List<Direccion> findAll() throws DAOException {
		log.debug("findAll");

		Connection con;
		Statement stm;
		ResultSet rs;

		List<Direccion> direcciones = new ArrayList<>();

		String sql = "SELECT LOCATION_ID,STREET_ADDRESS,POSTAL_CODE,CITY,STATE_PROVINCE,COUNTRY_ID FROM LOCATIONS ORDER BY LOCATION_ID";

		try {
			con = driverManager.getConexion();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {
				Direccion direccion = new Direccion();
				direccion.setId(rs.getLong("LOCATION_ID"));
				direccion.setCalle(rs.getString("STREET_ADDRESS"));
				direccion.setCodigoPostal(rs.getString("POSTAL_CODE"));
				direccion.setCiudad(rs.getString("CITY"));
				direccion.setEstado(rs.getString("STATE_PROVINCE"));
				direccion.setIdPais(rs.getString("COUNTRY_ID"));

				direcciones.add(direccion);
			}

			rs.close();
			stm.close();
			con.close();
			return direcciones;

		} catch (SQLException sqle) {
			log.error(sqle.getMessage(), sqle);
			throw new DAOException(TipoException.EXCEPCION_SQL);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(TipoException.EXCEPCION_GENERAL);
		}

	}

	@Override
	public Direccion findOne(Long id) throws DAOException {
		log.debug("findOne");
		log.info("id:" + id);

		Connection con;
		PreparedStatement pstm;
		ResultSet rs;

		Direccion direccion = null;

		String sql = "SELECT LOCATION_ID,STREET_ADDRESS,POSTAL_CODE,CITY,STATE_PROVINCE,COUNTRY_ID FROM LOCATIONS WHERE LOCATION_ID=?";

		try {
			con = driverManager.getConexion();
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, id);
			rs = pstm.executeQuery();

			if (rs.next()) {
				direccion = new Direccion();
				direccion.setId(rs.getLong("LOCATION_ID"));
				direccion.setCalle(rs.getString("STREET_ADDRESS"));
				direccion.setCodigoPostal(rs.getString("POSTAL_CODE"));
				direccion.setCiudad(rs.getString("CITY"));
				direccion.setEstado(rs.getString("STATE_PROVINCE"));
				direccion.setIdPais(rs.getString("COUNTRY_ID"));
			} else {
				log.error(TipoException.ELEMENTO_NO_ENCONTRADO.getMensaje());
				throw new DAOException(TipoException.ELEMENTO_NO_ENCONTRADO);
			}
			if (rs.next()) {
				log.fatal(TipoException.ELEMENTO_DUPLICADO.getMensaje());
				throw new DAOException(TipoException.ELEMENTO_DUPLICADO);
			}
			rs.close();
			pstm.close();
			con.close();

			return direccion;

		} catch (SQLException sqle) {
			log.error(sqle.getMessage(), sqle);
			throw new DAOException(TipoException.EXCEPCION_SQL);

		} catch (DAOException daoe) {
			throw daoe;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(TipoException.EXCEPCION_GENERAL);
		}
	}

	@Override
	public void create(Direccion item) throws DAOException {
		// TODO Auto-generated method stub
		log.debug("Create");

		Connection con;
		PreparedStatement pstm;

		String sql = "INSERT INTO LOCATIONS (LOCATION_ID,STREET_ADDRESS,POSTAL_CODE,CITY,STATE_PROVINCE,COUNTRY_ID) VALUES(?,?,?,?,?,?)";

		try {
			con = driverManager.getConexion();
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, item.getId());
			pstm.setString(2, item.getCalle());
			pstm.setString(3, item.getCodigoPostal());
			pstm.setString(4, item.getCiudad());
			pstm.setString(5, item.getEstado());
			pstm.setString(6, item.getIdPais());

			int i = pstm.executeUpdate();

			if (i == 1) {
				log.info("Elemento creado:");
			} else if (i > 1) {
				log.error(TipoException.ELEMENTO_DUPLICADO.getMensaje());
				throw new DAOException(TipoException.ELEMENTO_DUPLICADO);
			} else {
				log.error(TipoException.ELEMENTO_NO_CREADO.getMensaje());
				throw new DAOException(TipoException.ELEMENTO_NO_CREADO);
			}

			pstm.close();
			con.close();

		} catch (SQLException sqle) {
			log.error(sqle.getMessage(), sqle);
			throw new DAOException(TipoException.EXCEPCION_SQL);

		} catch (DAOException daoe) {
			log.error(daoe.getMessage(), daoe);
			throw new DAOException(daoe.getTipoExcepcion());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(TipoException.EXCEPCION_GENERAL);
		}

	}

	@Override
	public void update(Direccion item) throws DAOException {
		log.debug("update");

		Connection con;
		PreparedStatement pstm;

		String sql = "UPDATE LOCATIONS SET STREET_ADDRESS=?, POSTAL_CODE=?, CITY=?, STATE_PROVINCE=?, COUNTRY_ID=? WHERE LOCATION_ID=?";

		try {
			con = driverManager.getConexion();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, item.getCalle());
			pstm.setString(2, item.getCodigoPostal());
			pstm.setString(3, item.getCiudad());
			pstm.setString(4, item.getEstado());
			pstm.setString(5, item.getIdPais());
			pstm.setLong(6, item.getId());

			int i = pstm.executeUpdate();

			if (i == 0) {
				log.error(TipoException.ELEMENTO_NO_ACTUALIZADO.getMensaje());
				throw new DAOException(TipoException.ELEMENTO_NO_ACTUALIZADO);
			} else if (i > 1) {
				log.error(TipoException.ELEMENTO_DUPLICADO.getMensaje());
				throw new DAOException(TipoException.ELEMENTO_DUPLICADO);
			}

			pstm.close();
			con.close();

		} catch (SQLException sqle) {
			log.error(sqle.getMessage(), sqle);
			throw new DAOException(TipoException.EXCEPCION_SQL);

		} catch (DAOException daoe) {
			throw daoe;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(TipoException.EXCEPCION_GENERAL);
		}

	}

	@Override
	public void delete(Long key) throws DAOException {
		log.debug("delete");

		Connection con;
		PreparedStatement pstm;

		String sql = "DELETE FROM LOCATIONS WHERE LOCATION_ID=?";

		con = driverManager.getConexion();

		try {
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, key);
			int i = pstm.executeUpdate();

			if (i == 0) {
				log.error(TipoException.ELEMENTO_NO_ELIMINADO.getMensaje());
				throw new DAOException(TipoException.ELEMENTO_NO_ELIMINADO);
			} else if (i > 1) {
				log.error(TipoException.ELEMENTO_DUPLICADO.getMensaje());
				con.rollback();
				throw new DAOException(TipoException.ELEMENTO_DUPLICADO);
			}
			pstm.close();
			con.close();

		} catch (SQLException sqle) {
			log.error(sqle.getMessage(), sqle);
			throw new DAOException(TipoException.EXCEPCION_SQL);

		} catch (DAOException daoe) {
			throw daoe;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(TipoException.EXCEPCION_GENERAL);
		}
	}
}