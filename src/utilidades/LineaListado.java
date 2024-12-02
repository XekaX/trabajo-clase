package utilidades;

public class LineaListado implements Comparable<LineaListado>{
	
	//Atributos
	private String departamento;
	private int numJefes;
	
	//Constructor
	public LineaListado(String departamento, int numJefes) {
		super();
		this.departamento = departamento;
		this.numJefes = numJefes;
	}

	//Getters
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public int getNumJefes() {
		return numJefes;
	}

	public void setNumJefes(int numJefes) {
		this.numJefes = numJefes;
	}

	@Override
	public int compareTo(LineaListado otro) {
		// 
		return this.departamento.compareToIgnoreCase(otro.getDepartamento());
	}
	

}
