package tw.ming.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.ming.model.teacher;
import tw.ming.util.hibernateUtil;

public class teacherTest {
	private SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
	
	public void add() {			
		Session session = sessionFactory.openSession();//�ͦ��@��session
		session.beginTransaction();//�}�_�ư�
		teacher s = new teacher();
		s.setName("name");
		session.save(s);
		session.getTransaction().commit();//����ư�
		session.close();//����session
		//sessionFactory.close();//�����u�t
	}
	
	public void delete() {
		Session session = sessionFactory.openSession();//�ͦ��@��session
		session.beginTransaction();//�}�_�ư�
		
		teacher teacher = 
				(teacher)session.get(teacher.class,Long.valueOf(3));//���id=x�����
		session.delete(teacher);
		
		session.getTransaction().commit();//����ư�
		session.close();//����session
	}
	
	public void update() {
		Session session = sessionFactory.openSession();//�ͦ��@��session
		session.beginTransaction();//�}�_�ư�
		
		teacher teacher = 
				(teacher)session.get(teacher.class,Long.valueOf(3));//���id=x�����
		teacher.setName("name");
		session.save(teacher);
		
		session.getTransaction().commit();//����ư�
		session.close();//����session
	}
	
	public void getAllteacher() {
		Session session = sessionFactory.openSession();//�ͦ��@��session
		session.beginTransaction();//�}�_�ư�
		
		String hql = "from teacher";
		Query query = session.createQuery(hql);
		List<teacher> list = query.list();
		for(teacher teacher : list) {
			System.out.println(teacher);
		}
		
		session.getTransaction().commit();//����ư�
		session.close();//����session
	}
	
	public static void main(String[] args) {
		teacherTest teacherTest = new teacherTest();
		//teacherTest.add("ming2");//�W�[���
		//teacherTest.delete(2);
		//teacherTest.update(1,"ming123");
		teacherTest.getAllteacher();
	}
}
