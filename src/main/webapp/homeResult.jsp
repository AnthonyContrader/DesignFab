<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.MaterialsDTO" import="it.contrader.dto.MachinesDTO" import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Risultato</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
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
<%@include file="css/header.jsp"%>


<%-- <% MaterialsDTO material = (MaterialsDTO) request.getAttribute("dtoMaterials"); %> --%>
<% MachinesDTO machines = (MachinesDTO) request.getAttribute("dtoMachine"); %> 
<% List<MaterialsDTO> list = (List<MaterialsDTO>) request.getAttribute("list"); %>

<label>La quantità finale di materiale lavorato è: <%=machines.getFinal_quantity() %> Ripartiti in: </label>

	<form>
	<%for(MaterialsDTO m : list) { %>	
	<%= m.getMaterialName() %>
	<%= m.getQuantity() %>	
	<br>
	<% }%>
</form>


	

<img src="Immagini/plastic.png" alt="Plastic" width="100" height="200"> 
<%@ include file="../css/footer.jsp" %>
</body>
</html>