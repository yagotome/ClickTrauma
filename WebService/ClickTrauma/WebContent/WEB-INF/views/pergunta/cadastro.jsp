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
	<a href="lista?lang=pt">Lista em português</a>
	<a href="lista?lang=en">Lista em inglês</a>
	<br /> <br />
	<form action="insere" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td><label for="pergunta"><b>Pergunta:</b></label></td>
				<td><textarea rows="2" cols="30" name="textoPerguntaPt" id="pergunta" required></textarea></td>								
				<td><label for="img-pergunta">Imagem:</label></td>
				<td><input type="file" id="img-pergunta" name="img"></td>			
			</tr>
			<tr>				
				<td><label for="question"><b>Question:</b></label></td>
				<td><textarea rows="2" cols="30" name="textoPerguntaEn" id="question" required></textarea></td>
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
				<td><input name="textosRespostasPt[]" id="resp1" required></td>
				<td><input name="respostas[0].correta" type="checkbox"></td>				
				<td><label for="img-resp-0">Imagem:</label></td>
				<td><input type="file" id="img-resp-0" name="respostas[0].img"></td>		
			</tr>
			<tr>
				<td><label for="ans1">Answer 1:</label></td>
				<td><input name="textosRespostasEn[]" id="ans1" required></td>
			</tr>
			<tr>
				<td><label for="resp2">Resposta 2:</label></td>
				<td><input name="textosRespostasPt[]" id="resp2" required></td>
				<td><input name="respostas[1].correta" type="checkbox"></td>				
				<td><label for="img-resp-1">Imagem:</label></td>
				<td><input type="file" id="img-resp-1" name="respostas[1].img"></td>			
			</tr>
			<tr>				
				<td><label for="ans2">Answer 2:</label></td>
				<td><input name="textosRespostasEn[]" id="ans2" required></td>
			</tr>
			<tr>
				<td><label for="resp3">Resposta 3:</label></td>
				<td><input name="textosRespostasPt[]" id="resp3" required></td>
				<td><input name="respostas[2].correta" type="checkbox"></td>		
				<td><label for="img-resp-2">Imagem:</label></td>
				<td><input type="file" id="img-resp-2" name="respostas[2].img"></td>	
			</tr>
			<tr>				
				<td><label for="ans3">Answer 3:</label></td>
				<td><input name="textosRespostasEn[]" id="ans3" required></td>
			</tr>
			<tr>
				<td><label for="resp4">Resposta 4:</label></td>
				<td><input name="textosRespostasPt[]" id="resp4" required></td>
				<td><input name="respostas[3].correta" type="checkbox"></td>	
				<td><label for="img-resp-3">Imagem:</label></td>
				<td><input type="file" id="img-resp-3" name="respostas[3].img"></td>
			</tr>
			<tr>			
				<td><label for="ans4">Answer 4:</label></td>
				<td><input name="textosRespostasEn[]" id="ans4" required></td>
			</tr>
			<tr>
				<td><label for="resp5">Resposta 5:</label></td>
				<td><input name="textosRespostasPt[]" id="resp5"></td>
				<td><input name="respostas[4].correta" type="checkbox"></td>	
				<td><label for="img-resp-4">Imagem:</label></td>
				<td><input type="file" id="img-resp-4" name="respostas[4].img"></td>	
			</tr>
			<tr>				
				<td><label for="ans5">Answer 5:</label></td>
				<td><input name="textosRespostasEn[]" id="ans5"></td>
			</tr>
			<tr>
				<td><button id="insere">Insere</button></td>	
			</tr>
		</table>
	</form>
</body>
</html>