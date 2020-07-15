<%@page import="it.contrader.dto.SensorDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.MaterialsDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read User</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/materials/getall">Materials</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			MaterialsDTO u = (MaterialsDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>Material Name</th>
				<th>Material Quantity</th>
			</tr>
			<tr>
				<td><%=u.getMaterialName()%></td>
				<td><%=u.getMaterialsQuantity()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>