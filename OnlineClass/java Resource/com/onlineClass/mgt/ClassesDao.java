package com.onlineClass.mgt;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlineClass.util.hibernateUtil;

public class ClassesDao {
	
	public static void saveClasses(Classes classes) {
		Transaction transaction = null;
		try (Session session = hibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			
			session.save(classes);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
