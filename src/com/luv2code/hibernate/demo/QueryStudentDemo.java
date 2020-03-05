package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			List<Student> theStudents = session.createQuery("from Student").getResultList();//query students
			
			//display the students
			theStudents.forEach(s->System.out.println(s));
			
			theStudents = session.createQuery("from Student s where s.firstName='Isaac'").getResultList();
			
			theStudents.forEach(s->System.out.println(s));
			
			session.getTransaction().commit();
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

}
