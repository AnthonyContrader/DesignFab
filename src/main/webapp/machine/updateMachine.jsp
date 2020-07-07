<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.MachinesDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit User</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="MachineServlet?mode=machinelist">Users</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%MachinesDTO u = (MachinesDTO) request.getAttribute("dto");%>


<form id="floatleft" action="UserServlet?mode=update&id=<%=u.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="machine">Model</label>
    </div>
    <div class="col-75">
      <input type="text" id="machine" name="Model" value=<%=u.getModel()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="initial_quantity">Initial Quantity</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="initial_quantity" name="Initial Quantity" value=<%=u.getInit_quantity()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="initial_quantity">Initial Quantity</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="initial_quantity" name="Initial Quantity" value=<%=u.getInit_quantity()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Final Quantity</label>
    </div>
   	<div class="col-75">
      <input
			type="text" id="final_quantity" name="Final Quantity" value=<%=u.getFinal_quantity()%>> 
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>