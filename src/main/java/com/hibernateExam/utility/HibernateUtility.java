package com.hibernateExam.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateExam.model.City;
import com.hibernateExam.model.Country;
import com.hibernateExam.model.Language;
import com.hibernateExam.model.Sport;

public class HibernateUtility {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(Country.class).addAnnotatedClass(Language.class).addAnnotatedClass(City.class)
					.addAnnotatedClass(Sport.class).configure("com/hibernateExam/resource/hibernate.cfg.xml");
			sessionFactory = cfg.buildSessionFactory();
		}
		return sessionFactory;
	}
}
