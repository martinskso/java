package model;

public class Cidade implements Comparable<Cidade> {
	
		private int codigo;
	    private String nome;
	    private String uf;

	    public int getCodigo() {
	        return codigo;
	    }

	    public void setCodigo(int codigo) {
	        this.codigo = codigo;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public String getUf() {
	        return uf;
	    }

	    public void setUf(String uf) {
	        this.uf = uf;
	    }

	    public Cidade() {
	    }

	    public Cidade(int codigo, String nome, String uf) {
	        this.codigo = codigo;
	        this.nome = nome;
	        this.uf = uf;
	    }

	    @Override
	    public String toString() {
	        return "Codigo=" + codigo + ", nome=" + nome + ", uf=" + uf;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        return  ((Cidade)obj).codigo == this.codigo;
	    }

	    
	    @Override
	    public int compareTo(Cidade o) {
	        /*int resultado = this.nome.compareTo(o.getNome());      
	        if(resultado==0){
	            resultado = this.uf.compareTo(o.getUf());
	        }        
	        return resultado;*/
	    	
	    	int resultado =0;
	    	if(this.codigo > o.getCodigo()) {
	    		resultado = 1;    		
	    	}
	    	if(this.codigo < o.getCodigo()) {
	    		resultado = -1;
	    	}
	    	return resultado;	
		

	}

}
