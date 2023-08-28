package com.hibernateExam.service;

import java.util.List;

import com.hibernateExam.model.Country;

public interface CountryService {
	public void addCountry(String country);
	public void updateCountry(int countryId, String country, String language, String city);
	public void deleteCountry(int countryId);
	public List<Country> findAllCountry();
	public Country findCountrybyId(int countryId);
}
