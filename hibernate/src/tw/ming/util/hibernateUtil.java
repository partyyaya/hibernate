package tw.ming.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class hibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		//若沒有table,sql則會自動建置table
		Configuration configure = new Configuration().configure();//實例化配置文件
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configure.getProperties())
				.build();//實例化服務登記
		return	configure.buildSessionFactory(serviceRegistry);//獲取session工廠		
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
}
