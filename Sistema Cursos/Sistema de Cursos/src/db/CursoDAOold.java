package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import negocio.Artes;
import negocio.Curso;
import negocio.Informatica;


public class CursoDAOold {
	private int    codigo;
	private String area;
	private String nome;
	private Date data_inicio;
	private Date data_termino;
	private String horario;
	private int    n_vagas;
	private int    n_laboratorio;
	private String reg_software;
	private String descricao_material;
	private String nome_livros;
	private double valor;
	private Connection        conn;
	private PreparedStatement st;
	private PreparedStatement st2;
	private MysqlConnect      db;
	private boolean consulta = false;
	private ResourceBundle bn = null;
	
	public CursoDAOold(int codigo, ResourceBundle bun){
    	bn = bun;
    	setCodigo(codigo);
    	this.db        = new MysqlConnect();
        this.conn      = db.getConnection();
    }
	public CursoDAOold(){
    	this.db        = new MysqlConnect();
        this.conn      = db.getConnection();
    }
	
	public CursoDAOold(Informatica info, ResourceBundle bun){
		setCodigo(info.getCodigo());
		setArea(info.getArea());
		setNVagas(info.getNVagas());
		setDataInicio(info.getDataIniSql());
		setDataTermino(info.getDataFimSql());
		setNome(info.getNome());
		setHorario(info.getHorario());
		setValor(info.getValor());
		setNLaboratorio(info.getNLaboratorio());
		setRegSoftware(info.getRegSoftware());
		bn = bun;
    	this.db        = new MysqlConnect();
        this.conn      = db.getConnection();
	}
	
	public CursoDAOold(Artes at, ResourceBundle bun){
		setCodigo(at.getCodigo());
		setArea(at.getArea());
		setNVagas(at.getNVagas());
		setDataInicio(at.getDataIniSql());
		setDataTermino(at.getDataFimSql());
		setNome(at.getNome());
		setHorario(at.getHorario());
		setValor(at.getValor());
		setDescricaoMaterial(at.getDescricaoMaterial());
		this.db        = new MysqlConnect();
        this.conn      = db.getConnection();
	}
	
	//sets
	public void setCodigo(int codigo)            			   {this.codigo=codigo;}
	public void setNVagas(int n_vagas)           			   {this.n_vagas=n_vagas;}
	public void setNLaboratorio(int n_laboratorio)			   {this.n_laboratorio=n_laboratorio;}
	public void setDataInicio(Date data_inicio)  	   		   {this.data_inicio = data_inicio;}
	public void setDataTermino(Date data_termino)			   {this.data_termino = data_termino;}
	public void setNome(String nome)             			   {this.nome = nome;};
	public void setArea(String area)             			   {this.area = area;};
	public void setHorario(String horario)       			   {this.horario = horario;}
	public void setRegSoftware(String reg_software)			   {this.reg_software = reg_software;}
	public void setNomeLivros(String nome_livros)              {this.nome_livros = nome_livros;};
	public void setDescricaoMaterial(String descricao_material){this.descricao_material = descricao_material;}
	public void setValor(double valor)			 			   {this.valor = valor;}
	
	
	//gets
	public int getCodigo()   			{return codigo;}
	public int getNVagas()      		{return n_vagas;}
	public int getNLaboratorio()		{return n_laboratorio;}
	public Date getDataInicio() 		{return data_inicio;}
	public Date getDataTermino()		{return data_termino;}
	public String getNome()     		{return nome;}
	public String getHorario()  		{return horario;}
	public String getRegSoftware()		{return reg_software;}
	public String getDescricaoMaterial(){return descricao_material;}
	public String getNomeLivros()		{return nome_livros;}
	public String getArea()		        {return area;}
	public boolean getConsulta()		{return consulta;}
	public double getValor()    		{return valor;}
	
	
	public int geraCodigo(){
		int cod;
		Random gerador = new Random();;
		cod = gerador.nextInt(9999);
		do{
			if(consultaSimples(cod)){
				cod = gerador.nextInt(9999);
			}
		}while(consultaSimples(cod));
		return cod;
	}
	
	
	public boolean incluirInfo(){
		boolean sucesso = false;
		int code = geraCodigo();
		if(!consultaSimples(code)){	
			try {
				 String sql  = "INSERT INTO Curso (codigo, area, nome, data_inicio, data_termino, horario, n_vagas, valor) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		         String sql2 = "INSERT INTO Informatica(Curso_codigo_informatica, n_laboratorio, reg_softwares) VALUES (?, ?, ?)";
		         st          = conn.prepareStatement(sql);
		         st2         = conn.prepareStatement(sql2);
		         st.setInt(1,code);
		         st.setString(2,getArea());
		         st.setString(3,getNome());
		         st.setDate(4,getDataInicio());
		         st.setDate(5,getDataTermino());
		         st.setString(6,getHorario());
		         st.setInt(7,getNVagas());
		         st.setDouble(8, getValor());
		         
		         st2.setInt(1, code);
		         st2.setInt(2, getNLaboratorio());
		         st2.setString(3, getRegSoftware());
		         
		         st.executeUpdate();
		         st2.executeUpdate();
		         sucesso = true;
		         st.close();
		         setCodigo(code);
		      }
		      catch(Exception e){ 
		    	  JOptionPane.showMessageDialog(null, "cursodao.erroinclusao");
		    	  e.printStackTrace(); 
		      }
		      db.closeConnection();
		      
		}
		return sucesso;
		
	}
	
