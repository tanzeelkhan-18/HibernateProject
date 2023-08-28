package com.hibernateExam.dao;

import java.util.List;

import com.hibernateExam.model.City;

public interface CityDAO {
	public void addUpdateCity(City cb);
	public void deleteCity(int cityId);
	public List<City> findAllCity();
	public City findCitybyId(int cityId);
}
