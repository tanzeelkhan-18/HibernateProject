<%@page import="com.hibernateExam.model.Country"%>
<%@page import="java.util.List"%>
<%@page import="com.hibernateExam.service.CountryServiceImpl"%>
<%@page import="com.hibernateExam.service.CountryService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta name="copyright" content="MACode ID, https://macodeid.com/">
<title>Country Table</title>
<link rel="stylesheet" href="css/maicons.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="vendor/owl-carousel/css/owl.carousel.css">
<link rel="stylesheet" href="vendor/animate/animate.css">
<link rel="stylesheet" href="css/theme.css">
</head>
<body>

	<c:import url="header.jsp"></c:import>

	<br>
	<h1 align="center">Country</h1>
	<br>
	<table align="center" border="2" width="90%" cellpadding="8px">
		<tr>
			<th>Country ID</th>
			<th>Country Name</th>
			<th>Language</th>
			<th>Capital</th>
			<!-- 			<th>Edit</th>
			<th>Delete</th> -->
		</tr>
		<%
		CountryService cs = new CountryServiceImpl();
		List<Country> al = cs.findAllCountry();
		%>
		<tr>
			<%
			for (Country c : al) {
			%>
			<td><%=c.getCountryId()%></td>
			<td><%=c.getCountryName()%></td>
			<td><%=c.getLanguage().getLanguageName()%></td>
			<td><%=c.getCapital().getCityName()%></td>
		</tr>
		<%
		}
		%>
	</table>
	
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="vendor/owl-carousel/js/owl.carousel.min.js"></script>
	<script src="vendor/wow/wow.min.js"></script>
	<script src="js/theme.js"></script>
</body>
</html>