package RentingCoches;

public class Bicicleta extends Electrico{
	
	//Constructor
	public Bicicleta(int idVehiculo, int numRuedas, int precioAlquiler, String marca, String modelo, String color,
			String puntoRecogida, boolean disponible, String autonomia, int velocidadMax) {
		super(idVehiculo, numRuedas, precioAlquiler, marca, modelo, color, puntoRecogida, disponible, autonomia, velocidadMax);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Bicicleta [autonomia=" + autonomia + ", velocidadMax=" + velocidadMax + ", idVehiculo=" + idVehiculo
				+ ", numRuedas=" + numRuedas + ", precioAlquiler=" + precioAlquiler + ", marca=" + marca + ", modelo="
				+ modelo + ", color=" + color + ", puntoRecogida=" + puntoRecogida + ", disponible=" + disponible + "]";
	}
	
}
