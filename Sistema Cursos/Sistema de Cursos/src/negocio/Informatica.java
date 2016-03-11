package negocio;

import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

import db.CursoDAO;

public class Informatica extends Curso{
	protected int n_laboratorio;
	protected String reg_software;
	protected Date data_ini_sql;
	protected Date data_fim_sql;
	protected Tratamento tr = new Tratamento();
	
	public Informatica(int codigo, String nome, String area, Calendar data_inicio, Calendar data_termino, 
			String horario, int n_vagas, double valor,int n_laboratorio, String reg_software)
	{
		super(codigo, area, nome, data_inicio, data_termino, horario, n_vagas, valor);
		setNLaboratorio(n_laboratorio);
		setRegSoftware(reg_software);
	}
	
	public Informatica(String nome, String area, Calendar data_inicio, Calendar data_termino, 
			String horario, int n_vagas, double valor,int n_laboratorio, String reg_software)
	{
		super(nome, area, data_inicio, data_termino, horario, n_vagas, valor);
		setNLaboratorio(n_laboratorio);
		setRegSoftware(reg_software);
	}
	
	public Informatica(int codigo){
		super(codigo);
	}
	
	//sets
	public void setNLaboratorio(int n_laboratorio) {this.n_laboratorio = n_laboratorio;}
	public void setRegSoftware(String reg_software){this.reg_software  = reg_software;}
	
	//gets
	public int getNLaboratorio(){return n_laboratorio;}
	public String getRegSoftware(){return reg_software;}
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
		to.setNLaboratorio(n_laboratorio);
		to.setRegSoftware(reg_software);
		
		if(cur.incluir(to) && cur.incluirInfo(to) ){
			sucesso = true;
			setCodigo(code);
		}
		return sucesso;
	}
	
	public boolean consultarCurso(){
		boolean sucesso = false;
		CursoDAO cur = new CursoDAO(bn);
		CursoTO to = cur.consultar(1, codigo);
		if(cur.getConsulta()){
			setCodigo(to.getCodigo());
			setNome(to.getNome());
			setValor(to.getValor());
			setDataInicio(tr.converteCalendar(to.getDataInicio()));
			setDataTermino(tr.converteCalendar(to.getDataTermino()));
			setHorario(to.getHorario());
			setNVagas(to.getNVagas());
			setNLaboratorio(to.getNLaboratorio());
			setRegSoftware(to.getRegSoftware());
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
		to.setDataInicio(data_ini_sql);
		to.setDataTermino(data_fim_sql);
		to.setHorario(horario);
		to.setNVagas(n_vagas);
		to.setValor(valor);
		to.setNLaboratorio(n_laboratorio);
		to.setRegSoftware(reg_software);
		
		if(cur.editar(to, 1)) sucesso = true;
		return sucesso;
	}
	
	public boolean excluirCurso(){
		boolean sucesso = false;
		CursoDAO cur = new CursoDAO(bn);
		CursoTO to   = new CursoTO();
		to.setCodigo(codigo);
		if(cur.excluir(to)) sucesso = true;
		return sucesso;
	}
	
}
