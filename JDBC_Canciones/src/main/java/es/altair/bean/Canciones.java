package es.altair.bean;

public class Canciones {
	
	private int idcanciones;
	private String nombrecancion;
	private int anyo;
	private int duracion;
	private int idartista;
	private int idestilo;
	
	
	public int getIdcanciones() {
		return idcanciones;
	}


	public void setIdcanciones(int idcanciones) {
		this.idcanciones = idcanciones;
	}


	public String getNombrecancion() {
		return nombrecancion;
	}


	public void setNombrecancion(String nombrecancion) {
		this.nombrecancion = nombrecancion;
	}


	public int getAnyo() {
		return anyo;
	}


	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}


	public int getDuracion() {
		return duracion;
	}


	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


	public int getIdartista() {
		return idartista;
	}


	public void setIdartista(int idartista) {
		this.idartista = idartista;
	}


	public int getIdestilo() {
		return idestilo;
	}


	public void setIdestilo(int idestilo) {
		this.idestilo = idestilo;
	}


	@Override
	public String toString() {
		return "Canciones [idcanciones=" + idcanciones + ", nombrecancion=" + nombrecancion + ", anyo=" + anyo
				+ ", duracion=" + duracion + ", idartista=" + idartista + ", idestilo=" + idestilo + "]";
	}


	public Canciones(String nombrecancion, int anyo, int duracion, int idartista, int idestilo) {
		super();
		this.nombrecancion = nombrecancion;
		this.anyo = anyo;
		this.duracion = duracion;
		this.idartista = idartista;
		this.idestilo = idestilo;
	}


	public Canciones(int idcanciones, String nombrecancion, int anyo, int duracion, int idartista, int idestilo) {
		super();
		this.idcanciones = idcanciones;
		this.nombrecancion = nombrecancion;
		this.anyo = anyo;
		this.duracion = duracion;
		this.idartista = idartista;
		this.idestilo = idestilo;
	}
	
	
}
