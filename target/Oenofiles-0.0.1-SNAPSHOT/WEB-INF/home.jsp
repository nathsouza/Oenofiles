<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link href="https://fonts.googleapis.com/css?family=Raleway"
	rel="stylesheet">
<title>OENOfiles</title>
</head>
<body>
	<header>
		<h1>
			Welcome,
			<c:out value="${user.firstName} ${user.lastName}!" />
		</h1>
	</header>
	<div class="container">
		<div id="navbar">
			<ul>
				<li><a class="active" href="/home">Home</a></li>
				<li><a href="/wines/new">Add a Wine Tasting</a></li>
				<li><a href="/account/${user.id}">Account</a></li>
				<li><a href="/logout">Logout</a></li>
			</ul>
		</div>
		<div id="wineTable">
			<h2>Recent Wines Tasted:</h2>
			<table>
				<thead>
					<tr>
						<th>Wine:</th>
						<th>Grape:</th>
						<th>Date Tasted:</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${wines}" var="wine">

						<c:if test="${wine.user.id == user.id }">
							<tr>
								<td><a href="/wines/${wine.id}"><c:out value="${wine.name}" /></a></td>
								<td><c:out value="${wine.grape}" /></td>
								<td><fmt:formatDate type="date" value="${wine.createdAt}" /></td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>