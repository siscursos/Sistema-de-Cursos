package telas;

import java.awt.*;
import java.util.ResourceBundle;

import javax.swing.*;

public class TelaConfirmaCancel extends JDialog /*implements ActionListener*/{
	
	private JLabel lMatricula;
	private JLabel lCPF;
	private JLabel lNome;
	private JLabel lCurso1;
	private JLabel lCurso2;
	private JLabel lCurso3;
	private JLabel lCurso4;
	private JButton bExcluir;
	private JButton bSair;
	private ResourceBundle bn = null;
	
	public TelaConfirmaCancel(JDialog diag, ResourceBundle bun){
		bn = bun;
		setTitle(bn.getString("telaconfirmacancel.titulo"));

		lMatricula = new JLabel(bn.getString("telaconfirmacancel.lmatricula"));
		lCPF       = new JLabel(bn.getString("telaconfirmacancel.lcpf"));
		lNome      = new JLabel(bn.getString("telaconfirmacancel.lnome"));
		lCurso1    = new JLabel("Curso 1");
		lCurso2    = new JLabel("Curso 2");
		lCurso3    = new JLabel("Curso 3");
		lCurso4    = new JLabel("Curso 4");
		bExcluir   = new JButton(bn.getString("telaconfirmacancel.bexcluir"));
		bSair   = new JButton(bn.getString("telaconfirmacancel.bsair"));
		
		setTitle("Cancelar Matrícula"); 
		//Tela
		Container tela = getContentPane();
		tela.setLayout(new GridLayout(3,1));
		
		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(3,1));
		Panel p2 = new Panel();
		p2.setLayout(new GridLayout(4,1));
		Panel p3 = new Panel();
		p3.setLayout(new FlowLayout());
		
		p1.add(lMatricula);
		p1.add(lCPF);
		p1.add(lNome);
		p2.add(lCurso1);
		p2.add(lCurso2);
		p2.add(lCurso3);
		p2.add(lCurso4);
		p3.add(bExcluir);
		p3.add(bSair);
		
		tela.add(p1);
		tela.add(p2);
		tela.add(p3);
		
		setSize(400, 300);
	    setVisible(true);  
	    setLocation(400,300); 
	    
	}

	/*public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}*/
}
