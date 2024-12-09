package sonvico;

public class Cuenta {
	
	//Crearemos los Atributos que necesitaremos en la clase Cuenta.
	private int nCuenta;
	private int saldo;
	private String nomTitular;

	//Crearemos el constructor con los Atributos anteriores.

	public Cuenta(int nCuenta, int saldo, String nomTitular) {
		this.nCuenta = nCuenta;
		this.saldo = saldo;
		this.nomTitular = nomTitular;

	}
	
	//Implementaremos todos los metodos que necesitamos para la practica.
	public int getnCuenta() {
		return nCuenta;
	}

	public void setnCuenta(int nCuenta) {
		this.nCuenta = nCuenta;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public String getNomTitular() {
		return nomTitular;
	}

	public void setNomTitular(String nomTitular) {
		this.nomTitular = nomTitular;
	}

	//Aqui estoy creando un Metodo toString que me muestre toda la informacion de las cuentas automaticamente.
	public String toString() {
		return "Nombre del Titular:" + nomTitular + "    Saldo de Cuenta:" + saldo + "    Numero de Cuenta:" + nCuenta;
	}
	
	public 
}





