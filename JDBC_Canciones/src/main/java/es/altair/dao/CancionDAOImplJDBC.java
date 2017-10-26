package es.altair.dao;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import es.altair.bean.Canciones;


public class CancionDAOImplJDBC implements CancionDAO {
	
	private static ArtistaDAO aDAO = new ArtistaDAOImplJDBC();

	public List<Canciones> listarArtistas(int artistaID) {
		List<Canciones> canciones = new ArrayList<Canciones>();
		
		ConexionDAO.abrirConexion();
		
		String query = "SELECT * FROM canciones WHERE idartista = " + artistaID;
		
		try {
			Statement orden = ConexionDAO.getConexion().createStatement();
			ResultSet sentencia = orden.executeQuery(query);
			while (sentencia.next()) {
				Canciones s = new Canciones(sentencia.getInt("idcanciones"),
						sentencia.getString("nombrecancion"),
						sentencia.getInt("anyo"),
						sentencia.getInt("duracion"),						
						sentencia.getInt("idartista"),
						sentencia.getInt("idestilo"));

				canciones.add(s);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConexionDAO.cerrarConexion();
		
		return canciones;
	}
	
	public boolean actualizarCancionPorPais(List<Integer> idArtistaPais) {
		boolean es = false;	
		int num_filas=0;
		
		ConexionDAO.abrirConexion();
		
		for (int i = 0; i < idArtistaPais.size(); i++) {
			String query = "UPDATE canciones SET duracion = duracion + 60 WHERE idartista = ?";

			try {
				PreparedStatement orden = ConexionDAO.getConexion().prepareStatement(query);
				orden.setInt(1, idArtistaPais.get(i));

				num_filas = orden.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			ConexionDAO.cerrarConexion();

			if (num_filas == 0)
				es = false;
			else
				es = true;
		}
		return es;
		
	}

	
	public boolean eliminarCancionesArtistas(int idArtistaEliminarCanciones) {
		int num_filas = 0;

		ConexionDAO.abrirConexion();

		String query = "DELETE FROM canciones WHERE idartista = ?";

		try {
			PreparedStatement orden = ConexionDAO.getConexion().prepareStatement(query);
			orden.setInt(1, idArtistaEliminarCanciones);

			num_filas = orden.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		// return (num_filas == 0)? false: true;

		if (num_filas == 0)
			return false;
		else
			return true;

	}

	
	public boolean anadirCacion(Canciones cancion) {
		if (aDAO.existeArtista()) {

			int num_filas = 0;
			ConexionDAO.abrirConexion();

			String query = "INSERT INTO canciones VALUES(null, ?, ?, ?, ?, ?)";

			try {
				PreparedStatement orden = ConexionDAO.getConexion().prepareStatement(query);

				orden.setString(1, cancion.getNombrecancion());
				orden.setInt(2, cancion.getAnyo());
				orden.setInt(3, cancion.getDuracion());
				orden.setInt(4, cancion.getIdartista());
				orden.setInt(5, cancion.getIdestilo());

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

		} else {
			System.out.println("ERROR, LA CANCION " +  cancion.getNombrecancion() + " NO SE HA PODIDO INTRODUCIR");
			System.out.println("ERROR, NO EXISTE NINGUN ARTISTA CON EL ID: " + cancion.getIdartista());
			return false;
		}
	}

	public List<Canciones> listarCanciones() {
		
		List<Canciones> canciones = new ArrayList<Canciones>();

		ConexionDAO.abrirConexion();

		String query = "SELECT * FROM canciones";
		
		try {
			Statement orden = ConexionDAO.getConexion().createStatement();

			ResultSet sentencia = orden.executeQuery(query);

			while (sentencia.next()) {
				Canciones s1 = new Canciones(sentencia.getInt("idcanciones"),
						sentencia.getString("nombrecancion"),
						sentencia.getInt("anyo"),
						sentencia.getInt("duracion"),
						sentencia.getInt("idartista"),
						sentencia.getInt("idestilo"));

				canciones.add(s1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return canciones;
	}

	public boolean actualizarCancionDuracion_Pais(List<String> NombrePais) {
		boolean es = false;	
		int num_filas=0;
		
		ConexionDAO.abrirConexion();
		
		for (int i = 0; i < NombrePais.size(); i++) {
			String query = "UPDATE canciones JOIN artista ON (artista.idartista = canciones.idartista) "
					+ "SET duracion = duracion + 60"
					+ "WHERE pais = ?";

			try {
				PreparedStatement orden = ConexionDAO.getConexion().prepareStatement(query);
				orden.setString(1, NombrePais.get(i));

				num_filas = orden.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			ConexionDAO.cerrarConexion();

			if (num_filas == 0)
				es = false;
			else
				es = true;
		}
		return es;
	}

}
