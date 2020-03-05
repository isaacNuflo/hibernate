package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating 3 student objects...");
			Student student = new Student("Isaac","Nuflo","isaac.nuflo21@gmail.com");
			Student student1 = new Student("Elias","Nuflo","elias.nuflo21@gmail.com");
			Student student2 = new Student("Jose","Nuflo","jose.nuflo21@gmail.com");
			
			session.beginTransaction();
			
			session.save(student);
			session.save(student1);
			session.save(student2);
			
			session.getTransaction().commit();
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

}
