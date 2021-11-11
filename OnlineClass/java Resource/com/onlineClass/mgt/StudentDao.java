package com.onlineClass.mgt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlineClass.util.hibernateUtil;

public class StudentDao {

	public static void saveStudent(Student student) {
		Transaction transaction = null;
		try (Session session = hibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			
			
		
			session.save(student);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}


	@SuppressWarnings("unchecked")
public static List<Student> getAllstudent() {

	Transaction transaction = null;
	List<Student> listOfstudent = null;
	try (Session session = hibernateUtil.getSessionFactory().openSession()) {
		
		transaction = session.beginTransaction();
		
		
		listOfstudent = session.createQuery("from students").getResultList();
		
		// commit transaction
		transaction.commit();
	} catch (Exception e) {
		if (transaction != null) {
			transaction.rollback();
		}
		e.printStackTrace();
	}
	return listOfstudent;
}
}

