package negocio;

import java.util.Calendar;
import java.sql.Date;

import db.AlunoDAO;
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
		CursoDAO cur = new CursoDAO(this, bn);
		if(cur.incluirInfo() ){
			sucesso = true;
			setCodigo(cur.getCodigo());
		}
		return sucesso;
	}
	
	public boolean consultarCurso(){
		boolean sucesso = false;
		CursoDAO cur = new CursoDAO(this, bn);
		cur.consultar(1);
		if(cur.getConsulta()){
			setCodigo(cur.getCodigo());
			setNome(cur.getNome());
			setValor(cur.getValor());
			setDataInicio(tr.converteCalendar(cur.getDataInicio()));
			setDataTermino(tr.converteCalendar(cur.getDataTermino()));
			setHorario(cur.getHorario());
			setNVagas(cur.getNVagas());
			setNLaboratorio(cur.getNLaboratorio());
			setRegSoftware(cur.getRegSoftware());
			sucesso = true;
		}	
		return sucesso;
		
	}
	
	public boolean editarCurso(){
		data_ini_sql = tr.preparaDataDB(data_inicio);
		data_fim_sql = tr.preparaDataDB(data_termino);
		boolean sucesso = false;
		CursoDAO cur = new CursoDAO(this, bn);
		if(cur.editar(1)) sucesso = true;
		return sucesso;
	}
	
	public boolean excluirCurso(){
		boolean sucesso = false;
		CursoDAO cur = new CursoDAO(getCodigo(),bn);
		if(cur.excluir()) sucesso = true;
		return sucesso;
	}
	
}
