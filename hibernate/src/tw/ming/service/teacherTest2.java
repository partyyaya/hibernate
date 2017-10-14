package tw.ming.service;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import tw.ming.model.teacher;
import tw.ming.util.hibernateUtil;

public class teacherTest2 {
	private SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
	
	@Test
	public void testAdd() {
		Session session = sessionFactory.openSession();//生成一個session
		session.beginTransaction();//開起事務
		teacher s = new teacher();
		s.setName("name");
		session.save(s);
		session.getTransaction().commit();//提交事務
		session.close();//關閉session
		//sessionFactory.close();//關閉工廠
	}

	@Test
	public void testDelete() {
		Session session = sessionFactory.openSession();//生成一個session
		session.beginTransaction();//開起事務
		
		teacher teacher = 
				(teacher)session.get(teacher.class,Long.valueOf(3));//選擇id=x的資料
		session.delete(teacher);
		
		session.getTransaction().commit();//提交事務
		session.close();//關閉session
	}

	@Test
	public void testUpdate() {
		Session session = sessionFactory.openSession();//生成一個session
		session.beginTransaction();//開起事務
		
		teacher teacher = 
				(teacher)session.get(teacher.class,Long.valueOf(3));//選擇id=x的資料
		teacher.setName("name");
		session.save(teacher);
		
		session.getTransaction().commit();//提交事務
		session.close();//關閉session
	}

	@Test
	public void testGetAllteacher() {
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

}
