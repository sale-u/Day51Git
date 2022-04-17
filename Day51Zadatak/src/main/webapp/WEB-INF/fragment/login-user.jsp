<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
	<style>
	
		body {
			background-image:
			url("https://i0.wp.com/www.middleeastmonitor.com/wp-content/uploads/2021/11/20211112_2_50853993_70603392-1.jpg?quality=85&strip=all&zoom=1&ssl=1");
			background-size: cover;
			color: white;
		}
	
		div {
			width: 50vw;
			height: 10vh;
			color: white;
			margin: 5vh 3vw;
		}
		
		.odjava {
			background-color: rgba(200, 51, 120, 1); 
			text-decoration: none;
			color: white; 
			outline: solid white 1px;
			border: solid black 1px; 
			padding : 10px 20px;
			border-radius: 5px; 	
		}
		
		h3 {
			margin: 0 1.6rem; 
			text-decoration: underline;
		}
	
	</style>

</head>

<body>
<c:url value="/application/logout" var="urlLogout"></c:url>
<div>
	<h2>Prijavljeni ste kao: ${sessionScope.loginUser.username}</h2>
	
	<a class = "odjava" href="${urlLogout}">Odjavite se</a>
	<br>
</div>
</body>