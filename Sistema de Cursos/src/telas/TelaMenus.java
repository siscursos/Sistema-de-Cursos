package telas;
import java.awt.*;
import java.awt.event.*;
import java.util.ResourceBundle;

//import java.beans.PropertyVetoException;
import javax.swing.*;


public class TelaMenus extends JFrame implements ActionListener{
	
	ResourceBundle bn = null;
	JMenu arqMenu          = new JMenu("");
	JMenu operMenu         = new JMenu("");
	JMenu matrMenu         = new JMenu("");
	JMenu consMenu         = new JMenu("");
	
	JMenuItem aboutItem    = new JMenuItem("");
	JMenuItem exitItem     = new JMenuItem("");
	JMenuItem curItem      = new JMenuItem("");
	JMenuItem aluItem      = new JMenuItem("");
	JMenuItem cadItem      = new JMenuItem("");
	JMenuItem cancItem     = new JMenuItem("");
	JMenuItem relItem      = new JMenuItem("");
	JMenuItem matrItem     = new JMenuItem("");
	JMenuItem ccurItem     = new JMenuItem("");
	JDesktopPane deskPanel = new JDesktopPane();
	
	public TelaMenus(ResourceBundle bun){
		bn 				 = bun;
		arqMenu          = new JMenu(bn.getString("telamenus.arqmenu"));
		operMenu         = new JMenu(bn.getString("telamenus.opermenu"));
		matrMenu         = new JMenu(bn.getString("telamenus.matrmenu"));
		consMenu         = new JMenu(bn.getString("telamenus.consmenu"));
		
		aboutItem        = new JMenuItem(bn.getString("telamenus.aboutitem"));
		exitItem         = new JMenuItem(bn.getString("telamenus.exititem"));
		curItem      	 = new JMenuItem(bn.getString("telamenus.curitem"));
		aluItem      	 = new JMenuItem(bn.getString("telamenus.aluitem"));
		cadItem      	 = new JMenuItem(bn.getString("telamenus.caditem"));
		cancItem     	 = new JMenuItem(bn.getString("telamenus.cancitem"));
		relItem     	 = new JMenuItem(bn.getString("telamenus.relitem"));
		matrItem     	 = new JMenuItem(bn.getString("telamenus.matritem"));
		ccurItem     	 = new JMenuItem(bn.getString("telamenus.ccuritem"));
		
		
		setTitle(bn.getString("telamenus.titulo"));
		Container tela = getContentPane();;
		tela.add(deskPanel);
		JMenuBar bar = new JMenuBar();
	    setJMenuBar( bar );
		
	    matrItem.addActionListener(this);
		curItem.addActionListener(this);
		exitItem.addActionListener(this);
	    exitItem.addActionListener(this);
		ccurItem.addActionListener(this);
		aluItem.addActionListener(this);
		cadItem.addActionListener(this);
		relItem.addActionListener(this);
		cancItem.addActionListener(this);
		
		
		//arqMenu.add(aboutItem);
		//arqMenu.addSeparator();
		arqMenu.add(exitItem);
		operMenu.add(curItem);
		operMenu.add(aluItem);
		matrMenu.add(cadItem);
		matrMenu.add(cancItem);
		matrMenu.add(relItem);
		consMenu.add(ccurItem);
		consMenu.add(matrItem);
		
		bar.add(arqMenu);
		bar.add(operMenu);
		bar.add(matrMenu);
		bar.add(consMenu);
		
		//tela.add(p1);
		
		setSize( 800, 600 );
		setLocation( 300, 50 );
	    setVisible( true );
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	public void actionPerformed( ActionEvent evento ){
		
		if(evento.getSource() == curItem){
			
				TelaManterCursos telaCurso = new TelaManterCursos(bn);
				deskPanel.add(telaCurso);
				telaCurso.setVisible(true);
				telaCurso.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				
				/*try {
					telaCurso.setMaximum(true);
				} catch (PropertyVetoException e) {
					e.printStackTrace();
				}*/
	    }
		
		if(evento.getSource() == exitItem){
			System.exit(0);
			
		}
		
		if(evento.getSource() == aluItem){
			TelaManterAluno telaAluno = new TelaManterAluno(bn);
			deskPanel.add(telaAluno);
			telaAluno.setVisible(true);
			telaAluno.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			/*try {
				telaAluno.setMaximum(true);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}*/
			
		}
		if(evento.getSource() == cancItem){
			TelaCancelarMatricula telaCancelar = new TelaCancelarMatricula(deskPanel, bn);
			telaCancelar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			/*try {
				telaCancelar.setMaximum(true);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}*/
			
		}
		if(evento.getSource() == relItem){
			TelaRelMatricula telaRelatorio = new TelaRelMatricula(bn);
			deskPanel.add(telaRelatorio);
			telaRelatorio.setVisible(true);
			telaRelatorio.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			/*try {
				telaRelatorio.setMaximum(true);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}*/
			
		}
		if(evento.getSource() == cadItem){
			TelaCadastroMatricula telaCadastro = new TelaCadastroMatricula(bn);
			deskPanel.add(telaCadastro);
			telaCadastro.setVisible(true);
			telaCadastro.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			/*try {
				telaCadastro.setMaximum(true);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}*/
			
		}
		
		if(evento.getSource() == ccurItem){
			
			TelaConsultaCurso telaCurso = new TelaConsultaCurso(bn);
			deskPanel.add(telaCurso);
			telaCurso.setVisible(true);
			telaCurso.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			
			/*try {
				telaCurso.setMaximum(true);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}*/
    }
	
	if(evento.getSource() == matrItem){
		
		TelaConsultaMatricula telaMatricula = new TelaConsultaMatricula(bn);
		deskPanel.add(telaMatricula);
		telaMatricula.setVisible(true);
		telaMatricula.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		/*try {
			telaCurso.setMaximum(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}*/
	}
					
			
    }
	
}
