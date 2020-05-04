package aparcamiento;

import java.time.LocalDateTime;

public class Automovil extends Vehiculo {

	public enum TipoVehiculo {
		turismo, 
		todoTerreno, 
		furgoneta
	}
	
	private TipoVehiculo tipoVehiculo;

	
	public Automovil() {
		super();
		this.tipoVehiculo = null;
	}
	
	public Automovil(String matricula, boolean abonado, TipoVehiculo tipoVehiculo) {
		super(matricula, abonado);
		this.tipoVehiculo = tipoVehiculo;
		
	}
	
	public Automovil(String matricula, boolean abonado, LocalDateTime fechaentrada, TipoVehiculo tipoVehiculo) {
		super(matricula, fechaentrada, abonado);
		this.tipoVehiculo = tipoVehiculo;
		
	}
	
	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	@Override
	public double calcularImporte() {
		
		double importe 	= 0D;
		
		switch (getTipoVehiculo()) {
			case turismo:
				importe = this.calculaMinutosDentro() * 1.5 / 60;
				break;
			case todoTerreno:
				importe = this.calculaMinutosDentro() * 2.5 / 60;
				break;
			case furgoneta:
				importe = this.calculaMinutosDentro() * 3.5 / 60;
				break;
			default:
				break;
		}
		
		if (this.isAbonado()) {
			importe = importe * 0.6;
		}
		
		importe = (double) (Math.round(importe * 100)) / 100; 
		
		return importe;
	}

}
