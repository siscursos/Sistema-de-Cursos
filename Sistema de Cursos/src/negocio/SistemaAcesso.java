package negocio;

import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class SistemaAcesso {
	String dados;
	ArrayList<String> array = new ArrayList<String>();
	String[] vetor;
	
	public SistemaAcesso(String d){
		dados = d;
	}
	    
	public boolean registraDados(){
		boolean inserido = false;
		File arq = new File("sistema_acesso.txt");
		if(!arq.exists()){
			try
		      {
		         Formatter sis = new Formatter("sistema_acesso.txt");
		         insereDados();
				 sis.close();
				 inserido = true;
		      }
		      catch(Exception erro){
		    	  JOptionPane.showMessageDialog(null, "Não foi possível criar usuário e senha, favor contatar o suporte técnico");
		    	  inserido = false;
		      }
			
			
		}
		else{
			insereDados();
			inserido = true;
		}
		return inserido;
		
	}
	
	public boolean consultaDados(){
		boolean criado = false;
		File arq = new File("sistema_acesso.txt");
		if(!arq.exists()){
			try
		      {
		         Formatter sis = new Formatter("sistema_acesso.txt");
		         criado = true;
		         procuraDados(dados);
				 sis.close();
		         
		      }
		      catch(Exception erro){
		    	  criado = false;
		      }	
		}
		else{
			procuraDados(dados);
			criado = true;
		}
		return criado;
		
	}
	
	public boolean insereDados(){
		boolean insere = false;
			try{
				PrintWriter insereDado = new PrintWriter("sistema_acesso.txt");
				insereDado.printf(dados);
				insere = true;
				insereDado.close();
			}
			catch(Exception erro){
				insere = false;
			}
		return insere;
	}
	
	public boolean preparaVetor(){
		String linha = "";
		boolean vetorfeito = false;
		try{
			Scanner sc =new Scanner("sistema_acesso.txt");
			while (sc.hasNext()) {  
			    linha = sc.nextLine();
			    array.add(linha);
			    
			}
			vetor = array.toArray(new String[array.size()]);
			Arrays.sort(vetor);
			vetorfeito = true;
			sc.close();
         }
		 
         
         catch(Exception erro) {
        	 vetorfeito = false;
         }
		return vetorfeito;
	}
	
	public boolean procuraDados(String userpass){
		boolean encontrou = false;
		if(preparaVetor()){
			if(Arrays.binarySearch(vetor, userpass)<0){
				encontrou = false;
			}
			else encontrou = true;
		}
		return encontrou;
		
	}
	
}
