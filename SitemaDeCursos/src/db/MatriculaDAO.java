package db;
import negocio.*;
import java.sql.*;
import java.util.Random;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
public class MatriculaDAO {
	private Connection        conn;
	private PreparedStatement st;
	private PreparedStatement st2;
	private ConnectionFactory      db;
	private boolean consulta = false;
	private ResourceBundle bn = null;
	private int codigo_matricula;
	private Date data_matricula;
	private double valor_matricula;
	private String status_matricula;
	private String aluno_cpf;
	private int [] curso_codigo;
	private String nome_atendente;
	
	public MatriculaDAO(Matricula mt){
		setCodigoMatricula(mt.getCodigoMatricula());
		setDataMatricula(mt.getDataMatriculaSql());
		setValorMatricula(mt.getValorMatricula());
		setCursoCodigo(mt.getCodigoCurso());
		setStatusMatricula(mt.getStatusMatricula());
		setAlunoCPF(mt.getAlunoCPF());
	}
	
	//sets
	public void setCodigoMatricula(int cm){codigo_matricula = cm;}
	public void setDataMatricula(Date data_matricula){this.data_matricula = data_matricula;}
	public void setValorMatricula(double valor_matricula){this.valor_matricula = valor_matricula;}
	public void setStatusMatricula(String status_matricula){this.status_matricula = status_matricula;}
	public void setAlunoCPF(String aluno_cpf){this.aluno_cpf = aluno_cpf;}
	public void setCursoCodigo(int [] curso_codigo){this.curso_codigo = curso_codigo;}
	public void setNomeAtendente(String nome_atendente){this.nome_atendente = nome_atendente;}
	
	//gets
	public int getCodigoMatricula(){return codigo_matricula;}
	public Date getDataMatricula(){return data_matricula;}
	public double getValorMatricula(){return valor_matricula;}
	public String getStatusMatricula(){return status_matricula;}
	public String getAlunoCPF(){return aluno_cpf;}
	public int [] getCursoCodigo(){return curso_codigo;}
	public String getNomeAtendente(){return nome_atendente;}
	
	public int geraCodigo(){
		int cod;
		Random gerador = new Random();;
		cod = gerador.nextInt(99999);
		/*do{
			if(consultaSimples(cod)){
				cod = gerador.nextInt(99999);
			}
		}while(consultaSimples(cod));*/
		return cod;
	}
	
	
	public boolean cadastraCurso(int codigo_matricula, int codigo_curso){
		boolean sucesso = false;
		
		try {
			String sql  = "INSERT INTO CursoMatricula (Matricula_codigo_matricula, Curso_codigo) VALUES (?, ?)";
			st          = conn.prepareStatement(sql);
			st.setInt(1,codigo_matricula);
	        st.setInt(2,codigo_curso);
	        st.executeUpdate(); 
	        sucesso = true;
	        st.close();
	        
			
		}
		catch(Exception e){ 
	    	  sucesso = false;
	    	  e.printStackTrace(); 
	    }
		return sucesso;
	}
	
	public boolean cancelaCurso(int codigo_matricula){
		boolean sucesso = false;
		
		try {
			String sql  = "DELETE FROM CursoMatricula WHERE codigo_matricula = ?";
			st          = conn.prepareStatement(sql);
			st.setInt(1,codigo_matricula);
	        st.executeUpdate(); 
	        sucesso = true;
	        st.close();	
		}
		catch(Exception e){ 
	    	  sucesso = false;
	    	  e.printStackTrace(); 
	    }
		return sucesso;
	}
	
	public boolean cadastraMatricula(){
		boolean sucesso = false;
		int code = geraCodigo();
		try {
			String sql  = "INSERT INTO Matricula (codigo_matricula, data_matricula, valor_matricula, status_matricula, Aluno_cpf)"
					+  "VALUES (?, ?, ?, ?, ?)";
			st          = conn.prepareStatement(sql);
			st.setInt(1,code);
	        st.setDate(2,getDataMatricula());
	        st.setDouble(3, getValorMatricula());
	        st.setString(4, "Ativa");
	        st.setString(5, getAlunoCPF());
	        st.executeUpdate(); 
	        st.close();
	        try{
	        	for(int i= 0; i<curso_codigo.length; i++){
	        		cadastraCurso(code, curso_codigo[i]);
	        	}
	        	geralog(code, "Cadastro");
	        	setCodigoMatricula(code);
	        	sucesso = true;
	        }
	        catch(Exception e){ 
		    	  sucesso = false;
		    	  e.printStackTrace(); 
		    }	
		}
		catch(Exception e){ 
	    	  sucesso = false;
	    	  e.printStackTrace(); 
	      }
		return sucesso;
	}
	
	public boolean cancelarMatricula(int cod){
		boolean sucesso = false;
		try{
			String sql = "DELETE FROM Matricula WHERE codigo_matricula = ?";
			st          = conn.prepareStatement(sql);
			st.setInt(1,cod);
			st.executeUpdate(); 
	        
	        st.close();
	        cancelaCurso(cod);
	        sucesso = true;
	        geralog(cod, "Cancelamento");
		}
		catch(Exception e){ 
	    	  sucesso = false;
	    	  e.printStackTrace(); 
	      }
		return sucesso;
	}
	
	public boolean geralog(int code, String operacao){
		boolean sucesso = false;
		try {
			String sql  = "INSERT INTO LogMatricula (Matricula_codigo_matricula, data, operacao)"
					+  "VALUES (?, ?, ?)";
			st          = conn.prepareStatement(sql);
			st.setInt(1,code);
	        st.setDate(2,getDataMatricula());
	        //st.setString(3, getNomeAtendente());
	        st.setString(3, operacao);
		}
	    catch(Exception e){ 
		    	  sucesso = false;
		    	  e.printStackTrace(); 
		}	
		
		return sucesso;
		
	}
	
	
	public boolean consultaSimples(int cod){
		boolean existe = false;
		try {
			 ResultSet rs;
	         String sql = "SELECT * FROM matricula WHERE codigo_matricula = ?";
	         st         = conn.prepareStatement(sql);
	         st.setInt(1, cod);
	         rs         = st.executeQuery();
	         if (rs.next()) {
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
}
