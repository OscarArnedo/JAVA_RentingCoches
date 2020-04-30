package RentingCoches;

public class Empresa {
	private String cif, nombre, direccionE;
	private int cPostal, telefonoE;
	public float totalI, total, totalG;
	
	public Empresa(String cif, String nombre, String direccionE, int cPostal, int telefonoE) {
		this.cif = cif;
		this.nombre = nombre;
		this.direccionE = direccionE;
		this.cPostal = cPostal;
		this.telefonoE = telefonoE;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccionE() {
		return direccionE;
	}

	public void setDireccionE(String direccionE) {
		this.direccionE = direccionE;
	}

	public int getcPostal() {
		return cPostal;
	}

	public void setcPostal(int cPostal) {
		this.cPostal = cPostal;
	}

	public int getTelefonoE() {
		return telefonoE;
	}

	public void setTelefonoE(int telefonoE) {
		this.telefonoE = telefonoE;
	}

	public void saldoTotal() {
		this.total = this.totalI - this.totalG;
	}
	
	public float getSaldoTotal() {
		return this.total;
	}
}
