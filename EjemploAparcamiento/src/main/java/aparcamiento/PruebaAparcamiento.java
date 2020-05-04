package aparcamiento;

import java.time.LocalDateTime;

import aparcamiento.Automovil.TipoVehiculo;

public class PruebaAparcamiento {

	public static void main(String[] args) {
		
		LocalDateTime horaLocal = LocalDateTime.now();
		double importe = 0D;
		
		
		Aparcamiento aparcamiento = new Aparcamiento(8);
		
		Automovil 	automovil1 	= new Automovil("4471FVG", true, horaLocal.minusMinutes(15L),TipoVehiculo.turismo);
		Automovil 	automovil2 	= new Automovil("4472FVG", false, horaLocal.minusMinutes(20L),TipoVehiculo.turismo);
		Automovil 	automovil3 	= new Automovil("4473FVG", true, horaLocal.minusMinutes(25L),TipoVehiculo.todoTerreno);
		Automovil 	automovil4 	= new Automovil("4474FVG", false, horaLocal.minusMinutes(30L),TipoVehiculo.todoTerreno);
		Automovil 	automovil5 	= new Automovil("4475FVG", true, horaLocal.minusMinutes(35L),TipoVehiculo.furgoneta);
		Automovil 	automovil6 	= new Automovil("4476FVG", false, horaLocal.minusMinutes(40L),TipoVehiculo.furgoneta);
		
		Camion		camion1		= new Camion("5531JKS", true, horaLocal.minusMinutes(45L), 2); 
		Camion		camion2		= new Camion("5532JKS", false, horaLocal.minusMinutes(50L), 2); 
		Camion		camion3		= new Camion("5533JKS", true, horaLocal.minusMinutes(55L), 2); 
		Camion		camion4		= new Camion("5534JKS", false, horaLocal.minusMinutes(60L), 2); 
		Camion		camion5		= new Camion("5535JKS", false, horaLocal.minusMinutes(65L), 2); 
		
		aparcamiento.introducirVehiculo(automovil1);
		aparcamiento.introducirVehiculo(automovil2);
		aparcamiento.introducirVehiculo(automovil3);
		aparcamiento.introducirVehiculo(automovil4);
		aparcamiento.introducirVehiculo(automovil5);
		aparcamiento.introducirVehiculo(automovil6);
		
		aparcamiento.introducirVehiculo(camion1);
		aparcamiento.introducirVehiculo(camion2);
		aparcamiento.introducirVehiculo(camion3);
		aparcamiento.introducirVehiculo(camion4);
		aparcamiento.introducirVehiculo(camion5);

		System.out.println("Numero de plazas libres: " + (Aparcamiento.getPlazasTotales() - Aparcamiento.getPlazasOcupadas()));
		
		System.out.println("*****************************");
		
		if (aparcamiento.existeVehiculo(automovil6.getMatricula())) {
			importe = aparcamiento.dimeImporteAPagar(automovil6);
			System.out.printf ("Importe a pagar por el vehiculo con matricula %s = %.2f Euros\n" , automovil6.getMatricula() , importe);			
			aparcamiento.pagarImporte(importe);
			if (Aparcamiento.isBarreraAbierta()) {
				System.out.println ("La barrera se ha abierto y por tanto el automovil con matricula " + automovil6.getMatricula() + " puede salir"); 
				aparcamiento.sacarVehiculo(automovil6);		
				System.out.println("Numero de plazas libres: " + (Aparcamiento.getPlazasTotales() - Aparcamiento.getPlazasOcupadas()));
				System.out.println("Importe Recaudado: " + Aparcamiento.getRecaudacion());
				System.out.println("Barrera abierta: " + Aparcamiento.isBarreraAbierta());
			}
		}
		else {
			System.out.println("El vehiculo con matricula " + automovil6.getMatricula() + ", NO se encuentra en el Aparcamiento.");
		}
		
		
		System.out.println("*****************************");
		
		if (aparcamiento.existeVehiculo(camion1.getMatricula())) {
			importe = aparcamiento.dimeImporteAPagar(camion1);
			System.out.printf ("Importe a pagar por el camion con matricula %s = %.2f Euros\n" , camion1.getMatricula() , importe);			
			aparcamiento.pagarImporte(importe);
			if (Aparcamiento.isBarreraAbierta()) {
				System.out.println ("La barrera se ha abierto y por tanto el camion con matricula " + camion1.getMatricula() + " puede salir"); 
				aparcamiento.sacarVehiculo(camion1);			
				System.out.println("Numero de plazas libres: " + (Aparcamiento.getPlazasTotales() - Aparcamiento.getPlazasOcupadas()));
				System.out.println("Importe Recaudado: " + Aparcamiento.getRecaudacion());
				System.out.println("Barrera abierta: " + Aparcamiento.isBarreraAbierta());
			}
		}
		else {
			System.out.println("El cami�n con matricula " + camion1.getMatricula() + ", NO se encuentra en el Aparcamiento.");
		}
		
		
		System.out.println("*****************************");
		
		if (aparcamiento.existeVehiculo("4474FVG")) {
			importe = aparcamiento.dimeImporteAPagar("4474FVG");
			System.out.printf ("Importe a pagar por el camion con matricula %s = %.2f Euros\n" , "4474FVG" , importe);			
			aparcamiento.pagarImporte(importe);
			if (Aparcamiento.isBarreraAbierta()) {
				System.out.println ("La barrera se ha abierto y por tanto el camion con matricula " + "4474FVG" + " puede salir"); 
				aparcamiento.sacarVehiculo("4474FVG");		
				System.out.println("Numero de plazas libres: " + (Aparcamiento.getPlazasTotales() - Aparcamiento.getPlazasOcupadas()));
				System.out.println("Importe Recaudado: " + Aparcamiento.getRecaudacion());
				System.out.println("Barrera abierta: " + Aparcamiento.isBarreraAbierta());
			}
		}
		else {
			System.out.println("El camion con matricula " + "4474FVG" + ", NO se encuentra en el Aparcamiento.");
		}
		
		System.out.println("*****************************");
		
		System.out.println("Numero de plazas libres: " + (Aparcamiento.getPlazasTotales() - Aparcamiento.getPlazasOcupadas()));
		System.out.println("Importe Recaudado: " + Aparcamiento.getRecaudacion());
		System.out.println("Barrera abierta: " + Aparcamiento.isBarreraAbierta());
		
		
		System.out.println("Todo correcto");
	}

}
