<%@page import="model.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="repository.ClienteRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Lista de Clientes JSPs</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
</head>


<body>
	<div class="container">
		<h1>Lista de Clientes</h1>
		<strong>Lista de Clientes</strong>
		<table class="table" border="1px" width="80%">
			<tr>
				<th>Codigo</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>Endereço</th>
				<th>Email</th>
				<th>Alterar</th>
				<th>Deletear</th>
			</tr>
			<%
			    ClienteRepository clienteRepository = new ClienteRepository();
				List<Cliente> clientes = (List<Cliente>) clienteRepository.getAll();
				for (Cliente cliente : clientes) {
			%>
			<tr>
				<td><%=cliente.getCodigo()%></td>
				<td><%=cliente.getNome()%></td>
				<td><%=cliente.getTelefone()%></td>
				<td><%=cliente.getEndereco()%></td>
				<td><%=cliente.getEmail()%></td>
				<td><a href="cad_cliente.jsp?codigo=<%=cliente.getCodigo()%>">Alterar</a></td>
				<td><a href="DeletarCliente?codigo=<%=cliente.getCodigo()%>">Excluir</a></td>
			</tr>
			<%
				}
			%>			
			<tr>
				<td><a href="cad_cliente.jsp">Novo</td>
			</tr>
		</table>
	</div>
</body>
</html>
