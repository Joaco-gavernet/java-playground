package prog3.arbolgeneral;

public class Empleado {
	private String nombre;
	private Integer antiguedad;
	private Integer categoria;

	Empleado() {

	}

	Empleado(String nom, Integer ant, Integer cat) {
		this.nombre = nom;
		this.antiguedad = ant;
		this.categoria = cat;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", antiguedad=" + antiguedad + ", categoria=" + categoria + "]";
	}

}
