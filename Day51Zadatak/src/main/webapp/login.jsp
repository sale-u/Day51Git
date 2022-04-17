<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login forma</title>
    
    <!-- base mora da se doda inace se putanja ka css prosledjuje serveru u getInfoPath() !!! -->
    <base href="http://localhost:8080/Day51Zadatak/">
    
    <link rel="stylesheet" href="style1.css" type="text/css">
</head>

<body>
    <div class="flex-horiz">
        <div class="form-container">
            <form action="/Day51Zadatak/application/login" method = "post">
                <div class="flex-logo">
                    <div class="kvadrat"></div>
                    <div class="logo">LOGO</div>
                </div>
                <h4>Log in to your account</h4>
                <h5>${error_message}</h5>
                <input type="text" name="username" placeholder="Username" class="inp1">
                <input type="password" name="password" placeholder="Password" class="inp1">
                <input type="submit" value="Login" class="dugme">
            </form>
        </div>
    </div>

</body>


</html>
