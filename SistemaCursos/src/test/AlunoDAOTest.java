package test;

import static org.junit.Assert.assertEquals;


import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.AlunoDAO;
import to.AlunoTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AlunoDAOTest {
	static AlunoDAO dao;
	static AlunoTO to;
	
	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco
	 * nenhuma linha com o id igual ao do escolhido para o to instanciado
	 * abaixo. Se houver, delete. 
	 * Certifique-se de que o fixture aluno existe no banco.
	 * Certifique-se também que sobrecarregou o equals na classe AlunoTO
	 * Além disso, a ordem de execução dos testes é importante; por isso a anotação
	 * FixMethodOrder logo acima do nome desta classe
	 */
	
	@BeforeClass
	public static void setUp() throws Exception{
		dao = new AlunoDAO();
		to = new AlunoTO();
		to.setNome("Italo");
		to.setEnd("Rua dos Testes, 58");
		to.setTel("(11)9999-9999");
		to.setEmail("italo_teste@teste.com.br");
		to.setRg("52214477-X");
		to.setCpf("42521635842");
		to.setUser("italoteste");
		to.setPass("teste");
		
	}
	
	@Test
	public void test00Carregar() {
		//para funcionar o aluno deve ter sido carregado no banco por fora
		//delete from aluno;
		//insert into aluno (nome, endereco, telefone, email, rg, cpf, user, pass) values ('NomeTeste', 'Rua teste','12345678', 'email@email.com', '123456799', '12345678910', 'aluno1', 'senha1');
		AlunoTO fixture = new AlunoTO();
		fixture.setNome("NomeTeste");
		fixture.setEnd("Rua teste");
		fixture.setTel("12345678");
		fixture.setEmail("email@email.com");
		fixture.setRg("123456799");
		fixture.setCpf("12345678910");
		fixture.setUser("aluno1");
		fixture.setPass("senha1");
		AlunoTO novo = dao.carregar("12345678910");
		assertEquals("testa inclusao", novo, fixture);
	}
	
	@Test
	public void test01Inserir() {
		dao.incluir(to);
		AlunoTO novo = dao.carregar(to.getCpf());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test02Atualizar() {
		to.setTel("999999");
		dao.atualizar(to);
		AlunoTO novo = dao.carregar(to.getCpf());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test03Excluir() {
		to.setNome(null);
		to.setEnd(null);
		to.setTel(null);
		to.setEmail(null);
		to.setRg(null);
		to.setUser(null);
		to.setPass(null);
		dao.excluir(to);
		to.setCpf(null);
		AlunoTO novo = dao.carregar(to.getCpf());
		
		assertEquals("testa exclusão", novo, to);
	}

}
