package RentingCoches;

abstract public class Electrico extends Vehiculo {
	protected String autonomia;
	protected int velocidadMax;
	
	
	public Electrico(int idVehiculo, int numRuedas, int precioAlquiler, String marca, String modelo, String color,
			String puntoRecogida, boolean disponible, String autonomia, int velocidadMax) {
		super(idVehiculo, numRuedas, precioAlquiler, marca, modelo, color, puntoRecogida, disponible);
		// TODO Auto-generated constructor stub
		this.autonomia = autonomia;
		this.velocidadMax = velocidadMax;
	}

	//Getters y setters
	public String getAutonomia() {
		return autonomia;
	}
	
	public void setAutonomia(String autonomia) {
		this.autonomia = autonomia;
	}
	
	public int getVelocidadMax() {
		return velocidadMax;
	}
	
	public void setVelocidadMax(int velocidadMax) {
		this.velocidadMax = velocidadMax;
	}

	@Override
	public String toString() {
		return "Electrico [autonomia=" + autonomia + ", velocidadMax=" + velocidadMax + "]";
	}
	
	
}
