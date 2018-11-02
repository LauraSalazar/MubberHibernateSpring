package bd2.Muber.DAOImpl;

import org.hibernate.Query;
import org.hibernate.Session;

import bd2.Muber.model.Muber;

public class MuberDAOImpl {
	
	private Session session;
	
	public MuberDAOImpl(Session session){
		super();
		this.session = session;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	public Muber obtenerMuber(){
		Query a = session.createQuery(
				"select from Muber");
		Muber m = (Muber) a.list().get(0);
		return m;
	}
}