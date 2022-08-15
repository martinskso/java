package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import repository.ClienteRepository;


@WebServlet("/SalvarCliente")
public class SalvarCliente extends HttpServlet{
	private Cliente cliente;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		PrintWriter imprimir = response.getWriter();
		System.out.println("iniciando servlet...");
		imprimir.println("iniciando servlet...");
		imprimir.println("</br>");		
		int codigo = Integer.parseInt( request.getParameter("codigo"));		
		System.out.println("Codigo: " +codigo );
		imprimir.println("Codigo: " +request.getParameter("codigo"));	
		ClienteRepository clienteRepository = new ClienteRepository();	
		cliente = (Cliente) clienteRepository.getById( Integer.parseInt( request.getParameter("codigo")) );		
		if(cliente != null) {
			System.out.println("Iniciando o update");
			System.out.println("Nome: " +request.getParameter("nome") );
			imprimir.println("Nome: " +request.getParameter("nome"));
			cliente.setNome(request.getParameter("nome"));
			
			System.out.println("Telefone: " +request.getParameter("telefone") );
			imprimir.println("Telefone: : " +request.getParameter("telefone"));
			cliente.setTelefone(request.getParameter("telefone"));						
			clienteRepository.alterar(cliente);
			
			System.out.println("Endereco: " +request.getParameter("endereco") );
			imprimir.println("Endereco: : " +request.getParameter("endereco"));
			cliente.setEndereco(request.getParameter("endereco"));						
			clienteRepository.alterar(cliente);
			
			System.out.println("Email: " +request.getParameter("email") );
			imprimir.println("Email: : " +request.getParameter("email"));
			cliente.setEmail(request.getParameter("email"));						
			clienteRepository.alterar(cliente);		
			imprimir.println("Cliente alterado com sucesso!");	
		}else {
			cliente = new Cliente();
			System.out.println("Iniciando o insert");
			System.out.println("Codigo: " +codigo);	
			cliente.setCodigo( codigo );			
			System.out.println("Nome: " +request.getParameter("nome") );
			imprimir.println("Nome: " +request.getParameter("nome"));
			cliente.setNome(request.getParameter("nome"));	
			
			System.out.println("Telefone: " +request.getParameter("telefone") );
			imprimir.println("Telefone: : " +request.getParameter("telefone"));
			cliente.setTelefone(request.getParameter("telefone"));						
			clienteRepository.inserir(cliente);	
			
			System.out.println("Endereco: " +request.getParameter("endereco") );
			imprimir.println("Endereco: : " +request.getParameter("endereco"));
			cliente.setEndereco(request.getParameter("endereco"));						
			clienteRepository.alterar(cliente);
			
			System.out.println("Email: " +request.getParameter("email") );
			imprimir.println("Email: : " +request.getParameter("email"));
			cliente.setEmail(request.getParameter("email"));						
			clienteRepository.alterar(cliente);	
			imprimir.println("Cliente incluido com sucesso!");	
			
		}				
		imprimir.println("</br>");
		RequestDispatcher rd = request.getRequestDispatcher("/lista_clientes.jsp");
		rd.forward(request, response);		
	}
}
