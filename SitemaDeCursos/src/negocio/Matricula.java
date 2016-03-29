package negocio;
import java.sql.Date;
import java.util.Calendar;

import db.CursoDAO;
import db.MatriculaDAO;
public class Matricula {
	private int    codigo_matricula;
	private Calendar data_matricula;
	private double valor_matricula;
	private String status_matricula;
	private int [] codigo_curso;
	private int [] listacursos;
	protected Date data_matricula_sql;
	private String aluno_cpf;
	private String [] cursos;
	
	Tratamento tr = new Tratamento();
	
	public Matricula(Calendar data_matr, double valor_matr, String status_matr, String[] cursos, String aluno_cpf){
		setValorMatricula(valor_matr);
		setDataMatricula(data_matr);
		setStatusMatricula(status_matr);
		setCursos(cursos);
		setAlunoCPF(aluno_cpf);
				
	}
	
	public Matricula(){	}
	
	public Matricula(String cpf ,int [] listacursos){
		setListaCursos(listacursos);
		setAlunoCPF(cpf);
	}
	
	//sets
	public void setCodigoMatricula(int codigo_matricula)   {this.codigo_matricula= codigo_matricula;}
	public void setDataMatricula(Calendar data_matricula)    {this.data_matricula=data_matricula;}
	public void setValorMatricula(double valor_matricula)  {this.valor_matricula = valor_matricula;}
	public void setStatusMatricula(String status_matricula){this.status_matricula= status_matricula;}
	public void setCodigoCurso(int [] codigo_curso){this.codigo_curso = codigo_curso;}
	public void setCursos (String[] cursos){this.cursos = cursos;}
	public void setListaCursos (int[] listacursos){this.listacursos = listacursos;}
	public void setAlunoCPF(String aluno_cpf){this.aluno_cpf = aluno_cpf;}
	
	//gets
	public int getCodigoMatricula(){return codigo_matricula;}
	public Calendar getDataMatricula(){return data_matricula;}
	public String getStatusMatricula(){return status_matricula;}
	public double getValorMatricula(){return valor_matricula;}
	public int [] getCodigoCurso(){return codigo_curso;}
	public int [] getListaCursos(){return listacursos;}
	public Date getDataMatriculaSql(){return data_matricula_sql;}
	public String getAlunoCPF(){return aluno_cpf;}
	
	public int[] buscacodigos(){
		int codigos[]= new int[cursos.length];
		CursoDAO cur = new CursoDAO();
		for(int i= 0; i<codigos.length; i++){
			codigos[i] = cur.consultaCursosPorNome(cursos[i]);
			
		}
		return codigos;
	}
	
	public boolean cadastraMatricula(){
		boolean sucesso = false;
		CursoDAO curso = new CursoDAO();
		setCodigoCurso(buscacodigos());
		MatriculaDAO mt = new MatriculaDAO(this);
		if(mt.cadastraMatricula())sucesso = true;
		int [] codigos = getCodigoCurso();
		for(int i = 0; i<codigos.length; i++){
			int codigo = codigos[i];
			curso.preencheVaga(codigo, );
		}
		return sucesso;
	}
	
	
	
	public String [] nomeCursosInfo(){
		CursoDAO cur = new CursoDAO();
		String [] listanomes = cur.consultaCursosInfo();
		return listanomes;
	}
	
	public String [] nomeCursosArtes(){
		CursoDAO cur = new CursoDAO();
		String [] listanomes = cur.consultaCursosArtes();
		return listanomes;
	}
	
	
}
