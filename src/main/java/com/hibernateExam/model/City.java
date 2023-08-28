package com.hibernateExam.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/*@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)*/
@Entity(name = "CITY_TABLE")
public class City {
	// Data Members
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CITY_ID")
	private int cityId;

	@Column(name = "CITY_NAME")
	private String cityName;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "capital")
	private Country country;

	// Constructors
	public City(String cityName) {
		super();
		this.cityName = cityName;
	}

	public City() {
		super();
	}

	// Getters and Setters
	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	// ToStringMethod
	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + "]";
	}
}
