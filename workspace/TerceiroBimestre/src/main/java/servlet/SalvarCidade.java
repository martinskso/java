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

@WebServlet("/SalvarCidade")
public class SalvarCidade extends HttpServlet{
	private Cidade cidade;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		PrintWriter imprimir = response.getWriter();
		System.out.println("iniciando servlet...");
		imprimir.println("iniciando servlet...");
		imprimir.println("</br>");		
		int codigo = Integer.parseInt( request.getParameter("codigo"));		
		System.out.println("Codigo: " +codigo );
		imprimir.println("Codigo: " +request.getParameter("codigo"));	
		CidadeRepository cidadeRepository = new CidadeRepository();	
		cidade = (Cidade) cidadeRepository.getById( Integer.parseInt( request.getParameter("codigo")) );		
		if(cidade != null) {
			System.out.println("Iniciando o update");
			System.out.println("Nome: " +request.getParameter("nome") );
			imprimir.println("Nome: " +request.getParameter("nome"));
			cidade.setNome(request.getParameter("nome"));			
			System.out.println("UF: " +request.getParameter("uf") );
			imprimir.println("UF: : " +request.getParameter("uf"));
			cidade.setUf(request.getParameter("uf"));						
			cidadeRepository.alterar(cidade);		
			imprimir.println("Cidade alterada com sucesso!");	
		}else {
			cidade = new Cidade();
			System.out.println("Iniciando o insert");
			System.out.println("Codigo: " +codigo);	
			cidade.setCodigo( codigo );			
			System.out.println("Nome: " +request.getParameter("nome") );
			imprimir.println("Nome: " +request.getParameter("nome"));
			cidade.setNome(request.getParameter("nome"));			
			System.out.println("UF: " +request.getParameter("uf") );
			imprimir.println("UF: : " +request.getParameter("uf"));
			cidade.setUf(request.getParameter("uf"));						
			cidadeRepository.inserir(cidade);		
			imprimir.println("Cidade incluida com sucesso!");	
		}				
		imprimir.println("</br>");
		RequestDispatcher rd = request.getRequestDispatcher("/lista_cidades.jsp");
		rd.forward(request, response);		
	}
}

	
