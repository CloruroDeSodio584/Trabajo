package es.altair.bean;

public class Estilo {

	private int idestilo;
	private String nombreestilo;
	
	
	public Estilo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdestilo() {
		return idestilo;
	}

	public void setIdestilo(int idestilo) {
		this.idestilo = idestilo;
	}

	public String getNombreestilo() {
		return nombreestilo;
	}

	public void setNombreestilo(String nombreestilo) {
		this.nombreestilo = nombreestilo;
	}

	@Override
	public String toString() {
		return "Estilo [idestilo=" + idestilo + ", nombreestilo=" + nombreestilo + "]";
	}

	public Estilo(int idestilo, String nombreestilo) {
		super();
		this.idestilo = idestilo;
		this.nombreestilo = nombreestilo;
	}

	public Estilo(String nombreestilo) {
		super();
		this.nombreestilo = nombreestilo;
	}
	
	
}
