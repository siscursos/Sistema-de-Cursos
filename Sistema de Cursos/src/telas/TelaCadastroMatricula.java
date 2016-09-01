package telas;
import javax.swing.*;

import negocio.Aluno;
import negocio.Matricula;
import negocio.Tratamento;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

public class TelaCadastroMatricula extends JInternalFrame implements ActionListener{
	
	private JLabel lArea;
	private JLabel lCPF;
	private JTextField tCPF;
	private JComboBox cArea;
	private JButton bOK;
	private JButton bCancelar;
	private JButton bConsultar;
	private String resultado = ""; 
	private ResourceBundle bn = null;
	Matricula matricula = new Matricula();
	String []  listacursosinfo = matricula.nomeCursosInfo();
	String []  listacursosartes = matricula.nomeCursosArtes();
	String[] cursos = {"", "Informática", "Artes"};
	Panel pi3 = new Panel();
	Panel pi4 = new Panel();
	JCheckBox checkbox;
	ArrayList<String> cur = new ArrayList<String>();
	ArrayList<JCheckBox> checks = new ArrayList<JCheckBox>();
	
	public TelaCadastroMatricula(ResourceBundle bun) {
		bn = bun;
		Container tela = getContentPane();
		tela.setLayout(new GridLayout(4,1));
		
		lArea      = new JLabel(bn.getString("telacadastromatricula.larea"));
		lCPF       = new JLabel(bn.getString("telacadastromatricula.lcpf"));
		tCPF       = new JTextField(11);
		cArea      = new JComboBox(cursos);
		bOK        = new JButton(bn.getString("telacadastromatricula.bok"));
		bConsultar = new JButton(bn.getString("telacadastromatricula.bconsultar"));
		bCancelar  = new JButton(bn.getString("telacadastromatricula.bcancelar"));
		

        

		
	    Panel p1 = new Panel();
	    p1.setLayout(new FlowLayout());
	    Panel p2 = new Panel();
	    p2.setLayout(new GridLayout(1,2));
	    Panel p3 = new Panel();
	    p1.setLayout(new FlowLayout());
	    Panel p4 = new Panel();
	    p1.setLayout(new GridLayout(1,2));
	    
	    tCPF.addKeyListener(new java.awt.event.KeyAdapter() { 
			public void keyTyped(java.awt.event.KeyEvent evt){apenasNum(evt);}
		});
	    
	    
	    Panel pi1 = new Panel();
	    p1.setLayout(new FlowLayout());
	    Panel pi2 = new Panel();
	    p1.setLayout(new FlowLayout());
	    
	    pi3.setLayout(new FlowLayout());
	    
	    pi3.setLayout(new FlowLayout());
	    
	    for (int i = 0; i < listacursosinfo.length; i++) {
	        checkbox = new JCheckBox(listacursosinfo[i]);
	        checks.add(checkbox);
	        pi3.add(checkbox);
	    }
	    for (int i = 0; i < listacursosartes.length; i++) {
	        checkbox = new JCheckBox(listacursosartes[i]);
	        checks.add(checkbox);
	        pi4.add(checkbox);
	    }
	    
	    
	    
	  //listener
	    /*checkbox.addItemListener(new ItemListener(){
	    	public void itemStateChanged(ItemEvent e){
	    		if(checkbox.isSelected()){
	    			cur.add(checkbox.getText());
	    			
	    		}
	    	}
	    });*/
	    
	        bConsultar.addActionListener(this);
	        bOK.addActionListener(this);
	        
	        
	        
	  		cArea.addItemListener(new ItemListener(){  
	  		    public void itemStateChanged(ItemEvent e) {
	  		    	
	  		        resultado = (String) cArea.getSelectedItem(); ;
	  		        if(resultado.equals("Informática")){
	  		        	pi3.setVisible(true);
	  		        	pi4.setVisible(false);
	  		        	
	  		        };
	  		        if(resultado.equals("Artes")){
	  		        	pi3.setVisible(false);
	  		        	pi4.setVisible(true);
	  		        };
	  		        if(resultado.equals("")){
	  		        	pi3.setVisible(false);
	  		        	pi4.setVisible(false);
	  		        };
	  		    }});
	  		
	    pi1.add(bOK);
	    pi2.add(bCancelar);
	    
	    p1.add(lArea);
	    p1.add(cArea);
	    p2.add(pi3);
	    p2.add(pi4);
	    p3.add(lCPF);
	    p3.add(tCPF);
	    p3.add(bConsultar);
	    p4.add(pi1);
	    p4.add(pi2);
	    
	    tela.add(p1);
	    tela.add(p2);
	    tela.add(p3);
	    tela.add(p4);
	    
	    
	    setClosable(true);   
	    setIconifiable(false);  
	    setResizable(false);  
	    setSize(300,500);
	    bOK.setEnabled(false);
	    
	}
	
	private void apenasNum(KeyEvent evt) {
		String nums="0987654321";
		
		if(evt.getSource()==tCPF){ 
			if(!nums.contains(evt.getKeyChar()+"")){
				evt.consume();
			}
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if( e.getSource( ) == bConsultar ){
			String cpf = tCPF.getText();
			Tratamento tr = new Tratamento();
			if(tr.checaVazio(cpf))JOptionPane.showMessageDialog(null, "O campo CPF não pode estar vazio");
			else{
	    		  Aluno al = new Aluno(cpf);
	    		  if(al.consultaExistencia()){
	    			  bOK.setEnabled(true);
	    			  tCPF.setEditable(false);
	    			  bConsultar.setEnabled(false);
	    		  }
	    		  else{
	    			  JOptionPane.showMessageDialog(null, "Aluno não encontrado");
	    		  }
			}
		}
		
		if(e.getSource() == bOK){
			JCheckBox [] check = checks.toArray(new JCheckBox[checks.size()]);
			
			for(int j = 0; j<check.length; j++){
				if(check[j].isSelected()){
					cur.add(check[j].getText());
				}
			}
			String [] lista = cur.toArray(new String[cur.size()]);
			String cursos = "";
			String cpf = tCPF.getText();
			Calendar data = Calendar.getInstance();
			Matricula mt = new Matricula(data, 0.0, "Ativo", lista, cpf);
			if(mt.cadastraMatricula()){
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
				bOK.setEnabled(false);
				bConsultar.setEnabled(true);
				tCPF.setEditable(true);
				checkbox.setSelected(false);
			}
		}
	}
	
	

}

