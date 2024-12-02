package clases;

import java.time.LocalDate;

import utilidades.Utilidades;

public class Empleade {
	
	//Atributos
	private String dni;
	private String nomEmpleade;
	private int mes;
	private int anio;
	private float porcentajeIncremento;
	private int sueldoBase;
	
	private static final String NOMBRE_EMPRESA = "Eléctrica, S.A.";

	//Constructores
	public Empleade() {
		this.sueldoBase = 1000;
	}
	
	public Empleade(String dni, String nomEmpleado, int mes, int anio, float porcentajeIncremento) {
		super();
		this.dni = dni;
		this.nomEmpleade = nomEmpleado;
		this.mes = mes;
		this.anio = anio;
		this.porcentajeIncremento = porcentajeIncremento;
		this.sueldoBase = 1000;
	}

	//Setters y Getters
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNomEmpleade() {
		return nomEmpleade;
	}

	public void setNomEmpleade(String nomEmpleade) {
		this.nomEmpleade = nomEmpleade;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public float getPorcentajeIncremento() {
		return porcentajeIncremento;
	}

	public void setPorcentajeIncremento(float porcentajeIncremento) {
		this.porcentajeIncremento = porcentajeIncremento;
	}

	public int getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(int sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public static String getNombreEmpresa() {
		return NOMBRE_EMPRESA;
	}
	
	//Metodos propios
    public float calcularSueldo() {
    	float sueldo;
    	sueldo = sueldoBase + (sueldoBase*porcentajeIncremento)/100;
    			
    	if (calcularAniosAntiguedad()>=6){
    		sueldo += 100;
    	}
    	
    	return sueldo;
    }
	
    public int calcularAniosAntiguedad() {
		//
    	int aniosAntiguedad;
    	int diferenciaAnios, diferenciaMeses;
    	
    	diferenciaAnios = LocalDate.now().getYear()-anio;
    	diferenciaMeses = LocalDate.now().getMonthValue()- mes;
    	
    	if (diferenciaMeses>=0) {
    		diferenciaAnios++;
    	}
    	
		return diferenciaAnios;
	}

	public void setDatos(String dni) {
		this.dni = dni;
		this.nomEmpleade = Utilidades.introducirCadena("Introduce el nombre del Empleade: ");
		this.mes = Utilidades.leerInt(1, 12, "Introduce el mes: ");
		this.anio = Utilidades.leerInt(1980, 2021, "Introduce el mes: ");
		this.porcentajeIncremento = Utilidades.leerFloat("Introduce el porcentaje de incremento: ");
    }
    
    public void getDatos() {
		System.out.println("El nombre del empleado es: " + nomEmpleade);
		System.out.println("El mes en que ingresó en la empresa es: " + mes + " y el año "+ anio);
		System.out.printf("El sueldo del empleado es: %.2f", this.calcularSueldo());
	}

	@Override
	public String toString() {
		return "Empleade [dni=" + dni + ", nomEmpleade=" + nomEmpleade + ", mes=" + mes + ", anio=" + anio
				+ ", porcentajeIncremento=" + porcentajeIncremento + ", sueldoBase=" + sueldoBase + "]";
	}
    
    
}
