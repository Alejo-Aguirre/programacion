package co.uniquindio.model.biblioteca;

import java.time.LocalDate;

public class Autor extends Persona {

	String nacionalidad;
	LocalDate fechaNacimiento;

	public Autor() {
		// TODO Auto-generated constructor stub
	}

	public Autor(String nombre, String nacionalidad, LocalDate fechaNacieminto) {
		super(nombre);
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacieminto;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Autor{" +
				"nacionalidad='" + nacionalidad + '\'' +
				", fechaNacieminto=" + fechaNacimiento +
				", nombre='" + nombre + '\'' +
				'}';
	}

}
