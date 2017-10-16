package bd2.Muber.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import bd2.Muber.dto.ViajeDTO;
import bd2.Muber.model.Viaje;

public class MuberViajeDAOImpl {

	private Session session;
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public MuberViajeDAOImpl(Session session){
		this.session = session;
	}
	
	public void agregar(Viaje v) {
		// TODO Auto-generated method stub

	}

	public void modificar(Viaje v) {

			this.getSession().update(v);

	}

	public List<ViajeDTO> listarViajesAbiertos() {

		List<ViajeDTO> viajesDTO;

		Query a = this.getSession().createQuery(
				" from Viaje v where v.finalizado = 0 ");
		@SuppressWarnings("unchecked")
		List<Viaje> viajes = (List<Viaje>) a.list();
		// Armo lista DTOs
		viajesDTO = new ArrayList<ViajeDTO>();
		for (Viaje v : viajes) {
			viajesDTO.add(new ViajeDTO(v));
		}

		return viajesDTO;
	}

	public Viaje getViaje(Integer viajeId) {

		Viaje v = null;
		Query a = this.getSession().createQuery("from Viaje v left join fetch v.pasajeros where v.idViaje = :id ")
				.setParameter("id", viajeId);
		if (a.list().size() != 0) {
			v = (Viaje) a.list().get(0);
		}

		return v;

	}
	
	public Viaje getViajeCalificaciones(Integer viajeId) {
		Viaje v = null;
		Query a = this.getSession().createQuery("from Viaje v left join fetch v.calificaciones where v.idViaje = :id ")
				.setParameter("id", viajeId);
		if (a.list().size() != 0) {
			v = (Viaje) a.list().get(0);
		}
		return v;
	}

}
