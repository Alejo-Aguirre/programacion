package co.uniquindio.model.biblioteca;

import java.lang.reflect.Array;
import java.util.ArrayList;
import co.uniquindio.model.biblioteca.*;

public class Libro {

	String nombre, editorial;
	TipoLibro tipolibro;
	Autor autor;

	public Libro(String nombre, String editorial, TipoLibro tipolibro) {
		super();
		this.nombre = nombre;
		this.editorial = editorial;
		this.tipolibro = tipolibro;
	}

	public Libro() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}



	public TipoLibro getTipolibro() {
		return tipolibro;
	}

	public void setTipolibro(TipoLibro tipolibro) {
		this.tipolibro = tipolibro;
	}




	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return  " Nombre : " + getNombre() + "/ Tipo de libro : " + getTipolibro() + "/Editorial : " + getEditorial()+ " /Nombre de autor :" + getAutor().getNombre() + "\n";
	}






}
