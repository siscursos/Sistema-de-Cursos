package telas;

import java.awt.*;
import java.util.ResourceBundle;

import javax.swing.*;


public class TelaConsultaCurso extends JInternalFrame{
	private JLabel lArea;
	private JLabel lCurso1;
	private JLabel lCurso2;
	private JLabel lCurso3;
	private JLabel lCurso4;
	private JComboBox cArea;
	private ResourceBundle bn = null;
	
	private String [] area = {"","Informática", "Artes"};
	
	public TelaConsultaCurso(ResourceBundle bun) {
		
		bn = bun;
		lArea      = new JLabel(bn.getString("telaconsultacurso.larea"));
		lCurso1    = new JLabel("Curso 1");
		lCurso2    = new JLabel("Curso 2");
		lCurso3    = new JLabel("Curso 3");
		lCurso4    = new JLabel("Curso 4");
		cArea      = new JComboBox(area);
		
		//Tela
		Container tela = getContentPane();
		tela.setLayout(new GridLayout(2,1));
		
		Panel p1 = new Panel();
		p1.setLayout(new FlowLayout());
		Panel p2 = new Panel();
		p2.setLayout(new GridLayout(4,1));
		
		p1.add(lArea);
		p1.add(cArea);
		p2.add(lCurso1);
		p2.add(lCurso2);
		p2.add(lCurso3);
		p2.add(lCurso4);
		
		tela.add(p1);
		tela.add(p2);
		
		setClosable(true);
		setSize(400, 300);
		
}

}
