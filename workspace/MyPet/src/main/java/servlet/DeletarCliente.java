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

@WebServlet("/DeletarCliente")

public class DeletarCliente extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		PrintWriter imprimir = response.getWriter();
		System.out.println("iniciando servlet...");
		imprimir.println("iniciando servlet...");
		imprimir.println("</br>");		
		System.out.println("Codigo: " +request.getParameter("codigo") );
		imprimir.println("Codigo: " +request.getParameter("codigo"));			
		Cliente cliente = new Cliente();
		cliente.setCodigo( Integer.parseInt( request.getParameter("codigo")) );
		ClienteRepository clienteRepository = new ClienteRepository();
		clienteRepository.remover(cliente);		
		imprimir.println("Cliente excluido com sucesso!");		
		RequestDispatcher rd = request.getRequestDispatcher("/lista_clientes.jsp");
		rd.forward(request, response);		
	}
	
}