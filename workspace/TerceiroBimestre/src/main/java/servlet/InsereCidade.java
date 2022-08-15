package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cidade;
import repository.CidadeRepository;

@WebServlet("/InsereCidade")
public class InsereCidade extends HttpServlet{	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {				
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");			
		CidadeRepository cidadeRepository = new CidadeRepository();
        Cidade cidade = new Cidade(1, "maringa", "pr");
  		cidadeRepository.inserir(cidade);
		out.println("<h4> "+cidadeRepository.status+"</h4>");		
		out.println("</html>");
		out.close();				
	}	

}
