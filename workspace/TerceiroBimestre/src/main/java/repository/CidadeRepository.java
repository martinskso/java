package repository;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Collections;

import bd.Conexao;
import model.Cidade;
import interfaces.IPadraoRepository;

public class CidadeRepository implements IPadraoRepository{
	
	 String sql = "";    
	    Connection con = Conexao.getConnection();
	    public static String status;
	    ArrayList cidades = new ArrayList();
	    
	    public void salvar(Object o) {
	    	Cidade c = (Cidade) o;
	    	c =  (Cidade) getById(c.getCodigo());
	    	if ( c != null) {
	    		alterar(o);
	    	}else {
	    		inserir(o);
	    	}
	    	
	    }
	    
	    
	    @Override
	    public void inserir(Object o) {    
	        Cidade c = (Cidade) o;
	        try {
	            sql = "INSERT INTO CIDADE(CODIGO,NOME,UF) VALUES (?,?,?)";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, c.getCodigo());
	            ps.setString(2, c.getNome());
	            ps.setString(3, c.getUf());
	            ps.execute();
	            ps.close();
	            status = "Registro incluido com sucesso!";
	            System.out.println(status);
	        } catch (SQLException e) {
	            status = "Não foi possivel incluir o registro erro: "
	                    + e.getMessage() + " sql executado: " + sql;
	        }    
	    }

	    @Override
	    public void alterar(Object o) {        
	        Cidade c = (Cidade) o;
	        try {
	            sql = "UPDATE CIDADE SET NOME= ?, UF= ? WHERE CODIGO= ? ";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setString(1, c.getNome());
	            ps.setString(2, c.getUf());
	            ps.setInt(3, c.getCodigo());            
	            ps.execute();
	            ps.close();
	            status = "Registro alterado com sucesso!";
	        } catch (SQLException e) {
	            status = "Não foi possivel alterar o registro erro: "
	                    + e.getMessage() + " sql executado: " + sql;
	        }
	    }

	    @Override
	    public void remover(Object o) {
	        
	        Cidade c = (Cidade) o;
	        try {
	            sql = "DELETE FROM CIDADE WHERE CODIGO= ? ";
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
	        cidades.clear();
	        try {
	            sql = "select * from cidade";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                Cidade c = new Cidade(
	                        rs.getInt("codigo"),                    
	                        rs.getString("nome"),
	                        rs.getString("uf"));
	                cidades.add(c);
	            }
	        } catch (SQLException e) {
	            status = e.getMessage();
	        }
	        Collections.sort(cidades);
	        return cidades;
	    }

	    @Override
	    public Object getById(int id) {
	        
	        Cidade c = null;
	        try {
	            sql = "select * from cidade where codigo = ?";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            
	            if (rs.next()) {
	                c = new Cidade(
	                        rs.getInt("codigo"),                    
	                        rs.getString("nome"),
	                        rs.getString("uf"));                
	            }
	        } catch (SQLException e) {
	            status = e.getMessage();
	        }
	        return c;  
	    }
}
