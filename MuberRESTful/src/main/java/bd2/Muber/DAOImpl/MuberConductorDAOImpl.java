package bd2.Muber.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


import bd2.Muber.dto.ConductorDTO;
import bd2.Muber.model.Conductor;
import bd2.Muber.model.ConductorDetalle;

public class MuberConductorDAOImpl {

	private Session session; 
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public MuberConductorDAOImpl(Session session){
		super();
		this.session=session;
	}
	
	public void agregar(Conductor c) {
		// TODO Auto-generated method stub

	}

	public void modificar(Conductor c) {
			this.getSession().update(c);

	}

	//http://localhost:8080/MuberRESTful/rest/services/conductores	
	public List<ConductorDTO> listar() {

		List<ConductorDTO> conductoresDTO;

		Query a = this.getSession().createQuery(
				"from Conductor c");
		@SuppressWarnings("unchecked")
		List<Conductor> c = (List<Conductor>) a.list();
		// Armo lista DTOs
		conductoresDTO = new ArrayList<ConductorDTO>();
		for (Conductor conductor : c) {
			conductoresDTO.add(new ConductorDTO(conductor));
		}

		return conductoresDTO;
	}

	public ConductorDetalle conductorDetalle(Integer conductorId) {

			Query a = this.getSession().createQuery(
					"select new bd2.Muber.model.ConductorDetalle(c.nombre, count(distinct v.idViaje), avg(ca.puntaje), c.fechaLicencia) from Conductor c join c.viajes v join v.calificaciones ca where c.idUsuario = :id");
			a.setParameter("id", conductorId);
			System.out.println("Despues de la consulta" + a.uniqueResult().getClass().toString());
			ConductorDetalle p = (ConductorDetalle) a.list().get(0);
            
			return p;
		

	}


	public ConductorDTO getConductor(Integer conductorId) {

		ConductorDTO conductorDTO = null;
		Query a = this.getSession().createQuery("from Conductor c  where c.idUsuario = :id ").setParameter("id", conductorId);

		if (a.list().size() != 0) {
			Conductor c = (Conductor) a.list().get(0);

			conductorDTO = new ConductorDTO(c);
		}

		// Saco el promedio

		return conductorDTO;
	}
	
	public Conductor getConductorBase(Integer conductorId) {

		Query a = this.getSession().createQuery("from Conductor c left join fetch c.viajes where c.idUsuario = :id ").setParameter("id", conductorId);
		Conductor c = null; 
		if (a.list().size() != 0) {
			c = (Conductor) a.list().get(0);
		}

		return c;
	}

	public List<ConductorDTO> getConductoresTop10() {

			List<ConductorDTO> conductoresDTO;
			String conductoresConViajesAbiertos = "(select c.idUsuario from Conductor c join c.viajes v where v.finalizado = false group by c.idUsuario having count(v.idViaje) >= 1 ) ";
			Query a = session.createQuery(
					" select new Conductor(con.contrasena, con.dni,  con.fechaIngreso, con.fechaLicencia,  con.licencia,  con.nombre)  from Conductor con join con.viajes vi join vi.calificaciones ca where con.idUsuario not in "
							+ conductoresConViajesAbiertos + "  group by (con.idUsuario) order by avg(ca.puntaje)");
			a.setMaxResults(10);
			@SuppressWarnings("unchecked")
			List<Conductor> p = (List<Conductor>) a.list();

			//Armo DTO
			conductoresDTO = new ArrayList<ConductorDTO>();
			for (Conductor con : p){
				conductoresDTO.add(new ConductorDTO(con));
			}
			return conductoresDTO;

	}

}
