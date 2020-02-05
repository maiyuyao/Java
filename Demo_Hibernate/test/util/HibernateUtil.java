package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static Session session;

	// 旧版本的new Configuration()方法已经不能再使用了。
	// sessionFactory = new Configuration().configure().buildSessionFactory();
	static {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
	}

	// 获取SessionFactory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	// 获取Session
	public static Session getSession() {
		session = sessionFactory.openSession();
		return session;
	}

	// 关闭Session
	public static void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}
}
