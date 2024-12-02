package clases;

import utilidades.Utilidades;

public class Jefe extends Empleade{
	
	//Atributos
	private int plus;
	private String departamento;
	

	//Constructores
	public Jefe() {
		super();
		this.plus=250;
	}
	
	public Jefe(String dni, String nomEmpleado, int mes, int anio, float porcentajeIncremento, int plus,
			String departamento) {
		super(dni, nomEmpleado, mes, anio, porcentajeIncremento);
		this.plus = 250;
		this.departamento = departamento;
	}

	//Getters
	public int getPlus() {
		return plus;
	}

	public void setPlus(int plus) {
		this.plus = plus;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public void setDatos(String dni) {
		super.setDatos(dni);
		this.departamento = Utilidades.introducirCadena("Introduce el departamento: ");
    }
	
	public void getDatos() {
		super.getDatos();
		System.out.println("El plus del Jefe es: " + plus);
		System.out.println("El departamento es: " + departamento);
	}

	@Override
	public String toString() {
		return super.toString() + "Jefe [plus=" + plus + ", departamento=" + departamento + "]";
	}
	
	
}
