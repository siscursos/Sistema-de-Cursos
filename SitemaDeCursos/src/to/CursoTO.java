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
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CursoTO other = (CursoTO) obj;
			if (dataInicio == null) {
				if (other.dataInicio != null)
					return false;
			} else if (!dataInicio.equals(other.dataInicio))
				return false;
			if (dataTermino == null) {
				if (other.dataTermino != null)
					return false;
			} else if (!dataTermino.equals(other.dataTermino))
				return false;
			if (hora == null) {
				if (other.hora != null)
					return false;
			} else if (!hora.equals(other.hora))
				return false;
			if (idCurso != other.idCurso)
				return false;
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
				return false;
			if (numeroVagas != other.numeroVagas)
				return false;
			if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
				return false;
			return true;
		}

}
