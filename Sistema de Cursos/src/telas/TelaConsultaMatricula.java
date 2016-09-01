package telas;

import java.awt.*;
import java.util.ResourceBundle;

import javax.swing.*;


public class TelaConsultaMatricula extends JInternalFrame{
	private JLabel lMatricula;
	private JLabel lCPF;
	private JLabel lNome;
	private JLabel lCurso1;
	private JLabel lCurso2;
	private JLabel lCurso3;
	private JLabel lCurso4;
	private ResourceBundle bn = null;
	
	private String [] area = {"","Informática", "Artes"};
	
	public TelaConsultaMatricula(ResourceBundle bun) {
		
		bn = bun;
		lMatricula = new JLabel(bn.getString("telaconsultamatricula.lmatricula"));
		lCPF       = new JLabel(bn.getString("telaconsultamatricula.lcpf"));
		lNome      = new JLabel(bn.getString("telaconsultamatricula.lnome"));
		lCurso1    = new JLabel("Curso 1");
		lCurso2    = new JLabel("Curso 2");
		lCurso3    = new JLabel("Curso 3");
		lCurso4    = new JLabel("Curso 4");

		
		//Tela
		Container tela = getContentPane();
		tela.setLayout(new GridLayout(2,1));
		
		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(3,1));
		Panel p2 = new Panel();
		p2.setLayout(new GridLayout(4,1));
		
		p1.add(lMatricula);
		p1.add(lCPF);
		p1.add(lNome);
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