package com.hibernateExam.service;

import java.util.List;

import com.hibernateExam.dao.LanguageDAO;
import com.hibernateExam.dao.LanguageDAOImpl;
import com.hibernateExam.model.Language;

public class LanguageServiceImpl implements LanguageService {

	LanguageDAO ld = new LanguageDAOImpl();

	@Override
	public List<Language> findAllLanguage() {
		return ld.findAllLanguage();
	}
}
