package testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.AlunoDAO;
import to.AlunoTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AlunoDAOTeste {

	AlunoDAO dao;
	AlunoTO to;
	
	@Before
	public void setUp() throws Exception {
		dao = new AlunoDAO();
		to = new AlunoTO();
		to.setcPF("12345678911");
		to.setEmail("email@email.com");
		to.setEndereco("Rua teste");
		to.setNome("NomeTeste");
		to.setrG("123456789");
		to.setSenha("teste");
		to.setTelefone("12345678");
		to.setUser("teste1");
	}
	
	@Test
	public void test00Carregar() {
		//para funcionar o aluno 1 deve ter sido carregado no banco por fora
		//delete from aluno;
		//insert into aluno (nome, endereco, telefone, email, rg, cpf, user, pass) values ('NomeTeste', 'Rua teste','12345678', 'email@email.com', '123456799', '12345678910', 'aluno1', 'senha1');
		
		AlunoTO fixture = new AlunoTO();
		fixture.setcPF("12345678910");
		fixture.setEmail("email@email.com");
		fixture.setEndereco("Rua teste");
		fixture.setNome("NomeTeste");
		fixture.setrG("123456799");
		fixture.setSenha("teste");
		fixture.setTelefone("12345678");
		fixture.setUser("aluno1");
		fixture.setSenha("senha1");
		AlunoTO novo = dao.consultar("12345678910");
		assertEquals("testa Consulta", novo, fixture);
	}

	@Test
	public void test01Inserir() {
		dao.cadastrar(to);
		AlunoTO novo = dao.consultar(to.getcPF());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test02Atualizar() {
		to.setTelefone("999999");
		dao.alterar(to);
		AlunoTO novo = dao.consultar(to.getcPF());
		assertEquals("testa Alterar", novo, to);
	}
	
	@Test
	public void test03Excluir() {
		to.setEmail(null);
		to.setEndereco(null);
		to.setNome(null);
		to.setrG(null);
		to.setSenha(null);
		to.setTelefone(null);
		to.setUser(null);
		dao.excluir(to.getcPF());
		AlunoTO novo = dao.consultar(to.getcPF());
		to.setcPF(null);
		assertEquals("testa inclusao", novo, to);
	}
	
}
