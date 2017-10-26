package es.altair.dao;

import java.util.List;

import es.altair.bean.Artista;

public interface ArtistaDAO {

	public List<Artista> listarArtistas();
	
	public boolean insertarArtista(Artista a);

	public List<Artista> listarPorEstilo(int artistaEstiloID);
	
	public boolean cambiarEdad(Artista artistaCambiaEdad);

	public Artista recibeInformacion(int idArtistaCambiaEdad);
	
	public List<Integer> artistaPorPais(String paisAgregarMinutoCancion);
	
	public boolean existeArtista();

	public List<String> artistaPais(String paisAgregarMinutoCancion);
}
