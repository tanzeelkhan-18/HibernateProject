package com.hibernateExam.dao;

import java.util.List;

import com.hibernateExam.model.Country;

public interface CountryDAO {
	public void addCountry(Country cb);
	public void updateCountry(Country cb);
	public void deleteCountry(int countryId);
	public List<Country> findAllCountry();
	public Country findCountrybyId(int countryId);
}
