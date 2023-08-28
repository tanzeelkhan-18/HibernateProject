package com.hibernateExam.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.hibernateExam.model.City;
import com.hibernateExam.utility.HibernateUtility;

public class CityDaoImpl implements CityDAO {

	@Override
	public void addUpdateCity(City cb) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(cb);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteCity(int cityId) {
		City cb = new City();
		cb.setCityId(cityId);
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
	public List<City> findAllCity() {
		Session session = HibernateUtility.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "From CITY_TABLE";
		Query query = session.createQuery(hql);
		List<City> cbs = query.getResultList();
		session.getTransaction().commit();
		return cbs;
	}

	@Override
	public City findCitybyId(int cityId) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		session.beginTransaction();

		//Fetching data from db
		City cb = session.get(City.class, cityId);
		session.getTransaction().commit();
		return cb;
	}
	public static void main(String[] args) {
	}
}
