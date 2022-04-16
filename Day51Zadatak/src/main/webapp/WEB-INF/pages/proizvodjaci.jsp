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
		
		th, td {
			padding: 7px 10px;
		}
		
		th {
			background-color: rgba(128, 128, 128, 0.4);
		}
		
		td {
			background-color:  rgba(65, 51, 187, 0.5);
		}
		
		.edit, .obrisi {
			text-decoration: none;
			color: white;
			background-color:  rgba(65, 51, 187, 0.9);
			border: solid blue 1px;
			border-radius: 5px;
			padding: 5px 15px;
			margin: auto;
		}
		
		.obrisi {
			background-color:  rgba(120, 51, 255, 0.7);
		}
		
		h3 {
			margin: 0 3rem; 
			text-decoration: underline;
		}
	
	</style>
</head>


<html>
<body>

	<header>
		<jsp:include page="/WEB-INF/fragment/login-user.jsp" flush="true"></jsp:include>
		<jsp:include page="/WEB-INF/fragment/navigation.jsp" flush="true"></jsp:include>
	</header>

	<main>
		<br><br>
		<h3>Svi proizvodjaci registrovani u sistemu:</h3>

			<div>
				<table>
					<thead>
						<tr>
							<th>Pib</th>
							<th>MatBr</th>
							<th>Adresa</th>
							<th>PttBroj</th>
							<th>Mesto</th>
							<th> </th>
							<th> </th>
						</tr>
					</thead>
					
					<tbody>
					<c:forEach var="p" items="${proizvodjaci}">
						<tr>
							<td>${p.pib}</td>
							<td>${p.matBr}</td>
							<td>${p.adresa}</td>
							<td>${p.city.zipCode}</td>
							<td>${p.city.name}</td>
							<td>
								<a class="edit" href="/Day51Zadatak/application/proizvView?pib=${p.pib}">Edituj</a>
							</td>
							<td>
								<a class="obrisi" href="/Day51Zadatak/application/proizvDelete?pib=${p.pib}">Obrisi</a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>

	</main>
	
	
	<jsp:include page="/WEB-INF/fragment/footer.jsp" flush="true"></jsp:include>

</body>
</html>
