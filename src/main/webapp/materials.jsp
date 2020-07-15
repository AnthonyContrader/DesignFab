<%@ page import="it.contrader.dto.MaterialsDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Materials Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/materials/getall">Materials</a> <a href="/materials/logout"
			id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<MaterialsDTO> list = (List<MaterialsDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Material Name</th>
				<th>Material Quantity</th>
				<th>ID macchina</th>
				<th></th>
			</tr>
			<%
				for (MaterialsDTO u : list) {
			%>
			<tr>
				<td><a href="/materials/read?id=<%=u.getIdMaterials()%>"> <%=u.getMaterialName()%>
				</a></td>
				<td><%=u.getMaterialName()%></td>
				<td><%=u.getMaterialsQuantity()%></td>
				<td><%=u.getMachinesOnMaterial()%></td>
				<td><a href="/materials/preupdate?id=<%=u.getIdMaterials()%>">Edit</a></td>
				<td><a href="/materials/delete?id=<%=u.getIdMaterials()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/materials/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="materials">Material Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="materials" name="material_name"
						placeholder="inserisci materiale">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="materials_q">Quantity Name</label>
				</div>
				<div class="col-75">
					<input type="number" id="materials_q" name="material_quantity"
						placeholder="inserisci quantità">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="machines">ID macchina</label>
				</div>
				<div class="col-75">
					<input type="number" id="machines" name="machines"
						placeholder="inserisci macchina da associare">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>
	</div>
	<br>
	<%@ include file="css/footer.jsp"%>
</body>
</html>