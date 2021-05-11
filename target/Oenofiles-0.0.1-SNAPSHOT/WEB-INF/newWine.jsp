<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<title>OENOfiles</title>
<body>

<form:form id="regForm" action="/wines/new" method="post" modelAttribute="wine">
  <h1>New Wine Tasting</h1>
  <!-- One "tab" for each step in the form: -->
  <div class="tab"><h3>Wine Details:</h3>
    <p><input placeholder="Wine Name..." oninput="this.className = ''" name="name"></p>
    <p><input placeholder="Wine Region..." oninput="this.className = ''" name="region"></p>
    <p><input placeholder="Grape Variety..." oninput="this.className = ''" name="grape"></p>
    <p><input placeholder="Alcohol Percentage..." oninput="this.className = ''" name="abv" type = "number"></p>
    <p><input placeholder="Price" oninput="this.className = ''" name="price" type = "number"></p>    
  </div>
  <div class="tab"><h3>Sight:</h3>
    <p>Clarity:<input placeholder="Dull or Cloudy..." oninput="this.className = ''" name="clarity"></p>
    <p>Brightness:<input placeholder="Dull or Opaque..." oninput="this.className = ''" name="brightness"></p>
    <p>Concentration:<input placeholder="Pale, Medium, Deep..." oninput="this.className = ''" name="concentration"></p>
    <p>Color:<input placeholder="Whites: Straw, Yellow, Gold ....         Reds: Purple, Ruby, Garnet..." oninput="this.className = ''" name="color"></p>
    <p>Tears:<input placeholder="Low, Medium, High...." oninput="this.className = ''" name="tears"></p>
    <p>Sight Notes:<input placeholder="any additional notes...." oninput="this.className = ''" name="sightDescription"></p>
  </div>
  <div class="tab"><h3>Nose:</h3>
    <p>Fruit Characteristics:<input placeholder="Whites: Apple, Citric, Stone Fruit, Tropical...     Reds: Red, Black, Blue, Berry...." oninput="this.className = ''" name="noseFruit"></p>
    <p>Intensity<input placeholder="Delicate, Moderate, or Powerful...." oninput="this.className = ''" name="intensity"></p>
    <p>Nose Notes:<input placeholder="any additional notes...." oninput="this.className = ''" name="noseDescription"></p>
  </div>
  <div class="tab"><h3>Palate:</h3>
    <p>Sweetness:<input placeholder="Bone-Dry, Dry, Off-Dry, Sweet, Very Sweet..." oninput="this.className = ''" name="sweetness"></p>
    <p>Tannin:<input placeholder="Low, Medium, or High..." oninput="this.className = ''" name="tannin"></p>
    <p>Acidity:<input placeholder="Low, Medium, or High..." oninput="this.className = ''" name="acid"></p>
    <p>Alcohol:<input placeholder="Low, Medium, or High..." oninput="this.className = ''" name="alcohol"></p>
    <p>Body/Texture:<input placeholder="Light, Medium, or Full..." oninput="this.className = ''" name="body"></p>    
    <p>Fruit Flavors:<input placeholder="Whites: Apple, Citric, Stone Fruit, Tropical...     Reds: Red, Black, Blue, Berry...." oninput="this.className = ''" name="palateFruit"></p>    
    <p>Finish<input placeholder="Short, Medium, or Long..." oninput="this.className = ''" name="body"></p>    
  </div>
    <div class="tab"><h3>MOST IMPORTANTLY!! Did you enjoy it?</h3>
    <p>Yes<input oninput="this.className = ''" name="enjoy" type="radio" value="true"></p>
    <p>No<input oninput="this.className = ''" name="enjoy" type="radio" value="False"></p>
    <p>Or add a photo url link<input type = "text" name = "photo"></p>       
  </div>
  <div style="overflow:auto;">
    <div style="float:right;">
      <button type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
      <button type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
    </div>
  </div>
  <!-- Circles which indicates the steps of the form: -->
  <div style="text-align:center;margin-top:40px;">
    <span class="step"></span>
    <span class="step"></span>
    <span class="step"></span>
    <span class="step"></span>
    <span class="step"></span>    
  </div>
</form:form> 
<footer>
<a class="active" href="/home">Home</a></footer>
 <script type="text/javascript" src="/js/app.js"></script> 
</body>
</html>