package telas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ResourceBundle;

public class TelaCancelarMatricula extends JDialog implements ActionListener{
	
	
	private JLabel lCodigo;
	private JTextField tCodigo;
	private JButton bOK;
	private JButton bCancelar;
	private ResourceBundle bn = null;
	public TelaCancelarMatricula(JDesktopPane desk, ResourceBundle bun) {
		super();
		final Container tela = getContentPane();
		tela.setLayout(new GridLayout(2,1));
		bn = bun;
		setTitle(bn.getString("telacancelarmatricula.titulo"));
		Panel p1 = new Panel();
		p1.setLayout(new FlowLayout());
		Panel p2 = new Panel();
		p2.setLayout(new FlowLayout());
		
		lCodigo   = new JLabel(bn.getString("telacancelarmatricula.lcodigo"));
		tCodigo   = new JTextField(10);
		bOK       = new JButton(bn.getString("telacancelarmatricula.bok"));
		bCancelar = new JButton(bn.getString("telacancelarmatricula.bcancelar"));
		
		bOK.addActionListener(this);
		bCancelar.addActionListener(this);
		p1.add(lCodigo);
		p1.add(tCodigo);
		p2.add(bOK);
		p2.add(bCancelar);
		
		tela.add(p1);
		tela.add(p2);
		setSize(200, 110);
	    setVisible(true);  
	    setLocation(300,300); 
  
	}
	
	public void actionPerformed( ActionEvent evento )
	   {
	   
	      if( evento.getSource( ) == bOK )
	      {
	         TelaConfirmaCancel telacancelar = new TelaConfirmaCancel(this, bn);
	         setVisible(false);
	        
	      }
	      
	      if( evento.getSource( ) == bCancelar )
	      {
	         setVisible(false);
	         dispose();
	      }
	   }
	

}
