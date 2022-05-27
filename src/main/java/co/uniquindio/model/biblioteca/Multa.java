package co.uniquindio.model.biblioteca;
import java.util.Date;

public class Multa {
	
	Date fechaInicial;
	Date fechaFinal;
	
	public Multa(Date fechaInicial, Date fechaFinal) {
		super();
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
	}
	public Date getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

}
