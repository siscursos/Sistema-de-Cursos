package telas;
import javax.swing.*;
import com.toedter.calendar.*;

import negocio.Aluno;
import negocio.Artes;
import negocio.Curso;
import negocio.Informatica;
import negocio.Tratamento;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;


public class TelaManterCursos extends JInternalFrame implements ActionListener{
	
	
	
	private JLabel lArea;
	private JLabel lValor;
	private JLabel lNome;
	private JLabel lDataIni;
	private JLabel lDataFim;
	private JLabel lHora;
	private JLabel lNumVagas;
	private JLabel lExclusivo1;
	private JLabel lExclusivo2;
	private JLabel lCodigo;
	private JComboBox cCursos;
	private JTextField tValor;
	private JTextField tNome;
	private JTextField tHora;
	private JTextField tNumVagas;
	private JTextField tExclusivo1;
	private JTextField tCodigo;
	private JTextArea tExclusivo2;
	private JButton btnIncluir;
	private JButton btnConsultar;
	private JButton btnExcluir;
	private JButton btnCanc;
	private JButton btnEdit;
	private JButton btnLimpar;
	private JDateChooser dDataIni;
	private JDateChooser dDataFim;
	private int curso = 0;
	private ResourceBundle bn = null;
	private String [] cursos = {"","Informática", "Artes"};
	Tratamento tr = new Tratamento();
	
