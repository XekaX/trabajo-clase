package principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import clases.Empleade;
import clases.Jefe;
import utilidades.Utilidades;

public class Principal {

	public static void main(String[] args) {
		// Hasierako menua bistaratuko dugu
		int opc;
		boolean masEmpleados = true;
		List<Empleade> empleades = new ArrayList<>();

		do {
			opc = menu();

			if (empleades.isEmpty() && opc > 1 && opc < 9) {
				System.out.println("ERROR: Tienes que ir a la opci�n 0");
			} else {
				switch (opc) {
				case 0:
					sartuDatuak(empleades);
					break;
				case 1:
					bistaratuDatuak(empleades);
					break;
				case 2:
					bistaratuNagusiak(empleades);
					break;
				case 3:
					visualizarJefesDepartamento(empleades);
					break;
				case 4:
					visualizarEmpleadesNombre(empleades);
					break;
				case 5:
					visualizarEmpleadesSalario(empleades);
					break;
				case 6:
					visualizarJefesAnios(empleades);
					break;
				case 7:
					eliminarEmpleades(empleades);
					break;
				case 8:
					estadistica(empleades);
					break;
				case 9:
					System.out.println("AGURRRR");
					break;
				}
			}

		} while (opc != 9);
	}

	private static void estadistica(List<Empleade> empleades) {
		//
		boolean encontrado;
	
		// ******************************* CLASE LOCAL*****************************************
		class LineaListado implements Comparable<LineaListado> {

			// Atributos
			String departamento;
			int numJefes;

			// Constructor
			public LineaListado(String departamento, int numJefes) {
				super();
				this.departamento = departamento;
				this.numJefes = numJefes;
			}

			@Override
			public int compareTo(LineaListado otro) {
				//
				return this.departamento.compareToIgnoreCase(otro.departamento);
			}
		}
		// *******************************************************************************************
		LineaListado linea;

		LineaListado[] listado = new LineaListado[20];
		int numeroLineas = 0;

		// Generamos las lineas del listado
		for (Empleade emp : empleades) {
			if (emp instanceof Jefe) {
				encontrado = false;
				// Buscamos si el departamento ya esta registrado
				for (int i = 0; i < numeroLineas; i++) {
					if (((Jefe) emp).getDepartamento().equalsIgnoreCase(listado[i].departamento)) {
						listado[i].numJefes = listado[i].numJefes + 1;
						encontrado = true;
					}
				}
				// Si no hemos encontrado el departamento lo creamos
				if (!encontrado && numeroLineas < listado.length) {
					listado[numeroLineas] = new LineaListado(((Jefe) emp).getDepartamento(), 1);
					numeroLineas++;
				}
			}
		}

		if (listado.length > 0) {
			// Ordenamos el listado
			Arrays.sort(listado, 0, numeroLineas);

			// Sacamos los valores
			System.out.println("******************ESTADISTICA*****************************");
			for (int i = 0; i < numeroLineas; i++) {
				System.out.println("\t" + listado[i].departamento + "\t" + listado[i].numJefes);
			}
		} else {
			System.out.println("No se ha encontrado ning�n Jefe");
		}

	}

	private static void eliminarEmpleades(List<Empleade> empleades) {
		//
		String dni;
		int encontrado;
		boolean confirmarBorrado;
		
		dni = Utilidades.introducirCadena("Introduce el DNI del empleade: ");
		encontrado = buscarDni(dni, empleades);
		
		if (encontrado>=0) {
			//System.out.println(empleades.get(encontrado));
			empleades.get(encontrado).getDatos();;
			confirmarBorrado= Utilidades.esBoolean("Estas segura de que quieres borrar este empleado?");
			if(confirmarBorrado) {
				empleades.remove(encontrado);
			}
		}

	}

	private static void visualizarJefesAnios(List<Empleade> empleades) {
		// TODO Auto-generated method stub

	}

	private static void visualizarEmpleadesSalario(List<Empleade> empleades) {
		//

	}

