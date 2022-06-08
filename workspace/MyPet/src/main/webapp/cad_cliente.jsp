<%@page import="model.Cliente"%>
<%@page import="repository.ClienteRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Cliente</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
</head>
<body>
	<form action="SalvarCliente" method="post">
		<%
		int codigo = 0; 
		String nome = "";
		String telefone = "";
		String endereco = "";
		String email = "";
		try {
			codigo = Integer.parseInt(request.getParameter("codigo"));
			Cliente cliente = null;
			ClienteRepository clienteRepository = new ClienteRepository();
			cidade = (Cidade) cidadeRepository.getById(codigo);

			if (cidade != null) {
				nome = cidade.getNome();
				uf = cidade.getUf();
			} else {
				nome = "";
				uf = "";
			}
			out.println("Modo de alteração de dados...");
		} catch (Exception e) {
			out.println("Modo de inserção de dados...");
		}
		%>
		<h3>Cadastro de Cliente</h3>
		<br />
		
		<div class="form-group">
		
		
			<label for="codigo">Codigo</label> 
			<input class="form-control" name="codigo" id="codigo" type="text" value="<%=codigo%>">
		</div>
				
		<div class="form-group">
			<label for="nome">Nome</label> <input class="form-control"
				name="nome" id="nome" type="text" value="<%=nome%>">
		</div>
		
		<div class="form-group">
			<label for="uf">CPF</label> <input class="form-control" name="cpf"
				id="cpf" type="text" value="<%=cpf%>">
		</div>
		
		<div class="form-group">
			<label for="uf">Telefone</label> <input class="form-control" name="telefone"
				id="telefone" type="text" value="<%=telefone%>">
		</div>
		
		<div class="form-group">
			<label for="uf">Endereço</label> <input class="form-control" name="endereco"
				id="endereco" type="text" value="<%=endereco%>">
		</div>
		
		<div class="form-group">
			<label for="uf">Email</label> <input class="form-control" name="email"
				id="email" type="text" value="<%=email%>">
		</div>
		<button class="btn btn-primary" type="submit" value="Salvar">Salvar</button>
	</form>
</body>
</html>