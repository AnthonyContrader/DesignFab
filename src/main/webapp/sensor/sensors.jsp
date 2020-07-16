<%@page import="it.contrader.dto.SensorDTO"%>
<%@ page import="it.contrader.dto.MachineDTO"
	import="it.contrader.dto.MaterialsDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Sensor Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Sensor Manager</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/sensor/getall">Sensor</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<SensorDTO> list = (List<SensorDTO>) request.getSession().getAttribute("listSensor");
		List<MaterialsDTO> listMaterials = (List<MaterialsDTO>) request.getSession().getAttribute("listMaterials");
		%>

		<br>
		<table>
			<tr>
				<th>Name Sensor</th>

				<th></th>
				<th></th>
			</tr>
			<%
				for (SensorDTO u : list) {
			%>
			<tr>
				<td><a href="/sensor/read?id=<%=u.getId_sensor()%>"> <%=u.getSensor_name()%>
				</a></td>
				<td><a
					href="/sensor/preupdate?id=<%=u.getId_sensor()%>&id_material=<%=u.getMaterialsDTO().getIdMaterials()%>">Edit</a></td>
				<td><a href="/sensor/delete?id=<%=u.getId_sensor()%>">Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>


		<form id="floatright" action="/sensor/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="sensor">Sensor Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="sensor" name="sensor_name"
						placeholder="inserisci nome Sensor">
				</div>
			</div>
			<div class="col-25">
				<label for="material_name">Materials Name</label>
			</div>
			<div class="col-75">

				<select name="id_material" id="material_name">
					<%
						for (MaterialsDTO material : listMaterials) {
					%>
					<option value="<%=material.getIdMaterials()%>">
						<%=material.getMaterialName()%>
					</option>
					<%
						}
					%>
				</select>
			</div>
			<button type="submit">Insert</button>
		</form>
	</div>
</body>
</html>