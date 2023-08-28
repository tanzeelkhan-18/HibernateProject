package com.hibernateExam.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateExam.model.City;
import com.hibernateExam.model.Country;
import com.hibernateExam.model.Language;
import com.hibernateExam.model.Sport;

public class myTest {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Country.class).addAnnotatedClass(Language.class)
				.addAnnotatedClass(City.class).addAnnotatedClass(Sport.class).configure("com/hibernateExam/resource/hibernate.cfg.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		try {
			// Create Country

			Country country1 = new Country("India");
			Country country2 = new Country("America");
			Country country3 = new Country("Russia");

			Language language1 = new Language("Hindi");
			Language language2 = new Language("English");
			Language language3 = new Language("Russian");

			City capital1 = new City("New Delhi");
			City capital2 = new City("New York");
			City capital3 = new City("Moscow");

			country1.setLanguage(language1);
			country2.setLanguage(language2);
			country3.setLanguage(language3);

			country1.setCapital(capital1);
			country2.setCapital(capital2);
			country3.setCapital(capital3);

			Sport sport1 = new Sport("Hockey");
			Sport sport2 = new Sport("Cricket");
			Sport sport3 = new Sport("Baseball");
			Sport sport4 = new Sport("Chess");
			Sport sport5 = new Sport("IceHockey");
			Sport sport6 = new Sport("Carrom");


			country1.addSport(sport1);
			country1.addSport(sport2);

			country2.addSport(sport3);
			country2.addSport(sport4);

			country3.addSport(sport5);
			country3.addSport(sport6);

			session.save(language1);
			session.save(language2);
			session.save(language3);

			session.save(sport1);
			session.save(sport2);
			session.save(sport3);
			session.save(sport4);
			session.save(sport5);
			session.save(sport6);

			session.save(country1);
			session.save(country2);
			session.save(country3);

			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}