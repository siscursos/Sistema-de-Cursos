package to;

import java.util.Date;

public class CursoTO {
	protected int codigo;
	protected int codigoArea;
	protected String nome;
	protected Date dataInicio;
	protected Date dataTermino;
	protected String hora;
	protected int vagas;
	protected double valor;
	
	public CursoTO(int codigo, int codigoArea, String nome, Date dataInicio, Date dataTermino, String hora, int vagas,
			double valor) {
		
		this.codigo = codigo;
		this.codigoArea = codigoArea;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.hora = hora;
		this.vagas = vagas;
		this.valor = valor;
	}

	public CursoTO() {
		
	}

	public int getCodigo() {
		return codigo;
	}

	public int getCodigoArea() {
		return codigoArea;
	}

	public String getNome() {
		return nome;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public String getHora() {
		return hora;
	}

	public int getVagas() {
		return vagas;
	}

	public double getValor() {
		return valor;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setCodigoArea(int codigoArea) {
		this.codigoArea = codigoArea;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
