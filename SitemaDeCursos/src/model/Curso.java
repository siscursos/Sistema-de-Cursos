package model;

import dao.CursoDAO;
import to.CursoTO;

public class Curso
{
	private int idCurso;
	private String nome;
	private String dataInicio;
	private String dataTermino;
	private String hora;
	private int numeroVagas;
	private double valor;

	public Curso()
	{

	}

	public Curso(int idC, String nome, String dInicio, String dTermino, String hora, int nVagas, double valor)
	{
		setIdCurso(idC);
		setNome(nome);
		setDataInicio(dInicio);
		setDataTermino(dTermino);
		setHora(hora);
		setVagas(nVagas);
		setValor(valor);

	}

	// SET
	public void setIdCurso(int idC)
	{
		this.idCurso = idC;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public void setDataInicio(String dInicio)
	{
		this.dataInicio = dInicio;
	}

	public void setDataTermino(String dTermino)
	{
		this.dataTermino = dTermino;
	}

	public void setHora(String h)
	{
		this.hora = h;
	}

	public void setVagas(int vagas)
	{
		this.numeroVagas = vagas;
	}

	public void setValor(double valor)
	{
		this.valor = valor;
	}

	
	//GET
	public int getIdCurso()
	{
		return idCurso;
	}

	public String getNome()
	{
		return nome;
	}

	public String getDataInicio()
	{
		return dataInicio;
	}

	public String getDataTermino()
	{
		return dataTermino;
	}

	public String getHora()
	{
		return hora;
	}

	public int getVagas()
	{
		return numeroVagas;
	}

	public double getValor()
	{
		return valor;}


	
	//Metodos CRUD
	public boolean cadastrar()
	{
		CursoDAO dao = new CursoDAO();
		CursoTO to = new CursoTO();
		
		to.setIdCurso(idCurso);
		to.setNome(nome);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHora(hora);
		to.setVagas(numeroVagas);
		to.setValor(valor);
		
		return dao.cadastrar(to);
	}
	
	public CursoTO consultar()
	{
		CursoDAO dao = new CursoDAO();
		CursoTO to = dao.consultar(idCurso);
		
		setIdCurso(to.getIdCurso());
		setNome(to.getNome());
		setDataInicio(to.getDataInicio());
		setDataTermino(to.getDataTermino());
		setHora(to.getHora());
		setVagas(to.getVagas());
		setValor(to.getValor());
		
		return to;
	}
	
	public boolean excluir()
	{
		CursoDAO dao = new CursoDAO();
		return dao.excluir(idCurso);
	}
	
	public boolean alterar()
	{
		CursoDAO dao = new CursoDAO();
		CursoTO to = new CursoTO();
		
		to.setIdCurso(idCurso);
		to.setNome(nome);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHora(hora);
		to.setVagas(numeroVagas);
		to.setValor(valor);
		
		return dao.alterar(to);
	}
	
	
	
	//Outros
	@Override
	public String toString() {
		return getNome() + " - " + getDataInicio() + " / " + getDataTermino() +
				" - " + getHora() + " - " + getVagas() + " vagas - " + getValor(); 
	}
	
	
}
