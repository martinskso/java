package app;

import bd.Conexao;
import model.Cidade;
import repository.CidadeRepository;

public class Main {

	public static void main(String[] args) {
		
         System.out.println("Teste");
		
         Conexao.getConnection();
         System.out.println(Conexao.status);
         
		CidadeRepository cidadeRepository = new CidadeRepository();
		
		Cidade cidade = new Cidade(2, "maringa", "pr");
  		
        cidadeRepository.inserir(cidade);
  		
	}
}