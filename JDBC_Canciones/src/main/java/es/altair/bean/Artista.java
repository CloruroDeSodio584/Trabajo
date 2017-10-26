package es.altair.bean;

public class Artista {

	private int idartista;
	private String nombre;
	private String apellidos;
	private int edad;
	private String pais;
	private int idestilo;
	
	
	public Artista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Artista(int idartista, String nombre, String apellidos, int edad, String pais, int idestilo) {
		super();
		this.idartista = idartista;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.pais = pais;
		this.idestilo = idestilo;
	}

	public Artista(String nombre, String apellidos, int edad, String pais, int idestilo) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.pais = pais;
		this.idestilo = idestilo;
	}

	@Override
	public String toString() {
		return "Artista [idartista=" + idartista + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", pais=" + pais + ", idestilo=" + idestilo + "]";
	}

	public int getIdartista() {
		return idartista;
	}

	public void setIdartista(int idartista) {
		this.idartista = idartista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getIdestilo() {
		return idestilo;
	}

	public void setIdestilo(int idestilo) {
		this.idestilo = idestilo;
	}
	
}
