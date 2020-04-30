package RentingCoches;

public class Reserva {
	private int idReserva;
	private int numHoras;
	private float precioTotal, fianza;
	private Vehiculo vehiculo;
	private Cliente cliente;
	private boolean aprovada = false; 
	
	public Reserva(int idReserva, int numHoras, Vehiculo vehiculo, Cliente cliente) {
		this.idReserva = idReserva;
		this.numHoras = numHoras;
		this.vehiculo = vehiculo;
		this.cliente = cliente;
		calcularPrecoTotal(numHoras,vehiculo);
		calcularFianza(precioTotal);
		controlEdad();
		validacion();
	}
	
	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

	public float getFianza() {
		return fianza;
	}

	public void setFianza(float fianza) {
		this.fianza = fianza;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean isAprovada() {
		return aprovada;
	}

	public void setAprovada(boolean aprovada) {
		this.aprovada = aprovada;
	}

	public void entregarAntes(int horas){
		precioTotal = precioTotal - horas*5;
		vehiculo.setDisponible(true);
	}
	public void entregarVehiculo(){
		vehiculo.setDisponible(true);
	}
	public void entregarDespues(int horas) {
		precioTotal = precioTotal + horas*8;
		vehiculo.setDisponible(true);
	}
	
	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", numHoras=" + numHoras + ", precioTotal=" + precioTotal
				+ ", fianza=" + fianza + ", vehiculo=" + vehiculo + ", cliente=" + cliente + ", aprovada=" + aprovada
				+ "]";
	}

	public boolean validacion() {
		if (cliente.isCarnetConducir() == true &&  cliente.getEdad() >= 18) {
				System.out.println("Reserva aprovada");
				vehiculo.setDisponible(false);
				return aprovada = true;
		}else {
			System.out.println("Reserva cancelada, problemas con la edad o con el carnet de conducir");
			vehiculo.setDisponible(true);
			return aprovada = false;
		}
	}
	
	public void controlEdad() {
		if (cliente.getEdad() <= 25 || cliente.getEdad() >= 60) {
				System.out.println("Tienes que pagar 15€ mas en tu alquiler");
				precioTotal = precioTotal + 15;
		}else {
			System.out.println("Paga tu alquiler");
		}
	}
	
	public void calcularPrecoTotal(int numHoras, Vehiculo vehiculo){
		precioTotal = numHoras * vehiculo.precioAlquiler;
	}
	
	public void calcularFianza(float pTotal) {
		fianza = (float) (pTotal * 0.4);
	}
}
