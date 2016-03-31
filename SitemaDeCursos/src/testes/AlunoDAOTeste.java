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
		to.setCPF("12345678911");
		to.setEmail("email@email.com");
		to.setEndereco("Rua teste");
		to.setNome("NomeTeste");
		to.setRG("123456789");
		to.setSenha("teste");
		to.setTelefone("12345678");
	}
	
	@Test
	public void test00Carregar() {
		AlunoTO fixture = new AlunoTO();
		fixture.setCPF("12345678911");
		fixture.setEmail("email@email.com");
		fixture.setEndereco("Rua teste");
		fixture.setNome("NomeTeste");
		fixture.setRG("123456789");
		fixture.setSenha("teste");
		fixture.setTelefone("12345678");
		AlunoTO novo = dao.consultar("12345678911");
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Inserir() {
		dao.cadastrar(to);
		AlunoTO novo = dao.consultar(to.getCPF());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test02Atualizar() {
		to.setTelefone("999999");
		dao.alterar(to);
		AlunoTO novo = dao.consultar(to.getCPF());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test03Excluir() {
		to.setEmail(null);
		to.setEndereco(null);
		to.setNome(null);
		to.setRG(null);
		to.setSenha(null);
		to.setTelefone(null);
		dao.excluir(to.getCPF());
		AlunoTO novo = dao.consultar(to.getCPF());
		assertEquals("testa inclusao", novo, to);
	}
	
}
