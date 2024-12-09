package sonvico;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Indique el nombre de la primera cuenta:");
		String nombre1 = sc.next();
		System.out.println("Indique el saldo de la primera cuenta");
		int saldo2 = sc.nextInt();

		System.out.println("Indique el nombre de la segunda cuenta:");
		String nombre2 = sc.next();
		System.out.println("Indique el saldo de la segunda cuenta");
		int saldo1 = sc.nextInt();

		Random rd = new Random();
		int ncuenta1 = rd.nextInt(5000000);
		int ncuenta2 = rd.nextInt(5000000);

		Cuenta cliente1 = new Cuenta(ncuenta1, saldo1, nombre1);
		Cuenta cliente2 = new Cuenta(ncuenta2, saldo2, nombre2);

		System.out.println(cliente1.toString());
		System.out.println(cliente2.toString());
		boolean sistema = true;

		while (sistema = true) {
			menuBanco();
			int eleccion = sc.nextInt();

			switch (eleccion) {
			case 1:
				// Pedimos el nombre del titular
				System.out.println("Indique el nombre del Titular");
				String usuario = sc.next();
				// Aqui creamos dos if para comprobar a que usuario se refiere el nombre
				// introducido
				if (usuario.equals(nombre1)) {
					System.out.println("El saldo de la cuenta es de " + cliente1.getSaldo());
				} else if (usuario.equals(nombre2)) {

					System.out.println("El saldo de la cuenta es de " + cliente2.getSaldo());

				} else {
					System.out.println("El Titular de la cuenta indicado no existe.");
				}

				break;
			case 2:
				System.out.println("Indique el nombre del Titular");
				String usuario2 = sc.next();
				System.out.println("Indique la cantidad que quiere ingresar:");
				int ingreso = sc.nextInt();

				// Creamos otra vez los if para ver a que usuario se refiere, y entonces sumamos
				// al cliente.
				if (usuario2.equals(nombre1)) {
					cliente1.setSaldo(cliente1.getSaldo() + ingreso);

				} else if (usuario2.equals(nombre2)) {
					cliente2.setSaldo(cliente2.getSaldo() + ingreso);

				} else {
					System.out.println("El Titular de la cuenta indicado no existe.");
				}

				break;

			case 3:
				System.out.println("Indique el nombre del Titular");
				String usuario3 = sc.next();
				System.out.println("Indique la cantidad que quiere retirar:");
				int retirar = sc.nextInt();

				// Aqui haremos lo mismo que en el punto anterior solo que restando y ademas
				// comprobando que la cantidad indicada no supera el saldo de la cuenta.
				if (usuario3.equals(nombre1) && retirar <= cliente1.getSaldo()) {
					cliente1.setSaldo(cliente1.getSaldo() - retirar);

				} else if (usuario3.equals(nombre2) && retirar <= cliente1.getSaldo()) {
					cliente2.setSaldo(cliente2.getSaldo() - retirar);

				} else {
					System.out.println(
							"El Titular de la cuenta indicado no existe o la cantidad a retirar supera el saldo.");
				}

				break;

			case 4:
				System.out.println("Indique el nombre del Titular de la cuenta que desea transferir el dinero:");
				String transfer = sc.next();
				System.out.println("Indique el nombre del Titular al que desea transferir el dinero:");
				String transferido = sc.next();
				System.out.println("Indique la cantidad que desea transferir:");
				int cantidadTransfer = sc.nextInt();

				// En este caso crearemos dos if para comprobar de que usuario a que usuario va
				// a ir la transferencia. Restaremos y sumaremos a las dos cuentas segun se
				// indique.

				if (transfer.equals(nombre1) && transferido.equals(nombre2)
						&& cantidadTransfer <= cliente1.getSaldo()) {

					cliente1.setSaldo(cliente1.getSaldo() - cantidadTransfer);
					cliente2.setSaldo(cliente2.getSaldo() + cantidadTransfer);

				} else if (transfer.equals(nombre2)
						&& (transferido.equals(nombre1) && cantidadTransfer <= cliente2.getSaldo())) {

					cliente2.setSaldo(cliente2.getSaldo() - cantidadTransfer);
					cliente1.setSaldo(cliente1.getSaldo() + cantidadTransfer);

				} else {
					System.out.println(
							"El Titular de la cuenta indicado no existe o la cantidad a retirar supera el saldo.");
				}

				break;

			default:
				break;
			}
		}
	}

	// Metodo para imprimir el menu y que no este tan congestionado el codigo
	// principal.
	public static void menuBanco() {
		System.out.println("");
		System.out.println(
				"<---------------------------------------------------------------------------------------------------------------------------------- >");
		System.out.println(
				"| 1) | Consultar saldo      ||···|| 2) | Ingresar dinero        ||···|| 3) | Sacar dinero        ||···|| 4)| Realizar Transferencia |");
		System.out.println(
				"<---------------------------------------------------------------------------------------------------------------------------------- >");
		System.out.println("Introduzca la opcion deseada:");

	}
}
