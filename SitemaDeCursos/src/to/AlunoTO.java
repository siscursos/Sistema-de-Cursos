package to;



public class AlunoTO
{
   private String nome;
   private String endereco;
   private String telefone;
   private String email;
   private String rG;
   private String cPF;
   private String senha;
   
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
   
}
