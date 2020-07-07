<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.MachinesDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>User Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="MachineServlet?mode=machinelist">Machines</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<MachinesDTO> list = (List<MachinesDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Model</th>
			<th>Initial Quantity</th>
			<th>Final Quantity</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (MachinesDTO u : list) {
		%>
		<tr>
			<td><a href=MachineServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getModel()%>
			</a></td>
			<td><%=u.getInit_quantity()%></td>
			<td><%=u.getFinal_quantity()%></td>
			<td><a href=MachineServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a>
			</td>
			<td><a href=MachineServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="MachineServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="model">Model</label>
    </div>
    <div class="col-75">
      <input type="text" id="model" name="Model" placeholder="inserisci modello">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="init_quantity">Quantità iniziale</label>
    </div>
    <div class="col-75">
      <input type="text" id="init_quantity" name="Quantità iniziale" placeholder="inserisci quantità iniziale"> 
    </div>
    </div>
    <div class="row">
    <div class="col-25">
     <label for="final_quantity">Quantità finale</label>
    </div>
    <div class="col-75">
      <input type="text" id="final_quantity" name="Quantità finale" placeholder="inserisci quantità finale"> 
    </div>
  </div>
  <div class="row">		
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>