<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.MachinesDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Machines</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="MachineServlet?mode=machinelist">Machines</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%MachinesDTO u = (MachinesDTO) request.getAttribute("dto");%>


<form id="floatleft" action="MachineServlet?mode=update&id=<%=u.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="model">Model</label>
    </div>
    <div class="col-75">
      <input type="text" id="model" name="model" value=<%=u.getModel()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="initial_quantity">Initial Quantity</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="initial_quantity" name="init_quantity" value=<%=u.getInit_quantity()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="final_quantity">Final Quantity</label>
    </div>
   	<div class="col-75">
      <input
			type="text" id="final_quantity" name="final_quantity" value=<%=u.getFinal_quantity()%>> 
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>