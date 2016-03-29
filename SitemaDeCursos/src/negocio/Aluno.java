package negocio;

import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import db.AlunoDAO;
import to.AlunoTO;;

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
	// private boolean liberaBotao = false;

	// Construtor incluir
	public Aluno(String nomeAluno, String endAluno, String tel, String email, String rg, String cpf, String login,
			String senha, ResourceBundle bun) {
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

	// Construtor vazio
	public Aluno() {

	}

	// Construtor consultar
	public Aluno(String cpf) {
		setCPF(cpf);
	}

	// sets
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(String end) {
		endereco = end;
	}

	public void setTelefone(String tele) {
		telefone = tele;
	}

	public void setEmail(String mail) {
		email = mail;
	}

	public void setRG(String reg) {
		rg = reg;
	}

	public void setCPF(String cad) {
		cpf = cad;
	}

	public void setLogin(String log) {
		login = log;
	}

	public void setSenha(String pass) {
		senha = pass;
	}

	// gets
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

	public String getRG() {
		return rg;
	}

	public String getCPF() {
		return cpf;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public boolean cadastrarAluno() {
		String userpass = getLogin() + getSenha();
		SistemaAcesso sa = new SistemaAcesso(userpass);
		boolean sucesso = false;
		AlunoDAO al = new AlunoDAO(bn);
		AlunoTO to = new AlunoTO();
		to.setNome(nome);
		to.setEndereco(endereco);
		to.setTelefone(telefone);
		to.setEmail(email);
		to.setRG(rg);
		to.setCPF(cpf);
		to.setLogin(login);
		to.setSenha(senha);
		
		if (!al.consultaExistAluno(to)) {
			if (al.consultaExistLogin(to)) {
				if (al.incluir(to) && sa.registraDados()) {
					sucesso = true;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Usuário já existe!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Aluno já existe!");
		}

		return sucesso;
	}

	public boolean consultarAluno() {
		boolean sucesso = false;
		AlunoDAO al = new AlunoDAO(bn);
		AlunoTO to = al.consultar(cpf);

		setCPF(to.getCPF());
		setNome(to.getNome());
		setEndereco(to.getEndereco());
		setTelefone(to.getTelefone());
		setEmail(to.getEmail());
		setRG(to.getRG());
		setLogin(to.getLogin());
		setSenha(to.getSenha());
		sucesso = true;
		return sucesso;

	}

	public boolean editarAluno() {
		boolean sucesso = false;
		AlunoDAO al = new AlunoDAO(bn);
		AlunoTO  to = new AlunoTO();
		to.setNome(nome);
		to.setEndereco(endereco);
		to.setTelefone(telefone);
		to.setEmail(email);
		to.setRG(rg);
		to.setCPF(cpf);
		to.setLogin(login);
		to.setSenha(senha);
		al.editar(to);
		sucesso = true;
		return sucesso;
	}

	public boolean excluirAluno() {
		boolean sucesso = false;
		AlunoDAO al = new AlunoDAO(bn);
		AlunoTO  to  = new AlunoTO();
		to.setCPF(cpf);
		al.excluir(to);
		sucesso = true;
		return sucesso;
	}

	public boolean consultaExistencia() {
		boolean existe = false;
		AlunoDAO al = new AlunoDAO(bn);
		if (al.consultar(cpf) != null)
			existe = true;
		return existe;
	}

}
