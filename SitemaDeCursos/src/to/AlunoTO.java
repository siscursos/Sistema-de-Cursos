package to;

public class AlunoTO {

	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private String rG;
	private String cPF;
	private String usuario;
	private String senha;


	// Metodos SET
	public void setNome(String n) {
		this.nome = n;
	}

	public void setEndereco(String end) {
		this.endereco = end;
	}

	public void setTelefone(String tel) {
		this.telefone = tel;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setrG(String rG) {
		this.rG = rG;
	}

	public void setcPF(String cPF) {
		this.cPF = cPF;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setUser(String usuario){
		this.usuario = usuario;
	}


	// Metodos GET
	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getrG() {
		return rG;
	}

	public String getcPF() {
		return cPF;
	}
	public String getUser() {

		return usuario;
	}

	public String getSenha() {
		return senha;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AlunoTO))
			return false;
		AlunoTO other = (AlunoTO) obj;
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

	

	

	

}