	public boolean incluirAt(){
		boolean sucesso = false;
		int code = geraCodigo();
		if(!consultaSimples(code)){	
			try {
				 String sql  = "INSERT INTO curso (codigo, area, nome, data_inicio, data_termino, horario, n_vagas, valor) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		         String sql2 = "INSERT INTO Artes(Curso_codigo_artes, descricao_material) VALUES (?, ?)";
		         st          = conn.prepareStatement(sql);
		         
		         st.setInt(1,code);
		         st.setString(2,getArea());
		         st.setString(3,getNome());
		         st.setDate(4,getDataInicio());
		         st.setDate(5,getDataTermino());
		         st.setString(6,getHorario());
		         st.setInt(7,getNVagas());
		         st.setDouble(8, getValor());
		         st.executeUpdate();
		         
		         st2         = conn.prepareStatement(sql2);
		         st2.setInt(1, code);
		         st2.setString(2, getDescricaoMaterial());
		         
		         st2.executeUpdate();
		         sucesso = true;
		         st.close();
		         st2.close();
		         setCodigo(code);
		      }
		      catch(Exception e){ 
		    	  JOptionPane.showMessageDialog(null, "Erro de inclusão, favor contatar o suporte técnico");
		    	  e.printStackTrace(); 
		      }
		      db.closeConnection();
		}
		return sucesso;
		
	}
	
