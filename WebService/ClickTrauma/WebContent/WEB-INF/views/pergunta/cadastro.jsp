<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="pergunta/insere" method="post">
		<table>
			<tr>
				<td><label for="pergunta">Pergunta:</label></td>
				<td><input name="pergunta" id="pergunta"></td>			
			</tr>
			<tr>
				<td><label for="resp1">Resposta 1:</label></td>
				<td><input name="resp1" id="resp1"></td>			
			</tr>
			<tr>
				<td><label for="resp2">Resposta 2:</label></td>
				<td><input name="resp2" id="resp2"></td>			
			</tr>
			<tr>
				<td><label for="resp3">Resposta 3:</label></td>
				<td><input name="resp3" id="resp3"></td>			
			</tr>
			<tr>
				<td><label for="resp4">Resposta 4:</label></td>
				<td><input name="resp4" id="resp4"></td>			
			</tr>
			<tr>
				<td><label for="resp5">Resposta 5:</label></td>
				<td><input name="resp5" id="resp5"></td>			
			</tr>
			<tr>
				<td><button id="insere">Insere</button></td>			
			</tr>
		</table>
	</form>
</body>
</html>