package util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.*;
import datamodel.EverestTreking;
import datamodel.HotelRate;
import datamodel.LangtangTrekking;
import datamodel.TripPrice;

public class UtilDB {

	static SessionFactory sessionFactory = null;

	   public static SessionFactory getSessionFactory() {
	      if (sessionFactory != null) {
	         return sessionFactory;
	      }
	      Configuration configuration = new Configuration().configure();
	      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	      sessionFactory = configuration.buildSessionFactory(builder.build());
	      return sessionFactory;
	   }



	public static void createEverest(String desc) {
	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         session.save(new EverestTreking(desc));
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	   }
	
	public static void createLangtang(String desc) {
	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         session.save(new LangtangTrekking(desc));
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	   }
	
	public static void insertTripPrice(Integer days, Integer price) {
		 
	     Session session = getSessionFactory().openSession();
	     Transaction tx = null;
	     try {
	        tx = session.beginTransaction();
	        session.save(new TripPrice(days, price));
	        tx.commit();
	     } catch (HibernateException e) {
	        if (tx != null)
	           tx.rollback();
	        e.printStackTrace();
	     } finally {
	        session.close();
	     }
	  }
	
	public static void insertHotelPrice(String Ratings, Integer price) {
	     Session session = getSessionFactory().openSession();
	     Transaction tx = null;
	     try {
	        tx = session.beginTransaction();
	        session.save(new HotelRate(Ratings, price));
	        tx.commit();
	     } catch (HibernateException e) {
	        if (tx != null)
	           tx.rollback();
	        e.printStackTrace();
	     } finally {
	        session.close();
	     }
	  }

	public static List <HotelRate> listHotelRate(String Rating) {
		List<HotelRate> resultList = new ArrayList<HotelRate>();
		Session session = getSessionFactory().openSession();
	    Transaction tx = null;  // each process needs transaction and commit the changes in DB.

	      try {
	         tx = session.beginTransaction();
	         List<?> hotelRate = session.createQuery("FROM HotelRate").list();
	         for (Iterator<?> iterator = hotelRate.iterator(); iterator.hasNext();) {
	        	 HotelRate rate = (HotelRate) iterator.next();
	        	 if(rate.getRating().contentEquals(Rating))
	        	 {
	        		 resultList.add(rate);
	        	 }
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
	
	public static List <TripPrice> listTripPrice(Integer days) {
		List<TripPrice> resultList = new ArrayList<TripPrice>();
		Session session = getSessionFactory().openSession();
	    Transaction tx = null;  // each process needs transaction and commit the changes in DB.

	      try {
	         tx = session.beginTransaction();
	         List<?> hotelRate = session.createQuery("FROM TripPrice").list();
	         for (Iterator<?> iterator = hotelRate.iterator(); iterator.hasNext();) {
	        	 TripPrice price = (TripPrice) iterator.next();
	        	 if(price.getDays() == days)
	        	 {
	        		 resultList.add(price);
	        	 }
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
	


	public static List <EverestTreking> listEverestTrekking() {
		List<EverestTreking> resultList = new ArrayList<EverestTreking>();
		Session session = getSessionFactory().openSession();
	    Transaction tx = null;  // each process needs transaction and commit the changes in DB.

	      try {
	         tx = session.beginTransaction();
	         List<?> everestDays = session.createQuery("FROM EverestTreking").list();
	         for (Iterator<?> iterator = everestDays.iterator(); iterator.hasNext();) {
	        	 EverestTreking everest = (EverestTreking) iterator.next();
	            resultList.add(everest);
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
	
	
	public static List <LangtangTrekking> listLangtangTrekking() {
		List<LangtangTrekking> resultList = new ArrayList<LangtangTrekking>();
		Session session = getSessionFactory().openSession();
	    Transaction tx = null;  // each process needs transaction and commit the changes in DB.

	      try {
	         tx = session.beginTransaction();
	         List<?> everestDays = session.createQuery("FROM LangtangTrekking").list();
	         for (Iterator<?> iterator = everestDays.iterator(); iterator.hasNext();) {
	        	 LangtangTrekking Langtang = (LangtangTrekking) iterator.next();
	            resultList.add(Langtang);
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

	public static void populateTable()
	{
		createEverest("Arrive at Kathmandu transfer to hotel and unpacking");
		createEverest("Full day sight seeing tour around the Kathmandu valley.");
		createEverest("Fly out from Kathmandu to Lukla");
		createEverest("Phakding to Namche Bazaar");
		createEverest("Acclimtisation day Namche bazzar");
		createEverest("Namche Bazaar to Tyangboche");
		createEverest("Tyangboche to Pheriche");
		createEverest("Pheriche to Lobuche");
		createEverest("Lobuche to Kalapatthar");
		createEverest("Explore everest base camp.");
		createEverest("Lobuche to Pangboche");
		createEverest("Pangboche to Namche Bazaar.");
		createEverest("Namche Bazaar to Lukla.");
		createEverest("Lukla to Kathmandu by flight.");
		createEverest("Free Day at Kathmandu");
		createEverest("Fly Back to Your Country.");
		insertHotelPrice("Five", 100);
		insertHotelPrice("Four", 80);
		insertHotelPrice("Three", 60);
		insertTripPrice(15, 1000);
		insertTripPrice(16, 1100);
		insertTripPrice(17, 1200);
		insertTripPrice(18, 1300);
		insertTripPrice(19, 1400);
		insertTripPrice(20, 1500);
		createLangtang("Arrive at Kathmandu transfer to hotel and unpacking");
		createLangtang("Full day sight seeing tour around the Kathmandu valley.");
		createLangtang("Drive to Syabru Beshi");
		createLangtang("Lama Hotel (2.500 m)");
		createLangtang("Langtang (3.450 m)");
		createLangtang("Langtang (Acclimatisation)");
		createLangtang("Kyangjing Goampa (3.850 m)");
		createLangtang("Explore to  Langsisa Karka");
		createLangtang("Climb up to Tserko Ri (4.960 m)");
		createLangtang("Ghoda Tabela (2.990 m)");
		createLangtang("Tulo Syabru (2.250 m)");
		createLangtang("Sing Gompa (3.250 m)");
		createLangtang("Gosainkund (4.300 m)");
		createLangtang("Laurebiniak Pass (4.610 m) - Ghopte (3.430 m)");
		createLangtang("Tatopati (3.690 m) - Kutumsang (2.470 m)");
		createLangtang("Chisapani (2.160 m)");
		createLangtang("Back to Kathmandu");
		createLangtang("Free Day at Kathmandu");
		createLangtang("Fly Back to Your Country.");
		}


}

