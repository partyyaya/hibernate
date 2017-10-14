package tw.ming.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class hibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		//�Y�S��table,sql�h�|�۰ʫظmtable
		Configuration configure = new Configuration().configure();//��Ҥưt�m���
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configure.getProperties())
				.build();//��ҤƪA�ȵn�O
		return	configure.buildSessionFactory(serviceRegistry);//���session�u�t		
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
}
