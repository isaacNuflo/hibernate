package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, 1);
			
			System.out.println(myStudent);
			
			myStudent.setFirstName("Carlos");
			
			session.createQuery("update Student set email='foo@gmail.com' where firstName='Elias'").executeUpdate();
			
			session.getTransaction().commit();
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

}
