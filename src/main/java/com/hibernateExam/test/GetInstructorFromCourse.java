package com.hibernateExam.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateExam.model.City;
import com.hibernateExam.model.Country;
import com.hibernateExam.model.Language;
import com.hibernateExam.model.Sport;

public class GetInstructorFromCourse {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Country.class).addAnnotatedClass(Language.class).addAnnotatedClass(City.class)
				.addAnnotatedClass(Sport.class).configure("com/hibernateExam/resource/hibernate.cfg.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();


		try {
			//Fetch Country from db
			Country temp = session.get(Country.class, 1);
			System.out.println("Country Title: "+ temp);
			System.out.println("Associated Capital: ..."+ temp.getCapital());
			System.out.println("Associated Language: ..."+ temp.getLanguage());
			System.out.println("Associated Sport: ..."+ temp.getSports());
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