	private static void visualizarEmpleadesNombre(List<Empleade> empleades) {
		//
		String cadena;
		boolean primero = true;

		cadena = Utilidades.introducirCadena("Introduce una cadena que haga referencia al nombre del empleado: ");

		for (Empleade emp : empleades) {
			if (emp.getNomEmpleade().contains(cadena)) {
				if (primero) {
					System.out.println("\t DNI \t A�OS DE ANTIGUEDAD \t JEFE");
					primero = false;
				}
				System.out.println("\t" + emp.getDni() + "\t" + emp.calcularAniosAntiguedad()
						+ (emp instanceof Jefe ? "\t SI" : "\t NO"));
			}
		}

		// Mensaje de error
		if (!primero) {
			System.out.println("No se ha encontrado ning�n empleado");
		}
	}

	private static void visualizarJefesDepartamento(List<Empleade> empleades) {
		//
		String depar;
		boolean ningunJefe = true;

		depar = Utilidades.introducirCadena("Introduce un departamento: ");

		for (Empleade emp : empleades) {
			if (emp instanceof Jefe && ((Jefe) emp).getDepartamento().equalsIgnoreCase(depar)) {
				// Imprimimos la cabecera una sola vez
				if (ningunJefe) {
					System.out.println("Jefe/s del departamento " + depar);
					ningunJefe = false;
				}
				emp.getNomEmpleade();
			}
		}
		if (ningunJefe) {
			System.out.println("No se ha encontrado n�ngun Jefe para este departamento");
		}
	}

	private static void bistaratuNagusiak(List<Empleade> empleades) {
		//
		boolean hayJefes = false;

		for (Empleade emp : empleades) {
			if (emp instanceof Jefe) {
				if (!hayJefes) {
					System.out.println("**************** JEFES **********************");
					hayJefes = true;
				}
				emp.getDatos();
			}
		}

		if (!hayJefes) {
			System.out.println("No se ha encontrado ning�n Jefe");
		}

	}

	private static void bistaratuDatuak(List<Empleade> empleades) {
		//

		System.out.println("**************** EMPLEADES **********************");
		for (Empleade emp : empleades) {
			emp.getDatos();
		}

	}

	private static void sartuDatuak(List<Empleade> empleades) {
		// Declaraciones
		String dni;
		int encontrado;
		char eleccion;
		char[] posibilidades = { 'E', 'J' };
		Empleade emple;

		dni = Utilidades.introducirCadena("Introduce el DNI del empleade: ");
		encontrado = buscarDni(dni, empleades);

		if (encontrado >= 0) {
			System.out.println("Ya existe un empleado con ese DNI y es el siguiente:");
			empleades.get(encontrado).getDatos();
		} else {
			eleccion = Utilidades.leerCharArray(posibilidades, "�Quieres introdudir un Jefe o un Empleade?(E/J");

			if (eleccion == 'E') {
				emple = new Empleade();
			} else {
				emple = new Jefe();
			}
			emple.setDatos(dni);
			empleades.add(emple);
		}
	}

	private static int buscarDni(String dni, List<Empleade> empleades) {
		// Declaraciones
		int encontrado = -1;

		for (int i = 0; i < empleades.size() && encontrado == -1; i++) {
			if (empleades.get(i).getDni().equalsIgnoreCase(dni)) {
				encontrado = i;
			}
		}

		return encontrado;
	}

	private static int menu() {
		int resp;

		System.out.println("0. Introducir datos");
		System.out.println("1. Visualizar los datos existententes de todos los empleados (los jefes son empleados");
		System.out.println("2. Visualizar los datos de los jefes");
		System.out.println("3. Modificar el sueldo base de todos los empleados");
		System.out.println("4. Modificar el plus de todos los jefes");
		System.out.println("5. Mostrar ordenados los jefes por apellido");
		System.out.println("6. ");
		System.out.println("9. Salir");
		resp = Utilidades.leerInt(0, 9, "ELIJA UNA OPCI�N");

		return resp;
	}

}