	public TelaManterCursos(ResourceBundle bun){
		bn = bun;
		//Tela
		final Container tela = getContentPane();
		tela.setLayout(new GridLayout(6,1));
		
		//Paineis
		Panel p1 = new Panel();
		p1.setLayout(new FlowLayout());
		Panel p2 = new Panel();
		p2.setLayout(new FlowLayout());
		Panel p3 = new Panel();
		p3.setLayout(new FlowLayout());
		Panel p4 = new Panel();
		p4.setLayout(new FlowLayout());
		final Panel p5 = new Panel();
		p5.setLayout(new FlowLayout());
		Panel p6 = new Panel();
		p6.setLayout(new GridLayout(1,5));
		
		
		//Paineis Internos
		Panel pi1  = new Panel();
		pi1.setLayout(new FlowLayout());
		Panel pi2  = new Panel();
		pi2.setLayout(new GridLayout(2,1));
		Panel pi3  = new Panel();
		pi3.setLayout(new FlowLayout());
		Panel pi4  = new Panel();
		pi4.setLayout(new FlowLayout());
		Panel pi5  = new Panel();
		pi5.setLayout(new FlowLayout());
		final Panel pi6  = new Panel();
		pi6.setLayout(new FlowLayout());
		final Panel pi6e5  = new Panel();
		pi6e5.setLayout(new FlowLayout());
		Panel pi7  = new Panel();
		pi7.setLayout(new FlowLayout());
		Panel pi8  = new Panel();
		pi8.setLayout(new FlowLayout());
		Panel pi9  = new Panel();
		pi9.setLayout(new FlowLayout());
		Panel pi10 = new Panel();
		pi10.setLayout(new FlowLayout());
		Panel pi11 = new Panel();
		pi11.setLayout(new FlowLayout());
		
		
		//Labels
		lArea       = new JLabel(bn.getString("telamantercursos.larea"));
		lValor      = new JLabel(bn.getString("telamantercursos.lvalor"));
		lNome       = new JLabel(bn.getString("telamantercursos.lnome"));
		lCodigo     = new JLabel(bn.getString("telamantercursos.lcodigo"));
		lDataIni    = new JLabel(bn.getString("telamantercursos.ldataini"));
		lDataFim    = new JLabel(bn.getString("telamantercursos.ldatafim"));
		lHora       = new JLabel(bn.getString("telamantercursos.lhora"));
		lNumVagas   = new JLabel(bn.getString("telamantercursos.lnumvagas"));
		lExclusivo1 = new JLabel(bn.getString("telamantercursos.lexclusivo1"));
		lExclusivo1.setVisible(false);
		lExclusivo2 = new JLabel(bn.getString("telamantercursos.lexclusivo2i"));
		lExclusivo2.setVisible(false);
		
		//Combo
		cCursos   = new JComboBox(cursos);
		cCursos.addItemListener(new ItemListener(){  
		    public void itemStateChanged(ItemEvent e) {  
		        String resultado = (String) cCursos.getSelectedItem(); ;
		        if(resultado.equals("Informática")){
		        	lExclusivo1.setText(bn.getString("telamantercursos.lexclusivo1"));
		        	lExclusivo2.setText(bn.getString("telamantercursos.lexclusivo2i"));
		        	lExclusivo1.setVisible(true);
		        	tExclusivo1.setVisible(true);
		        	lExclusivo2.setVisible(true);
		        	tExclusivo2.setVisible(true);
		        	curso = 1;
		        };
		        if(resultado.equals("Artes")){
		        	lExclusivo2.setText(bn.getString("telamantercursos.lexclusivo2a"));
		        	lExclusivo1.setVisible(false);
		        	tExclusivo1.setVisible(false);
		        	lExclusivo2.setVisible(true);
		        	tExclusivo2.setVisible(true);
		        	curso = 2;
		        };
		        if(resultado.equals("")){
		        	lExclusivo1.setVisible(false);
		        	tExclusivo1.setVisible(false);
		        	lExclusivo2.setVisible(false);
		        	tExclusivo2.setVisible(false);
		        	curso = 0;
		        };
		    }  
		});
		cCursos.setPreferredSize(new Dimension(100, 20));
		cCursos.setMinimumSize(new Dimension(100, 20));
		cCursos.setMaximumSize(new Dimension(100, 20));
		
		//TextFields
		tValor      = new JTextField(7);
		tNome       = new JTextField(17);
		tCodigo     = new JTextField(5);
		tHora       = new JTextField(7);
		tNumVagas   = new JTextField(5);
		tExclusivo1 = new JTextField(5);
		tExclusivo1.setVisible(false);
		tExclusivo2 = new JTextArea(4, 25);
		tExclusivo2.setVisible(false);
		
		//Botões
		btnIncluir     = new JButton(bn.getString("telamantercursos.btnincluir"));
		btnExcluir	   = new JButton(bn.getString("telamantercursos.btnexcluir"));
		btnConsultar   = new JButton(bn.getString("telamantercursos.btnconsultar"));
		btnCanc        = new JButton(bn.getString("telamantercursos.btncanc"));
		btnEdit        = new JButton(bn.getString("telamantercursos.btnedit"));
		btnLimpar     = new JButton("Limpar");
		
		//DateChooser
		dDataIni = new JDateChooser("dd/MM/yyyy","##/##/####", '_');
		dDataFim = new JDateChooser("dd/MM/yyyy","##/##/####", '_');
		
		//Inclusão no painel interno
		//pi1.add(lArea);
		pi1.add(cCursos);
		pi2.add(btnConsultar);
		pi2.add(btnLimpar);
		pi3.add(lDataIni);
		pi3.add(dDataIni);
		pi4.add(lDataFim);
		pi4.add(dDataFim);
		pi5.add(lHora);
		pi5.add(tHora);
		pi6.add(lNumVagas);
		pi6.add(tNumVagas);
		pi6e5.add(lExclusivo1);
		pi6e5.add(tExclusivo1);
		pi7.add(btnIncluir);
		
		pi9.add(btnEdit);
		pi10.add(btnExcluir);
		pi11.add(btnCanc);
		
		
		//Propriedades Painel Interno
		//pi1.setSize(2, 2);
		
		
		//listeners
		btnIncluir.addActionListener(this);
		btnCanc.addActionListener(this);
		btnConsultar.addActionListener(this);
		btnEdit.addActionListener(this);
		btnExcluir.addActionListener(this);
		btnLimpar.addActionListener(this);
		
		tValor.addKeyListener(new java.awt.event.KeyAdapter() { 
			public void keyTyped(java.awt.event.KeyEvent evt){apenasNum(evt);}
		});
		tCodigo.addKeyListener(new java.awt.event.KeyAdapter() { 
			public void keyTyped(java.awt.event.KeyEvent evt){apenasNum(evt);}
		});
		tHora.addKeyListener(new java.awt.event.KeyAdapter() { 
			public void keyTyped(java.awt.event.KeyEvent evt){apenasNum(evt);}
		});
		tNumVagas.addKeyListener(new java.awt.event.KeyAdapter() { 
			public void keyTyped(java.awt.event.KeyEvent evt){apenasNum(evt);}
		});
		tExclusivo1.addKeyListener(new java.awt.event.KeyAdapter() { 
			public void keyTyped(java.awt.event.KeyEvent evt){apenasNum(evt);}
		});
		
		//Inclusão nos Paineis
		p1.add(lArea);
		p1.add(cCursos);
		p1.add(lValor);
		p1.add(tValor);
		p2.add(lNome);
		p2.add(tNome);
		p2.add(lCodigo);
		p2.add(tCodigo);
		p2.add(pi2);
		p3.add(lDataIni);
		p3.add(dDataIni);
		p3.add(lDataFim);
		p3.add(dDataFim);
		p4.add(pi5);
		p4.add(pi6);
		p4.add(pi6e5);
		p5.add(lExclusivo2);
		p5.add(tExclusivo2);
		p6.add(pi7);
		p6.add(pi9);
		p6.add(pi10);
		p6.add(pi11);
		
		
		
		//Inclusão na tela
		tela.add(p1);
		tela.add(p2);
		tela.add(p3);
		tela.add(p4);
		tela.add(p5);
		tela.add(p6);
		
		setClosable(true);
		setSize(460, 400);
		btnEdit.setEnabled(false);
		btnExcluir.setEnabled(false);
		
		
	}
	
