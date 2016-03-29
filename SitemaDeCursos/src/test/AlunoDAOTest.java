package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import db.AlunoDAO;
import to.AlunoTO;

public class AlunoDAOTest {
	AlunoDAO dao;
	AlunoTO  to;
	
	@Before
	public void setUp() throws Exception {
		dao = new AlunoDAO();
		to = new AlunoTO();
		to.setNome("Teste");
		to.setEndereco("Rua de Teste, 77");
		to.setTelefone("985214124");
		to.setEmail("teste@teste.com");
		to.setRG("854214578");
		to.setCPF("45214547898");
		to.setLogin("teste1");
		to.setSenha("senha12");
	}
	@Test
	public void test00Consultar() {
		
		AlunoTO fixture = new AlunoTO();
		
		fixture.setNome("Teste2");
		fixture.setEndereco("Rua de Teste, 70");
		fixture.setTelefone("985214125");
		fixture.setEmail("teste2@teste.com");
		fixture.setRG("854214443");
		fixture.setCPF("45214547212");
		fixture.setLogin("teste2");
		fixture.setSenha("senha15");
		AlunoTO novo = dao.consultar("45214547212");
		assertEquals("testa consulta", novo, fixture);
	}

	@Test
	public void test01Inserir() {
		dao.incluir(to);
		AlunoTO novo = dao.consultar(to.getCPF());
		novo.setCPF(to.getCPF());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test02Editar() {
		to.setTelefone("999999");
		dao.editar(to);
		AlunoTO novo = dao.consultar(to.getCPF());
		novo.setCPF(to.getCPF());
		assertEquals("testa inclusao", novo, to);
	}
	@Test
	public void test03Excluir() {
		to.setNome(null);
		to.setEndereco(null);
		to.setTelefone(null);
		to.setEmail(null);
		to.setRG(null);
		to.setLogin(null);
		to.setSenha(null);
		dao.excluir(to);
		AlunoTO novo = dao.consultar(to.getCPF());
		novo.setCPF(to.getCPF());
		assertEquals("testa inclusao", novo, to);
	}
}
