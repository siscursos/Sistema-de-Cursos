package db;
import java.sql.*;
import java.util.ResourceBundle;

import javax.swing.*;

import negocio.Aluno;

public class AlunoDAO {
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private String rg;
	private String cpf;
	private String login;
	private String senha;
	private Connection        conn;
	private PreparedStatement st;
	private PreparedStatement st2;
	private MysqlConnect      db;
	private boolean consulta = false;
	private ResourceBundle bn = null;

    public AlunoDAO(ResourceBundle bun){
    	bn = bun;
    	this.db        = new MysqlConnect();
        this.conn      = db.getConnection();
    }
    
    public AlunoDAO(Aluno al, ResourceBundle bun){
    	bn = bun;
    	this.db        = new MysqlConnect();
        this.conn      = db.getConnection();
    	setNome(al.getNome());
		setEndereco(al.getEndereco());
		setTelefone(al.getTelefone());
		setEmail(al.getEmail());
		setRG(al.getRG());
		setCPF(al.getCPF());
		setLogin(al.getLogin());
		setSenha(al.getSenha());
    }
    
    public AlunoDAO(String cpf){
    	this.db        = new MysqlConnect();
        this.conn      = db.getConnection();
    	setCPF(cpf);
    }
    
    //sets
   public void setNome(String nome)     {this.nome = nome;}
	public void setEndereco(String end)  {endereco = end;}
	public void setTelefone(String tele) {telefone = tele;}
	public void setEmail(String mail)    {email = mail;}
	public void setRG(String reg)        {rg = reg;}
	public void setCPF(String cad)       {cpf = cad;}
	public void setLogin(String log)     {login = log;}
	public void setSenha(String pass)    {senha = pass;}
	
	//gets
	public String  getNome()     {return nome;}
	public String  getEndereco() {return endereco;}
	public String  getTelefone() {return telefone;}
	public String  getEmail()    {return email;}
	public String  getRG()       {return rg;}
	public String  getCPF()      {return cpf;}
	public String  getLogin()    {return login;}
	public String  getSenha()    {return senha;}
	public boolean getConsulta() {return consulta;}
	
	public boolean incluir(){
		boolean sucesso = false;
		if(!consultaSimples()){	
			try {
		         String sql  = "INSERT INTO aluno (cpf, nome, endereco, telefone, email, rg) VALUES (?, ?, ?, ?, ?, ?)";
		         String sql2 = "INSERT INTO SisAcesso(Aluno_cpf, tipo_usuario, login, senha)                   VALUES (?, ?, ?, ?)";
		         st          = conn.prepareStatement(sql);
		         st2         = conn.prepareStatement(sql2);
		         st.setString(1,getCPF());
		         st.setString(2,getNome());
		         st.setString(3,getEndereco());
		         st.setString(4,getTelefone());
		         st.setString(5,getEmail());
		         st.setString(6,getRG());
		         st2.setString(1, getCPF());
		         st2.setInt(2, 1);
		         st2.setString(3, getLogin());
		         st2.setString(4, getSenha());
		         st.executeUpdate();
		         st2.executeUpdate();
		         sucesso = true;
		         st.close();
		      }
		      catch(Exception e){ 
		    	  JOptionPane.showMessageDialog(null, "Erro de inclusão, favor contatar o suporte técnico");
		    	  e.printStackTrace(); 
		      }
		      db.closeConnection();
		}
		return sucesso;
		
	}
	
	public boolean consultaSimples(){
		boolean existe = false;
		try {
			 ResultSet rs;
			 ResultSet rs2;
	         String sql = "SELECT * FROM aluno WHERE cpf = ?";
	         st         = conn.prepareStatement(sql);
	         st.setString(1, getCPF());
	         String sql2 = "SELECT * FROM SisAcesso WHERE login = ?";
	         st2         = conn.prepareStatement(sql2);
	         st2.setString(1, getLogin());
	         rs         = st.executeQuery();
	         rs2        = st2.executeQuery();
	         if (rs.next()) {
	        	 JOptionPane.showMessageDialog(null, "Aluno existe"); 
	        	 existe = true;
	         }
	         else if(rs2.next()){
	        	 JOptionPane.showMessageDialog(null, "Login já existe"); 
	        	 existe = true;
	         }
	         else{
	        	 existe = false;
	         }
	         st.close();
	      }
	      catch(Exception e) { 
	    	  JOptionPane.showMessageDialog(null, "Erro ao verificar existência, favor contatar o suporte técnico");
	    	  e.printStackTrace(); 
	      }
		  return existe;
	}
	
	public AlunoDAO consultar(){
		ResultSet rs;
	      try {
	    	 String sql = "SELECT * FROM aluno al INNER JOIN sisacesso sa ON al.cpf = sa.aluno_cpf where cpf = ?;";
	         st         = conn.prepareStatement(sql);
	         st.setString(1, getCPF()); 
	         rs         = st.executeQuery();
	         if (rs.next()) { 
	            setCPF(rs.getString("cpf"));
	            setNome(rs.getString("nome"));
	            setEndereco(rs.getString("endereco"));
	            setTelefone(rs.getString("telefone"));
	            setEmail(rs.getString("email"));
	            setRG(rs.getString("rg"));
	            setLogin(rs.getString("login"));
	            setSenha(rs.getString("senha"));
	            consulta = true;
	            
	         }
	         else{
	        	 JOptionPane.showMessageDialog(null, "Aluno não encontrado");
	        	 consulta = false;
	         }
	         st.close();
	      }
	      catch(Exception e) { 
	    	  JOptionPane.showMessageDialog(null, "Erro ao realizar consulta, favor entrar em contato com o suporte técnico");
	    	  e.printStackTrace(); 
	      }
	      return this;
	}
	
	public boolean editar(){
		boolean sucesso = false;
	      try {
	         String sql = "UPDATE aluno al inner join sisAcesso sa on al.cpf = sa.Aluno_cpf SET nome = ?,"
	        		 +"endereco = ?, telefone = ?, email = ?, rg = ?, login = ?, senha = ? WHERE cpf = ?";
	         st         = conn.prepareStatement(sql);
	         st.setString(1,getNome());
	         st.setString(2,getEndereco());
	         st.setString(3,getTelefone());
	         st.setString(4,getEmail());
	         st.setString(5,getRG());
	         st.setString(6,getLogin());
	         st.setString(7,getSenha());
	         st.setString(8,getCPF());
	         st.executeUpdate();
	         
	         sucesso = true;
	         st.close();
	         
	      }
	      catch(Exception e) { 
	    	  JOptionPane.showMessageDialog(null, "Erro ao editar dados, favor entrar em contato com o suporte técnico");
	    	  e.printStackTrace(); 
	      }
	      db.closeConnection();
	      return sucesso;
	}
	
	public boolean excluir(){
		boolean sucesso = false;
	      try {
	         String sql = "DELETE FROM aluno WHERE cpf = ?";
	         st         = conn.prepareStatement(sql);
	         st.setString(1, getCPF());
	         st.executeUpdate();
	         sucesso    = true;
	      }
	      catch(Exception e) {
	    	  JOptionPane.showMessageDialog(null, "Erro ao excluir dados, favor entrar em contato com o suporte técnico");
	    	  e.printStackTrace();
	      }
	      db.closeConnection();
	      return sucesso;
	}
}
