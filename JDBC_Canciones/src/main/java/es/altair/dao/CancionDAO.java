package es.altair.dao;

import java.util.List;

import es.altair.bean.Canciones;


public interface CancionDAO {
	
	List<Canciones> listarArtistas(int artistaID);
	
	boolean actualizarCancionPorPais(List<Integer> idArtistaPais);

	boolean eliminarCancionesArtistas(int idArtistaEliminarCanciones);
	
	boolean anadirCacion(Canciones cancion);
	
	List<Canciones> listarCanciones();
	
	boolean actualizarCancionDuracion_Pais(List<String> NombrePais);
}
