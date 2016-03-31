package model;

import dao.AlunoDAO;
import to.AlunoTO;

public class Aluno 
{
   private String nome;
   private String endereco;
   private String telefone;
   private String email;
   private String rG;
   private String cPF;
   private String senha;
   
   //Construtor com parêmetros
   public Aluno(String n, String end, String tel, String email, String rG, String cPF, String senha)
   {
   
      setNome(n);
      setEndereco(end);
      setTelefone(tel);
      setEmail(email);
      setRG(rG);
      setCPF(cPF);
      setSenha(senha);
   }
   
   //Contrutor vazio
   public Aluno()
	   {
		   
	   }
	   
   //Metodos SET
	public void setNome(String n)
	{
		this.nome = n;
	}

	public void setEndereco(String end)
	{
		this.endereco = end;
	}

	public void setTelefone(String tel)
	{
		this.telefone = tel;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public void setRG(String rG)
	{
		this.rG = rG;
	}

	public void setCPF(String cPF)
	{
		this.cPF = cPF;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
	}

	
	//Metodos GET
	public String getNome()
	{
		return nome;
	}

	public String getEndereco()
	{
		return endereco;
	}

	public String getTelefone()
	{
		return telefone;
	}

	public String getEmail()
	{
		return email;
	}

	public String getRG()
	{
		return rG;
	}

	public String getCPF()
	{
		return cPF;
	}

	public String getSenha()
	{
		return senha;
	}
	

	//Metodos CRUD
	public boolean cadastrar()
	{
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();
		to.setNome(nome);
		to.setEndereco(endereco);
		to.setTelefone(telefone);
		to.setEmail(email);
		to.setRG(rG);
		to.setCPF(cPF);
		
		return dao.cadastrar(to);
	}
	
	public AlunoTO consultar()
	{
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = dao.consultar(cPF);
		
		setNome(to.getNome());
		setEndereco(to.getEndereco());
		setTelefone(to.getTelefone());
		setEmail(to.getEmail());
		setRG(to.getRG());
		setCPF(to.getCPF());
		
		return to;
	}
	
	public boolean excluir()
	{
		AlunoDAO dao = new AlunoDAO();
		return dao.excluir(cPF);
	}
	
	public boolean alterar()
	{
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();
		to.setNome(nome);
		to.setEndereco(endereco);
		to.setTelefone(telefone);
		to.setEmail(email);
		to.setRG(rG);
		to.setCPF(cPF);
		
		return dao.alterar(to);
	}
	
	
	
	//Outros
	@Override
	public String toString() {
		return getNome() + " - " + getEmail();
	}
	

}
