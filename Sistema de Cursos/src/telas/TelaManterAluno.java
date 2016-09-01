package telas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ResourceBundle;
import negocio.Aluno;
import negocio.Tratamento;


public class TelaManterAluno extends JInternalFrame implements ActionListener{
	
	private JLabel lNome;
	private JLabel lEnd;
	private JLabel lTel;
	private JLabel lEmail;
	private JLabel lRG;
	private JLabel lCPF;
	private JLabel lUser;
	private JLabel lPass;
	private JTextField tNome;
	private JTextField tEnd;
	private JTextField tTel;
	private JTextField tEmail;
	private JTextField tRG;
	private JTextField tCPF;
	private JTextField tUser;
	private JTextField tPass;
	private JButton    bConsultar;
	private JButton    bExcluir;
	private JButton    bEditar;
	private JButton    bInserir;
	private JButton    bCancelar;
	private JButton    bLimpar;
	private ResourceBundle bn = null;
	
	public TelaManterAluno(ResourceBundle bun) {
		
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
		p6.setLayout(new GridLayout(1,4));
		
		//Paineis Internos
		Panel pi1  = new Panel();
		pi1.setLayout(new FlowLayout());
		Panel pi2  = new Panel();
		pi1.setLayout(new FlowLayout());
		Panel pi3  = new Panel();
		pi3.setLayout(new FlowLayout());
		Panel pi4  = new Panel();
		pi4.setLayout(new FlowLayout());
		Panel pi5  = new Panel();
		pi5.setLayout(new GridLayout(2,1));
		
		//Labels
		lNome  = new JLabel(bn.getString("telamanteraluno.lnome"));
		lEnd   = new JLabel(bn.getString("telamanteraluno.lend"));
		lTel   = new JLabel(bn.getString("telamanteraluno.ltel"));
		lEmail = new JLabel(bn.getString("telamanteraluno.lemail"));
		lRG    = new JLabel(bn.getString("telamanteraluno.lrg"));
		lCPF   = new JLabel(bn.getString("telamanteraluno.lcpf"));
		lUser  = new JLabel(bn.getString("telamanteraluno.luser"));
		lPass  = new JLabel(bn.getString("telamanteraluno.lpass"));
		
		//TextField
		tNome = new JTextField(30);
		tEnd  = new JTextField(30);
		tTel = new JTextField(10);
		tEmail = new JTextField(15);
		tRG = new JTextField(11);
		tCPF = new JTextField(11);
		tUser = new JTextField(10);
		tPass = new JPasswordField(10);
		
		//Botões
		bInserir   = new JButton(bn.getString("telamanteraluno.binserir"));
		bConsultar = new JButton(bn.getString("telamanteraluno.bconsultar"));
		bEditar    = new JButton(bn.getString("telamanteraluno.beditar"));
		bExcluir   = new JButton(bn.getString("telamanteraluno.bexcluir"));
		bCancelar  = new JButton(bn.getString("telamanteraluno.bcancelar"));
		bLimpar    = new JButton("Limpar");
		
		//KeyListeners
		
		tCPF.addKeyListener(new java.awt.event.KeyAdapter() { 
			public void keyTyped(java.awt.event.KeyEvent evt){apenasNum(evt);}
		});
		tTel.addKeyListener(new java.awt.event.KeyAdapter() { 
			public void keyTyped(java.awt.event.KeyEvent evt){apenasNum(evt);}
		});
		tNome.addKeyListener(new java.awt.event.KeyAdapter() { 
			public void keyTyped(java.awt.event.KeyEvent evt){apenasNum(evt);}
		});
		
		//ActionListeners
		bInserir.addActionListener(this);
		bConsultar.addActionListener(this);
		bEditar.addActionListener(this);
		bExcluir.addActionListener(this);
		bCancelar.addActionListener(this);
		bLimpar.addActionListener(this);

		
		pi1.add(bInserir);
		pi2.add(bExcluir);
		pi3.add(bEditar);
		pi4.add(bCancelar);
		pi5.add(bConsultar);
		pi5.add(bLimpar);
		
		
		p1.add(lNome);
		p1.add(tNome);
		p2.add(lEnd);
		p2.add(tEnd);
		p3.add(lTel);
		p3.add(tTel);
		p3.add(lEmail);
		p3.add(tEmail);
		p4.add(lRG);
		p4.add(tRG);
		p4.add(lCPF);
		p4.add(tCPF);
		p4.add(pi5);
		p5.add(lUser);
		p5.add(tUser);
		p5.add(lPass);
		p5.add(tPass);
		p6.add(pi1);
		p6.add(pi2);
		p6.add(pi3);
		p6.add(pi4);
		
		tela.add(p1);
		tela.add(p2);
		tela.add(p3);
		tela.add(p4);
		tela.add(p5);
		tela.add(p6);
		
		bEditar.setEnabled(false);
		bExcluir.setEnabled(false);
		setClosable(true);
		setSize(420, 400);
	}
	
	private void apenasNum(KeyEvent evt) {
		String nums="0987654321";
		
		if(evt.getSource()==tCPF){ 
			if(!nums.contains(evt.getKeyChar()+"")){
				evt.consume();
			}
		}
		if(evt.getSource()==tTel){ 
			if(!nums.contains(evt.getKeyChar()+"")){
				evt.consume();
			}
		}
		if(evt.getSource()==tNome){ 
			if(nums.contains(evt.getKeyChar()+"")){
				evt.consume();
			}
		}
	}
	
