<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*" import="java.lang.Long"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.MaterialsDTO"
	import="it.contrader.dto.MachineDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no ">
<meta name="description" content="User Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Home User</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="/css/vittoriostyle.css" rel="stylesheet">
</head>
<body>
	<%@include file="css/header.jsp"%>
	

			
		<form class="work" action="/work/update" method="post">
			<label for="quantity">Inserisci rifiuti nella macchina:</label> <input
				type="number" id="quantity" name="material_quantity">
				
				
			
				
			<button type="submit" value="work" name="button"
				style="background-color: Tomato;">Avvio</button>
		</form>


	<%@ include file="css/footer.jsp"%>
</body>
</html>