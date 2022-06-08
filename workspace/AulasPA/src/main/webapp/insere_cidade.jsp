<%@page import="model.Cidade"%>
<%@page import="repository.CidadeRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	try {
		Cidade cidade = new Cidade(3, "sao paulo", "SP");
		CidadeRepository cidadeRepository = new CidadeRepository();
		cidadeRepository.inserir(cidade);
		out.println("Cidade inserida com sucesso...");
	} catch (Exception e) {
		out.println("Erro ao inserir: " + e.getMessage());
	}
	%>

</body>
</html>