package to;

public class CursoTO
{
	private int idCurso;
	private String nome;
	private String dataInicio;
	private String dataTermino;
	private String hora;
	private int numeroVagas;
	private double valor;
	
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

}
