<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.MaterialsDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Material</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="MaterialsServlet?mode=materialslist">Materials</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%MaterialsDTO u = (MaterialsDTO) request.getAttribute("dto");%>


<form id="floatleft" action="MaterialsServlet?mode=update&id=<%=u.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="material_name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="material_name" name="material_name" value=<%=u.getMaterialName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="quantity">Quantity</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="quantity" name="quantity_materials" value=<%=u.getQuantity()%>> 
    </div>
  </div>

      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>