package muber.test;

import bd2.Muber.model.Calificacion;
import bd2.Muber.model.Conductor;
import bd2.Muber.model.Muber;
import bd2.Muber.model.Pasajero;
import bd2.Muber.model.Viaje;

public class MainConductores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Inicia Prueba Mubber");
		Muber mub = new Muber();

		// Agrego el conductor al sistema
		Conductor r = mub.agregarConductor(new Conductor("password", "26784352", "06-2-2015", "09-04-2000", "Licencia 267/a",
				"Roberto Gonzalez"));
		
		// Agrego 6 conductores conductor

		Conductor r0 = mub.agregarConductor(new Conductor("password1", "26783332", "06-2-2015", "09-04-2000", "Licencia 266/b",
				"Carlos Gomez"));
		
		Conductor r1 = mub.agregarConductor(new Conductor("password2", "27783352", "06-2-2015", "09-04-2000", "Licencia 265/c",
				"Rebeca Fernandez"));
		
		Conductor r2 = mub.agregarConductor(new Conductor("password3", "26787359", "06-2-2015", "09-04-2000", "Licencia 264/d",
				"Raul Perez"));
		
		Conductor r3 = mub.agregarConductor(new Conductor("password4", "26784357", "06-2-2015", "09-04-2000", "Licencia 263/e",
				"Gimena Lopez"));
		
		Conductor r4 = mub.agregarConductor(new Conductor("password5", "26784387", "06-2-2015", "09-04-2000", "Licencia 262/f",
				"Gonzalo Francia"));
		
		Conductor r5 = mub.agregarConductor(new Conductor("password6", "26784354", "06-2-2015", "09-04-2000", "Licencia 261/g",
				"Gustavo Pellegrini"));

		Conductor r6 = mub.agregarConductor(new Conductor("password7", "26784376", "06-2-2015", "09-04-2000", "Licencia 260/h",
				"Ruben Salas"));
		
		Conductor r7 = mub.agregarConductor(new Conductor("password8", "26784365", "06-2-2015", "09-04-2000", "Licencia 259/i",
				"Ariel Darregueira"));
		
		Conductor r8 = mub.agregarConductor(new Conductor("password9", "26723365", "06-2-2015", "09-04-2000", "Licencia 259/j",
				"Fernando Funes"));
		
		Conductor r9 = mub.agregarConductor(new Conductor("password10", "12784365", "06-2-2015", "09-04-2000", "Licencia 259/k",
				"Mercedes Aguirre"));
		
		Conductor r10 = mub.agregarConductor(new Conductor("password11", "26894365", "06-2-2015", "09-04-2000", "Licencia 259/l",
				"Marcos Maldonado"));
		
		Conductor r11 = mub.agregarConductor(new Conductor("password12", "26784398", "06-2-2015", "09-04-2000", "Licencia 259/m",
				"Mariana Acosta"));
		
		Conductor r12 = mub.agregarConductor(new Conductor("password13", "26784565", "06-2-2015", "09-04-2000", "Licencia 259/n",
				"Carolina Rodriguez"));
		
		// Agrego el viaje al sistema
		Viaje v = mub.agregarViaje(new Viaje(new Integer(4), new String("La Plata"), new String("Punta Lara"), new Double(900.0)));
		
		Viaje v1 = mub.agregarViaje(new Viaje(new Integer(4), new String("Berazateghi"), new String("Ramos Mejia"), new Double(800.0)));
		
		Viaje v2 = mub.agregarViaje(new Viaje(new Integer(4), new String("Vicente Lopez"), new String("La Plata"), new Double(1000.0)));
		
		Viaje v3 = mub.agregarViaje(new Viaje(new Integer(4), new String("Caseros"), new String("San Martin"), new Double(500.0)));
		
		Viaje v4 = mub.agregarViaje(new Viaje(new Integer(4), new String("Nuñez"), new String("Liniers"), new Double(650.0)));
		
		Viaje v5 = mub.agregarViaje(new Viaje(new Integer(4), new String("Flores"), new String("Palermo"), new Double(500.0)));
		
		Viaje v6 = mub.agregarViaje(new Viaje(new Integer(4), new String("Lomas"), new String("Microcentro"), new Double(1100.0)));
		
		Viaje v7 = mub.agregarViaje(new Viaje(new Integer(4), new String("Tolosa"), new String("Beriso"), new Double(550.0)));
		
		Viaje v8 = mub.agregarViaje(new Viaje(new Integer(4), new String("La Matanza"), new String("Microcentro"), new Double(1500.0)));
		
		Viaje v9 = mub.agregarViaje(new Viaje(new Integer(4), new String("Congreso"), new String("Caballito"), new Double(650.0)));
		
		Viaje v10 = mub.agregarViaje(new Viaje(new Integer(4), new String("Lugano"), new String("San Telmo"), new Double(900.0)));	
		
		Viaje v11 = mub.agregarViaje(new Viaje(new Integer(4), new String("Pinamar"), new String("Miramar"), new Double(700.0)));	
		
		Viaje v12 = mub.agregarViaje(new Viaje(new Integer(4), new String("Caseros"), new String("Microcentro"), new Double(800.0)));	
		
		Viaje v13 = mub.agregarViaje(new Viaje(new Integer(4), new String("Villa Gesel"), new String("Pinamar"), new Double(1100.0)));	
		
		Viaje v14 = mub.agregarViaje(new Viaje(new Integer(4), new String("Cid Campeador"), new String("microcentro"), new Double(500.0)));	
		
		Viaje v15 = mub.agregarViaje(new Viaje(new Integer(4), new String("Chascomus"), new String("La Plata"), new Double(1500.0)));	
		
		r.agregarViaje(v);
		
		r0.agregarViaje(v1);
		
		r1.agregarViaje(v2);
		
		r3.agregarViaje(v3);
		
		r4.agregarViaje(v4);
		
		r5.agregarViaje(v5);
		
		r6.agregarViaje(v6);
		
		r7.agregarViaje(v7);
		
		r2.agregarViaje(v8);
		
		r5.agregarViaje(v9);
		
		r5.agregarViaje(v10);
		
		r8.agregarViaje(v11);
		
		r9.agregarViaje(v12);
		
		r10.agregarViaje(v13);
		
		r11.agregarViaje(v14);
		
		r12.agregarViaje(v15);

		// Creo los pasajeros German, Alicia y Margarita

		// Agrego el pasajero al sistema
		Pasajero g = mub.agregarPasajero(new Pasajero("passwordGerman", new Double(1500.0), "25798654", "17-04-2016",
				"German Lopez"));

		// Agrego el pasajero al sistema
		Pasajero a = mub.agregarPasajero(new Pasajero("passwordAlicia", new Double(1500.0), "13245876", "01-05-2016",
				"Alicia Gutierrez"));

		// Agrego el pasajero al sistema
		Pasajero m = mub.agregarPasajero(new Pasajero("passwordPasajero1", new Double(3500.0), "45673129", "13-02-2015",
				"Margarita Perez"));
		
		// Agrego el pasajero al sistema
		Pasajero m1 = mub.agregarPasajero(new Pasajero("passwordPasajero2", new Double(2500.0), "45673129", "13-02-2015",
				"Pasajero1"));
		
		// Agrego el pasajero al sistema
		Pasajero m2 = mub.agregarPasajero(new Pasajero("passwordPasajero3", new Double(3500.0), "45673129", "13-02-2015",
				"Pasajero2"));
		
		// Agrego el pasajero al sistema
		Pasajero m3 = mub.agregarPasajero(new Pasajero("passwordPasajero4", new Double(4500.0), "45673129", "13-02-2015",
				"Pasajero3"));
		
		// Agrego el pasajero al sistema
		Pasajero m4 = mub.agregarPasajero(new Pasajero("passwordPasajero5", new Double(5500.0), "45673129", "13-02-2015",
				"Pasajero4"));
		
		// Agrego el pasajero al sistema
		Pasajero m5 = mub.agregarPasajero(new Pasajero("passwordPasajero6", new Double(5500.0), "45673129", "13-02-2015",
				"Pasajero5"));
		
		Pasajero m6 = mub.agregarPasajero(new Pasajero("passwordPasajero7", new Double(3500.0), "45673129", "13-02-2015",
				"Pasajero6"));
		
		// Agrego el pasajero al sistema
		Pasajero m7 = mub.agregarPasajero(new Pasajero("passwordPasajero8", new Double(2500.0), "45673129", "13-02-2015",
				"Pasajero7"));
		
		// Agrego el pasajero al sistema
		Pasajero m8 = mub.agregarPasajero(new Pasajero("passwordPasajero9", new Double(3500.0), "45673129", "13-02-2015",
				"Pasajero8"));
		
		// Agrego el pasajero al sistema
		Pasajero m9 = mub.agregarPasajero(new Pasajero("passwordPasajero10", new Double(4500.0), "45673129", "13-02-2015",
				"Pasajero9"));
		
		// Agrego el pasajero al sistema
		Pasajero m10 = mub.agregarPasajero(new Pasajero("passwordPasajero11", new Double(4500.0), "45673129", "13-02-2015",
				"Pasajero10"));
		
		Pasajero m11 = mub.agregarPasajero(new Pasajero("passwordPasajero12", new Double(2500.0), "45673129", "13-02-2015",
				"Pasajero11"));
		
		// Agrego el pasajero al sistema
		Pasajero m12 = mub.agregarPasajero(new Pasajero("passwordPasajero13", new Double(2500.0), "45673129", "13-02-2015",
				"Pasajero12"));
		
		// Agrego el pasajero al sistema
		Pasajero m13 = mub.agregarPasajero(new Pasajero("passwordPasajero14", new Double(4500.0), "45673129", "13-02-2015",
				"Pasajero13"));
		
		// Agrego el pasajero al sistema
		Pasajero m14 = mub.agregarPasajero(new Pasajero("passwordPasajero15", new Double(4500.0), "45673129", "13-02-2015",
				"Pasajero14"));
		
		// Agrego el pasajero al sistema
		Pasajero m15 = mub.agregarPasajero(new Pasajero("passwordPasajero16", new Double(5500.0), "45673129", "13-02-2015",
				"Pasajero15"));

		// Registro Pâsajeros al viaje
		v.agregarPasajero(g);
		v.agregarPasajero(a);
		v.agregarPasajero(m);
		
		v1.agregarPasajero(m1);
		v1.agregarPasajero(m2);
		v1.agregarPasajero(m3);
		
		v2.agregarPasajero(m4);
		v2.agregarPasajero(m9);
		
		v3.agregarPasajero(m5);
		v3.agregarPasajero(m10);
		v3.agregarPasajero(m15);		
		
		v4.agregarPasajero(m6);
		v4.agregarPasajero(m11);
		
		v5.agregarPasajero(m7);
		v5.agregarPasajero(m12);		
		
		v6.agregarPasajero(m8);
		v6.agregarPasajero(m13);		
		
		v7.agregarPasajero(m9);
		v7.agregarPasajero(m14);
		
		v8.agregarPasajero(m14);
		v8.agregarPasajero(m10);
		
		v9.agregarPasajero(m11);
		v9.agregarPasajero(m1);
		
		v10.agregarPasajero(m3);
		v10.agregarPasajero(m6);
		v10.agregarPasajero(m8);
		
		v11.agregarPasajero(m2);
		v11.agregarPasajero(m12);
		
		v12.agregarPasajero(m3);
		v12.agregarPasajero(m5);
		v12.agregarPasajero(m8);
		v12.agregarPasajero(m7);
		
		v13.agregarPasajero(m5);
		v13.agregarPasajero(m9);
		v13.agregarPasajero(m3);
		v13.agregarPasajero(m10);
		
		v14.agregarPasajero(m2);
		v14.agregarPasajero(m15);
		
		v15.agregarPasajero(m1);
		
		
		for (Pasajero p : v.getPasajeros()) {
			System.out.println(
					"Dinero disponible antes del viaje de " + p.getNombre() + " es: " + p.getDineroDisponible());
		}

		// Finalizo Viaje
		v.finalizar();
		v1.finalizar();
		v2.finalizar();
		v3.finalizar();
		v4.finalizar();
		v5.finalizar();
		v6.finalizar();
		v10.finalizar();
		v9.finalizar();
		v11.finalizar();
		v12.finalizar();
		v13.finalizar();
		v14.finalizar();
		v15.finalizar();

		// Los pasajeros califican viaje
		v.agregarCalificacion(new Calificacion(new String(" Todo exelente "), 5,g));
		v.agregarCalificacion(new Calificacion(new String(" Todo muy bien, conductor recomendable "), 4,a));
		v.agregarCalificacion(new Calificacion( new String(" Llegamos en tiempo, recomendable "), 4,m));

		v1.agregarCalificacion(new Calificacion( "TODO ok", 2, m1));
		v1.agregarCalificacion(new Calificacion( "TODO ok", 2, m2));
		v1.agregarCalificacion(new Calificacion( "TODO ok", 2, m3));
		
		v2.agregarCalificacion(new Calificacion( "TODO ok", 2, m4));
		v2.agregarCalificacion(new Calificacion( "TODO ok", 2, m9));
		
		v3.agregarCalificacion(new Calificacion( "TODO ok", 3, m5));
		v3.agregarCalificacion(new Calificacion( "TODO ok", 3, m10));
		v3.agregarCalificacion(new Calificacion( "TODO ok", 3, m15));

		v4.agregarCalificacion(new Calificacion( "TODO ok", 4, m6));
		v4.agregarCalificacion(new Calificacion( "TODO ok", 4, m11));
		
		v5.agregarCalificacion(new Calificacion( "TODO ok", 5, m7));
		v5.agregarCalificacion(new Calificacion( "TODO ok", 5, m12));
		
		v6.agregarCalificacion(new Calificacion( "TODO ok", 2, m8));
		v6.agregarCalificacion(new Calificacion( "TODO ok", 2, m13));
		
		v7.agregarCalificacion(new Calificacion( "TODO ok", 2, m9));
		v7.agregarCalificacion(new Calificacion( "TODO ok", 2, m13));
		
		v8.agregarCalificacion(new Calificacion( "TODO ok", 3, m14));
		v8.agregarCalificacion(new Calificacion( "TODO ok", 3, m10));
		
		v9.agregarCalificacion(new Calificacion( "TODO ok", 2, m11));
		v9.agregarCalificacion(new Calificacion( "TODO ok", 2, m1));
		
		v10.agregarCalificacion(new Calificacion( "TODO ok", 4, m3));
		v10.agregarCalificacion(new Calificacion( "TODO ok", 4, m6));
		v10.agregarCalificacion(new Calificacion( "TODO ok", 4, m8));
		
		v11.agregarCalificacion(new Calificacion( "TODO ok", 3, m11));
		v11.agregarCalificacion(new Calificacion( "TODO ok", 3, m1));
		
		v12.agregarCalificacion(new Calificacion( "TODO ok", 4, m3));
		v12.agregarCalificacion(new Calificacion( "TODO ok", 4, m6));
		v12.agregarCalificacion(new Calificacion( "TODO ok", 4, m8));
		v12.agregarCalificacion(new Calificacion( "TODO ok", 4, m1));
		
		v13.agregarCalificacion(new Calificacion( "TODO ok", 2, m3));
		v13.agregarCalificacion(new Calificacion( "TODO ok", 2, m6));
		v13.agregarCalificacion(new Calificacion( "TODO ok", 2, m8));
		v13.agregarCalificacion(new Calificacion( "TODO ok", 2, m1));
		
		v14.agregarCalificacion(new Calificacion( "TODO ok", 2, m11));
		v14.agregarCalificacion(new Calificacion( "TODO ok", 2, m1));
		
		v15.agregarCalificacion(new Calificacion( "TODO ok", 2, m11));

		

		
		for (Calificacion c : v.getCalificaciones()) {
			System.out.println("Dinero disponible despues del viaje de " + c.getPasajero().getNombre() + " es: "
					+ c.getPasajero().getDineroDisponible() + ", su comentario es" + c.getComentario()
					+ " y su puntaje es: " + c.getPuntaje());

		}

		// Armo las tablas y persisto los datos de la aplicacion
		mub.persistirDatos();

	}

}