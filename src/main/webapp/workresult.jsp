<%@ page import="it.contrader.dto.MaterialsDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<%
			List<MaterialsDTO> list = (List<MaterialsDTO>) request.getSession().getAttribute("list");
		%>
	<%
				for (MaterialsDTO u : list) {
			%>
	<%=u.getMaterialsQuantity()%>
	<%=u.getIdMaterials()%>

	<%
				}
			%>
</body>
</html>