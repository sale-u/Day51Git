<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:url value="/application/city/add" var="cityAdd"></c:url>
<c:url value="/application/city" var="cities"></c:url>

<c:url value="/application/company/add" var="companyAdd"></c:url>
<c:url value="/application/company" var="companies"></c:url>

<div>
	<nav>
		<a href="${cityAdd}">Add city</a>
		<a href="${cities }">View cities</a>

		<a href="${companyAdd }">Add company</a>
		<a href="${companies }">View companies</a>	
	
	</nav>
</div>

