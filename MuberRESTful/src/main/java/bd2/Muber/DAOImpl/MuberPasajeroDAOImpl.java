package bd2.Muber.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import bd2.Muber.dto.PasajeroDTO;
import bd2.Muber.model.Pasajero;

public class MuberPasajeroDAOImpl {

	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public MuberPasajeroDAOImpl(Session session) {
		super();
		this.session = session;
	}

	public void agregar(Pasajero p) {
		// TODO Auto-generated method stub

	}

	public void modificar(Pasajero p) {
		this.getSession().update(p);
	}

	public List<PasajeroDTO> listar() {

		List<PasajeroDTO> pasajerosDTO;

		Query a = this.getSession().createQuery("from Pasajero");
		@SuppressWarnings("unchecked")
		List<Pasajero> p = (List<Pasajero>) a.list();
		// ArmoDTO
		pasajerosDTO = new ArrayList<PasajeroDTO>();
		for (Pasajero pasajero : p) {
			pasajerosDTO.add(new PasajeroDTO(pasajero));
		}
		return pasajerosDTO;

	}

	public Pasajero getPasajero(Integer pasajeroId) {

		Pasajero pasajero = null;
		Query a = this.getSession().createQuery("from Pasajero p where p.idUsuario = :id ").setParameter("id",
				pasajeroId);

		if (a.list().size() != 0) {
			pasajero = (Pasajero) a.list().get(0);
		}
		return pasajero;
	}

}
