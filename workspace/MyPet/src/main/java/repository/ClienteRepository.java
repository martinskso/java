package repository;

import java.util.ArrayList;

public class ClienteRepository implements IPadraoRepository {
	
	 String sql = "";    
	    Connection con = Conexao.getConnection();
	    public static String status;
	    ArrayList clientes = new ArrayList();
	    
	    public void salvar(Object o) {
	    	Cliente c = (Cliente) o;
	    	c =  (Cliente) getById(c.getCodigo());
	    	if ( c != null) {
	    		alterar(o);
	    	}else {
	    		inserir(o);
	    	}
	    	
	    }
	    	    
	    @Override
	    public void inserir(Object o) {    
	        Cliente c = (Cliente) o;
	        try {
	            sql = "INSERT INTO CIDADE(CODIGO,NOME,TELEFONE, ENDERECO, EMAIL) VALUES (?,?,?,?,?)";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, 	c.getCodigo());
	            ps.setString(2, c.getNome());
	            ps.setString(3, c.getEndereco());
	            ps.setString(4, c.getTelefone());
	            ps.setString(5, c.getEmail());
	            ps.execute();
	            ps.close();
	            status = "Registro incluido com sucesso!";
	            System.out.println(status);
	        } catch (SQLException e) {
	            status = "N�o foi possivel incluir o registro erro: "
	                    + e.getMessage() + " sql executado: " + sql;
	        }    
	    }

	    @Override
	    public void alterar(Object o) {        
	        Cliente c = (Cliente) o;
	        try {
	            sql = "UPDATE CLIENTE SET NOME= ?, ENDERECO= ?, TELEFONE= ?, EMAIL= ? WHERE CODIGO= ? ";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, 	c.getCodigo());
	            ps.setString(2, c.getNome());
	            ps.setString(3, c.getEndereco());
	            ps.setString(4, c.getTelefone());
	            ps.setString(5, c.getEmail());
	            ps.execute();
	            ps.close();
	            status = "Registro alterado com sucesso!";
	        } catch (SQLException e) {
	            status = "N�o foi possivel alterar o registro erro: "
	                    + e.getMessage() + " sql executado: " + sql;
	        }
	    }

	    @Override
	    public void remover(Object o) {
	        
	        Cliente c = (Cliente) o;
	        try {
	            sql = "DELETE FROM CLIENTE WHERE CODIGO= ? ";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, c.getCodigo());            
	            ps.execute();
	            ps.close();
	            status = "Registro removido com sucesso!";
	        } catch (SQLException e) {
	            status = "Não foi possivel remover o registro erro: "
	                    + e.getMessage() + " sql executado: " + sql;
	        }
	        
	    }

	    @Override
	    public ArrayList getAll() {
	        clientes.clear();
	        try {
	            sql = "select * from cliente";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                Cliente c = new Cliente(
	                        rs.getInt("codigo"),                    
	                        rs.getString("nome"),
	                        rs.getString("endereco"));
	                		rs.getString("telefone"));
	                		rs.getString("email"));
	                clientes.add(c);
	            }
	        } catch (SQLException e) {
	            status = e.getMessage();
	        }
	        Collections.sort(clientes);
	        return clientes;
	    }

	    @Override
	    public Object getById(int id) {
	        
	        Cliente c = null;
	        try {
	            sql = "select * from cliente where codigo = ?";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            
	            if (rs.next()) {
	                c = new Cliente(
	                        rs.getInt("codigo"),                    
	                        rs.getString("nome"),
	                        rs.getString("endereco"));
            				rs.getString("telefone"));
            				rs.getString("email"));                
	            }
	        } catch (SQLException e) {
	            status = e.getMessage();
	        }
	        return c;  
	    }
	
	

}
