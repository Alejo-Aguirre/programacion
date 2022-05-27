package co.uniquindio.model.biblioteca;
import java.time.LocalDate;
import java.util.Date;

public class Prestamo {

	LocalDate fechaInicial;
	LocalDate fechaFinal;
	Lector lector;
	Libro libro;



	public Prestamo(LocalDate fechaInicial, LocalDate fechaFinal, Lector lector, Libro libro) {
		super();
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.lector = lector;
		this.libro = libro;
	}

	public Prestamo() {
		// TODO Auto-generated constructor stub
	}

	public LocalDate getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(LocalDate fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public LocalDate getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(LocalDate fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public Lector getLector() {
		return lector;
	}
	public void setLector(Lector lector) {
		this.lector = lector;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}


	@Override
	public String toString() {
		return " libro : "+ getLibro().getNombre()+ " lector :" + getLector().getNombre()+ " fecha in"+ getFechaInicial()+" fecha fin"+fechaFinal;
	}






}
