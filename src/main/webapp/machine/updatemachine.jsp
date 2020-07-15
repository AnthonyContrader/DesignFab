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
	<%@ include file="/css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/machine/getall">Machines</a> <a href="/user/logout"
			id="logout">Logout</a>
	</div>
	<br>
	<div class="main">
		<%
			MachineDTO u = (MachineDTO) request.getSession().getAttribute("dto");
			Long idsensor = (Long) request.getSession().getAttribute("id_sensor");
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
				<input type="hidden" name="id" value=<%=u.getId_machine()%>>
				<input  name="id_sensor" style="display:none;" value=<%=idsensor%>>
			</div>
			<button type="submit">Edit</button>
		</form>
	</div>
</body>
</html>