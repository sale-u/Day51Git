<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
	<style>
		div {
			width: 50vw;
			height: 10vh;
			color: white;
			margin: 5vh 3vw;
		}
		
		.odjava {
			background-color: red; 
			text-decoration: none;
			color: white; 
			border: solid black 1px; 
			padding : 10px 20px;
			border-radius: 5px; 	
		}
	
	</style>

</head>


<c:url value="/application/logout" var="urlLogout"></c:url>
<div>
	<h2>Prijavljeni ste kao: ${sessionScope.loginUser.username}</h2> <!--  -->
	
	<a class = "odjava" href="${urlLogout}">Odjavite se</a>
	<br>
</div>
