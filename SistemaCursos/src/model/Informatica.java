package model;

import java.util.Date;

public class Informatica extends Curso{
	protected int n_laboratorio;
	protected String reg_softwares;
	public Informatica() {
		super();
	}
	
	public Informatica(int codigo, int codigoArea, String nome, Date dataInicio, Date dataTermino, String hora,
			int vagas, double valor, int n_laboratorio, String reg_softwares) {
		super(codigo, codigoArea, nome, dataInicio, dataTermino, hora, vagas, valor);
		this.n_laboratorio = n_laboratorio;
		this.reg_softwares = reg_softwares;
		
	}

	public int getN_laboratorio() {
		return n_laboratorio;
	}

	public String getReg_softwares() {
		return reg_softwares;
	}

	public void setN_laboratorio(int n_laboratorio) {
		this.n_laboratorio = n_laboratorio;
	}

	public void setReg_softwares(String reg_softwares) {
		this.reg_softwares = reg_softwares;
	}
	
	
	
}
