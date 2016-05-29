<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lista de perguntas</title>
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.js"></script>
	<script type="text/javascript">
		function exclui(id, desc) {
			var ok = confirm('Deseja realmente excluir a pergunta "' + desc + '"?');
			if (ok){
				$.post("remove", {'id' : id}, function() {
					$("#pergunta_"+id).hide();
				});
			}
		}
	</script>
	<style type="text/css">		
		table {
		    border-collapse: collapse;
		    width: 100%;
		}
		
		th, td {
		    text-align: left;
		    padding: 8px;
		}
		
		tr:nth-child(even) {
			background-color: #f2f2f2
		}
		
		th {
		    background-color: #4CAF50;
		    color: white;
		}
		#novaPergunta {
		    background-color: #4CAF50;
		    border: 3px solid #410E45;
		    border-radius: 8px;
		    padding: 4px;
		}
		
		#novaPergunta:hover {	
		    background-color: #410E45;
		}
		
		#novaPergunta:link, #novaPergunta:visited, #novaPergunta:hover, #novaPergunta:active {
			color: white;
			text-decoration:none; 
		}
	</style>
</head>
<body>
	<a id="novaPergunta" href="cadastro">Cadastro</a>
	<br /> <br />
	<table>
		<tr>
			<th>Id</th>
			<th>Pergunta</th>
			<th>Resp1</th>
			<th>Resp2</th>
			<th>Resp3</th>
			<th>Resp4</th>
			<th>Resp5</th>
			<th>Correta</th>
			<th>Excluir</th>
		</tr>
		<c:forEach items="${perguntas}" var="pergunta">
			<tr id="pergunta_${pergunta.id}">
				<td>${pergunta.id}</td>
				<td>${pergunta.texto}</td>
				<td>${pergunta.respostas[0].texto}</td>			
				<td>${pergunta.respostas[1].texto}</td>
				<td>${pergunta.respostas[2].texto}</td>
				<td>${pergunta.respostas[3].texto}</td>
				<td>${empty pergunta.respostas[4] ? "" : pergunta.respostas[4].texto}</td>
				<td>
					<c:forEach items="${pergunta.respostas}" var="resp">
						<c:if test="${resp.correta}">
							${resp.texto}
						</c:if>
					</c:forEach>
				</td>
				<td><button onclick="exclui('${pergunta.id}', '${pergunta.texto}')">X</button></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>