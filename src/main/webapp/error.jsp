<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>
<%String error = (String) request.getAttribute("ERRORE"); %>
</head>
<body>

<h3><%= error %></h3>

Please go to <a href="/JspApp/index.jsp">home page</a>

</body>
</html>