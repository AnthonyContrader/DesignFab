<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.MaterialsDTO"%>
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
	<%@ include file="/css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/materials/getall">Materials</a> <a href="/user/logout"
			id="logout">Logout</a>
	</div>
	<br>
	<div class="main">
		<%
			MaterialsDTO u = (MaterialsDTO) request.getSession().getAttribute("dto");
		%>

		<form id="floatleft" action="/materials/update" method="post">
			<div class="row">
				<div class="col-25">
					<label for="materials">materials name</label>
					<div class="col-75">
						<input type="text" id="materials" name="materials_name"
							value=<%=u.getMaterialName()%>>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="quant">materials qunatity</label>
					</div>
					<div class="col-75">
						<input type="text" id="quant" name="Material_quantity"
							value=<%=u.getMaterialsQuantity()%>>
					</div>
					<input type="hidden" name="id" value=<%=u.getIdMaterials()%>>
				</div>
				<button type="submit">Edit</button>
		</form>
	</div>
</body>
</html>