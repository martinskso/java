
<%@page import="model.Cidade"%>
<%@page import="java.util.List"%>
<%@page import="repository.CidadeRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Lista de Cidade JSPs</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
</head>


<body>
	<div class="container">
		<h1>Lista de Cidades</h1>
		<strong>Lista de Cidades</strong>
		<table class="table" border="1px" width="80%">
			<tr>
				<th>Codigo</th>
				<th>Nome</th>
				<th>UF</th>
				<th>Alterar</th>
				<th>Deletear</th>
			</tr>
			<%
			    CidadeRepository cidadeRepository = new CidadeRepository();
				List<Cidade> cidades = (List<Cidade>) cidadeRepository.getAll();
				for (Cidade cidade : cidades) {
			%>
			<tr>
				<td><%=cidade.getCodigo()%></td>
				<td><%=cidade.getNome()%></td>
				<td><%=cidade.getUf()%></td>
				<td><a href="cad_cidade.jsp?codigo=<%=cidade.getCodigo()%>">Alterar</a></td>
				<td><a href="DeletarCidade?codigo=<%=cidade.getCodigo()%>">Excluir</a></td>
			</tr>
			<%
				}
			%>			
			<tr>
				<td><a href="cad_cidade.jsp">Novo</td>
			</tr>
		</table>
	</div>
</body>
</html>
