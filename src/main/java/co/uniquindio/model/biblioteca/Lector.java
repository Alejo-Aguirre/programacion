package co.uniquindio.model.biblioteca;

import javafx.beans.property.StringProperty;

public class Lector extends Persona {


	String id, telefono, direccion;
	Prestamo prestamo;



	public Prestamo getPrestamo() {
		return prestamo;
	}



	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}






	public Lector(String nombre, String id, String telefono, String direccion, Prestamo prestamo) {
		super(nombre);
		this.id = id;
		this.telefono = telefono;
		this.direccion = direccion;
		this.prestamo = prestamo;
	}



	public Lector() {
		// TODO Auto-generated constructor stub
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	@Override
	public String toString() {
		return super.toString()+ " id "+ getId() +  "telefono "+  getTelefono() + " direccion " + getDireccion()+ "fecha inicio : "+ getPrestamo().getFechaInicial()+  " fecha Final "+ getPrestamo().getFechaFinal();
	}






}
