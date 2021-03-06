package bd2.Muber.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// return new
			// Configuration().configure("hibernate/hibernate.cfg.xml").buildSessionFactory();
			Configuration configuration = new Configuration();
			configuration.configure("hibernate/hibernate.cfg.xml");
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			return (configuration.buildSessionFactory(serviceRegistry));
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
