package RentingCoches;

public class Furgoneta extends Combustible{
	
	public Furgoneta(int idVehiculo, int numRuedas, int precioAlquiler, String marca, String modelo, String color,
			String puntoRecogida, boolean disponible, String matricula, ECombustible tipoCombustible, int numPuertas,
			int numPlazas, boolean automatico) {
		super(idVehiculo, numRuedas, precioAlquiler, marca, modelo, color, puntoRecogida, disponible, matricula,
				tipoCombustible, numPuertas, numPlazas, automatico);
	}

	@Override
	public String toString() {
		return "Furgoneta [matricula=" + matricula + ", tipoCombustible=" + tipoCombustible + ", numPuertas="
				+ numPuertas + ", numPlazas=" + numPlazas + ", automatico=" + automatico + ", idVehiculo=" + idVehiculo
				+ ", numRuedas=" + numRuedas + ", precioAlquiler=" + precioAlquiler + ", marca=" + marca + ", modelo="
				+ modelo + ", color=" + color + ", puntoRecogida=" + puntoRecogida + ", disponible=" + disponible + "]";
	}
	
}
