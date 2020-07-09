<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.List" import="it.contrader.dto.MaterialsDTO" %>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Avvio Macchinario</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
<style>


</style>
</head>
<body>
<%@include file="css/header.jsp"%>

<div class="navbar">
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

<form class="work" action="WorkServlet" method="post">
  <label for="quantity">Inserisci rifiuti nella macchina:</label>
  <input type="number" id="quantity" name="quantity">
  <br>
   <label for="ID_macchine">Inserisci ID macchina:</label>
  <input type="number" id="ID_macchine" name="id_machine">
    <br>
   <label for="ID_materiali">Inserisci ID materiale:</label>
   <input type="number" id="ID_materiali" name="id_materials">
  <button type="submit" value="work" name="button" style = background-color:Tomato;>Avvio</button>
</form>

		

<%@ include file="../css/footer.jsp" %>
</body>
</html>