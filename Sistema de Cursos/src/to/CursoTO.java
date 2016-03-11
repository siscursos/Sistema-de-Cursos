package to;

import java.sql.Date;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.sql.Date;
//To padrão
public class CursoTO {
	protected int    codigo;
	protected String nome;
	protected String area;
	protected String horario;
	protected int    n_vagas;
	protected double valor;
	protected ResourceBundle bn;
	protected int n_laboratorio;
	protected String reg_software;
	protected Date data_ini_sql;
	protected Date data_fim_sql;
	protected String descricao_material;
	protected String nome_livros;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public int getNVagas() {
		return n_vagas;
	}
	public void setNVagas(int n_vagas) {
		this.n_vagas = n_vagas;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public ResourceBundle getBn() {
		return bn;
	}
	public void setBn(ResourceBundle bn) {
		this.bn = bn;
	}
	public int getNLaboratorio() {
		return n_laboratorio;
	}
	public void setNLaboratorio(int n_laboratorio) {
		this.n_laboratorio = n_laboratorio;
	}
	public String getRegSoftware() {
		return reg_software;
	}
	public void setRegSoftware(String reg_software) {
		this.reg_software = reg_software;
	}
	public Date getDataInicio() {
		return data_ini_sql;
	}
	public void setDataInicio(Date data_ini_sql) {
		this.data_ini_sql = data_ini_sql;
	}
	public Date getDataTermino() {
		return data_fim_sql;
	}
	public void setDataTermino(Date data_fim_sql) {
		this.data_fim_sql = data_fim_sql;
	}
	public String getDescricaoMaterial() {
		return descricao_material;
	}
	public void setDescricaoMaterial(String descricao_material) {
		this.descricao_material = descricao_material;
	}
	public String getNome_livros() {
		return nome_livros;
	}
	public void setNome_livros(String nome_livros) {
		this.nome_livros = nome_livros;
	}
	
	
	
}
