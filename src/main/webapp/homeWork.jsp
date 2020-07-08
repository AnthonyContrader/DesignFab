<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.List" import="it.contrader.dto.MaterialsDTO" %>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Avvio Macchinario</title>
<style>

img:hover {
  animation: shake 0.5s;
  animation-iteration-count: infinite;
}

@keyframes shake {
  0%  { transform: translate(1px, 1px) rotate(0deg); }
  10% { transform: translate(-1px, -2px) rotate(-1deg); }
  20% { transform: translate(-3px, 0px) rotate(1deg); }
  30% { transform: translate(3px, 2px) rotate(0deg); }
  40% { transform: translate(1px, -1px) rotate(1deg); }
  50% { transform: translate(-1px, 2px) rotate(-1deg); }
  60% { transform: translate(-3px, 1px) rotate(0deg); }
  70% { transform: translate(3px, 1px) rotate(-1deg); }
  80% { transform: translate(-1px, -1px) rotate(1deg); }
  90% { transform: translate(1px, 2px) rotate(0deg); }
  100% { transform: translate(1px, -2px) rotate(-1deg); }
}
</style>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

<form class="work" action="WorkServlet" method="post">
  <label for="fname">TEST:</label>
  <input type="number" id="quantity" name="quantity">
  <input type="number" id="ID_macchine" name="id_machine">
   <input type="number" id="ID_materiali" name="id_materials">
  <button type="submit" value="work" name="button" style = background-color:Tomato;>Avvio</button>
</form>


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
			<td><a href=MaterialsServlet?mode=read&update=true&id=<%=u.getId()%>></a>
			</td>
			<td><a href=MaterialsServlet?mode=delete&id=<%=u.getId()%>></a>
			</td>

		</tr>
		<%
			}
		%>
	</table>
	
	
<form>
<p>TEST:</p>
	<img src="Immagini/plastic.png" alt="Plastic" width="100" height="200">
	<img src="Immagini/Paper.png" alt="Paper" width="100" height="200">
	<img src="Immagini/Glass.png" alt="Glass" width="100" height="200">
</form>
<%@ include file="../css/footer.jsp" %>
</body>
</html>