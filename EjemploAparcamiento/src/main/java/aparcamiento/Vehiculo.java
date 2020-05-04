package aparcamiento;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class Vehiculo {

	private String 		matricula;
	private FechaHora 	fechaEntrada;
	private boolean		abonado;	
	
	public Vehiculo() {
		this.matricula 		= "";
		this.fechaEntrada 	= new FechaHora(LocalDateTime.now());
		this.abonado		= false;
	}
	
	public Vehiculo(String matricula, boolean abonado) {
		this.matricula 		= matricula;
		this.fechaEntrada 	= new FechaHora(LocalDateTime.now());
		this.abonado		= abonado;
	}
	
	public Vehiculo(String matricula, LocalDateTime fechaEntrada , boolean abonado) {
		this.matricula 		= matricula;
		this.fechaEntrada 	= new FechaHora(fechaEntrada);
		this.abonado		= abonado;
	}
	
	public abstract double calcularImporte();

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public FechaHora getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(FechaHora fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public boolean isAbonado() {
		return abonado;
	}

	public void setAbonado(boolean abonado) {
		this.abonado = abonado;
	}
	
	public double calculaMinutosDentro() {
		
		double minutes = ChronoUnit.MINUTES.between(this.getFechaEntrada().getFechaHora() , LocalDateTime.now()) + 1;
		
		return minutes;
		
	}
	
}
