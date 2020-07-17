<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"
	import="it.contrader.dto.MaterialsDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RICICLAGGIO</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<h3>CENTRO LAVORAZIONE CARTA</h3>
	<%
		MaterialsDTO dtoWork = (MaterialsDTO) request.getSession().getAttribute("dtoWork");
		Double var = dtoWork.getMaterialsQuantity() / 10;
	%>
	<form></form>

	<p>
		al momento ci sono <strong><%=dtoWork.getMaterialsQuantity()%></strong>
		Kg di carta nel macchinario.
	</p>

	<div class="w3-container">
		<h2>Dynamic Progress Bar</h2>

		<div class="w3-light-grey">
			<div id="myBar" class="w3-green" style="height: 24px; width: 0"></div>
		</div>
		<br>

		<button class="w3-button w3-green"
			onclick="move(); setTimeout(myFunction, 3000)">AVVIO
			PRODUZIONE</button>
	</div>
	<p style="display: none" id="var_hidden">Sono stati prodotti <strong><%=(var)%></strong> cartoni</p>

	<script>
function myFunction() {
	document.getElementById("var_hidden").style.display = "block";
		}
	</script>


	<script>
		function move() {
			var elem = document.getElementById("myBar");
			var width = 1;
			var id = setInterval(frame, 10);
			function frame() {
				if (width >= 100) {
					clearInterval(id);
				} else {
					width++;
					elem.style.width = width + '%';
				}
			}
		}
		var myVar = setInterval(myTimer, 1000);
	</script>




</body>
</html>