	public void limpar(){
		tValor.setText("");
		tNome.setText("");
		tCodigo.setText("");
		dDataIni.setDate(null);
		dDataFim.setDate(null);
		tHora.setText("");
		tNumVagas.setText("");
		tExclusivo1.setText("");
		tExclusivo2.setText("");
		cCursos.setSelectedIndex(0);
		cCursos.setEditable(true); 
		btnEdit.setEnabled(false);
		btnExcluir.setEnabled(false);
		curso = 0;
		
	}
	
	
	private void apenasNum(KeyEvent evt) {
		String nums="0987654321";
		
		if(evt.getSource()==tValor){ 
			if(!nums.contains(evt.getKeyChar()+"")){
				evt.consume();
			}
		}
		if(evt.getSource()==tCodigo){ 
			if(!nums.contains(evt.getKeyChar()+"")){
				evt.consume();
			}
		}
		if(evt.getSource()==tHora){ 
			if(!nums.contains(evt.getKeyChar()+"")){
				evt.consume();
			}
		}
		if(evt.getSource()==tNumVagas){ 
			if(!nums.contains(evt.getKeyChar()+"")){
				evt.consume();
			}
		}
		if(evt.getSource()==tExclusivo1){ 
			if(!nums.contains(evt.getKeyChar()+"")){
				evt.consume();
			}
		}
	}
	
	
	
