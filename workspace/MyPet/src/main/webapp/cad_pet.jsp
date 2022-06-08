<%@page import="model.Cidade"%>
<%@page import="repository.CidadeRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Pet</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
</head>
<body>
	<form action="SalvarCidade" method="post">
		<%
		int codigo = 0; 
		String nome = "";
		String uf = "";
		try {
			codigo = Integer.parseInt(request.getParameter("codigo"));
			Cidade cidade = null;
			CidadeRepository cidadeRepository = new CidadeRepository();
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
		<h3>Cadastro do Pet</h3>
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
			<label for="uf">Animal</label> <input class="form-control" name="uf"
				id="uf" type="text" value="<%=uf%>">
		</div>
		
		<div class="form-group">
			<label for="uf">Idade</label> <input class="form-control" name="uf"
				id="uf" type="text" value="<%=uf%>">
		</div>
		
		<div class="form-group">
			<label for="uf">Sexo</label> <input class="form-control" name="uf"
				id="uf" type="text" value="<%=uf%>">
		</div>
		
		<button class="btn btn-primary" type="submit" value="Salvar">Salvar</button>
	</form>
</body>
</html>