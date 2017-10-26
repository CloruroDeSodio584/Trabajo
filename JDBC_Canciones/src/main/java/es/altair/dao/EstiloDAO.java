package es.altair.dao;

import java.util.List;

import es.altair.bean.Estilo;

public interface EstiloDAO {

	public List<Estilo> ListarTodosEstilos();
	
	public boolean insertarNuevoEstilo(Estilo estilo);
	
	public boolean existeEstilos();
}
