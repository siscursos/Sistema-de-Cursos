package telas;
import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

import com.toedter.calendar.*;


public class TelaRelMatricula extends JInternalFrame{
	
	private JLabel lArea;
	private JLabel lCurso;
	private JLabel lPeriodo;
	private JLabel lDe;
	private JLabel lAte;
	private JComboBox cArea;
	private JComboBox cCurso;
	private JDateChooser dDataIni;
	private JDateChooser dDataFim;
	private JButton bOK;
	private JButton bCancelar;
	private ResourceBundle bn = null;
	
	String[] area  = {"","Informática","Artes"};
	String[] curso = {"","Curso 1", "Curso 2", "Curso 3"};
	public TelaRelMatricula(ResourceBundle bun) {
		
		bn = bun;
		lArea     = new JLabel(bn.getString("telarelmatricula.larea"));
		lCurso    = new JLabel(bn.getString("telarelmatricula.lcurso"));
		lPeriodo  = new JLabel(bn.getString("telarelmatricula.lperiodo"));
		lDe       = new JLabel(bn.getString("telarelmatricula.lde"));
		lAte      = new JLabel(bn.getString("telarelmatricula.late"));
		cArea     = new JComboBox(area);
		cCurso    = new JComboBox(curso);
		dDataIni  = new JDateChooser("dd/MM/yyyy","##/##/####", '_');
		dDataFim  = new JDateChooser("dd/MM/yyyy","##/##/####", '_');
		bOK       = new JButton(bn.getString("telarelmatricula.bok"));
		bCancelar = new JButton(bn.getString("telarelmatricula.bcancelar"));
		
		//Tela
		final Container tela = getContentPane();
		tela.setLayout(new GridLayout(4,1));
		
		//Paineis
		Panel p1 = new Panel();
		p1.setLayout(new FlowLayout());
		Panel p2 = new Panel();
		p2.setLayout(new FlowLayout());
		Panel p3 = new Panel();
		p3.setLayout(new FlowLayout());
		Panel p4 = new Panel();
		p4.setLayout(new GridLayout(1,3));
		
		Panel pi1 = new Panel();
		pi1.setLayout(new FlowLayout());
		Panel pi2 = new Panel();
		pi2.setLayout(new FlowLayout());
		Panel pi3 = new Panel();
		pi3.setLayout(new FlowLayout());
		
		p1.add(lArea);
		p1.add(cArea);
		p1.add(lCurso);
		p1.add(cCurso);
		p2.add(lPeriodo);
		p3.add(lDe);
		p3.add(dDataIni);
		p3.add(lAte);
		p3.add(dDataFim);
		p4.add(pi1);
		p4.add(pi2);
		p4.add(pi3);
	    
		pi3.add(bOK);
		pi3.add(bCancelar);
		
		tela.add(p1);
		tela.add(p2);
		tela.add(p3);
		tela.add(p4);
		
	    setClosable(true);   
	    setIconifiable(false);  
	    setResizable(false);  
	    setSize(450,200);  
	}
	

}
