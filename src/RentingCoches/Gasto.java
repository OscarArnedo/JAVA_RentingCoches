package RentingCoches;

import java.util.Scanner;

public class Gasto implements IDinero{
	private int idGasto;
	private EGastos tipoGasto;
	private String fecha;
	private float cantidad;
	private Empresa empresa;
	//Constructor
	public Gasto(int idGasto, EGastos tipoGasto, String fecha, float cantidad, Empresa empresa) {
		super();
		this.idGasto = idGasto;
		this.tipoGasto = tipoGasto;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.empresa = empresa;
		empresa.totalG = empresa.totalG + cantidad;
	}
	
	//Getters y setters
	public int getIdGasto() {
		return idGasto;
	}

	public void setIdGasto(int idGasto) {
		this.idGasto = idGasto;
	}

	public EGastos getTipoGasto() {
		return tipoGasto;
	}


	public void setTipoGasto(EGastos tipoGasto) {
		this.tipoGasto = tipoGasto;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public float getCantidad() {
		return cantidad;
	}


	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	
	public void sumaGastos () {
		empresa.totalG = empresa.totalG + cantidad;
	}

	@Override
	public String toString() {
		return "Gasto [id=" + idGasto + ", Tipo Gasto=" + tipoGasto + ", fecha=" + fecha + ", cantidad=" + cantidad
				+ ", empresa=" + empresa + "]";
	}
	
	public void cambiarMoneda() {
		int opcion;
		Scanner keyboard = new Scanner(System.in); 
			System.out.println("------------------------------------------");
			System.out.println("1. Mostrar en Euros (€)");
			System.out.println("2. Mostrar en Dolares ($)");
			System.out.println("3. Mostrar en Libras (£)");
			opcion = keyboard.nextInt();
			
			switch(opcion) {
				case 1:
					System.out.println(cantidad +"€");
					break;
				case 2:
					System.out.println(cantidad *1.12 +"$");
					break;
				case 3:
					System.out.println(cantidad *0.86 +"£");
					break;
			}
	}
}
