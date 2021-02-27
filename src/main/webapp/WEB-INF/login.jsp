<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<title>OENOfiles</title>
</head>
<body>
	<header>
		<h1>OENOfiles</h1>
	</header>
	<form method="post" id="loginForm" action="/login">
	  <h1>Login</h1>
		<input type="text" name="email" placeholder="Enter Email" />
		<input type="password" name="password" placeholder="Enter Password"/> 
		<p><c:out value="${error}" /></p>
		<a href="/register" class="badge badge-dark">New Oeno's click here!</a>		
		 <div style="overflow:auto;">
    	 <div style="float:right;">
			<button type="submit">Login</button>
		</div></div>		
	</form>
</body>

</html>