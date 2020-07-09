<%@page import="it.contrader.dto.SensorDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.SensorDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Sensor Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="SensorServlet?mode=sensorlist">Sensor</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<SensorDTO> list = (List<SensorDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Sensor Type</th>
			<th>modello_machine</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (SensorDTO u : list) {
		%>
		<tr>
			<td><a href=SensorServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getSensortype()%>
			</a></td>

			<td><%=u.getModello_macchina()%></td>
			
			<td><a href=SensorServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a>

			</td>
			<td><a href=SensorServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="SensorServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="sensor_type">Sensor Type</label>
      <label for="id_machine">ID Machine</label>
    </div>
    <div class="col-75">
      <input type="text" id="sensor_type" name="sensor_type" placeholder="inserisci il tipo di Sensore">
    </div>

    </div>
    <div class="col-25">
      <label for="id:machine">id_machine</label>
    </div>
    <div class="col-75">
      <input type="text" id="id_machine" name="id_machine" placeholder="inserisci l'id macchina">
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