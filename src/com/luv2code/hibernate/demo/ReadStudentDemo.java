package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("creating a new object");
			Student tempStudent = new Student("Nathaly","Nuflo","nathaly.nuflo21@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("Saving the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			session.getTransaction().commit();
			System.out.println("done");
			
			System.out.println("Saved student. Generated id: "+ tempStudent.getId());
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student myStudent =  session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: " + myStudent);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

}
