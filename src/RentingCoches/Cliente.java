package RentingCoches;

public class Cliente {
	private String dniC, nombreC, apellidosC, direccionC, cuentaBank;
	private int idCliente, edad;
	private boolean carnetConducir;
	
	//Constructor
	public Cliente(int idCliente, String dniC, String nombreC, String apellidosC, String direccionC, String cuentaBank,
			int edad, boolean carnetConducir) {
		this.idCliente = idCliente;
		setDni(dniC);
		this.nombreC = nombreC;
		this.apellidosC = apellidosC;
		this.direccionC = direccionC;
		this.cuentaBank = cuentaBank;
		this.edad = edad;
		this.carnetConducir = carnetConducir;
	}
	//Getters y setters

	public String getDniC() {
		return dniC;
	}

	public String getNombreC() {
		return nombreC;
	}

	public void setNombreC(String nombreC) {
		this.nombreC = nombreC;
	}

	public String getApellidosC() {
		return apellidosC;
	}

	public void setApellidosC(String apellidosC) {
		this.apellidosC = apellidosC;
	}

	public String getDireccionC() {
		return direccionC;
	}

	public void setDireccionC(String direccionC) {
		this.direccionC = direccionC;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public String getCuentaBank() {
		return cuentaBank;
	}
	
	public void setCuentaBank(String cuentaBank) {
		this.cuentaBank = cuentaBank;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isCarnetConducir() {
		return carnetConducir;
	}

	public void setCarnetConducir(boolean carnetConducir) {
		this.carnetConducir = carnetConducir;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Cliente [id="+idCliente + ", dni=" + dniC + ", nombre=" + nombreC + ", apellidos=" + apellidosC + ", direccion="
				+ direccionC + ", Cuenta Bancaria=" + cuentaBank + ", edad=" + edad
				+ ", Carnet de conducir=" + carnetConducir + "]";
	}

	public void setDni(String dniC) {
		if (validaDniC(dniC)) {
			this.dniC = dniC;
			System.out.println("El dni: \"" + dniC + "\" s'ha pogut tramitar CORRECTAMENT");
			this.dniC = dniC;
		}else {				
			System.out.println("El dni: \"" + dniC + "\" no s'ha pogut tramitar");
			this.dniC = null;
			}
	}
	private boolean validaDniC(String dniC){
		if 	(dniC.length() != 9) {
			System.out.println("Problema amb el DNI: la longitud és diferent de 9");
			return false;
		}
		else if (!Character.isLetter(dniC.charAt(8))) {
			System.out.println("Problema amb el DNI: l'últim caràcter ha de ser una lletra");
			return false;
		}
		else if (!validaDigitsDni(dniC)) {
			System.out.println("Problema amb el DNI: els 8 primers caràcters han de ser dígits");
			return false;
		}
		else if (!Character.isUpperCase(dniC.charAt(8))) {
			System.out.println("Problema amb el DNI: el darrer caràcter ha de ser una lletra majúscula");
			return false;
		}
		return true;
	}
	
	private boolean validaDigitsDni(String dniC){
		for (int i=0; i<dniC.length()-1; i++){
			if (!Character.isDigit(dniC.charAt(i))) return false;
		}
		return true;
	}
}
