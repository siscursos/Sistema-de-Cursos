package testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.CursoDAO;
import to.CursoTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CursoDAOTeste {

	CursoDAO dao;
	CursoTO to;
	
	@Before
	public void setUp() throws Exception {
		dao = new CursoDAO();
		to = new CursoTO();
		to.setNome("Teste");
		to.setVagas(15);
		to.setHora("19:30 - 22:30");
		to.setValor(1500);
		to.setDataInicio("2016/04/01");
		to.setDataTermino("2016/07/01");
	}
	
	@Test
	public void test00Carregar() {
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		//insert into cliente (id, nome, fone) values (1, 'nome1', 'fone1');
		CursoTO fixture = new CursoTO();
		fixture.setIdCurso(1);
		fixture.setNome("Teste");
		fixture.setVagas(15);
		fixture.setHora("19:30 - 22:30");
		fixture.setValor(1500);
		fixture.setDataInicio("2016/04/01");
		fixture.setDataTermino("2016/07/01");
		CursoTO novo = dao.consultar(1);
		novo.setIdCurso(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Inserir() {
		dao.cadastrar(to);
		CursoTO novo = dao.consultar(to.getIdCurso());
		novo.setIdCurso(to.getIdCurso());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test02Atualizar() {
		to.setNome("Teste1");
		dao.alterar(to);
		CursoTO novo = dao.consultar(to.getIdCurso());
		novo.setIdCurso(to.getIdCurso());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test03Excluir() {
		dao.excluir(to.getIdCurso());
		CursoTO novo = dao.consultar(to.getIdCurso());
		novo.setIdCurso(to.getIdCurso());
		assertEquals("testa inclusao", novo, to);
	}
}
