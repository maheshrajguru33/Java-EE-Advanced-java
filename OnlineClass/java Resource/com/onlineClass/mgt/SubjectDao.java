package com.onlineClass.mgt;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlineClass.util.hibernateUtil;

public class SubjectDao {
	
	public static void saveSubject(Subject subject) {
		Transaction transaction = null;
		try (Session session = hibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
		
			session.save(subject);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
