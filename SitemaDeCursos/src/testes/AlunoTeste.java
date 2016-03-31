package testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.Aluno;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AlunoTeste {
	Aluno aluno, copia;
	
	@Before
	public void setUp() throws Exception {
		aluno = new Aluno("Teste", "Rua Teste", "12345678", "email@email.com", "123456789", "12345678911", "teste");
		copia = new Aluno("Teste", "Rua Teste", "12345678", "email@email.com", "123456789", "12345678912", "teste");
	}
	
	@Test
	public void test00Carregar() {
		Aluno fixture = new Aluno("Teste", "Rua Teste", "12345678", "email@email.com", "123456789", "12345678911", "teste");
		Aluno novo = new Aluno("Teste", "Rua Teste", "12345678", "email@email.com", "123456789", "12345678912", "teste");
		novo.consultar();
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		aluno.cadastrar();
		aluno.consultar();
		assertEquals("testa criacao", aluno, copia);
	}

	@Test
	public void test02Atualizar() {
		aluno.setTelefone("999999");
		copia.setTelefone("999999");		
		aluno.alterar();
		assertEquals("testa inclusao", aluno, copia);
	}

	@Test
	public void test03Excluir() {
		aluno.excluir();
		assertEquals("testa inclusao", aluno, copia);
	}

}