	public boolean consultaSimples(int cod){
		boolean existe = false;
			
		
		try {
			 ResultSet rs;
	         String sql = "SELECT * FROM curso WHERE codigo = ?";
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
	
	public CursoDAOold consultar(int cod){
		ResultSet rs;
	      try {
	    	  
	    	  String sql = "";
	    	 if(cod == 1){ 
	    		 sql = "SELECT * FROM curso cur "
	    		 		+ "INNER JOIN Informatica info ON cur.codigo = info.Curso_codigo_informatica where codigo = ?";
	    		 st         = conn.prepareStatement(sql);
	    		 st.setInt(1, getCodigo()); 
	    		 rs         = st.executeQuery();
	    		 if (rs.next()) { 
	    			 setCodigo(rs.getInt("codigo"));
	    			 setArea(rs.getString("area"));
	    			 setNome(rs.getString("nome"));
	    			 setValor(rs.getDouble("valor"));
	    			 setDataInicio(rs.getDate("data_inicio"));
	    			 setDataTermino(rs.getDate("data_termino"));
	    			 setHorario(rs.getString("horario"));
	    			 setNVagas(rs.getInt("n_vagas"));
	    			 setNLaboratorio(rs.getInt("n_laboratorio"));
	    			 setRegSoftware(rs.getString("reg_softwares"));
	    			 consulta = true;
	    		 
	    		 }
	    		 else{
		        	 JOptionPane.showMessageDialog(null, "Curso não encontrado");
		        	 consulta = false;
		         }
	    	}
	    	 else if(cod == 2){
	    		 sql = "SELECT * FROM curso cur INNER JOIN Artes art ON cur.codigo = art.Curso_codigo_artes where codigo = ?";	 
	    		 st         = conn.prepareStatement(sql);
	    		 st.setInt(1, getCodigo()); 
	    		 rs         = st.executeQuery();
	    		 if (rs.next()) { 
	    			 setCodigo(rs.getInt("codigo"));
	    			 setNome(rs.getString("nome"));
	    			 setArea("Artes");
	    			 setDataInicio(rs.getDate("data_inicio"));
	    			 setDataTermino(rs.getDate("data_termino"));
	    			 setHorario(rs.getString("horario"));;
	    			 setNVagas(rs.getInt("n_vagas"));;
	    			 setValor(rs.getDouble("valor"));;
	    			 setDescricaoMaterial(rs.getString("descricao_material"));
	    			 consulta = true;
	    		 }
	    		 else{
		        	 JOptionPane.showMessageDialog(null, "Curso não encontrado");
		        	 consulta = false;
		         }
	            
	         }
	         
	         st.close();
	      
	    	 
	      }
	      catch(Exception e) { 
	    	  JOptionPane.showMessageDialog(null, "Erro ao realizar consulta, favor entrar em contato com o suporte técnico");
	    	  e.printStackTrace(); 
	      }
	      return this;
	}
	
	public boolean editar(int cod){
		boolean sucesso = false;
	      try {
	    	  String sql = "";
		     if(cod == 1){ 
	         sql = "UPDATE curso cur inner join Informatica info on cur.codigo = info.Curso_codigo_informatica SET nome = ?,"
	        		 +"data_inicio = ?, data_termino = ?, horario = ?, n_vagas = ?, valor = ?, n_laboratorio = ?, reg_softwares = ? WHERE codigo = ?";
	         st         = conn.prepareStatement(sql);
	         st.setString(1,getNome());
	         st.setDate(2, getDataInicio());
	         st.setDate(3, getDataTermino());
	         st.setString(4, getHorario());
	         st.setInt(5, getNVagas());
	         st.setDouble(6, getValor());
	         st.setInt(7, getNLaboratorio());
	         st.setString(8, getRegSoftware());
	         st.setInt(9, getCodigo());
	         st.executeUpdate();
	         
	         sucesso = true;
	         st.close();
		    }
		     if(cod == 2){ 
		    	 sql = "UPDATE curso cur inner join Artes a on cur.codigo = a.Curso_codigo_artes SET nome = ?,"
		        		 +"data_inicio = ?, data_termino = ?, horario = ?, n_vagas = ?, valor = ?, descricao_material = ? WHERE codigo = ?";
		         st         = conn.prepareStatement(sql);
		         st.setString(1,getNome());
		         st.setDate(2, getDataInicio());
		         st.setDate(3, getDataTermino());
		         st.setString(4, getHorario());
		         st.setInt(5, getNVagas());
		         st.setDouble(6, getValor());
		         st.setString(7, getDescricaoMaterial());
		         st.setInt(8, getCodigo());
		         st.executeUpdate();
		         
		         sucesso = true;
		         st.close();
			    	 } 
	      }
	      catch(Exception e) { 
	    	  JOptionPane.showMessageDialog(null, "Erro ao editar dados, favor entrar em contato com o suporte técnico");
	    	  e.printStackTrace(); 
	      }
	      db.closeConnection();
	      return sucesso;
	}
	
	public boolean preencheVaga(int cod){
		consultar(cod);
		int nvagas = getNVagas() - 1;
		boolean sucesso = false;
		try{
			String sql = "UPDATE curso SET n_vagas = ? WHERE codigo = ?";
			st         = conn.prepareStatement(sql);
	        st.setInt(1,nvagas);
	        st.setInt(2,cod);
	        st.executeUpdate(); 
	        sucesso = true;
	        st.close();
		}
		catch(Exception e) { 
	    	  JOptionPane.showMessageDialog(null, "Erro ao preencher vaga, favor entrar em contato com o suporte técnico");
	    	  e.printStackTrace(); 
	    }
		return sucesso;
	}
	
	public boolean liberaVaga(int cod){
		consultar(cod);
		int nvagas = getNVagas() + 1;
		boolean sucesso = false;
		try{
			String sql = "UPDATE curso SET n_vagas = ? WHERE codigo = ?";
			st         = conn.prepareStatement(sql);
	        st.setInt(1,nvagas);
	        st.setInt(2,cod);
	        st.executeUpdate(); 
	        sucesso = true;
	        st.close();
		}
		catch(Exception e) { 
	    	  JOptionPane.showMessageDialog(null, "Erro ao preencher vaga, favor entrar em contato com o suporte técnico");
	    	  e.printStackTrace(); 
	    }
		return sucesso;
	}
	
	public boolean excluir(){
		boolean sucesso = false;
	      try {
	         String sql = "DELETE FROM curso WHERE codigo = ?";
	         st         = conn.prepareStatement(sql);
	         st.setInt(1, getCodigo());
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
	
	public int[] consultaCursosPorArea(String area){
		ArrayList<Integer> codigo  = new ArrayList<Integer>();
		;
		try{
			ResultSet rs;
			String sql = "SELECT codigo, n_vagas FROM curso where area = ?";
			st         = conn.prepareStatement(sql);
   		 	st.setString(1, area); 
   		 	rs         = st.executeQuery();
   		 	while(rs.next()){
   		 		int cod = rs.getInt("codigo");
   		 		int numvagas = rs.getInt("n_vagas");
   		 		if(numvagas > 0){
   		 			codigo.add(cod);
   		 		}
   		 	}    
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		int[] vetor = new int[codigo.size()];
	    for (int i=0; i < vetor.length; i++)
	    {
	        vetor[i] = codigo.get(i).intValue();
	    }
		return vetor;
		
	}
	
	public int consultaCursosPorNome(String nome){
		int codigo  = 0000;
		try{
			ResultSet rs;
			String sql = "SELECT codigo FROM curso where nome = ?";
			st         = conn.prepareStatement(sql);
   		 	st.setString(1, area);
   		    rs         = st.executeQuery();
   		 	if(rs.next()){
   		 		codigo = rs.getInt("codigo");
   		 	}
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return codigo;
	}
	
	public String[] consultaCursosInfo(){
		ArrayList<String> nomes  = new ArrayList<String>();
		String [] cursos;
		try{
			String cur = "Informatica";
			ResultSet rs;
			String sql = "SELECT nome, n_vagas FROM curso WHERE area = ?";
			st         = conn.prepareStatement(sql); 
			st.setString(1, cur);
   		 	rs         = st.executeQuery();
   		 	while(rs.next()){
   		 		String name = rs.getString("nome");
   		 		int numvagas = rs.getInt("n_vagas");
   		 		if(numvagas > 0){
   		 			nomes.add(name);
   		 		}
   		 	}
   		 	st.close();
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		cursos = nomes.toArray(new String [nomes.size()]);
		return cursos;
		
		
	}
	
	public String[] consultaCursosArtes(){
		ArrayList<String> nomes  = new ArrayList<String>();
		String [] cursos;
		try{
			String cur = "Artes";
			ResultSet rs;
			String sql = "SELECT nome, n_vagas FROM curso WHERE area = ?";
			st         = conn.prepareStatement(sql);
			st.setString(1, cur);
   		 	rs         = st.executeQuery();
   		 	while(rs.next()){
   		 		String name = rs.getString("nome");
   		 		int numvagas = rs.getInt("n_vagas");
   		 		if(numvagas > 0){
   		 			nomes.add(name);
   		 		}
   		 	}
   		 	
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		cursos = nomes.toArray(new String [nomes.size()]);
		return cursos;
		
		
	}
	
	public String consultaNome(int cod){
		String nome = "";
		try {
			 ResultSet rs;
	         String sql = "SELECT * FROM curso WHERE codigo = ?";
	         st         = conn.prepareStatement(sql);
	         st.setInt(1, cod);
	         rs         = st.executeQuery();
	         if (rs.next()) {
	        	nome =  rs.getString("nome");
	         }
	         st.close();
	      }
	      catch(Exception e) { 
	    	  e.printStackTrace(); 
	      }
		
		  return nome;
	}
	
	
	
}
