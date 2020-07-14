<%@ page import="it.contrader.dto.MachineDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Machine Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Machine manager</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/machine/getall">Machines</a> <a href="/user/logout"
			id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<MachineDTO> list = (List<MachineDTO>) request.getSession().getAttribute("list");
		%>

		<br>
		<table>
			<tr>
				<th>Name</th>
				<th>Type</th>
				<th>id materials</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (MachineDTO u : list) {
			%>
			<tr>
				<td><a href="/machine/read?id=<%=u.getId_machine()%>"> <%=u.getMachineName()%>
				</a></td>
				<td><%=u.getMaterialName()%></td>
				<td><%=u.getMaterials()%></td>
				<td><a href="/machine/preupdate?id=<%=u.getId_machine()%>">Edit</a></td>

				<td><a href="/machine/delete?id=<%=u.getId_machine()%>">Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>


		<form id="floatright" action="/machine/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="machine">Machine Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="machine" name="machine_name"
						placeholder="inserisci nome Macchina">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="material_name">material name</label>
				</div>
				<div class="col-75">
					<input type="text" id="materialName" name="material_name"
						placeholder="inserisci tipo materiale">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="id_materials">ID material </label>
				</div>
				<div class="col-75">
					<input type="text" id="materials" name="materials"
						placeholder="inserisci tipo materiale">
				</div>
			</div>


			<button type="submit">Insert</button>
		</form>
	</div>
</body>
</html>