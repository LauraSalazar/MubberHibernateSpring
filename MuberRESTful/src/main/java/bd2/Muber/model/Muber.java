package bd2.Muber.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bd2.Muber.util.HibernateUtil;

public class Muber {

	private Integer idMuber;
	
	public Integer getIdMuber() {
		return idMuber;
	}

	public void setIdMuber(Integer idMuber) {
		this.idMuber = idMuber;
	}

	private List<Conductor> conductores;

	private List<Pasajero> pasajeros;

	private List<Viaje> viajes;

	public Muber() {
		super();
		this.conductores = new ArrayList<Conductor>();
		this.pasajeros = new ArrayList<Pasajero>();
		this.viajes = new ArrayList<Viaje>();
	}

	public List<Conductor> getConductores() {
		return conductores;
	}

	public void setConductores(List<Conductor> conductores) {
		this.conductores = conductores;
	}

	public List<Pasajero> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(List<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}

	public List<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(List<Viaje> viajes) {
		this.viajes = viajes;
	}

	public Conductor agregarConductor(Conductor c) {
		this.conductores.add(c);
		return (c);
	}

	public Pasajero agregarPasajero(Pasajero p) {
		this.pasajeros.add(p);
		return (p);
	}

	public Viaje agregarViaje(Viaje v) {
		v.setFinalizado(false);
		this.viajes.add(v);
		return v;
	}

	public void persistirDatos() {

		// Persisto los objetos de la aplicacion
		System.out.println("antes del getSessionFactory");
	    Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("despues del getSessionFactory");
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(this);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}

}
