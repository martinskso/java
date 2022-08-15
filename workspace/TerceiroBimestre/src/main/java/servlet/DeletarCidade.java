package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cidade;
import repository.CidadeRepository;

@WebServlet("/DeletarCidade")

public class DeletarCidade extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		PrintWriter imprimir = response.getWriter();
		System.out.println("iniciando servlet...");
		imprimir.println("iniciando servlet...");
		imprimir.println("</br>");		
		System.out.println("Codigo: " +request.getParameter("codigo") );
		imprimir.println("Codigo: " +request.getParameter("codigo"));			
		Cidade cidade = new Cidade();
		cidade.setCodigo( Integer.parseInt( request.getParameter("codigo")) );
		CidadeRepository cidadeRepository = new CidadeRepository();
		cidadeRepository.remover(cidade);		
		imprimir.println("Cidade excluida com sucesso!");		
		RequestDispatcher rd = request.getRequestDispatcher("/lista_cidades.jsp");
		rd.forward(request, response);		
	}
	
}
