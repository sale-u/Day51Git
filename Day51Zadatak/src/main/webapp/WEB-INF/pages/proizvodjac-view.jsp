<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Prikazi proizvodjaca</title>
	
	<style>
		table {
			border-spacing: 5px
		}
		
		td {
			background-color:  rgba(65, 51, 187, 0.5);
			padding: 7px 10px;
		}
		
		[type="text"], select {
			background-color:  rgba(65, 51, 187, 0.5);
			color: white;
			font-size: 1rem;
		}
		
		.cancel, .sacuvaj {
			text-decoration: none;
			color: white;
			border: solid blue 1px;
			outline: solid white 1px;
			border-radius: 5px;
			padding: 10px 15px;
			margin: 2rem 3rem 0 0;
		}
		
		.cancel {
			background-color:  rgba(200, 51, 120, 0.9);
		}
		
		.sacuvaj {
			background-color:  rgba(120, 150, 230, 0.9);
		}

	
	</style>


</head>

<body>

	<header>
		<jsp:include page="/WEB-INF/fragment/login-user.jsp" flush="true"></jsp:include>
		<jsp:include page="/WEB-INF/fragment/navigation.jsp" flush="true"></jsp:include>
	</header>


	<main>
		<br>
		<h3>Trenutni podaci o proizvodjacu</h3>
		<div>
			<form action="/Day51Zadatak/application/proizvSave" method="post">
				<table>
					<tbody>
						<tr>
							<td>Pib</td>
							<td><input type="text" name="pib" value="${proizvodjac.pib}" readonly="readonly"></td>
						</tr>
						<tr>
							<td>MatBroj</td>
							<td><input type="text" name="matbr" value="${proizvodjac.matBr}"></td>	
						</tr>
						<tr>
							<td>Adresa</td>
							<td><input type="text" name="adresa" value="${proizvodjac.adresa}"></td>
						</tr>
						<tr>
							<td>Mesto</td>
							<td><select name="zipCode">
								<c:forEach var="c" items="${cities}">
									<option value = "${c.zipCode}"
										${c.zipCode == proizvodjac.city.zipCode ? 'selected' : ''}>
										${c.zipCode} ${c.name}
									</option>
								</c:forEach>
							</select></td>	
						</tr>
					</tbody>
				</table>
				
				<input class="cancel" type="submit" value="cancel" name="dugme">
				<input class="sacuvaj" type="submit" value="Sacuvaj izmene" name="dugme">

			</form>
			
			<br><br>
			<p style="background-color: red;">${requestScope.error_message}</p>
			
		</div>
		
	</main>
	
	
	<jsp:include page="/WEB-INF/fragment/footer.jsp" flush="true"></jsp:include>

</body>

</html>