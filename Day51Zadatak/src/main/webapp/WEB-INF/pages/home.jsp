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
	
	main {
		width: 55vw;
		height: 30vh;
		color: beige;
		text-align: center;
		margin: 20vh auto;
	}
	
	h1 {
		width: 50vw;
		font-style: italic;
		padding: 0.5rem 2rem;
		background-color:  rgba(65, 51, 255, 0.3);
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
		<div class="h1">
			<h1>Dobro dosli, uspesno ste se prijavili na aplikaciju</h1>
		</div>
	</main>
	
	<jsp:include page="/WEB-INF/fragment/footer.jsp" flush="true"></jsp:include>

</body>
</html>
