package com.hibernateExam.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.hibernateExam.model.Sport;
import com.hibernateExam.utility.HibernateUtility;

public class SportDAOImpl implements SportDAO {

	@Override
	public void addUpdateSport(Sport sb) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(sb);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteSport(int sportId) {
		Sport sb = new Sport();
		sb.setSportId(sportId);
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(sb);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Sport> findAllSport() {
		Session session = HibernateUtility.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "From SPORT_TABLE";
		Query query = session.createQuery(hql);
		List<Sport> sbs = query.getResultList();
		session.getTransaction().commit();
		return sbs;
	}

	@Override
	public Sport findSportbyId(int sportId) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		session.beginTransaction();

		//Fetching data from db
		Sport sb = session.get(Sport.class, sportId);
		session.getTransaction().commit();
		return sb;
	}
	public static void main(String[] args) {
	}
}
