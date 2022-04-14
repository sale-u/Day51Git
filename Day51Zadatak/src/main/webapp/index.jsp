<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<h2>Dobro dosli</h2>
	
	<div>
		<c:url value="/application/login" var="urlLogin"/>
		<a href="${urlLogin}">Prijavi se</a>
	</div>
</body>
</html>
