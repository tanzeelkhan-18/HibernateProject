package com.hibernateExam.dao;

import java.util.List;

import com.hibernateExam.model.Language;

public interface LanguageDAO {
	public void addUpdateLanguage(Language cb);
	public void deleteLanguage(int languageId);
	public List<Language> findAllLanguage();
	public Language findLanguagebyId(int languageId);
}
