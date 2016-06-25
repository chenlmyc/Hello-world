package tools;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateHelper {

	private static final SessionFactory sessionFactory = new Configuration()
			.configure("hibernate.cfg.xml").buildSessionFactory();
	private static Session session;
	public HibernateHelper() {
	}
	public static SessionFactory getSessionFactory() {
		System.out.println("hello world");
		
		return new Configuration()
		.configure("/hibernate.cfg.xml").buildSessionFactory();
	}

	public static Session getSession() {
		if(session == null){
			session = sessionFactory.openSession();
			
		}
		return session;

	}
}
