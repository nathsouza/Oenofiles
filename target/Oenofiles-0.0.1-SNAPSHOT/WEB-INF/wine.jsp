<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

    
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
		<h1>
			Welcome,
			<c:out value="${user.firstName} ${user.lastName}!" />
		</h1>
	</header>
	<div class="container">
		<%-- <div id="navbar">
			<ul>
				<li><a class="active" href="/home">Home</a></li>
				<li><a href="/wines/new">Add a Wine Tasting</a></li>
				<li><a href="/account/${user.id}">Account</a></li>
				<li><a href="/logout">Logout</a></li>
			</ul>
		</div> --%>
		<div id="wineDetails">
		
		<h1>${wine.name}</h1>
		<p style="text-align:center;"><img src="${wine.photo}" alt="${wine.name}" width="500" height="400"></p>
		<p>Did you like it?!: ${wine.enjoy}</p>
		<p>Grape Variety: ${wine.grape}</p>
		<p>Wine Region: ${wine.region}</p>

		<h3>Sight Details</h3>		
			<p>Clarity: ${wine.clarity}</p>
			<p>Brightness: ${wine.brightness}</p>
			<p>Color: ${wine.color}</p>
			<p>Tears: ${wine.tears}</p>
			<p>Notes: ${wine.sightDescription}</p>
			
		<h3>Nose Details</h3>		
			<p>Intensity: ${wine.intensity}</p>
			<p>Fruit: ${wine.noseFruit}</p>
			<p>Notes: ${wine.noseDescription}</p>
			
		<h3>Palate Details</h3>		
			<p>Sweetness: ${wine.sweetness}</p>
			<p>Tannin: ${wine.tannin}</p>
			<p>Acid: ${wine.acid}</p>
			<p>Alcohol: ${wine.alcohol}</p>
			<p>Body: ${wine.body}</p>
			<p>Fruit: ${wine.palateFruit}</p>
			<p>Finish: ${wine.finish}</p>
			<p>Notes: ${wine.palateDescription}</p>
		
		<h3>Misc. Details</h3>
			<p>Price: ${wine.price}</p>
			<p>Finish: ${wine.abv}</p>
			<p>Date Tasted: <fmt:formatDate type="date" value="${wine.createdAt}" /></p>
			<a href="/home">Go Home</a>
			
		</div>
	</div>

</body>
</html>