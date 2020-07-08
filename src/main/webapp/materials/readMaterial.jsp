<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.MaterialsDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Materials</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="MaterialsServlet?mode=materialslist">Materials</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%MaterialsDTO u = (MaterialsDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Name</th>
		<th>Quantity</th>
		<th></th>
	</tr>
	<tr>
		<td><%=u.getMaterialName()%></td>
		<td> <%=u.getQuantity()%></td>
		<td></td>
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