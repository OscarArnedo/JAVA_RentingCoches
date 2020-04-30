package RentingCoches;

import java.util.Scanner;

public class Ingreso{
	private int idIngreso;
	private String tipoIngreso, fecha;
	private float cantidad;
	private Empresa empresa;
	

	//Constructor
	public Ingreso(int idIngreso, String tipoIngreso, String fecha, float cantidad, Empresa empresa) {
		this.idIngreso = idIngreso;
		this.tipoIngreso = tipoIngreso;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.empresa = empresa;
		empresa.totalI = empresa.totalI + cantidad;
	}

	
	//Getters y Setters
	public int getIdIngreso() {
		return idIngreso;
	}
	
	public void setIdIngreso(int idIngreso) {
		this.idIngreso = idIngreso;
	}
	
	public String getTipoIngreso() {
		return tipoIngreso;
	}


	public void setTipoIngreso(String tipoIngreso) {
		this.tipoIngreso = tipoIngreso;
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
	
	
	public void sumaIngresos () {
		empresa.totalI = empresa.totalI + cantidad;
	}


	@Override
	public String toString() {
		return "Ingreso [id=" + idIngreso + ", tipo ingreso=" + tipoIngreso + ", fecha=" + fecha + ", cantidad="
				+ cantidad + ", empresa=" + empresa + "]";
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
