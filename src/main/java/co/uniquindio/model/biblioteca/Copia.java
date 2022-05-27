package co.uniquindio.model.biblioteca;

import co.uniquindio.model.biblioteca.*;

public class Copia {

	String id;
	EstadoCopia estadoCopia;
	Libro libro;

	public Copia(String id, EstadoCopia estadoCopia) {
		super();
		this.id = id;
		this.estadoCopia = estadoCopia;
	}

	public Copia() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EstadoCopia getEstadoCopia() {
		return estadoCopia;
	}

	public void setEstadoCopia(EstadoCopia estadoCopia) {
		this.estadoCopia = estadoCopia;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	@Override
	public String toString() {
		return "libro :"+ libro.getNombre() + " id : " +  getId() + " Estado : "+ getEstadoCopia() +" \n";
	}





}
