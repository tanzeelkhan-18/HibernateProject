package com.hibernateExam.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.hibernateExam.model.City;
import com.hibernateExam.model.Country;
import com.hibernateExam.model.Language;
import com.hibernateExam.utility.HibernateUtility;

public class CountryDAOImpl implements CountryDAO {

	@Override
	public void addCountry(Country cb) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Language lang = cb.getLanguage();
			City ct = cb.getCapital();
			session.saveOrUpdate(lang);
			session.saveOrUpdate(ct);
			session.update(ct);
			session.saveOrUpdate(cb);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void updateCountry(Country cb) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Language lang = cb.getLanguage();
			City ct = cb.getCapital();
			session.update(lang);
			session.update(ct);
			session.update(cb);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteCountry(int countryId) {
		Country cb = new Country();
		cb.setCountryId(countryId);
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(cb);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Country> findAllCountry() {
		Session session = HibernateUtility.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "From COUNTRY_TABLE";
		Query query = session.createQuery(hql);
		List<Country> cbs = query.getResultList();
		session.getTransaction().commit();
		return cbs;
	}

	@Override
	public Country findCountrybyId(int countryId) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		session.beginTransaction();

		//Fetching data from db
		Country cb = session.get(Country.class, countryId);
		session.getTransaction().commit();
		return cb;
	}
	public static void main(String[] args) {

	}
}
