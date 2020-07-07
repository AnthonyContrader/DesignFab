<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.MachinesDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read User</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="MachineServlet?mode=machinelist">Users</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%MachinesDTO u = (MachinesDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Model</th>
		<th>Initial Quantity</th>
		<th>Final Quantity</th>
	</tr>
	<tr>
		<td><%=u.getModel()%></td>
		<td> <%=u.getInit_quantity()%></td>
		<td> <%=u.getFinal_quantity()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>