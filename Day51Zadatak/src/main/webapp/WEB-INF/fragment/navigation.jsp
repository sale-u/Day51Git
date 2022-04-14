<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:url value="/application/proizvAdd" var="proizvAdd"></c:url>
<c:url value="/application/proizvList" var="proizvList"></c:url>

<div>
	<nav>
		<a href="${proizvAdd}">Dodaj proizvodjaca</a>
		<a href="${proizvList }">Lista svih proizvodjaca</a>
	</nav>
</div>

