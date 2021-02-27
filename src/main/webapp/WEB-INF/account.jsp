<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link href="https://fonts.googleapis.com/css?family=Raleway"rel="stylesheet">
<title>OENOfiles</title>
</head>
<body>
	<header>
		<h1>Account Details</h1>
	</header>
	<form:form method="post" action="/account/${user.id}" modelAttribute="user" id="regForm">
		<p><form:label path="firstName">First Name:</form:label>
			<form:input type="text" path="firstName" />
		</p>
		<p><form:label path="lastName">Last Name:</form:label>
			<form:input type="lastName" path="lastName" />
		</p>
		<p><form:label path="email">Email:</form:label>
			<form:input type="email" path="email" />
		</p>
		<p><form:label path="password">Password:</form:label>
			<form:password path="password" placeholder="Enter New Password"/>
		</p>
		<p><form:label path="passwordConfirmation">Password Confirmation:</form:label>
			<form:password path="passwordConfirmation" placeholder ="Please re-enter new password" />
		</p>
		<p><form:errors path="user.*" /></p>
		<p><c:out value="${error}"/></p>		
		<button type="submit">Update Account Details</button>
		<a href="/home">Cancel</a>		
		
	</form:form>
</body>
</html>