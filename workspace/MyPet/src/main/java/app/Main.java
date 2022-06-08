package app;

import bd.Conexao;
import model.Cidade;
import repository.CidadeRepository;

public class Main {

	public static void main(String[] args) {
		
         System.out.println("Teste");
		
         Conexao.getConnection();
         System.out.println(Conexao.status);
         
		ClienteRepository clienteRepository = new ClienteRepository();
		
		Cliente cliente = new Cliente(1, "maringa", "pr");
  		
        clienteRepository.inserir(cliente);
  		
	}
}