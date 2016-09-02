package model;

import dao.AlunoDAO;
import to.AlunoTO;

public class Aluno {
	private int id;
	private String nome;
	private String end;
	private String tel;
	private String email;
	private String rg;
	private String cpf;
	private String user;
	private String pass;
	
	
	
	
	public Aluno(int id, String nome, String end, String tel, String email, String rg, String cpf, String user,
			String pass) {
		this.id = id;
		this.nome = nome;
		this.end = end;
		this.tel = tel;
		this.email = email;
		this.rg = rg;
		this.cpf = cpf;
		this.user = user;
		this.pass = pass;
	}
	
	public Aluno(String nome, String end, String tel, String email, String rg, String cpf, String user,
			String pass) {
		this.id = id;
		this.nome = nome;
		this.end = end;
		this.tel = tel;
		this.email = email;
		this.rg = rg;
		this.cpf = cpf;
		this.user = user;
		this.pass = pass;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	
	public AlunoTO getTo(){
		AlunoTO to = new AlunoTO();
		
		to.setId(id);
		to.setCpf(cpf);
		to.setEmail(email);
		to.setEnd(end);
		to.setNome(nome);
		to.setPass(pass);
		to.setRg(rg);
		to.setTel(tel);
		to.setUser(user);
		
		return to;
		
	}
	
	public void criar(){
		AlunoDAO dao = new AlunoDAO();
		AlunoTO  to  = getTo();
		dao.incluir(to);
		this.id = to.getId();
	}
	
	public void atualizar(){
		AlunoDAO dao = new AlunoDAO();
		AlunoTO  to  = getTo();
		dao.atualizar(to);
	}
	
	public void excluir() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();
		to.setId(id);
		dao.excluir(to);
	}
	
	public void carregar(){
		AlunoDAO dao = new AlunoDAO();
		AlunoTO  to  = dao.carregar(cpf);
		
		id = to.getId();
		nome = to.getNome();
		end = to.getEnd();
		tel = to.getTel();
		email = to.getEmail();
		rg = to.getRg();
		cpf = to.getCpf();
		user = to.getUser();
		pass = to.getPass();
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
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
}
