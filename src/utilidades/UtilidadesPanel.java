package utilidades;

import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class UtilidadesPanel {
	public static String introducirCadena(String mensaje) {

		String cadena = "";

		cadena = JOptionPane.showInputDialog(mensaje);

		return cadena;
	}

	public static String leerString(int x, String mensaje) {
		String cadena = null;
		boolean ok;
		do {
			ok = true;
			cadena = introducirCadena(mensaje);
			if (cadena.length() > x) {
				System.out.println("Error al introducir datos. ");
				ok = false;
			}
		} while (!ok);

		return cadena;
	}

	public static double leerDouble(int x, int y, String mensaje) {
		double num = 0;
		boolean ok;
		do {
			try {
				ok = true;
				num = Double.parseDouble(introducirCadena(mensaje));

			} catch (NumberFormatException e) {
				System.out.println("Hay que introducir numeros");
				ok = false;
				num = x;

			}
			if (num < x || num > y) {
				System.out.println("Dato fuera de rango, introduce entre" + x + " y " + y);
				ok = false;
			}
		} while (!ok);
		return num;
	}

	public static double leerDouble(String mensaje) {
		double fNumero = 0;
		boolean ok;
		do {
			try {
				ok = true;
				fNumero = Double.parseDouble(introducirCadena(mensaje));
			} catch (NumberFormatException e) {
				System.out.println("Error al introducir el n�mero");
				ok = false;
			}
		} while (!ok);
		return fNumero;
	}

	public static boolean esBoolean(String mensaje) {
		String respu;
		do {
			respu = introducirCadena(mensaje).toLowerCase();
		} while (!respu.equals("0") && !respu.equals("1") && !respu.equals("si") && !respu.equals("no")
				&& !respu.equals("s") && !respu.equals("n") && !respu.equals("true") && !respu.equals("false"));
		if (respu.equals("1") || respu.equals("si") || respu.equals("s") || respu.equals("true")) {
			return true;
		} else {
			return false;
		}
	}

	public static char leerCharArray(char caracteres[], String mensaje) {
		int i;
		boolean error = false;
		String letra;
		char aux = 0;

		do {
			error = false;
			letra = introducirCadena(mensaje);
			if (letra.length() != 1) {
				System.out.println("Error, introduce un caracter: ");
				error = true;
			} else {
				aux = letra.charAt(0);
				for (i = 0; i < caracteres.length; i++) {
					if (Character.toUpperCase(caracteres[i]) == Character.toUpperCase(aux)) {
						break;
					}
				}
				if (i == caracteres.length) {
					error = true;
					System.out.println("Error, el caracter introducido no es valido. ");
				}
			}
		} while (error);
		return aux;
	}

	public static char leerChar(String mensaje) {
		boolean error = false;
		String letra;

		do {
			error = false;
			letra = introducirCadena(mensaje);
			if (letra.length() != 1) {
				System.out.println("Error, introduce un car�ccter: ");
				error = true;
			}

		} while (error);
		return letra.charAt(0);
	}

	public static float leerFloat(String mensaje) {
		float fNumero = 0;
		boolean ok;
		do {
			try {
				ok = true;
				fNumero = Float.parseFloat(introducirCadena(mensaje));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error al introducir datos");
				ok = false;
			}
		} while (!ok);
		return fNumero;
	}

	public static float leerFloat(float x, float y, String mensaje) {
		float fNumero = 0;
		boolean ok;
		do {
			try {
				ok = true;
				fNumero = Float.parseFloat(introducirCadena(mensaje));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Hay que introducir numeros. Vuelve aintroducir: ");
				ok = false;
				fNumero = x;
			}
			if (fNumero < x || fNumero > y) {
				JOptionPane.showMessageDialog(null, "Dato fuera de rando. Introduce entre " + x + " y " + y);
				ok = false;
			}
		} while (!ok);
		return fNumero;
	}

	public static int leerInt(String mensaje) {
		int iNumero = 0;
		boolean ok;
		do {
			try {
				ok = true;
				iNumero = Integer.parseInt(introducirCadena(mensaje));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Hay que introducir numeros. Vuelve aintroducir: ");
				ok = false;
			}
		} while (!ok);
		return iNumero;
	}

	public static int leerInt(int x, int y, String mensaje) {
		int num = 0;
		boolean ok;
		do {
			try {
				ok = true;
				num = Integer.parseInt(introducirCadena(mensaje));

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Hay que introducir numeros. Vuelve aintroducir: ");
				ok = false;
				num = x;

			}
			if (num < x || num > y) {
				JOptionPane.showMessageDialog(null, "Dato fuera de rango, introduce entre " + x + " y " + y);
				ok = false;
			}
		} while (!ok);
		return num;
	}
}
