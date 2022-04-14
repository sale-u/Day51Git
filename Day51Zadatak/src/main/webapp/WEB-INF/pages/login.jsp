<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<h2>Prijavite se na nasu aplikaciju</h2>
	
	<div>
		<form action="/Day51Zadatak/application/login" method="post">
			<div>
				${error_message}
			</div>
			
			username:
			<div>
				<input type="text" name="username" value="/">
			</div>
			
			password:
			<div>
				<input type="password" name="password" value="/">
			</div>
			
			
			<div>
				<input type="submit" name="login" value="Prijavi se">
			</div>
		</form>
	</div>
	
</body>
</html>
