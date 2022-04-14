<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>

	<header>
		<jsp:include page="/WEB-INF/fragment/login-user.jsp" flush="true"></jsp:include>
		<jsp:include page="/WEB-INF/fragment/navigation.jsp" flush="true"></jsp:include>
	</header>

	<main>
		<h2>Svi proizvodjaci registrovani u sistemu</h2>
		<article>
			<div>
				<table>
					<thead>
						<tr>
							<th>Pib</th>
							<th>MatBr</th>
							<th>Adresa</th>
							<th>Mesto</th>
						</tr>
					</thead>
					
					<tbody>
					<c:forEach var="p" items="${proizvodjaci}">
						<tr>
							<td>${p.pib}</td>
							<td>${p.maticniBroj}</td>
							<td>${p.adresa}</td>
							<td>${p.mesto}</td>
							<td>
								<a href="/Day51Zadatak/application/proizvView?pib=${p.pib}">Pogledaj</a>
								<br>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</article>
	</main>
	
	
	<footer><br><br> Copyright 2022 </footer>

</body>
</html>
