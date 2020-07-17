<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="it.contrader.dto.MaterialsDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3> CENTRO LAVORAZIONE CARTA </h3>
		<%
			MaterialsDTO dtoWork = (MaterialsDTO) request.getSession().getAttribute("dtoWork");
		%>
	<form></form>	
<%=dtoWork.getMaterialName() %>
<%=dtoWork.getMaterialsQuantity()%>
</body>
</html>