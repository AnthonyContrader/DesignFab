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
   <label for="Model_macchine">Inserisci il macchinario:</label>
  <input type="text" id="Model_macchine" name="model_machine">
    <br>
  <!--  <label for="Nome_materiali">Inserisci il materiale:</label>
   <input type="text" id="Nome_materiali" name="material_name"> -->
  <button type="submit" value="work" name="button" style = background-color:Tomato;>Avvio</button>
</form>

		

<%@ include file="../css/footer.jsp" %>
</body>
</html>