package RentingCoches;

public abstract class Vehiculo {
	protected int idVehiculo, numRuedas,precioAlquiler;
	protected String marca, modelo, color, puntoRecogida;
	protected boolean disponible;
	
	//Constructor
	public Vehiculo(int idVehiculo, int numRuedas, int precioAlquiler, String marca, String modelo, String color,
			String puntoRecogida, boolean disponible) {
		this.idVehiculo = idVehiculo;
		this.numRuedas = numRuedas;
		this.precioAlquiler = precioAlquiler;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.puntoRecogida = puntoRecogida;
		this.disponible = disponible;
	}
	
	//Getters y setters
	public int getIdVehiculo() {
		return idVehiculo;
	}

	public int getNumRuedas() {
		return numRuedas;
	}
	public void setNumRuedas(int numRuedas) {
		this.numRuedas = numRuedas;
	}
	public int getPrecioAlquiler() {
		return precioAlquiler;
	}
	public void setPrecioAlquiler(int precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}
	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getPuntoRecogida() {
		return puntoRecogida;
	}
	
	public void setPuntoRecogida(String puntoRecogida) {
		this.puntoRecogida = puntoRecogida;
	}
	
	public boolean isDisponible() {
		return disponible;
	}
	
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + idVehiculo + ", Numero de ruedas=" + numRuedas + ", Precio de alquiler=" + precioAlquiler
				+ ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", Punto de recogida=" + puntoRecogida
				+ ", disponible=" + disponible + "]";
	}
	
	public void entregarAntes() {
		this.disponible = true;
	}
	
	
}
