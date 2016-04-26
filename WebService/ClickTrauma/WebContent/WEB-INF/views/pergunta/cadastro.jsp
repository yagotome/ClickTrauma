<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="insere" method="post">
		<table>
			<tr>
				<td><label for="pergunta"><b>Pergunta:</b></label></td>
				<td><textarea rows="2" cols="30" name="pergunta" id="pergunta" required></textarea></td>
			</tr> 
		</table>
		<table>
			<tr>
				<td></td>
				<td></td>	
				<td>Correta</td>			
			</tr>
			<tr>
				<td><label for="resp1">Resposta 1:</label></td>
				<td><input name="resp1" id="resp1" required></td>
				<td><input name="certa1" type="checkbox"></td>		
			</tr>
			<tr>
				<td><label for="resp2">Resposta 2:</label></td>
				<td><input name="resp2" id="resp2" required></td>
				<td><input name="certa2" type="checkbox"></td>			
			</tr>
			<tr>
				<td><label for="resp3">Resposta 3:</label></td>
				<td><input name="resp3" id="resp3" required></td>
				<td><input name="certa3" type="checkbox"></td>		
			</tr>
			<tr>
				<td><label for="resp4">Resposta 4:</label></td>
				<td><input name="resp4" id="resp4" required></td>
				<td><input name="certa4" type="checkbox"></td>	
			</tr>
			<tr>
				<td><label for="resp5">Resposta 5:</label></td>
				<td><input name="resp5" id="resp5"></td>
				<td><input name="certa5" type="checkbox"></td>	
			</tr>
			<tr>
				<td><button id="insere">Insere</button></td>	
			</tr>
		</table>
	</form>
</body>
</html>