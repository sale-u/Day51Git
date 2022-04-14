<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/application/logout" var="urlLogout"></c:url>
<div>
	Prijavljeni ste kao: ${sessionScope.loginUser.username}, <a href="${urlLogout}">Odjavite se</a>
	<br>
	Prijavljeni ste kao: ${loginUser.username}
</div>
