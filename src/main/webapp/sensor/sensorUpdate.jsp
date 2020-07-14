<%@page import="it.contrader.dto.SensorDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.MachineDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Machine</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/machine/getall">Machines</a> <a href="/user/logout"
			id="logout">Logout</a>
	</div>
	<br>
	<div class="main">
		<%
			SensorDTO u = (SensorDTO) request.getSession().getAttribute("sensorRead");
		%>

		<form id="floatleft" action="/sensor/update" method="post">
			<div class="row">
				<div class="col-25">
					<label for="sensor">Sensor name</label>
				</div>
				<div class="col-75">
					<input type="text" id="sensor" name="sensor_name"
						value=<%=u.getSensor_name()%>>
				</div>
			</div>
			<button type="submit">Edit</button>
		</form>
	</div>
</body>
</html>