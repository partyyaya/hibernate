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
		Session session = sessionFactory.openSession();//�ͦ��@��session
		session.beginTransaction();//�}�_�ư�
		Student s = new Student();
		s.setName(name);
		session.save(s);
		session.getTransaction().commit();//����ư�
		session.close();//����session
		//sessionFactory.close();//�����u�t
	}
	
	private void delete(long x) {
		Session session = sessionFactory.openSession();//�ͦ��@��session
		session.beginTransaction();//�}�_�ư�
		
		Student student = 
				(Student)session.get(Student.class,Long.valueOf(x));//���id=x�����
		session.delete(student);
		
		session.getTransaction().commit();//����ư�
		session.close();//����session
	}
	
	private void update(long x,String name) {
		Session session = sessionFactory.openSession();//�ͦ��@��session
		session.beginTransaction();//�}�_�ư�
		
		Student student = 
				(Student)session.get(Student.class,Long.valueOf(x));//���id=x�����
		student.setName(name);
		session.save(student);
		
		session.getTransaction().commit();//����ư�
		session.close();//����session
	}
	
	private void getAllStudent() {
		Session session = sessionFactory.openSession();//�ͦ��@��session
		session.beginTransaction();//�}�_�ư�
		
		String hql = "from Student";
		Query query = session.createQuery(hql);
		List<Student> list = query.list();
		for(Student student : list) {
			System.out.println(student);
		}
		
		session.getTransaction().commit();//����ư�
		session.close();//����session
	}
	
	public static void main(String[] args) {
		StudentTest studentTest = new StudentTest();
		//studentTest.add();//�W�[���
		studentTest.getAllStudent();
	}
}
