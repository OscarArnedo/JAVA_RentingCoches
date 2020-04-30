package RentingCoches;

abstract public class Combustible extends Vehiculo {
	protected String matricula;
	protected ECombustible tipoCombustible;
	protected int numPuertas, numPlazas;
	protected boolean automatico;
	
	//Constructor
	public Combustible(int idVehiculo, int numRuedas, int precioAlquiler, String marca, String modelo, String color,
			String puntoRecogida, boolean disponible, String matricula, ECombustible tipoCombustible, int numPuertas, 
			int numPlazas, boolean automatico) {
		super(idVehiculo, numRuedas, precioAlquiler, marca, modelo, color, puntoRecogida, disponible);
		this.matricula = matricula;
		this.tipoCombustible = tipoCombustible;
		this.numPuertas = numPuertas;
		this.numPlazas = numPlazas;
		this.automatico = automatico;
	}
	
	
	//Getters y setters
	public String getMatricula() {
		return matricula;
	}

	public ECombustible getTipoCombustible() {
		return tipoCombustible;
	}

	public int getNumPuertas() {
		return numPuertas;
	}

	public int getNumPlazas() {
		return numPlazas;
	}

	public boolean isAutomatico() {
		return automatico;
	}
	
	public void setAutomatico(boolean automatico) {
		this.automatico = automatico;
	}


	@Override
	public String toString() {
		return "Combustible [matricula=" + matricula + ", tipoCombustible=" + tipoCombustible + ", numPuertas="
				+ numPuertas + ", numPlazas=" + numPlazas + ", automatico=" + automatico + "]";
	}
	
	
	
}
