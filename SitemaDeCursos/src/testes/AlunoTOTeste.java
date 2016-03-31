package testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import to.AlunoTO;

public class AlunoTOTeste {

	AlunoTO to;
	
	@Before
	public void setUp() throws Exception {
		to = new AlunoTO();
		to.setTelefone("123456789");
		to.setNome("Teste");
		to.setCPF("12345678911");
	}

	@Test
	public void testGets() {
		assertEquals("getNome", to.getNome(), "Teste");
		assertEquals("getTelefone", to.getTelefone(), "123456789");
		assertEquals("getCPF", to.getCPF(), 3);
	}
	
	@Test
	public void testEquals(){
		AlunoTO copia = new AlunoTO();
		copia.setTelefone(to.getTelefone());
		copia.setNome(to.getNome());
		copia.setCPF(to.getCPF());
		assertEquals("teste to igual a copia", to, copia);
	}

}
