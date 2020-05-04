package aparcamiento;

import java.util.ArrayList;

public class Aparcamiento {

	
	private static int 			plazasTotales;
	private static int 			plazasOcupadas;
	private static double		recaudacion;
	private static boolean		barreraAbierta;
	private ArrayList<Vehiculo> vehiculos;
	

	public Aparcamiento(int plazasTotales) {
		
		setPlazasTotales(plazasTotales);
		setPlazasOcupadas(0);
		this.vehiculos = new ArrayList<Vehiculo>();
		
	}
	
	public boolean introducirVehiculo(Vehiculo vehiculo) {
		
		if (existeVehiculo(vehiculo)) {
			System.out.println("El vehiculo con matricula " + vehiculo.getMatricula() + ", ya se encuentra en el Aparcamiento.");
			return false;
		}
		
		if (getPlazasTotales() <= getPlazasOcupadas()) {
			System.out.println("El vehiculo con matricula " + vehiculo.getMatricula() + " no puede acceder. El Aparcamiento se encuentra lleno.");
			return false;
		}
		
		this.getVehiculos().add(vehiculo);
		setPlazasOcupadas(getPlazasOcupadas() + 1);
		return true;
	}

	public boolean existeVehiculo(Vehiculo vehiculo) {
		
		return existeVehiculo(vehiculo.getMatricula());
	}
	
	
	public boolean existeVehiculo(String matricula) {
		
		boolean lEstaVehiculo = false;
		
		for (Vehiculo cadavehiculo: this.getVehiculos()) {
			if (cadavehiculo.getMatricula().equalsIgnoreCase(matricula)) {
				lEstaVehiculo = true;
				break;
			}
		}
		
		return lEstaVehiculo;
	}
	
	public Vehiculo dameVehiculo(String matricula) {
		
		Vehiculo vehiculo = null;
		
		for (Vehiculo cadavehiculo: this.getVehiculos()) {
			if (cadavehiculo.getMatricula().equalsIgnoreCase(matricula)) {
				vehiculo = cadavehiculo;
				break;
			}
		}
		
		return vehiculo;
	}
	
	public double dimeImporteAPagar(String matricula) {
		
		double importe = 0D;
		
		if (existeVehiculo(matricula)) {
			importe = dimeImporteAPagar(dameVehiculo(matricula));
		}
		else {
			System.out.println("El vehiculo con matricula " + matricula + ", no se encuentra en el Aparcamiento.");
		}
		
		return importe;
	}
	
	public double dimeImporteAPagar(Vehiculo vehiculo) {
		
		double importe = vehiculo.calcularImporte();

		return importe;
	}
	
	
	public void pagarImporte(double importe) {
		System.out.printf("Incremento la recaudacion del aparcamiento en %.2f Euros\n" , importe);		
		Aparcamiento.setRecaudacion(Aparcamiento.getRecaudacion() + importe);
		System.out.printf("Se abre la barrera\n" , importe);		
		Aparcamiento.setBarreraAbierta(true);
	}
	
	
	
	public void sacarVehiculo(String matricula) {
		
		if (existeVehiculo(matricula)) {
			sacarVehiculo(dameVehiculo(matricula));
		}
		else {
			System.out.println("El vehiculo con matricula " + matricula + ", no se encuentra en el Aparcamiento.");
		}
		
	}

	public void sacarVehiculo(Vehiculo vehiculo) {
		
		System.out.println("Quito el vehiculo del aparcamiento");		
		
		this.getVehiculos().remove(vehiculo);
		System.out.println("Cierro la barrera");		
		Aparcamiento.setBarreraAbierta(false);
		System.out.println("Decremento en 1 el numero de plazas ocupadas");		
		
		Aparcamiento.setPlazasOcupadas(Aparcamiento.getPlazasOcupadas() - 1);
		
	}
	
	
	
	
	
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	
	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public static int getPlazasTotales() {
		return Aparcamiento.plazasTotales;
	}
	public static void setPlazasTotales(int plazasTotales) {
		Aparcamiento.plazasTotales = plazasTotales;
	}
	
	public static int getPlazasOcupadas() {
		return Aparcamiento.plazasOcupadas;
	}

	public static void setPlazasOcupadas(int plazasOcupadas) {
		Aparcamiento.plazasOcupadas = plazasOcupadas;
	}
	
	public static double getRecaudacion() {
		return Aparcamiento.recaudacion;
	}

	public static void setRecaudacion(double recaudacion) {
		Aparcamiento.recaudacion = recaudacion;
	}

	public static boolean isBarreraAbierta() {
		return Aparcamiento.barreraAbierta;
	}

	public static void setBarreraAbierta(boolean barreraAbierta) {
		Aparcamiento.barreraAbierta = barreraAbierta;
	}


	
}

