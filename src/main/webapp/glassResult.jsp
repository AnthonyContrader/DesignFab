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
	<h3>CENTRO LAVORAZIONE VETRO</h3>
	<%
		MaterialsDTO dtoWork = (MaterialsDTO) request.getSession().getAttribute("dtoWork");
		Double var = Math.random() * (dtoWork.getMaterialsQuantity() - 0.0) + 0;
		Double glass = (Double) request.getSession().getAttribute("glassquantity");
	%>
	<form></form>
	<form class="glass" action="/glass/updateGlass" method="post"
		id="glassWork" name="glassMaterial">
		<input type="number" id="quantity"
			value=<%=dtoWork.getMaterialsQuantity()%> style="display: none"
			name="material_quantity"> <input type="number"
			id="id_material" value=<%=dtoWork.getIdMaterials()%>
			style="display: none" name="id_material">

		<p>
			Al momento ci sono <strong><%=dtoWork.getMaterialsQuantity()%></strong>
			KG di
			<%=dtoWork.getMaterialName()%></p>

		<div class="w3-container">
			<h2><%=dtoWork.getMaterialName()%>
				Progress Bar
			</h2>

			<div class="w3-light-grey">
				<div id="myBar" class="w3-green" style="height: 24px; width: 0"></div>
			</div>
			<br> <input type="number" id="quantity" value=<%=var%>
				style="display: none" name="material_glass">

			<button class="w3-button w3-green" type="submit"
				onclick="move(); setTimeout(myFunction, 3000)" value="glass">AVVIO
				PRODUZIONE</button>
		</div>




	</form>
	<%
		if (glass != null) {
	%>
	<p id="var_hidden">
		Sono stati prodotti Glass <strong><%=(glass)%></strong> di bottiglie
	</p>
	<%
		}
	%>
	<script>
		function myFunction() {
			document.getElementById("glassWork").submit();
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

	<form class="work" action="/work/update" method="post">
		<input type="number" id="quantity" style="display: none"
			name="material_quantity">

	</form>




</body>
</html>