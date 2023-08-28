package com.hibernateExam.dao;

import java.util.List;

import com.hibernateExam.model.Sport;

public interface SportDAO {
	public void addUpdateSport(Sport cb);
	public void deleteSport(int sportId);
	public List<Sport> findAllSport();
	public Sport findSportbyId(int sportId);
}
