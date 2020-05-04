package aparcamiento;

import java.time.LocalDateTime;

public class FechaHora {

	private int anio;
	private int mes;
	private int dia;
	private int hora;
	private int minuto;
	private LocalDateTime fechaHora;
	
	
	public FechaHora() {
		
		this.anio 		= 0;
		this.mes 		= 0;
		this.dia 		= 0;
		this.hora 		= 0;
		this.minuto 	= 0;
		this.fechaHora	= null;
	}
	
	public FechaHora(LocalDateTime fecha) {
		
		this.anio 		= fecha.getYear();
		this.mes 		= fecha.getMonthValue();
		this.dia 		= fecha.getDayOfMonth();
		this.hora 		= fecha.getHour();
		this.minuto		= fecha.getMinute();
		
		this.fechaHora	= fecha;
		
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public LocalDateTime getFechaHora() {
		if (fechaHora == null) {
			return LocalDateTime.of(this.anio, this.mes, this.dia, this.hora, this.minuto);
		}
		else {
			return fechaHora;
		}
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	
	
}

