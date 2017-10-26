package es.altair.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.altair.bean.Estilo;


public class EstiloDAOImplJDBC implements EstiloDAO {

	public List<Estilo> ListarTodosEstilos() {
		
		List<Estilo> artistaEstilo = new ArrayList<Estilo>();
		
		ConexionDAO.abrirConexion();
		
		String Query = "SELECT * FROM estilo";
		
		try {
			Statement orden = ConexionDAO.getConexion().createStatement();
			ResultSet sentencia = orden.executeQuery(Query);
			
			while (sentencia.next()) {
				Estilo e1 = new Estilo(sentencia.getInt("idestilo"), sentencia.getString("nombreestilo"));

				artistaEstilo.add(e1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConexionDAO.cerrarConexion();	
		
		return artistaEstilo;
	}

	public boolean insertarNuevoEstilo(Estilo estilo) {
		int num_filas = 0;
		
		ConexionDAO.abrirConexion();

		String query = "INSERT INTO estilo VALUES(null, ?)";

		try {
			
			PreparedStatement orden = ConexionDAO.getConexion().prepareStatement(query);
			orden.setString(1, estilo.getNombreestilo());

			num_filas = orden.executeUpdate();

		} catch (SQLException sql) {
			
			sql.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		// return (num_filas == 0)? false: true;

		if (num_filas == 0)
			return false;
		else
			return true;
		
		
	}

	public boolean existeEstilos() {
		
		List<Estilo> estilo = new ArrayList<Estilo>();

		ConexionDAO.abrirConexion();

		String query = "SELECT * FROM estilo";
		
		try {
			Statement orden = ConexionDAO.getConexion().createStatement();
			ResultSet sentencia = orden.executeQuery(query);
			while (sentencia.next()) {
				Estilo e = new Estilo(sentencia.getInt("idestilo"), sentencia.getString("nombreestilo"));
				estilo.add(e);
			}
		} catch (SQLException sql) {
			sql.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		if (estilo.isEmpty()) {
			return false;
		} else {
			return true;
		}
		
	}

}
