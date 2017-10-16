package muber.test;

import bd2.Muber.model.Calificacion;
import bd2.Muber.model.Conductor;
import bd2.Muber.model.Muber;
import bd2.Muber.model.Pasajero;
import bd2.Muber.model.Viaje;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Inicia Prueba Mubber");
		Muber mub = new Muber();

		// Agrego el conductor al sistema
		Conductor r = mub.agregarConductor(new Conductor("password", "26784352", "06-2-2015", "09-04-2000", "Licencia 267/a",
				"Roberto Gonzalez"));

		// Agrego el viaje al sistema
		Viaje v = mub.agregarViaje(new Viaje(new Integer(4), new String("La Plata"), new String("3 arroyos"), new Double(900.0)));

		r.agregarViaje(v);

		// Creo los pasajeros German, Alicia y Margarita

		// Agrego el pasajero al sistema
		Pasajero g = mub.agregarPasajero(new Pasajero("passwordGerman", new Double(1500.0), "25798654", "17-04-2016",
				"German Lopez"));

		// Agrego el pasajero al sistema
		Pasajero a = mub.agregarPasajero(new Pasajero("passwordAlicia", new Double(1500.0), "13245876", "01-05-2016",
				"Alicia Gutierrez"));

		// Agrego el pasajero al sistema
		Pasajero m = mub.agregarPasajero(new Pasajero("passwordMargarita", new Double(1500.0), "45673129", "13-02-2015",
				"Margarita Perez"));

		// Agrego el pasajero al sistema - Entrega etapa 2
		mub.agregarPasajero(new Pasajero("passwordHugo", new Double(2300.0), "23987453", "14-09-2016", "Hugo Ramos"));

		// Registro Pâsajeros al viaje
		v.agregarPasajero(g);
		v.agregarPasajero(a);
		v.agregarPasajero(m);

		for (Pasajero p : v.getPasajeros()) {
			System.out.println(
					"Dinero disponible antes del viaje de " + p.getNombre() + " es: " + p.getDineroDisponible());
		}

		// Finalizo Viaje
		v.finalizar();

		// Los pasajeros califican viaje

		v.agregarCalificacion(new Calificacion(" Todo exelente ", 5,g));
		v.agregarCalificacion(new Calificacion(" Todo muy bien, conductor recomendable ", 4,a));
		v.agregarCalificacion(new Calificacion(" Llegamos en tiempo, recomendable ", 4,m));

		for (Calificacion c : v.getCalificaciones()) {
			System.out.println("Dinero disponible despues del viaje de " + c.getPasajero().getNombre() + " es: "
					+ c.getPasajero().getDineroDisponible() + ", su comentario es" + c.getComentario()
					+ " y su puntaje es: " + c.getPuntaje());

		}

		// Armo las tablas y persisto los datos de la aplicacion
		mub.persistirDatos();

	}

}
