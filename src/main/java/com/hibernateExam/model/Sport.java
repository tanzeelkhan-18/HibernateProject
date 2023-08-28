package com.hibernateExam.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/*@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)*/
@Entity(name = "SPORT_TABLE")
public class Sport {
	// Data Members
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SPORT_ID")
	private int sportId;
	@Column(name = "SPORT_NAME")
	private String sportName;

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "COUNTRY_SPORT", joinColumns = @JoinColumn(name = "SPORT_ID"), inverseJoinColumns = @JoinColumn(name = "COUNTRY_ID"))
	List<Country> country;

	// Constructors
	public Sport(String sportName) {
		super();
		this.sportName = sportName;
	}

	public Sport() {
		super();
	}

	// Getters and Setters
	public int getSportId() {
		return sportId;
	}

	public void setSportId(int sportId) {
		this.sportId = sportId;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public List<Country> getCountry() {
		return country;
	}

	public void setCountry(List<Country> country) {
		this.country = country;
	}

	// ToStringMethod
	@Override
	public String toString() {
		return "Sport [sportId=" + sportId + ", sportName=" + sportName + "]";
	}

	// Method to add Countries
	public void addCountry(Country tempCountry) {
		if (country == null) {
			country = new ArrayList<Country>();
		}
		country.add(tempCountry);
	}

}
