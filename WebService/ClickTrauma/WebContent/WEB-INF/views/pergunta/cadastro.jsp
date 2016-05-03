<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cadastro de perguntas</title>
	<c:if test="${not empty param.inserido}">
		<script type="text/javascript">
			alert("Pergunta cadastrada com sucesso.");		
		</script>
	</c:if>
</head>
<body>
	<a href="lista">Lista</a>
	<br /> <br />
	<form action="insere" method="post">
		<table>
			<tr>
				<td><label for="pergunta"><b>Pergunta:</b></label></td>
				<td><textarea rows="2" cols="30" name="texto" id="pergunta" required></textarea></td>
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
				<td><input name="respostas[0].texto" id="resp1" required></td>
				<td><input name="respostas[0].correta" type="checkbox"></td>		
			</tr>
			<tr>
				<td><label for="resp2">Resposta 2:</label></td>
				<td><input name="respostas[1].texto" id="resp2" required></td>
				<td><input name="respostas[1].correta" type="checkbox"></td>			
			</tr>
			<tr>
				<td><label for="resp3">Resposta 3:</label></td>
				<td><input name="respostas[2].texto" id="resp3" required></td>
				<td><input name="respostas[2].correta" type="checkbox"></td>		
			</tr>
			<tr>
				<td><label for="resp4">Resposta 4:</label></td>
				<td><input name="respostas[3].texto" id="resp4" required></td>
				<td><input name="respostas[3].correta" type="checkbox"></td>	
			</tr>
			<tr>
				<td><label for="resp5">Resposta 5:</label></td>
				<td><input name="respostas[4].texto" id="resp5"></td>
				<td><input name="respostas[4].correta" type="checkbox"></td>	
			</tr>
			<tr>
				<td><button id="insere">Insere</button></td>	
			</tr>
		</table>
	</form>
</body>
</html>