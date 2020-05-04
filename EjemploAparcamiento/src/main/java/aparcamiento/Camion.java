package aparcamiento;

import java.time.LocalDateTime;

public class Camion extends Vehiculo {

	private int ejes;

	
	public Camion() {
		super();
		this.ejes = 0;
	}
	
	public Camion(String matricula, boolean abonado, int ejes) {
		super(matricula, abonado);
		this.ejes = ejes;
	}
	
	public Camion(String matricula, boolean abonado, LocalDateTime fechaentrada, int ejes) {
		super(matricula, fechaentrada, abonado);
		this.ejes = ejes;
	}
	
	public int getEjes() {
		return ejes;
	}

	public void setEjes(int ejes) {
		this.ejes = ejes;
	}

	@Override
	public double calcularImporte() {
		double importe 	= 0D;
		
		if (this.getEjes() > 3) {
			importe = this.calculaMinutosDentro() * 4.5 / 60;
		}
		else {
			importe = this.calculaMinutosDentro() * 6.5 / 60;
		}
		
		if (this.isAbonado()) {
			importe = importe * 0.6;
		}
		
		importe = (double) (Math.round(importe * 100)) / 100; 
		
		return importe;
	}

	
}