	public void actionPerformed( ActionEvent evento )
	   {
	   
	      if( evento.getSource( ) == btnIncluir )
	      {
	    	 String nome     = tNome.getText();
	    	 String area     = (String)cCursos.getSelectedItem();
	    	 Calendar data_ini   = dDataIni.getCalendar();
	    	 Calendar data_fim   = dDataFim.getCalendar();
	    	 String horario  = tHora.getText();
	    	 int n_vagas  = Integer.parseInt(tNumVagas.getText());
	    	 double valor = Double.parseDouble(tValor.getText());
	    	 int codigo;
	    	 
	    	 if(curso == 1){
	    		 int n_laboratorio = Integer.parseInt(tExclusivo1.getText());
	    		 String reg_software = tExclusivo2.getText();
	    	 
	    	 
	    		 if(tr.checaVazio(nome)||tr.checaVazio(horario)||tr.checaCampoVazio(tNumVagas) || tr.checaCampoVazio(tValor)||!tr.checkData(dDataIni)||
	    				 !tr.checkData(dDataFim))JOptionPane.showMessageDialog(null, "Nenhum campo deve ficar vazio");
		    	 else{
		    		 	 Informatica info = new Informatica(nome, area, data_ini, data_fim, 
		    		 			 horario, n_vagas, valor, n_laboratorio, reg_software);
		    		 		 if(info.cadastrarCurso()){
		    		 		 codigo = info.getCodigo();
			    			 JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso, código do curso: " + codigo);
			    			 limpar();
		    		 		 }
		    		 		 else{
		    		 			JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o curso");
		    		 		 }
			    		 }
		 
	    	 }
	    	 else if(curso == 2){
	    		 String matLivros = tExclusivo2.getText();
	    	 
	    	 
	    		 if(tr.checaVazio(nome)||tr.checaVazio(horario)||tr.checaCampoVazio(tNumVagas) || tr.checaCampoVazio(tValor)||!tr.checkData(dDataIni)||
	    				 !tr.checkData(dDataFim))JOptionPane.showMessageDialog(null, "Nenhum campo deve ficar vazio");
		    	 else{
		    		 	 Artes at = new Artes(nome, area, data_ini, data_fim, 
		    		 			 horario, n_vagas, valor, matLivros);
		    		 		 if(at.cadastrarCurso()){
		    		 		 codigo = at.getCodigo();
			    			 JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso, código do curso: " + codigo);
			    			 limpar();
		    		 		 }
		    		 		 else{
		    		 			JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o curso");
		    		 		 }
			    		 }
		 
	    	 }
	    	 else if(curso == 0) {JOptionPane.showMessageDialog(null, "Favor selecionar a área do curso");}
	    	 
	    	
	      }
	      if( evento.getSource( ) == btnCanc )
	      {
	         dispose();
	      }
	   
	    	 
	    	 
	    	 
	      
	      

	    	 
	      
	      
	      if( evento.getSource( ) == btnConsultar )
	      {	  
	    	  if(tr.checaVazio(tCodigo.getText()))JOptionPane.showMessageDialog(null, "O campo Código não pode estar vazio");
	    	  else{
	    		  int codigo = Integer.parseInt(tCodigo.getText());
	    		  if(curso == 1){
	    			  Informatica info = new Informatica(codigo);
	    		  	  if(info.consultarCurso()){
	    		  		  tValor.setText(""+info.getValor());
	    		  		  tNome.setText(info.getNome());
	    		  		  tCodigo.setText(""+info.getCodigo());
	    		  		  dDataIni.setCalendar(info.getDataInicio());
	    		  		  dDataFim.setCalendar(info.getDataTermino());
	    		  		  tHora.setText(info.getHorario());
	    		  		  tNumVagas.setText(""+info.getNVagas());
	    		  		  tExclusivo1.setText(""+info.getNLaboratorio());
	    		  		  tExclusivo2.setText(info.getRegSoftware());
	    		  		  btnIncluir.setEnabled(false);
	    		  		  btnEdit.setEnabled(true);
	    		  		  btnExcluir.setEnabled(true);
	    		  		  tCodigo.setEditable(false);
	    		  		  cCursos.setEnabled(false);
	    		  		  
	    		  	  }
	    		  }
	    		  	  else if(curso == 2){
		    			  Artes at = new Artes(codigo);
		    		  	  if(at.consultarCurso()){
		    		  		  tValor.setText(""+at.getValor());
		    		  		  tNome.setText(at.getNome());
		    		  		  tCodigo.setText(""+at.getCodigo());
		    		  		  dDataIni.setCalendar(at.getDataInicio());
		    		  		  dDataFim.setCalendar(at.getDataTermino());
		    		  		  tHora.setText(at.getHorario());
		    		  		  tNumVagas.setText(""+at.getNVagas());
		    		  		  tExclusivo2.setText(at.getDescricaoMaterial());
		    		  		  btnIncluir.setEnabled(false);
		    		  		  btnEdit.setEnabled(true);
		    		  		  btnExcluir.setEnabled(true);
		    		  		  tCodigo.setEditable(false);
		    		  		  cCursos.setEnabled(false);
		    		  		  
		    		  	  }	  
	    		  
	    		  	  }
	    		  	  
	    		  	  else if(curso == 0){
	    		  		  JOptionPane.showMessageDialog(null, "Favor selecionar a área do curso");
	    		  	  }
	    		  	  
	    		  }
	    		  	  
	    		  
	    		  
	    	  }
	      
	      
	      if( evento.getSource( ) == btnExcluir )
	      {	  
	    	  int codigo = Integer.parseInt(tCodigo.getText());
	    		  if(curso == 1){
	    			  Informatica info = new Informatica(codigo);
	    		  	  if(info.excluirCurso()){
	    		  		  JOptionPane.showMessageDialog(null, "Curso excluído com sucesso");
		    			  btnExcluir.setEnabled(false);
		    			  btnEdit.setEnabled(false);
		    			  btnIncluir.setEnabled(true);
		    			  tCodigo.setEditable(true);
		    			  cCursos.setEnabled(true);
		    			  limpar();
	    		  		  
	    		  	  }
	    		  }
	    		  	  else if(curso == 2){
		    			  Artes at = new Artes(codigo);
		    		  	  if(at.excluirCurso()){
		    		  		JOptionPane.showMessageDialog(null, "Curso excluído com sucesso");
			    			  btnExcluir.setEnabled(false);
			    			  btnEdit.setEnabled(false);
			    			  btnIncluir.setEnabled(true);
			    			  tCodigo.setEditable(true);
			    			  cCursos.setEnabled(true);
			    			  limpar();
		    		  		  
		    		  	  }
	    		  	  
	    		  	  }
	    		  }
		  
	      
	      if( evento.getSource() == btnEdit){
	    	  	 
	    	  	 String nome     = tNome.getText();
	    	  	 String area     = (String)cCursos.getSelectedItem();
		    	 Calendar data_ini   = dDataIni.getCalendar();
		    	 Calendar data_fim   = dDataFim.getCalendar();
		    	 String horario  = tHora.getText();
		    	 int n_vagas  = Integer.parseInt(tNumVagas.getText());
		    	 double valor = Double.parseDouble(tValor.getText());
		    	 int cod = Integer.parseInt(tCodigo.getText());
		    	 
		    	 if(curso == 1){
		    		 int n_laboratorio = Integer.parseInt(tExclusivo1.getText());
		    		 String reg_software = tExclusivo2.getText();
		         
		    	 
		    		 Informatica info = new Informatica(cod, area, nome, data_ini, data_fim, 
	    		 			 horario, n_vagas, valor, n_laboratorio, reg_software);
		    		 if(info.editarCurso()){
		    			 JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
		    			 limpar();
		    			 btnExcluir.setEnabled(false);
		    			 btnEdit.setEnabled(false);
		    			 btnIncluir.setEnabled(true);
		    			 cCursos.setEnabled(true);
		    			 tCodigo.setEditable(true);
		    			 limpar();
		    		 }
		    	 }
		    	 else if(curso == 2){
		    		 String matLivros = tExclusivo2.getText();
		         
		    	 
		    		 Artes at = new Artes(cod, nome, area, data_ini, data_fim, 
	    		 			 horario, n_vagas, valor, matLivros);
		    		 if(at.editarCurso()){
		    			 JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
		    			 limpar();
		    			 btnExcluir.setEnabled(false);
		    			 btnEdit.setEnabled(false);
		    			 btnIncluir.setEnabled(true);
		    			 cCursos.setEnabled(true);
		    			 tCodigo.setEditable(true);
		    			 limpar();
		    		 }
		    	 }
	      }
	      
	      if( evento.getSource( ) == btnLimpar ){
	    	  limpar();
	    	  btnEdit.setEnabled(false);
	    	  btnExcluir.setEnabled(false);
	    	  btnIncluir.setEnabled(true);
	    	  tCodigo.setEditable(true);
	    	  cCursos.setEnabled(true);
	    	  
	     
	      }
	      

 
	   }
	      
	   
}

