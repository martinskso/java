<%@page import="model.Cliente"%>
<%@page import="repository.ClienteRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyPet</title>
</head>
<body>

	<%
	try {
		Cliente cliente = new Cliente(2, "Marcia", "9999-9595", "Rua B, 22", "marcia@gmail.com");
		ClienteRepository clienteRepository = new ClienteRepository();
		clienteRepository.inserir(cliente);
		out.println("Cliente inserido com sucesso...");
	} catch (Exception e) {
		out.println("Erro ao inserir: " + e.getMessage());
	}
	%>

</body>
</html>