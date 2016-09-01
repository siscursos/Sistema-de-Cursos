package negocio;

import java.util.Calendar;
import java.sql.Date;

import db.CursoDAO;
import to.CursoTO;

public class Artes extends Curso{
	protected String descricao_material;
	protected String nome_livros;
	protected Date data_ini_sql;
	protected Date data_fim_sql;
	protected Tratamento tr = new Tratamento();
	
	public Artes(int codigo, String nome, String area, Calendar data_inicio, Calendar data_termino, 
			String horario, int n_vagas, double valor,String descricao_material)
	{
		super(codigo, nome, area, data_inicio, data_termino, horario, n_vagas, valor);
		setDescricaoMaterial(descricao_material);
	}
	
	public Artes(String nome, String area, Calendar data_inicio, Calendar data_termino, 
			String horario, int n_vagas, double valor,String descricao_material)
	{
		super(nome, area, data_inicio, data_termino, horario, n_vagas, valor);
		setDescricaoMaterial(descricao_material);
	}
	
	public Artes(int codigo){
		super(codigo);
	}
	
	//sets
	public void setDescricaoMaterial(String descricao_material){this.descricao_material = descricao_material;}
	public void setNomeLivros(String nome_livros){this.nome_livros = nome_livros;};
	//gets
	public String getDescricaoMaterial(){return descricao_material;}
	public String getNomeLivros(){return nome_livros;}
	public Date getDataIniSql(){return data_ini_sql;}
	public Date getDataFimSql(){return data_fim_sql;}
	
	public boolean cadastrarCurso(){
		data_ini_sql = tr.preparaDataDB(data_inicio);
		data_fim_sql = tr.preparaDataDB(data_termino);
		boolean sucesso = false;
		int code = geraCodigo();
		CursoDAO cur = new CursoDAO(bn);
		CursoTO   to  = new CursoTO();
		
		to.setCodigo(codigo);
		to.setNome(nome);
		to.setArea(area);
		to.setDataInicio(data_ini_sql);
		to.setDataTermino(data_fim_sql);
		to.setHorario(horario);
		to.setNVagas(n_vagas);
		to.setValor(valor);
		to.setDescricaoMaterial(descricao_material);
		to.setNome_livros(nome_livros);
		
		if(cur.incluir(to) && cur.incluirAt(to) ){
			sucesso = true;
			setCodigo(code);
		}
		return sucesso;
	}
	
	public boolean consultarCurso(){
		boolean sucesso = false;
		setCodArea(2);
		CursoDAO cur = new CursoDAO(bn);
		CursoTO to = cur.consultar(getCodArea(), codigo);
		
		if(cur.getConsulta()){
			setCodigo(to.getCodigo());
			setNome(to.getNome());
			setValor(to.getValor());
			setDataInicio(tr.converteCalendar(to.getDataInicio()));
			setDataTermino(tr.converteCalendar(to.getDataTermino()));
			setHorario(to.getHorario());
			setNVagas(to.getNVagas());
			setDescricaoMaterial(to.getDescricaoMaterial());
			setNomeLivros(to.getNome_livros());;
			sucesso = true;
		}	
		return sucesso;
		
	}
	
	public boolean editarCurso(){
		data_ini_sql = tr.preparaDataDB(data_inicio);
		data_fim_sql = tr.preparaDataDB(data_termino);
		boolean sucesso = false;
		CursoTO   to  = new CursoTO();
		CursoDAO cur = new CursoDAO(bn);
		
		to.setCodigo(codigo);
		to.setNome(nome);
		to.setArea(area);
		to.setCodArea(codArea);
		to.setDataInicio(data_ini_sql);
		to.setDataTermino(data_fim_sql);
		to.setHorario(horario);
		to.setNVagas(n_vagas);
		to.setValor(valor);
		to.setDescricaoMaterial(descricao_material);;
		to.setNome_livros(nome_livros);
		
		if(cur.editar(to)) sucesso = true;
		return sucesso;
	}
	
	public boolean excluirCurso(){
		boolean sucesso = false;
		CursoTO   to  = new CursoTO();
		CursoDAO cur = new CursoDAO(bn);
		to.setCodigo(codigo);
		if(cur.excluir(to)) sucesso = true;
		return sucesso;
	}
}
