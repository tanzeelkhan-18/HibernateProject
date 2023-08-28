package com.hibernateExam.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/*@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)*/
@Entity(name = "COUNTRY_TABLE")
public class Country {
	// Data Members
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COUNTRY_ID")
	private int countryId;
	@Column(name = "COUNTRY_NAME")
	private String countryName;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Language language;

	@OneToOne(cascade = CascadeType.ALL)
	private City capital;

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "COUNTRY_SPORT", joinColumns = @JoinColumn(name = "COUNTRY_ID"), inverseJoinColumns = @JoinColumn(name = "SPORT_ID"))
	List<Sport> sports;

	// Constructors
	public Country(String countryName) {
		super();
		this.countryName = countryName;
	}
	public Country() {
		super();
	}

	// Getters and Setters
	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryName() {
		return countryName;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public City getCapital() {
		return capital;
	}

	public void setCapital(City capital) {
		this.capital = capital;
	}

	public List<Sport> getSports() {
		return sports;
	}

	public void setSports(List<Sport> sports) {
		this.sports = sports;
	}

	// ToStringMethod
	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName=" + countryName + ", language=" + language
				+ ", capital=" + capital + ", sports=" + sports + "]";
	}

	// Method to add Sports
	public void addSport(Sport tempSport) {
		if (sports == null) {
			sports = new ArrayList<Sport>();
		}
		sports.add(tempSport);
	}
}
