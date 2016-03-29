package negocio;

import java.util.ResourceBundle;

import db.AlunoDAO;

public class Aluno {
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private String rg;
	private String cpf;
	private String login;
	private String senha;
	ResourceBundle bn = null;
	//private boolean liberaBotao = false;
	
	
	//Construtor incluir
	public Aluno(String nomeAluno, String endAluno, String tel, String email, String rg, String cpf, String login, String senha, ResourceBundle bun){
		bn = bun;
		setNome(nomeAluno);
		setEndereco(endAluno);
		setTelefone(tel);
		setEmail(email);
		setRG(rg);
		setCPF(cpf);
		setLogin(login);
		setSenha(senha);
		
	}
	//Construtor vazio
	public Aluno(){
		
	}
	
	//Construtor consultar
	public Aluno(String cpf){
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
	public String getNome()     {return nome;}
	public String getEndereco() {return endereco;}
	public String getTelefone() {return telefone;}
	public String getEmail()    {return email;}
	public String getRG()       {return rg;}
	public String getCPF()      {return cpf;}
	public String getLogin()    {return login;}
	public String getSenha()    {return senha;}
	
	
	public boolean cadastrarAluno(){
		String userpass = getLogin() + getSenha();
		SistemaAcesso sa = new SistemaAcesso(userpass);
		boolean sucesso = false;
		AlunoDAO al = new AlunoDAO(this, bn);
		if(al.incluir() && sa.registraDados()) sucesso = true;
		
		return sucesso;
	}
	
	public boolean consultarAluno(){
		boolean sucesso = false;
		AlunoDAO al = new AlunoDAO(getCPF());
		al.consultar();
		if(al.getConsulta()){
			setCPF(al.getCPF());
			setNome(al.getNome());
			setEndereco(al.getEndereco());
			setTelefone(al.getTelefone());
			setEmail(al.getEmail());
			setRG(al.getRG());
			setLogin(al.getLogin());
			setSenha(al.getSenha());
			sucesso = true;
		}	
		return sucesso;
		
	}
	
	public boolean editarAluno(){
		boolean sucesso = false;
		AlunoDAO al = new AlunoDAO(this, bn);
		if(al.editar()) sucesso = true;
		return sucesso;
	}
	
	public boolean excluirAluno(){
		boolean sucesso = false;
		AlunoDAO al = new AlunoDAO(getCPF());
		if(al.excluir()) sucesso = true;
		return sucesso;
	}
	
	public boolean consultaExistencia(){
		boolean existe = false;
		String cpf = getCPF();
		AlunoDAO al = new AlunoDAO(cpf);
		if(al.consultaSimples())existe = true;
		return existe;
	}
	

	
}
