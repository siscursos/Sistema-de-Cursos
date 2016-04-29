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
   private String usuario;

//Construtor com parêmetros
   public Aluno(String n, String end, String tel, String email, String rG, String cPF)
   {
   
      setNome(n);
      setEndereco(end);
      setTelefone(tel);
      setEmail(email);
      setRG(rG);
      setCPF(cPF);
      setSenha(senha);
      setUsuario(usuario);
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

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
	
	public String getUsuario() {
		return usuario;
	}
	
	public AlunoTO getTO() {
		AlunoTO to = new AlunoTO();
		to.setNome(nome);
		to.setEndereco(endereco);
		to.setTelefone(telefone);
		to.setEmail(email);
		to.setrG(rG);
		to.setcPF(cPF);
		to.setUser(usuario);
		to.setSenha(senha);
		return to;
	}

	//Metodos CRUD
	public void cadastrar()
	{
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = getTO();
		
		dao.cadastrar(to);
	}

	
	
	public AlunoTO consultar()
	{
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = dao.consultar(cPF);
		
		nome = to.getNome();
		endereco = to.getEndereco();
		telefone = to.getTelefone();
		email = to.getEmail();
		rG = to.getrG();
		cPF = to.getcPF();
		usuario = to.getUser();
		senha = to.getSenha();
		
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
		AlunoTO to = getTO();
		
		return dao.alterar(to);
	}
	
	
	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Aluno))
			return false;
		Aluno other = (Aluno) obj;
		if (cPF == null) {
			if (other.cPF != null)
				return false;
		} else if (!cPF.equals(other.cPF))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (rG == null) {
			if (other.rG != null)
				return false;
		} else if (!rG.equals(other.rG))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	//Outros
	@Override
	public String toString() {
		return getNome() + " - " + getEmail();
	}
	

}
