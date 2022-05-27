package co.uniquindio.model.biblioteca;

import javafx.beans.property.StringProperty;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Biblioteca {

	ArrayList<Lector> listaLectores = new ArrayList<>();
	ArrayList<Prestamo> listaPrestamos = new ArrayList<>();
	ArrayList<Libro> listaLibros = new ArrayList<>();
	ArrayList<Copia> listaCopias = new ArrayList<>();
	ArrayList<Autor> listaAutores = new ArrayList<>();

	TipoLibro tipolibro = null;
	EstadoCopia estadoCopia = null;

	public ArrayList<Lector> getListaLectores() {
		return listaLectores;
	}

	public void setListaLectores(ArrayList<Lector> listaLectores) {
		this.listaLectores = listaLectores;
	}

	public ArrayList<Prestamo> getListaPrestamos() {
		return listaPrestamos;
	}

	public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
		this.listaPrestamos = listaPrestamos;
	}

	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(ArrayList<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}

	public ArrayList<Copia> getListaCopias() {
		return listaCopias;
	}

	public void setListaCopias(ArrayList<Copia> listaCopias) {
		this.listaCopias = listaCopias;
	}

	public ArrayList<Autor> getListaAutores() {
		return listaAutores;
	}

	public void setListaAutores(ArrayList<Autor> listaAutores) {
		this.listaAutores = listaAutores;
	}

	public void crearLector(String id, String nombre, String telefono, String direccion) {


		if (buscarLector(id) == null) {

			Lector lector = new Lector();

			lector.setId(id);
			lector.setNombre(nombre);
			lector.setTelefono(telefono);
			lector.setDireccion(direccion);

			listaLectores.add(lector);

		}

	}

	private Lector buscarLector(String id) {

		for (Lector lector : listaLectores) {
			if (lector.getId().equalsIgnoreCase(id)) {
				return lector;
			}

		}

		return null;
	}

	public void crearLibro(String nombre, int tipoLibrot, String editorial, String nombreAutor) {

		if (buscarLibro(nombre) == null) {

			Autor aut = buscarAutores(nombreAutor);

			Libro libro = new Libro();

			libro.setNombre(nombre);

			/**
			 * settear el tipo de libro
			 */
			if (tipoLibrot == 0) {
				tipolibro = TipoLibro.NOVELA;
			}
			if (tipoLibrot == 1) {
				tipolibro = TipoLibro.TEATRO;
			}
			if (tipoLibrot == 2) {
				tipolibro = TipoLibro.POESIA;
			}
			if (tipoLibrot == 3) {
				tipolibro = TipoLibro.ENSAYO;
			}

			libro.setTipolibro(tipolibro);
			libro.setEditorial(editorial);
			libro.setAutor(aut);

			listaLibros.add(libro);


			//System.out.println(getListaLibros() + aut.getNombre());

		}


	}


	public void crearCopias(String nombre,String id, int estadocopiat) {

		Libro libroAux = buscarLibro(nombre);
		if (buscarCopia(id) == null) {

			Copia copia = new Copia();

			copia.setId(id);

			if (estadocopiat == 0) {
				estadoCopia = EstadoCopia.BIBLIOTECA;
			}
			if (estadocopiat == 1) {
				estadoCopia = EstadoCopia.PRESTADO;
			}
			if (estadocopiat == 2) {
				estadoCopia = EstadoCopia.RETRASO;
			}
			if (estadocopiat == 3) {
				estadoCopia = EstadoCopia.REPARACION;
			}

			copia.setEstadoCopia(estadoCopia);
			copia.setLibro(libroAux);


			listaCopias.add(copia);
		}

	}

	private Copia buscarCopia(String id) {
		// TODO Auto-generated method stub
		for (Copia copia : listaCopias) {
			if (copia.getId().equalsIgnoreCase(id)) {
				return copia;
			}
		}
		return null;
	}

	public ArrayList<Autor> obtenerAutores() {
		return listaAutores;
	}


	/**
	 * metodo para buscar un libro
	 * @param nombre
	 * @return
	 */
	private Libro buscarLibro(String nombre) {
		for (Libro libro : listaLibros) {
			if (libro.getNombre().equalsIgnoreCase(nombre)){
				return libro;
			}
		}
		return null;
	}

	/**
	 * metodo para crear un autor
	 * @param nombre,nacionalidad,fechaNacimiento
	 * @throws ParseException
	 */
	public void crearAutor(String nombre, String nacionalidad, String fechaNacimiento) throws ParseException {

		//ya ententi porque date esta obseleta
//		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
//		Date fecha = formato.parse(fechaNacimiento);
//		System.out.println(formato.format(fecha));

		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fecha = LocalDate.parse(fechaNacimiento, formato);
		System.out.println(fecha);

		if (buscarAutores(String.valueOf(nombre)) == null) {

			Autor autor = new Autor();

			autor.setNombre(nombre);
			autor.setNacionalidad(nacionalidad);
			autor.setFechaNacimiento(fecha);

			listaAutores.add(autor);

		}

	}



	private Autor buscarAutores(String nombre) {

		for (Autor autor : listaAutores) {
			if (autor.getNombre().equals(nombre)) {
				return autor;
			}

		}

		return null;
	}

	public void crearPrestamo(String libro, String lector, String fechaInicio, String fechaFin) {

		Libro libroAux = buscarLibro(libro);
		Lector lectorAux = buscarLector(lector);

		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaI = LocalDate.parse(fechaInicio, formato);
		LocalDate fechaF = LocalDate.parse(fechaFin, formato);

			Prestamo prestamo = new Prestamo();

			prestamo.setLector(lectorAux);
			prestamo.setLibro(libroAux);
            prestamo.setFechaInicial(fechaI);
			prestamo.setFechaFinal(fechaF);

			listaPrestamos.add(prestamo);

	}


	/// profe este el metodo para devolver un prestamo
//	public void eliminarPrestamo (String idlector ){
//
//		if ( idlector == null || idlector.isEmpty()){
//			System.out.println("esta vacio no se puede eliminar ");
//		}
//
//		Prestamo prestamoConsultado = BuscarPrestamo(idlector);
//
//		if (prestamoConsultado == null){
//			System.out.println(" no existe");
//		}
//
//		getListaPrestamos().remove(prestamoConsultado);
//	}











}


