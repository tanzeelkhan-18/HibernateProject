package com.hibernateExam.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernateExam.model.Country;
import com.hibernateExam.service.CountryService;
import com.hibernateExam.service.CountryServiceImpl;

@WebServlet("/CountryController")
public class CountryController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		CountryService cs = new CountryServiceImpl();
		List<Country> al = cs.findAllCountry();
	}

}
