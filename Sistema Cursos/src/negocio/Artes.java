package negocio;

import java.util.Calendar;
import java.sql.Date;

import db.CursoDAO;

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
	
	//gets
	public String getDescricaoMaterial(){return descricao_material;}
	public Date getDataIniSql(){return data_ini_sql;}
	public Date getDataFimSql(){return data_fim_sql;}
	
	public boolean cadastrarCurso(){
		boolean sucesso = false;
		data_ini_sql = tr.preparaDataDB(data_inicio);
		data_fim_sql = tr.preparaDataDB(data_termino);
		CursoDAO cur = new CursoDAO(this, bn);
		if(cur.incluirAt() ) sucesso = true;
		return sucesso;
	}
	
	public boolean consultarCurso(){
		boolean sucesso = false;
		CursoDAO cur = new CursoDAO(this, bn);
		cur.consultar(2);
		if(cur.getConsulta()){
			setCodigo(cur.getCodigo());
			setNome(cur.getNome());
			setValor(cur.getValor());
			setDataInicio(tr.converteCalendar(cur.getDataInicio()));
			setDataTermino(tr.converteCalendar(cur.getDataTermino()));
			setHorario(cur.getHorario());
			setNVagas(cur.getNVagas());
			setDescricaoMaterial(cur.getDescricaoMaterial());
			sucesso = true;
		}	
		return sucesso;
		
	}
	
	public boolean editarCurso(){
		data_ini_sql = tr.preparaDataDB(data_inicio);
		data_fim_sql = tr.preparaDataDB(data_termino);
		boolean sucesso = false;
		CursoDAO cur = new CursoDAO(this, bn);
		if(cur.editar(2)) sucesso = true;
		return sucesso;
	}
	
	public boolean excluirCurso(){
		boolean sucesso = false;
		CursoDAO cur = new CursoDAO(getCodigo(),bn);
		if(cur.excluir()) sucesso = true;
		return sucesso;
	}
}
