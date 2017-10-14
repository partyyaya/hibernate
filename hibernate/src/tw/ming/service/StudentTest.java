package tw.ming.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import tw.ming.model.Student;
import tw.ming.util.hibernateUtil;

public class StudentTest {
	private SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
	
	private void add(String name) {			
		Session session = sessionFactory.openSession();//生成一個session
		session.beginTransaction();//開起事務
		Student s = new Student();
		s.setName(name);
		session.save(s);
		session.getTransaction().commit();//提交事務
		session.close();//關閉session
		//sessionFactory.close();//關閉工廠
	}
	
	private void delete(long x) {
		Session session = sessionFactory.openSession();//生成一個session
		session.beginTransaction();//開起事務
		
		Student student = 
				(Student)session.get(Student.class,Long.valueOf(x));//選擇id=x的資料
		session.delete(student);
		
		session.getTransaction().commit();//提交事務
		session.close();//關閉session
	}
	
	private void update(long x,String name) {
		Session session = sessionFactory.openSession();//生成一個session
		session.beginTransaction();//開起事務
		
		Student student = 
				(Student)session.get(Student.class,Long.valueOf(x));//選擇id=x的資料
		student.setName(name);
		session.save(student);
		
		session.getTransaction().commit();//提交事務
		session.close();//關閉session
	}
	
	private void getAllStudent() {
		Session session = sessionFactory.openSession();//生成一個session
		session.beginTransaction();//開起事務
		
		String hql = "from Student";
		Query query = session.createQuery(hql);
		List<Student> list = query.list();
		for(Student student : list) {
			System.out.println(student);
		}
		
		session.getTransaction().commit();//提交事務
		session.close();//關閉session
	}
	
	public static void main(String[] args) {
		StudentTest studentTest = new StudentTest();
		//studentTest.add();//增加資料
		studentTest.getAllStudent();
	}
}
