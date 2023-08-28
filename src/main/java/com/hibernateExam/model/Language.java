package com.hibernateExam.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)*/
@Entity(name = "LANGUAGE_TABLE")
public class Language {
	// Data Members
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LANGUAGE_ID")
	private int languageId;
	@Column(name = "LANGUAGE_NAME")
	private String languageName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "language")
	List<Country> country;

	// Constructors
	public Language(String languageName) {
		super();
		this.languageName = languageName;
	}

	public Language() {
		super();
	}

	// Getters and Setters
	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public List<Country> getCountry() {
		return country;
	}

	public void setCountry(List<Country> country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Language [languageId=" + languageId + ", languageName=" + languageName + "]";
	}

	// Method to add Countries
	public void addCountry(Country tempCountry) {
		if(country==null) {
			country = new ArrayList<Country>();
		}
		country.add(tempCountry);
		tempCountry.setLanguage(this);
	}
}
