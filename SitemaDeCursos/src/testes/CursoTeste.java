package testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.Curso;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CursoTeste {
	
	Curso curso, copia;
	
	@Before
	public void setUp() throws Exception {
		curso = new Curso(2, "Teste", "01/04/2016", "01/07/2016", "19:30 - 22:30", 15, 1500);
		copia = new Curso(3, "Teste", "01/04/2016", "01/07/2016", "19:30 - 22:30", 15, 1500);
	}
	
	@Test
	public void test00Carregar() {
		Curso fixture = new Curso(2, "Teste", "01/04/2016", "01/07/2016", "19:30 - 22:30", 15, 1500);
		Curso novo = new Curso(2, "Teste", "01/04/2016", "01/07/2016", "19:30 - 22:30", 15, 1500);
		novo.consultar();
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		curso.cadastrar();
		curso.consultar();
		assertEquals("testa criacao", curso, copia);
	}

	@Test
	public void test02Atualizar() {
		curso.setNome("999999");
		copia.setNome("999999");		
		curso.alterar();
		assertEquals("testa inclusao", curso, copia);
	}

	@Test
	public void test03Excluir() {
		curso.excluir();
		assertEquals("testa inclusao", curso, copia);
	}

}
