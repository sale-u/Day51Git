<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Dodaj proizvodjaca</title>
	<style>
		body {
			background-image:
			url("https://i0.wp.com/www.middleeastmonitor.com/wp-content/uploads/2021/11/20211112_2_50853993_70603392-1.jpg?quality=85&strip=all&zoom=1&ssl=1");
			background-size: cover;
			color: white;
		}
	
	</style>
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
					<input type="text" name="pib">
					<br><br>
					<label>MatBroj</label>
					<input type="text" name="matbr">	
					<br><br>
					<label>Adresa</label>
					<input type="text" name="adresa">
					<br><br>
					<label>Mesto</label>
					<select name="zipCode">
						<c:forEach var="c" items="${cities}">
							<option value = "${c.zipCode}">
								${c.zipCode} ${c.name}
							</option>
						</c:forEach>
					</select>
	
					
					<br><br><br>
					
					<input type="submit" value="cancel" name="dugme">
					<input type="submit" value="Dodaj" name="dugme">
					
					<br><br>
					<p>${requestScope.error_message}</p>

				</form>
			</div>
		</article>
		
	</main>
	
	
	<jsp:include page="/WEB-INF/fragment/footer.jsp" flush="true"></jsp:include>

</body>

</html>