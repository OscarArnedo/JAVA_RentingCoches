package RentingCoches;
import java.util.ArrayList;
import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Scanner keyboard2 = new Scanner(System.in);
		System.out.println("Introduciendo datos...\n");
		Empresa empresa = new Empresa("","RentalClot","Carrer de València 680",18027,933525052);
		//Lista de clientes
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		clientes.add( new Cliente(0,"45123789X", "Oscar", "Arnedo Riccobene", "Av. Diagonal 25 7 3", "6621000418401234567891", 18, true));
		clientes.add( new Cliente(1,"37123426G", "Jose", "Suarez Garcia", "C. Llacuna 30 4 2", "6621894418477734567891", 20, true));
		clientes.add( new Cliente(2,"41103456A", "Pepito", "Suarez Arnedo", "C. Inventada 123 1 1", "6621894418477734567891", 20, true));
		clientes.add( new Cliente(3,"39182428H", "Jose", "Riccobene Garcia", "C. Castillejos 120 3 2", "6621894418477734567891", 20, true));
		
		//Lista de vehiculos
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		
		vehiculos.add(new Patinete(0, 2, 10, "Xiaomi", "Mi Scooter", "Blanco", "Llacuna", false, "30Km", 25));
		vehiculos.add(new Bicicleta(1, 2, 15, "Moma", "Mtb Equinox", "Gris", "Poblenou", true, "4h", 30));
		vehiculos.add(new Coche(2, 4, 60, "Nissan", "Primera", "Negro", "Glories", true, "4101 BWX", ECombustible.Gasolina, 5, 5, false));
		vehiculos.add(new Moto(3, 2, 50, "Yamaha", "E300", "Plateado", "Llacuna", false, "5214 AES", ECombustible.Gasolina, 5, 5, false));
		vehiculos.add(new Furgoneta(4, 4, 60, "Citroen", "Jumper", "Blanco", "Clot", true, "5552 EFG", ECombustible.Gasolina, 5, 5, false));
		
		
		//Lista de Ingresos
		ArrayList<Ingreso> ingresos = new ArrayList<Ingreso>();
		ingresos.add(new Ingreso(0, "AlquilerCoche", "20/05/2019", 80, empresa));
		ingresos.add(new Ingreso(1, "AlquilerCoche", "25/05/2019", 100, empresa));
		ingresos.add(new Ingreso(2, "AlquilerCoche", "18/06/2019", 40, empresa));
		ingresos.add(new Ingreso(3, "AlquilerCoche", "1/10/2019", 95, empresa));
		ingresos.add(new Ingreso(4, "Prestamo", "20/05/2019", 4000, empresa));

		
		//Lista de Gastos
		ArrayList<Gasto> gastos = new ArrayList<Gasto>();
		gastos.add(new Gasto(0, EGastos.averias, "20/05/2019", 200, empresa));
		gastos.add(new Gasto(1, EGastos.seguros, "30/05/2019", 80, empresa));
		gastos.add(new Gasto(2, EGastos.mantenimiento, "15/08/2019", 80, empresa));
		gastos.add(new Gasto(3, EGastos.seguros, "07/07/2019", 80, empresa));

		empresa.saldoTotal();
		//Lista de Reservas
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		reservas.add(new Reserva(0,3,vehiculos.get(0),clientes.get(0)));
		System.out.println("\nDatos introducidos correctamente.\n");
		int longitud = vehiculos.size();
		int opcion = 0;
		while (opcion != 3) {
			System.out.println("----------------------------------------------");
			System.out.println("Aplicación de Renting Coches");
			System.out.println("1. Acceder como cliente");
			System.out.println("2. Acceder como administrador");
			System.out.println("3. Cerrar programa.");
			opcion = keyboard.nextInt();
			
			switch(opcion) {
				case 1:
					menuCliente(vehiculos,clientes,reservas);
					break;
				case 2:
					menuAdmin(vehiculos,clientes,reservas,empresa, ingresos, gastos);
					break;
				case 3:
					System.out.println("Cerrando...");
					System.exit(0);
					break;
			}
		}
	}
	
	public static void menuCliente(ArrayList<Vehiculo> vehiculos, ArrayList<Cliente> clientes,ArrayList<Reserva> reservas){
		String opcion;
		int idReserva = reservas.size(), idV, idC;
		Scanner bugs = new Scanner(System.in);
		Scanner keyboard = new Scanner(System.in);

		System.out.println("----------------------------------------------");
		System.out.println("1. Mostrar la lista de vehiculos disponibles");
		System.out.println("2. Mostrar la lista de coches disponibles");
		System.out.println("3. Mostrar la lista de motos disponibes");
		System.out.println("4. Mostrar la lista de furgonetas disponibes");
		System.out.println("5. Mostrar la lista de patinetes disponibes");
		System.out.println("6. Mostrar la lista de bicicletas disponibes");
		System.out.println("7. Hacer una reserva");
		System.out.println("8. Entregar antes un vehiculo");
		System.out.println("9. Entregar despues un vehiculo");
		opcion = bugs.nextLine();
		
		int longitud = vehiculos.size();
		switch(opcion) {
			case "1":
				int numVehiculos = 0;
				for(int x = 0;x < longitud;x++) {
					if(vehiculos.get(x).isDisponible()) {
						System.out.println(vehiculos.get(x).toString());
						numVehiculos++;
					}
				}
				if(numVehiculos == 0) {
					System.out.println("No hay vehiculos disponibles");
				}
				break;
			case "2":
				int numCoches = 0;
				for(int x = 0;x < longitud;x++) {
					if(vehiculos.get(x) instanceof Coche) {
						if(vehiculos.get(x).isDisponible()) {
							System.out.println(vehiculos.get(x).toString());
							numCoches++;
						}
					}
				}
					
				if(numCoches == 0) {
					System.out.println("No hay coches disponibles");
				}
				break;
				
			case "3":
				int numMotos = 0;
				for(int x = 0;x < longitud;x++) {
					if(vehiculos.get(x) instanceof Moto) {
						if(vehiculos.get(x).isDisponible()) {
							System.out.println(vehiculos.get(x).toString());
							numMotos++;
						}
					}
				}
					
				if(numMotos == 0) {
					System.out.println("No hay motos disponibles");
				}
				break;
				
			case "4":
				int numFurgonetas = 0;
				for(int x = 0;x < longitud;x++) {
					if(vehiculos.get(x) instanceof Furgoneta) {
						if(vehiculos.get(x).isDisponible()) {
							System.out.println(vehiculos.get(x).toString());
							numFurgonetas++;
						}
					}
				}
					
				if(numFurgonetas == 0) {
					System.out.println("No hay furgonetas disponibles");
				}
				break;
				
			case "5":
				int numPatinetes = 0;
				for(int x = 0;x < longitud;x++) {
					if(vehiculos.get(x) instanceof Patinete) {
						if(vehiculos.get(x).isDisponible()) {
							System.out.println(vehiculos.get(x).toString());
							numPatinetes++;
						}
					}
				}
					
				if(numPatinetes == 0) {
					System.out.println("No hay patinetes disponibles");
				}
				break;
				
			case "6":
				int numBicicletas = 0;
				for(int x = 0;x < longitud;x++) {
					if(vehiculos.get(x) instanceof Furgoneta) {
						if(vehiculos.get(x).isDisponible()) {
							System.out.println(vehiculos.get(x).toString());
							numBicicletas++;
						}
					}
				}
					
				if(numBicicletas == 0) {
					System.out.println("No hay bicletas disponibles");
				}
				break;
				
			case "7":
				System.out.println("----------------------------------------------");
				System.out.print("Introduce el numero de horas que quieres reservar: ");
				int nHoras = bugs.nextInt();
				System.out.print("Introduce el ID del Vehiculo que quieres reservar: ");
				idV = keyboard.nextInt();
				System.out.print("Introduce el ID del Cliente en cuestión: ");
				idC = keyboard.nextInt();
				
				reservas.add(new Reserva(idReserva,nHoras,vehiculos.get(idV),clientes.get(idC)));
				System.out.println("**Reserva creada correctamente, ID de l reserva: "+(reservas.size()-1)+" **");
				break;
			case "8":
				System.out.print("Introduce el id de la reserva: ");
				int idR = keyboard.nextInt();
				System.out.print("Introduce el numero de horas antes que lo vas a devolver: ");
				int numHoras = keyboard.nextInt();
				reservas.get(idR).entregarAntes(numHoras);
				System.out.println("**Precio de la reserva reducido**");
				System.out.print("Introduce el id del vehículo que quieres devolver: ");
				int index = keyboard.nextInt();
				vehiculos.get(index).entregarAntes();
				System.out.println("**Vehiculo cambiado a disponible**");
				System.out.println("");
				break;
			case "9":
				System.out.print("Introduce el numero de que lo has devouelto mas tarde: ");
				int nH = keyboard.nextInt();
				System.out.print("Introduce el id de la reserva: ");
				int idRes = keyboard.nextInt();
				reservas.get(idRes).entregarDespues(nH);
				System.out.println("**Precio de la reserva aumentado**");
				System.out.println("**Vehiculo cambiado a disponible**");
				break;
		}
	}
	
	public static boolean validarAcceso() {
		int contraseñaBuena = 1234, contraseña;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Introduce la contraseña del Administrador: ");
		contraseña = keyboard.nextInt();
		if (contraseña != contraseñaBuena) {
			System.out.println("Contraseña incorrecta. Saliendo...");
			return false;
		}else {
			return true;
		}
	}
	
	public static void menuAdmin(ArrayList<Vehiculo> vehiculos, ArrayList<Cliente> clientes, ArrayList <Reserva> reservas, Empresa empresa, ArrayList<Ingreso> ingresos, ArrayList<Gasto> gastos){
		int opcion;
		Scanner keyboard = new Scanner(System.in);
		if (validarAcceso()) {
			System.out.println("----------------------------------------------");
			System.out.println("1. Area Clientes");
			System.out.println("2. Area Vehiculos");
			System.out.println("3. Area Reservas");
			System.out.println("4. Area Empresa");
			opcion = keyboard.nextInt();
			
			switch(opcion) {
				case 1:
					menuClienteAdmin(clientes);
					break;
				case 2:
					menuVehiculosAdmin(vehiculos);
					break;
				case 3:
					menuReservasAdmin(reservas, vehiculos, clientes);
					break;
				case 4:
					menuEmpresa(empresa, ingresos, gastos);
					break;
			}
			
		}else {
			System.exit(0);
		}
		
	}
	
	public static void menuClienteAdmin(ArrayList <Cliente> clientes) {
		int opcion, nClientes = clientes.size();
		Scanner keyboard = new Scanner(System.in);
		Scanner bugs = new Scanner(System.in);
		System.out.println("----------------------------------------------");
		System.out.println("1. Introducir un Cliente");
		System.out.println("2. Mostrar clientes");
		opcion = keyboard.nextInt();
		switch (opcion) {
			case 1:
				System.out.println("----------------------------------------------");
				System.out.println("Introduce el DNI del Cliente");
				String dni = bugs.nextLine();
				System.out.println("Introduce el nombre del Cliente");
				String nombre = bugs.nextLine();
				System.out.println("Introduce los apellidos del Cliente");
				String apellidos = bugs.nextLine();
				System.out.println("Introduce la dirección del Cliente");
				String direccion = bugs.nextLine();
				System.out.println("Introduce la cuenta bancaria del Cliente");
				String cuentaBank = bugs.nextLine();				
				System.out.println("Introduce la edad del Cliente");
				int edad = keyboard.nextInt();
				System.out.println("Indica si el cliente tiene carnet de conducir o no (true o false)");
				boolean carnet = keyboard.nextBoolean();
				
				clientes.add(new Cliente(nClientes,dni,nombre,apellidos,direccion,cuentaBank,edad,carnet));
				System.out.println("Se ha añadido el cliente: "+clientes.get(nClientes).getNombreC()+" "+clientes.get(nClientes).getApellidosC());
				nClientes++;
				
				break;
			case 2:
				int longitudClientes = clientes.size();
				
				for(int x = 0;x < longitudClientes;x++) {
					System.out.println(clientes.get(x).toString());
				}
				break;
		}
	}
	
	public static void menuVehiculosAdmin(ArrayList <Vehiculo> vehiculos) {
		int opcion, nVehiculos = vehiculos.size();
		Scanner keyboard = new Scanner(System.in);
		Scanner bugs = new Scanner(System.in);
		System.out.println("----------------------------------------------");
		System.out.println("1. Introducir un Vehiculo");
		System.out.println("2. Mostrar vehiculos");
		opcion = keyboard.nextInt();
		switch (opcion) {
			case 1:
				System.out.println("----------------------------------------------");
				System.out.println("Introduce el tipo de Vehiculo (coche, moto, furgoneta, patinete o bici): ");
				String tipoVehiculo = bugs.nextLine();
				System.out.println("Introduce el numero de ruedas del Vehiculo: ");
				int numRuedas = keyboard.nextInt();
				System.out.println("Introduce el precio de alquiler del Vehiculo (la hora): ");
				int precio = keyboard.nextInt();
				System.out.println("Introduce la marca del vehiculo: ");
				String marca = bugs.nextLine();
				System.out.println("Introduce el modelo del vehiculo: ");
				String modelo = bugs.nextLine();
				System.out.println("Introduce el color del vehiculo: ");
				String color = bugs.nextLine();
				System.out.println("Introduce el punto de recogida del vehiculo: ");
				String pRecogida = bugs.nextLine();
				
				if (tipoVehiculo == "coche" || tipoVehiculo == "moto" || tipoVehiculo == "furgoneta") {
					System.out.println("Introduce la matrícula: ");
					String matricula = bugs.nextLine();
					System.out.println("Introduce el tipo de combustible vehiculo: ");
					String combustible = bugs.nextLine();
					System.out.println("Introduce el numero de puertas vehiculo: ");
					int numPuertas = keyboard.nextInt();
					System.out.println("Introduce el numero de plazas vehiculo: ");
					int numPlazas = keyboard.nextInt();
					System.out.println("Indica si el vehiculo es automático o no (true o false): ");
					boolean auto = keyboard.nextBoolean();
					
					if (tipoVehiculo.equals("coche")) {
						if (combustible == "gasolina") {
							vehiculos.add(new Coche(nVehiculos, numRuedas, precio, marca, modelo, color, pRecogida, true, matricula, ECombustible.Gasolina, numPuertas, numPlazas, auto));
							System.out.println("Se ha añadido un coche de marca: "+vehiculos.get(vehiculos.size()).marca);

						}else {
							vehiculos.add(new Coche(nVehiculos, numRuedas, precio, marca, modelo, color, pRecogida, true, matricula, ECombustible.Diesel, numPuertas, numPlazas, auto));
						}
					}
					if (tipoVehiculo == "moto") {
						if (combustible == "gasolina") {
							vehiculos.add(new Moto(nVehiculos, numRuedas, precio, marca, modelo, color, pRecogida, true, matricula, ECombustible.Gasolina, numPuertas, numPlazas, auto));
						}else {
							vehiculos.add(new Moto(nVehiculos, numRuedas, precio, marca, modelo, color, pRecogida, true, matricula, ECombustible.Diesel, numPuertas, numPlazas, auto));
						}
					}
					if (tipoVehiculo == "furgoneta") {
						if (combustible == "gasolina") {
							vehiculos.add(new Furgoneta(nVehiculos, numRuedas, precio, marca, modelo, color, pRecogida, true, matricula, ECombustible.Gasolina, numPuertas, numPlazas, auto));
						}else{
							vehiculos.add(new Furgoneta(nVehiculos, numRuedas, precio, marca, modelo, color, pRecogida, true, matricula, ECombustible.Diesel, numPuertas, numPlazas, auto));
						}
					}
				}
				if (tipoVehiculo == "patinete" || tipoVehiculo == "bici") {
					System.out.println("Introduce la autonomia: ");
					String autonomia = keyboard.nextLine();
					System.out.println("Introduce la velocidad maxima (km/h): ");
					int vMax = keyboard.nextInt();
					if (tipoVehiculo == "patinete") {
						vehiculos.add(new Patinete(nVehiculos, numRuedas, precio, marca, modelo, color, pRecogida, true, autonomia, vMax));
					}
					if (tipoVehiculo == "bici") {
						vehiculos.add(new Bicicleta(nVehiculos, numRuedas, precio, marca, modelo, color, pRecogida, true, autonomia, vMax));
					}
				}
				break;
			case 2:
				int longitud = vehiculos.size();
				for(int x = 0;x < longitud;x++) {
					System.out.println(vehiculos.get(x).toString());
				}
				break;
				
		}

	}
	
	public static void menuReservasAdmin(ArrayList<Reserva> reservas, ArrayList<Vehiculo> vehiculos, ArrayList<Cliente> clientes) {
		int opcion, nReservas = reservas.size();
		Scanner keyboard = new Scanner(System.in);
		Scanner bugs = new Scanner(System.in);
		System.out.println("----------------------------------------------");
		System.out.println("1. Introducir una reserva");
		System.out.println("2. Mostrar las reservas");
		opcion = keyboard.nextInt();

		switch(opcion) {
			case 1:
				System.out.println("----------------------------------------------");
				System.out.print("Introduce el numero de horas: ");
				int numeroHoras = keyboard.nextInt();
				System.out.print("Introduce el ID del Vehiculo que quieres reservar: ");
				int idV = keyboard.nextInt();
				System.out.print("Introduce el ID del Cliente en cuestión: ");
				int idC = keyboard.nextInt();
				
				reservas.add(new Reserva(nReservas,numeroHoras,vehiculos.get(idV),clientes.get(idC)));
				break;
			case 2:
				int longitud = reservas.size();
				for(int x = 0;x < longitud;x++) {
					System.out.println(reservas.get(x).toString());
				}
				break;
		}
	}
	
	public static void menuEmpresa(Empresa empresa, ArrayList<Ingreso> ingresos, ArrayList<Gasto> gastos) {
		int opcion, nIngresos = ingresos.size(), nGastos = gastos.size();
		Scanner keyboard = new Scanner(System.in);
		Scanner bugs = new Scanner(System.in);
		System.out.println("----------------------------------------------");
		System.out.println("1. Introducir un gasto");
		System.out.println("2. Mostrar registro de gastos");
		System.out.println("3. Introducir un ingreso");
		System.out.println("4. Mostrar registro de ingresos");
		System.out.println("5. Revisar el saldo total de la empresa");
		System.out.println("6. Mostrar la cantidad de un gasto/ingreso en otra moneda");
		opcion = keyboard.nextInt();

		switch(opcion) {	
			case 1:
				System.out.println("----------------------------------------------");
				System.out.println("Introduce el motivo del gasto (mantenimiento, seguros o averias): ");
				String motivo = bugs.nextLine();
				System.out.println("Introduce la fecha del gasto: ");
				String fecha = bugs.nextLine();
				System.out.println("Introduce la cantidad del gasto: ");
				float cantidad = keyboard.nextFloat();
				if (motivo.equals("mantenimiento")) {
					gastos.add(new Gasto(nGastos,EGastos.mantenimiento,fecha,cantidad,empresa));
				}else{
					if (motivo.equals("seguros")) {
						gastos.add(new Gasto(nGastos,EGastos.seguros,fecha,cantidad,empresa));
					}else{
						if (motivo.equals("averias")) {
							gastos.add(new Gasto(nGastos,EGastos.averias,fecha,cantidad,empresa));
						}else {
							System.out.println("Has introducido un motivo de gasto no válido.");
						}
					}
				}
				break;
			case 2:
				int longitud = gastos.size();
				for(int x = 0;x < longitud;x++) {
					System.out.println(gastos.get(x).toString());
				}
				break;
			case 3:
				System.out.println("----------------------------------------------");
				System.out.println("Introduce el motivo del ingreso: ");
				String motivoI = bugs.nextLine();
				System.out.println("Introduce la fecha del ingreso: ");
				String fechaI = bugs.nextLine();
				System.out.println("Introduce la cantidad del ingreso: ");
				float cantidadI = keyboard.nextFloat();
				ingresos.add(new Ingreso(nIngresos,motivoI,fechaI,cantidadI,empresa));
				break;
			case 4:
				int longitudI = ingresos.size();
				for(int x = 0;x < longitudI;x++) {
					System.out.println(ingresos.get(x).toString());
				}
				break;
			case 5:
				empresa.saldoTotal();
				System.out.println(empresa.getSaldoTotal());
				break;
			case 6:
				System.out.println("----------------------------------------------");
				System.out.println("¿ingreso o gasto?");
				String tipo = bugs.nextLine();
				System.out.println("Indica el id del gasto/ingreso: ");
				int id = keyboard.nextInt();
				if (tipo.equalsIgnoreCase("ingreso")) {
					ingresos.get(id).cambiarMoneda();
				}else {
					if (tipo.equalsIgnoreCase("gasto")) {
						gastos.get(id).cambiarMoneda();
					}else {
						System.out.println("No has seleccionado ni gasto ni ingreso");
					}
				}
				break;
		}
	}
}

