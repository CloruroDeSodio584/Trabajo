package es.altair.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.altair.bean.Artista;

public class ArtistaDAOImplJDBC implements ArtistaDAO {

	  private static EstiloDAO eDAO = new EstiloDAOImplJDBC();
	
	public List<Artista> listarArtistas() {
		
		List<Artista> artista = new ArrayList<Artista>();
		
		ConexionDAO.abrirConexion();
		
		String query ="SELECT * FROM artista";
		
		try {
			Statement sentencia = ConexionDAO.getConexion().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			
			while(resultado.next()) {
				Artista a = new Artista(resultado.getInt("idartista"),
						resultado.getString("nombre"),
						resultado.getString("apellidos"),
						resultado.getInt("edad"),
						resultado.getString("pais"),
						resultado.getInt("idestilo"));
				
			artista.add(a);	
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConexionDAO.cerrarConexion();
		return artista;
	}

	public boolean insertarArtista(Artista a) {
		
		if (eDAO.existeEstilos())
		{
			int num_filas = 0;
			
			ConexionDAO.abrirConexion();
			
			String query = "INSERT INTO artista VALUES(null, ?, ?, ?, ?, ?)";
			
			try {
				PreparedStatement orden = ConexionDAO.getConexion().prepareStatement(query);
			
				;
				orden.setString(1, a.getNombre());
				orden.setString(2, a.getApellidos());
				orden.setInt(3, a.getEdad());
				orden.setString(4, a.getPais());
				orden.setInt(5, a.getIdestilo());
				
				num_filas = orden.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ConexionDAO.cerrarConexion();
			
			if (num_filas == 0) 
			{
				return false;
			}
			else
			return true;
			
			}
		else
		{
			System.out.println("ERROR, NO SE PUEDE INTRODUCIR EL ARTISTA");			
			return false;
		}
		
			
		
	
	}

	public List<Artista> listarPorEstilo(int artistaEstiloID) {
		
		List<Artista> artistas = new ArrayList<Artista>();
		
		ConexionDAO.abrirConexion();
		
		String query = "SELECT * FROM artista WHERE idestilo = " + artistaEstiloID;
		
		try {
			Statement sentencia = ConexionDAO.getConexion().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			
			while(resultado.next()) {
				
				Artista a1 = new Artista(
						resultado.getInt("idartista"),
						resultado.getString("nombre"),
						resultado.getString("apellidos"),
						resultado.getInt("edad"),
						resultado.getString("pais"),
						resultado.getInt("idestilo"));
				
				artistas.add(a1);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			ConexionDAO.cerrarConexion();
		
		return artistas;
	}

	public boolean cambiarEdad(Artista artistaCambiaEdad) {
		
		int num_filas = 0;
		
		ConexionDAO.abrirConexion();
		
		String query = "UPDATE artista SET edad = ? WHERE idartista = ?";
		
		try {
			PreparedStatement orden = ConexionDAO.getConexion().prepareStatement(query);
			orden.setInt(1, artistaCambiaEdad.getEdad());
			orden.setInt(2, artistaCambiaEdad.getIdartista());
			
			num_filas = orden.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConexionDAO.cerrarConexion();
		
		if (num_filas == 0)
			return false;
		else
			return true;
	}

	public Artista recibeInformacion(int idArtistaCambiaEdad) {
		
		Artista a = null;
		
		ConexionDAO.abrirConexion();
		String query = "SELECT * FROM artista WHERE idartista = ?";
		
		try {
			PreparedStatement orden = ConexionDAO.getConexion().prepareStatement(query);
			orden.setInt(1, idArtistaCambiaEdad);
			
			ResultSet sentencia = orden.executeQuery();
			
			while (sentencia.next()) {
				a = new Artista(sentencia.getInt("idartista"),						
						sentencia.getString("nombre"),
						sentencia.getString("apellidos"),
						sentencia.getInt("edad"),
						sentencia.getString("pais"),
						sentencia.getInt("idestilo"));
				
				

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConexionDAO.cerrarConexion();
		
		return a;
	}

	public List<Integer> artistaPorPais(String paisAgregarMinutoCancion) {
		
		List<Integer> artistaID = new ArrayList<Integer>();
		
		ConexionDAO.abrirConexion();
		
		String query = "SELECT * FROM artista WHERE pais = ?";
		
		try {
			PreparedStatement orden = ConexionDAO.getConexion().prepareStatement(query);
			orden.setString(1, paisAgregarMinutoCancion);
			
			ResultSet sentencia = orden.executeQuery();
			
			while (sentencia.next()) {
				artistaID.add(sentencia.getInt("idartista"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConexionDAO.cerrarConexion();
		
		
		return artistaID;
	}
	
	public List<String> artistaPais(String paisAgregarMinutoCancion) {
		
     List<String> artistaPais = new ArrayList<String>();
		
		ConexionDAO.abrirConexion();
		
		String query = "SELECT * FROM artista WHERE pais = ?";
		
		try {
			PreparedStatement orden = ConexionDAO.getConexion().prepareStatement(query);
			orden.setString(1, paisAgregarMinutoCancion);
			
			ResultSet sentencia = orden.executeQuery();
			
			while (sentencia.next()) {
				artistaPais.add(sentencia.getString("pais"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	ConexionDAO.cerrarConexion();
		
		
		return artistaPais;
	}

	public boolean existeArtista() {
		
		List<Artista> artistas = new ArrayList<Artista>();
		
		ConexionDAO.abrirConexion();
		
		String query = "SELECT * FROM artista";
		Statement orden;
		try {
			orden = ConexionDAO.getConexion().createStatement();
			ResultSet sentencia = orden.executeQuery(query);
			
			while (sentencia.next()) {
			Artista a = new Artista(sentencia.getInt("idartista"),						
						sentencia.getString("nombre"),
						sentencia.getString("apellidos"),
						sentencia.getInt("edad"),
						sentencia.getString("pais"),
						sentencia.getInt("idestilo"));
				artistas.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		ConexionDAO.cerrarConexion();
		
		if (artistas.isEmpty()) {
			return false;
		} else {
			return true;
		}
		
	}

}
