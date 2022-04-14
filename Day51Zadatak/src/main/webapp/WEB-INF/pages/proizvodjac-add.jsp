<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodaj proizvodjaca</title>
</head>

<body>

	<header>
		<jsp:include page="/WEB-INF/fragment/login-user.jsp" flush="true"></jsp:include>
		<jsp:include page="/WEB-INF/fragment/navigation.jsp" flush="true"></jsp:include>
	</header>


	<main>
		<h2>Dodaj proizvodjaca</h2>
		<article>
			<div>
				<form action="/Day51Zadatak/application/proizvAddSave" method="post">
					<label>Pib</label>
					<input type="number" name="pib" value="${proizvodjac.pib}">
					<br><br>
					<label>MatBroj</label>
					<input type="number" name="matbr" value="${proizvodjac.maticniBroj}">	
					<br><br>
					<label>Adresa</label>
					<input type="text" name="adresa" value="${proizvodjac.adresa}">
					<br><br>
					<label>Mesto</label>
					<input type="text" name="mesto" value="${proizvodjac.mesto}">		
					
					<br><br><br>
					
					<input type="submit" value="cancel" name="dugme">
					<input type="submit" value="Dodaj" name="dugme">
					
					<br><br>
					<p>${requestScope.error_message}</p>

				</form>
			</div>
		</article>
		
	</main>
	
	
	<footer><br><br> Copyright 2022 </footer>

</body>

</html>