<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.MaterialsDTO" errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Materials Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="MaterialsServlet?mode=materialslist">Materials</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<MaterialsDTO> list = (List<MaterialsDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Material Name</th>
			<th>Quantity</th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (MaterialsDTO u : list) {
		%>
		<tr>
			<td><a href=MaterialsServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getMaterialName()%>
			</a></td>
			<td><%=u.getQuantity()%></td>
			<td><a href=MaterialsServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a>
			</td>
			<td><a href=MaterialsServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="MaterialsServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="material_name">Nome Materiale</label>
    </div>
    <div class="col-75">
      <input type="text" id="material_name" name="material_name" placeholder="inserisci il nome del materiale">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="quantity">quantity</label>
    </div>
    <div class="col-75">
      <input type="number" id="quantity" name="quantity_materials" placeholder="inserisci quantità"> 
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>