package negocio;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class Tratamento {
	public Tratamento(){
		
	}
	
	public boolean checaVazio(String texto){
		boolean vazio = false;
		if(texto.length()<=0)vazio = true;
		return vazio;
	}
	
	public Date preparaDataDB(Calendar data){
		Date dataSQL = new Date(data.getTimeInMillis());
		return dataSQL;
	}
	
	public boolean checkData(JDateChooser chooser){
		boolean correto = true;
		if(chooser.getDate() == null){
			correto = false;
		}
		return correto;
	}
	
	public boolean checaCampoVazio(JTextField txt){
		boolean vazio = false;
		if(txt.getText()== null)vazio = true;
		return vazio;
	}
	
	public Calendar converteCalendar(java.sql.Date date){
		 Calendar cal = new GregorianCalendar();
	     cal.setTime(date);
	     return cal;
	}
}
