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

	<form id="floatright" action="/work/test" method="post">
		<div>
			<select id="type" name="material_type">
				<option value="PAPER">PAPER</option>
				<option value="PLASTIC">PLASTIC</option>
				<option value="GLASS">GLASS</option>
				<option value="INDIFFERENZIATA">INDIFFERENZIATA</option>
			</select>
			<button type="submit" style="background-color: Tomato;">AVVIO</button>
		</div>		
	</form>
</body>
</html>