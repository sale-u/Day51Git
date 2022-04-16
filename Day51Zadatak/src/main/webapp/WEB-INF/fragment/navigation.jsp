<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
	<style>
		.lnk {
			text-decoration: none;
			color: white; 
			border: solid white 1px; 
			padding : 10px 20px;
			border-radius: 5px;
		}
	
	</style>

</head>


<c:url value="/application/proizvAdd" var="proizvAdd"></c:url>
<c:url value="/application/proizvList" var="proizvList"></c:url>

<div>
	<nav>
		<br>
		<a class="lnk" href="${proizvAdd}">Dodaj proizvodjaca</a>
		<br><br><br>
		<a class="lnk" href="${proizvList }">Lista svih proizvodjaca</a>
	</nav>
</div>

