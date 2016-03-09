package negocio;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;

import db.AlunoDAO;
import db.CursoDAO;

public class Curso {
	protected int    codigo;
	protected String nome;
	protected String area;
	protected Calendar data_inicio;
	protected Calendar data_termino;
	protected String horario;
	protected int    n_vagas;
	protected double valor;
	protected ResourceBundle bn;
	
	public Curso(int codigo, String nome, String area, Calendar data_inicio, Calendar data_termino, String horario, int n_vagas, double valor){
		setCodigo(codigo);
		setArea(area);
		setNome(nome);
		setDataInicio(data_inicio);
		setDataTermino(data_termino);
		setHorario(horario);
		setNVagas(n_vagas);
		setValor(valor);
	}
	
	public Curso(int codigo){
		setCodigo(codigo);
	}
	
	public Curso(String nome, String area,  Calendar data_inicio, Calendar data_termino, String horario, int n_vagas, double valor){
		setCodigo(codigo);
		setArea(area);
		setNome(nome);
		setDataInicio(data_inicio);
		setDataTermino(data_termino);
		setHorario(horario);
		setNVagas(n_vagas);
		setValor(valor);
	}
	
	
	public Curso(){
		
	}
	
	//sets
	public void setCodigo(int codigo)              {this.codigo=codigo;}
	public void setArea(String area)              {this.area=area;}
	public void setNome(String nome)               {this.nome = nome;}
	public void setDataInicio(Calendar data_inicio)  {this.data_inicio = data_inicio;}
	public void setDataTermino(Calendar data_termino){this.data_termino = data_termino;}
	public void setHorario(String horario)         {this.horario = horario;}
	public void setNVagas(int n_vagas)             {this.n_vagas = n_vagas;}
	public void setValor(double valor)             {this.valor = valor;}
	
	//gets
	
	public int getCodigo()          {return codigo;}
	public String getArea()		    {return area;}
	public String getNome()         {return nome;}
	public Calendar getDataInicio() {return data_inicio;}
	public Calendar getDataTermino(){return data_termino;}
	public String getHorario()      {return horario;}
	public int getNVagas()          {return n_vagas;}
	public double getValor()        {return valor;}
	
	public int geraCodigo() {
		int cod;
		Random gerador = new Random();
		cod = gerador.nextInt(9999);
		CursoDAO cur = new CursoDAO(bn);
		
		do {			
			cod = gerador.nextInt(9999);			
		} while (cur.consultar(1, cod) != null);
		return cod;
	}
	
	public String [] preparaVetorNome(int cod, String area){
		CursoDAO cur = new CursoDAO(bn);
		int [] vInt = cur.consultaCursosPorArea(area);
		String[] nomes = new String[vInt.length];
		for(int i = 0; i<nomes.length; i++){
			nomes[i] = cur.consultaNome(vInt[i]);
		}
		return nomes;
	}
	

}
