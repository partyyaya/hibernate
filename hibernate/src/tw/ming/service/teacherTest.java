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
		Session session = sessionFactory.openSession();//生成一個session
		session.beginTransaction();//開起事務
		teacher s = new teacher();
		s.setName("name");
		session.save(s);
		session.getTransaction().commit();//提交事務
		session.close();//關閉session
		//sessionFactory.close();//關閉工廠
	}
	
	public void delete() {
		Session session = sessionFactory.openSession();//生成一個session
		session.beginTransaction();//開起事務
		
		teacher teacher = 
				(teacher)session.get(teacher.class,Long.valueOf(3));//選擇id=x的資料
		session.delete(teacher);
		
		session.getTransaction().commit();//提交事務
		session.close();//關閉session
	}
	
	public void update() {
		Session session = sessionFactory.openSession();//生成一個session
		session.beginTransaction();//開起事務
		
		teacher teacher = 
				(teacher)session.get(teacher.class,Long.valueOf(3));//選擇id=x的資料
		teacher.setName("name");
		session.save(teacher);
		
		session.getTransaction().commit();//提交事務
		session.close();//關閉session
	}
	
	public void getAllteacher() {
		Session session = sessionFactory.openSession();//生成一個session
		session.beginTransaction();//開起事務
		
		String hql = "from teacher";
		Query query = session.createQuery(hql);
		List<teacher> list = query.list();
		for(teacher teacher : list) {
			System.out.println(teacher);
		}
		
		session.getTransaction().commit();//提交事務
		session.close();//關閉session
	}
	
	public static void main(String[] args) {
		teacherTest teacherTest = new teacherTest();
		//teacherTest.add("ming2");//增加資料
		//teacherTest.delete(2);
		//teacherTest.update(1,"ming123");
		teacherTest.getAllteacher();
	}
}
