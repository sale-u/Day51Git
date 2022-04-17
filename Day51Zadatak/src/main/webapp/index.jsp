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
}

a {
	background-color: rgba(120, 150, 230, 0.9);
	color: white;
	border: solid black 1px;
	outline: solid white 1px;
	border-radius: 5px; 
	padding : 10px 20px;
	text-decoration: none;
}

h1 {
	color: white;
}

main {
	text-align: center; 
	width : 50vw;
	height: 40vh;
	margin: 5vh auto;
}

</style>
</head>

<html>
<body>
	<main>

		<div>
			<h1>Dobro dosli</h1>

			<div>
				<c:url value="/application/login" var="urlLogin" />
				<a href="${urlLogin}">Prijavi se</a>
			</div>
		</div>
		
	</main>
</body>
</html>
