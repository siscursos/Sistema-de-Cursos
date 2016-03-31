package testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import to.CursoTO;

public class CursoTOTeste {

	CursoTO to;
	
	@Before
	public void setUp() throws Exception {
		to = new CursoTO();
		to = new CursoTO();
		to.setIdCurso(1);
		to.setNome("Teste");
		to.setVagas(15);
		to.setHora("19:30 - 22:30");
		to.setValor(1500);
		to.setDataInicio("01/04/2016");
		to.setDataTermino("01/07/2016");
	}

	@Test
	public void testGets() {
		assertEquals("getNome", to.getNome(), "Teste");
		assertEquals("getIdCurso", to.getIdCurso(), 1);
		assertEquals("getVagas", to.getVagas(), 15);
		assertEquals("getHora", to.getHora(), "19:30 - 22:30");
		//assertEquals("getValor", to.getValor(), 1500.00);
		assertEquals("getDataInicio", to.getDataInicio(), "01/04/2016");
		assertEquals("getDataTermino", to.getDataTermino(), "01/07/2016");
	}
	
	@Test
	public void testEquals(){
		CursoTO copia = new CursoTO();
		copia.setIdCurso(to.getIdCurso());
		copia.setNome(to.getNome());
		copia.setVagas(to.getVagas());
		copia.setHora(to.getHora());
		copia.setValor(1500);
		copia.setDataInicio(to.getDataInicio());
		copia.setDataTermino(to.getDataTermino());
		assertEquals("teste to igual a copia", to, copia);
	}
}
