package com.hibernateExam.service;

import java.util.List;

import com.hibernateExam.dao.CountryDAO;
import com.hibernateExam.dao.CountryDAOImpl;
import com.hibernateExam.model.City;
import com.hibernateExam.model.Country;
import com.hibernateExam.model.Language;

public class CountryServiceImpl implements CountryService {

	CountryDAO cd = new CountryDAOImpl();

	@Override
	public void addCountry(String country) {
		Country cb = new Country(country);
		cd.addCountry(cb);
	}

	@Override
	public void updateCountry(int countryId, String country, String language, String city) {
		Country cb = new Country(country);
		cb.setCountryId(countryId);
		Language lang = new Language(language);
		cb.setLanguage(lang);
		City ct = new City(city);
		cb.setCapital(ct);
		cd.updateCountry(cb);
	}

	@Override
	public void deleteCountry(int countryId) {
		cd.deleteCountry(countryId);
	}

	@Override
	public List<Country> findAllCountry() {
		List cl = cd.findAllCountry();
		return cl;
	}

	@Override
	public Country findCountrybyId(int countryId) {
		Country cb = new Country();
		cb = cd.findCountrybyId(countryId);
		return cb;
	}

	public static void main(String[] args) {
		CountryServiceImpl cs = new CountryServiceImpl();
		cs.updateCountry(1, "Hindustan", "Hindi", "New Delhi");
	}

}
