package model;

import java.util.Date;

public class Artes extends Curso{
	protected String descricao_material;
	protected String nome_livros;
	public Artes() {
		super();
	}
	public Artes(int codigo, int codigoArea, String nome, Date dataInicio, Date dataTermino, String hora, int vagas,
			double valor, String descricao_material, String nome_livros) {
		super(codigo, codigoArea, nome, dataInicio, dataTermino, hora, vagas, valor);
		this.descricao_material = descricao_material;
		this.nome_livros        = nome_livros;
	}
	
	public String getDescricao_material() {
		return descricao_material;
	}
	public String getNome_livros() {
		return nome_livros;
	}
	public void setDescricao_material(String descricao_material) {
		this.descricao_material = descricao_material;
	}
	public void setNome_livros(String nome_livros) {
		this.nome_livros = nome_livros;
	}
	
	
}
