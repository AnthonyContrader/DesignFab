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
			href="/machine/getall">Machines</a> 
			<a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>
	<div class="main">
		<%
			MachineDTO u = (MachineDTO) request.getSession().getAttribute("dto");
		%>

		<form id="floatleft" action="/machine/update" method="post">
			<div class="row">
				<div class="col-25">
					<label for="machine">machine name</label>
				</div>
				<div class="col-75">
					<input type="text" id="machine" name="machine_name"
						value=<%=u.getMachineName()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="material">material name</label>
				</div>
				<div class="col-75">
					<input type="text" id="material" name="material_name"
						value=<%=u.getMaterialName()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="materialsName">material ID</label>
				</div>
				<div class="col-75">
					<input type="text" id="materialsName" name="materials"
						value=<%=u.getMaterials()%>>
				</div>
			</div>
			<button type="submit">Edit</button>
		</form>
	</div>
</body>
</html>