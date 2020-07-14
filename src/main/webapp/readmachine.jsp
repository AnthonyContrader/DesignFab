<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.MachineDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Machine</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/machine/getall">Machines</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>
	<div class="main">
		<%
			MachineDTO u = (MachineDTO) request.getSession().getAttribute("dto");
		%>

		<table>
			<tr>
				<th>Machine ID</th>
				<th>Name</th>
				<th>Type</th>
				<th>Materials ID</th>
			</tr>
			<tr>
				<td><%=u.getId_machine()%></td>
				<td><%=u.getMachineName()%></td>
				<td><%=u.getMaterialName()%></td>
				<td><%=u.getMaterials()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>

	</div>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>