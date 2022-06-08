package model;

public class Cliente implements Comparable<Cliente> {
	
	private int codigo;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
     
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente() {
    }

    public Cliente(int codigo, String nome, String telefone, String endereco, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Codigo=" + codigo + ", nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco + ", email=" + email;
    }

    @Override
    public boolean equals(Object obj) {
        return  ((Cliente)obj).codigo == this.codigo;
    }

    
    @Override
    public int compareTo(Cliente o) {
            	
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
