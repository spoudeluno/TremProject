package util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import datamodel.EverestTreking;
public class UtilDB {
	static  SessionFactory sessionFactory = null;
	
	   public static List<EverestTreking> listEmployees() {
	      List<EverestTreking> resultList = new ArrayList<EverestTreking>();

	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;  // each process needs transaction and commit the changes in DB.

	      try {
	         tx = session.beginTransaction();
	         List<?> employees = session.createQuery("FROM Employee").list();
	         for (Iterator<?> iterator = employees.iterator(); iterator.hasNext();) {
	        	 EverestTreking employee = (EverestTreking) iterator.next();
	            resultList.add(employee);
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	      return resultList;
	   }
	   public static void createEverest(String Desc) {
	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         session.save(new EverestTreking(Desc));
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	   }
	   public static SessionFactory getSessionFactory() {
		      if (sessionFactory != null) {
		         return sessionFactory;
		      }
		      Configuration configuration = new Configuration().configure();
		      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		      sessionFactory = configuration.buildSessionFactory(builder.build());
		      return sessionFactory;
		   }

}
