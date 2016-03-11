package negocio;
import java.util.Calendar;

public class LogMatricula {
	private Calendar data;
	private String hora;
	private String nome_atendente;
	private String operacao;
	
	public LogMatricula(String nome_atendente, String operacao){
		setNomeAtendente(nome_atendente);
		setOperacao(operacao);
	}
	
	public void setNomeAtendente(String nome_atendente){this.nome_atendente = nome_atendente;}
	public void setOperacao(String operacao){this.operacao = operacao;}
	
	public String getNomeAtendente(){return nome_atendente;}
	public String getOperacao(){return operacao;}
}
