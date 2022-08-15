package app;

import bd.Conexao;
import model.Cliente;
import repository.ClienteRepository;

public class Main {

	public static void main(String[] args) {
		
         System.out.println("Teste");
		
         Conexao.getConnection();
         System.out.println(Conexao.status);
         
		ClienteRepository clienteRepository = new ClienteRepository();
		
		Cliente cliente = new Cliente(1, "Maria", "9595-9595", "Rua A, 23", "maria@gmail.com");
  		
        clienteRepository.inserir(cliente);
  		
	}
}