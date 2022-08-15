package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import repository.ClienteRepository;

@WebServlet("/InsereCliente")
public class InsereCliente extends HttpServlet{	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {				
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");			
		ClienteRepository clienteRepository = new ClienteRepository();
        Cliente cliente = new Cliente(1, "Maria", "9595-9595", "Rua A, 23", "maria@gmail.com");
  		clienteRepository.inserir(cliente);
		out.println("<h4> "+clienteRepository.status+"</h4>");		
		out.println("</html>");
		out.close();				
	}	

}