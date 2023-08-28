package com.hibernateExam.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.hibernateExam.model.Country;
import com.hibernateExam.model.Language;
import com.hibernateExam.utility.HibernateUtility;

public class LanguageDAOImpl implements LanguageDAO {

	@Override
	public void addUpdateLanguage(Language lb) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(lb);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteLanguage(int languageId) {
		Language lb = new Language();
		lb.setLanguageId(languageId);
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(lb);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Language> findAllLanguage() {
		Session session = HibernateUtility.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "From LANGUAGE_TABLE";
		Query query = session.createQuery(hql);
		List<Language> lbs = query.getResultList();
		session.getTransaction().commit();
		return lbs;
	}

	@Override
	public Language findLanguagebyId(int languageId) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		session.beginTransaction();

		//Fetching data from db
		Language lb = session.get(Language.class, languageId);
		session.getTransaction().commit();
		return lb;
	}

	public static void main(String[] args) {
		LanguageDAOImpl ld = new LanguageDAOImpl();
		List<Language> cl = ld.findAllLanguage();
		for(Language l: cl) {
			System.out.println(l);
			List<Country> cl2 = l.getCountry();
			for(Country c : cl2) {
				System.out.println(c.getCountryName());
			}
		}
	}
}