	public void limpar(){
		tNome.setText("");
		tEnd.setText("");
		tTel.setText("");
		tEmail.setText("");
		tRG.setText("");
		tCPF.setText("");
		tUser.setText("");
		tPass.setText("");
	}

	public void actionPerformed( ActionEvent evento )
	   {
	   
	      if( evento.getSource( ) == bInserir )
	      {
	    	 Tratamento tr = new Tratamento(); 
	    	 String nome     = tNome.getText();
	    	 String endereco = tEnd.getText();
	    	 String telefone = tTel.getText();
	    	 String email    = tEmail.getText();
	    	 String rg       = tRG.getText();
	    	 String cpf      = tCPF.getText();
	    	 String login    = tUser.getText();
	    	 String senha	 = tPass.getText();
	         
	    	 if(tr.checaVazio(nome)||tr.checaVazio(endereco)||tr.checaVazio(telefone)||tr.checaVazio(email)||
	    		tr.checaVazio(rg)||tr.checaVazio(cpf)||
	    		tr.checaVazio(login)||tr.checaVazio(senha))JOptionPane.showMessageDialog(null, "Nenhum campo deve ficar vazio");
	    	 else{
	    		 Aluno al = new Aluno(nome, endereco, telefone, email, rg, cpf,login, senha, bn);
	    		 if(al.cadastrarAluno()){
	    			 JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
	    			 limpar();
	    		 }
	    	 }
	    	 
	      }
	      
	      if( evento.getSource( ) == bConsultar )
	      {	  
	    	  String cpf = tCPF.getText();
	    	  Tratamento tr = new Tratamento();
	    	  if(tr.checaVazio(cpf))JOptionPane.showMessageDialog(null, "O campo CPF não pode estar vazio");
	    	  else{
	    		  Aluno al = new Aluno(cpf);
	    		  if(al.consultarAluno()){
	    			  tNome.setText(al.getNome());
	    			  tEnd.setText(al.getEndereco());
	    			  tTel.setText(al.getTelefone());
	    			  tEmail.setText(al.getEmail());
	    			  tRG.setText(al.getRG());
	    			  tCPF.setText(al.getCPF());
	    			  tUser.setText(al.getLogin());
	    			  tPass.setText(al.getSenha());
	    			  bInserir.setEnabled(false);
	    			  bEditar.setEnabled(true);
	    			  bExcluir.setEnabled(true);
	    			  tCPF.setEditable(false);
	    		  }
	    	  }
	      }
	      
	      if( evento.getSource( ) == bExcluir )
	      {	  
	    	  String cpf = tCPF.getText();
	    	  Tratamento tr = new Tratamento();
	    	  if(tr.checaVazio(cpf))JOptionPane.showMessageDialog(null, "O campo CPF não pode estar vazio");
	    	  else{
	    		  Aluno al = new Aluno(cpf);
	    		  if(al.excluirAluno()){
	    			  JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso");
	    			  bExcluir.setEnabled(false);
	    			  bEditar.setEnabled(false);
	    			  bInserir.setEnabled(true);
	    			  tCPF.setEditable(true);
	    			  limpar();
	    		  }
	    	  }
	      }
	      
	      if( evento.getSource() == bEditar){
	    	  Tratamento tr = new Tratamento(); 
		    	 String nome     = tNome.getText();
		    	 String endereco = tEnd.getText();
		    	 String telefone = tTel.getText();
		    	 String email    = tEmail.getText();
		    	 String rg       = tRG.getText();
		    	 String cpf      = tCPF.getText();
		    	 String login    = tUser.getText();
		    	 String senha	 = tPass.getText();
		         
		    	 if(tr.checaVazio(nome)||tr.checaVazio(endereco)||tr.checaVazio(telefone)||tr.checaVazio(email)||
		    		tr.checaVazio(rg)||tr.checaVazio(cpf)||
		    		tr.checaVazio(login)||tr.checaVazio(senha))JOptionPane.showMessageDialog(null, "Nenhum campo deve ficar vazio");
		    	 else{
		    		 Aluno al = new Aluno(nome, endereco, telefone, email, rg, cpf,login, senha, bn);
		    		 if(al.editarAluno()){
		    			 JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
		    			 limpar();
		    			 bExcluir.setEnabled(false);
		    			 bEditar.setEnabled(false);
		    			 bInserir.setEnabled(true);
		    			 tNome.setText(al.getNome());
		    			 tEnd.setText(al.getEndereco());
		    			 tTel.setText(al.getTelefone());
		    			 tEmail.setText(al.getEmail());
		    			 tRG.setText(al.getRG());
		    			 tCPF.setText(al.getCPF());
		    			 tUser.setText(al.getLogin());
		    			 tPass.setText(al.getSenha());
		    			 tCPF.setEditable(true);
		    			 limpar();
		    		 }
		    	 }
	      }
	      
	      if( evento.getSource( ) == bLimpar ){
	    	  limpar();
	    	  bEditar.setEnabled(false);
	    	  bExcluir.setEnabled(false);
	    	  bInserir.setEnabled(true);
	    	  tCPF.setEditable(true);
	    	  
	      }
	      if( evento.getSource( ) == bCancelar )
	      {
	         dispose();
	      }
	   }

	
}
