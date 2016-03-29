package telas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TelaLogin extends JFrame implements ActionListener{

	   private JButton bOK, bCancelar;
	   private JLabel lLogin, lSenha, lIdioma;
	   private JTextField tLogin;
	   private JPasswordField pSenha;
	   private ResourceBundle bundle = null;
	   private JComboBox cIdioma;
	   private int idioma;
	   
	   String[] idiomas = {"Português" , "English", "Español"};
	   
	   public TelaLogin(){
		   bundle = ResourceBundle.getBundle("Lang", new Locale("pt", "BR"));
		  cIdioma   = new JComboBox(idiomas);
	      cIdioma.addItemListener(new ItemListener(){  
			    public void itemStateChanged(ItemEvent e) {  
			        String resultado = (String) cIdioma.getSelectedItem(); ;
			        if(resultado.equals("English")){
			        	bundle = ResourceBundle.getBundle("Lang", Locale.US);
			        	lLogin.setText(bundle.getString("telalogin.llogin"));
			        	lSenha.setText(bundle.getString("telalogin.lsenha"));
			        	lIdioma.setText(bundle.getString("telalogin.lidioma"));
			        	bOK.setText(bundle.getString("telalogin.bok"));
			        	bCancelar.setText(bundle.getString("telalogin.bcancelar"));
			        };
			        if(resultado.equals("Español")){
			        	bundle = ResourceBundle.getBundle("Lang", new Locale("es", "ES"));
			        	lLogin.setText(bundle.getString("telalogin.llogin"));
			        	lSenha.setText(bundle.getString("telalogin.lsenha"));
			        	lIdioma.setText(bundle.getString("telalogin.lidioma"));
			        	bOK.setText(bundle.getString("telalogin.bok"));
			        	bCancelar.setText(bundle.getString("telalogin.bcancelar"));
			        };
			        if(resultado.equals("Português")){
			        	bundle = ResourceBundle.getBundle("Lang", new Locale("pt", "BR"));
			        	lLogin.setText(bundle.getString("telalogin.llogin"));
			        	lSenha.setText(bundle.getString("telalogin.lsenha"));
			        	lIdioma.setText(bundle.getString("telalogin.lidioma"));
			        	bOK.setText(bundle.getString("telalogin.bok"));
			        	bCancelar.setText(bundle.getString("telalogin.bcancelar"));
			        };
			    }
	      });
	      Container tela = getContentPane( );
	      Panel     p1   = new Panel();
	      Panel     p2   = new Panel();
	      Panel     p3   = new Panel(); 
	      Panel     p4   = new Panel(); 
	   
	      tela.setLayout( new GridLayout(4,1 ) );
	      p1.setLayout(new FlowLayout());
	      p2.setLayout(new FlowLayout());
	      p3.setLayout(new FlowLayout());
	      p4.setLayout(new FlowLayout());
	      
	      setTitle(bundle.getString("telalogin.titulo"));
	      lLogin    = new JLabel(bundle.getString("telalogin.llogin") );
	      lSenha    = new JLabel(bundle.getString("telalogin.lsenha") );
	      lIdioma   = new JLabel(bundle.getString("telalogin.lidioma") );
	      tLogin    = new JTextField( 15 );
	      pSenha    = new JPasswordField( 15 );
	      bOK       = new JButton(bundle.getString("telalogin.bok") );
	      bCancelar = new JButton(bundle.getString("telalogin.bcancelar"));
	      
	   
	      bOK.addActionListener( this );
	      bCancelar.addActionListener( this );
	      
	   
	      p1.add( lLogin );
	      p1.add( tLogin );
	      p2.add( lSenha );
	      p2.add( pSenha );
	      p3.add(lIdioma);
	      p3.add(cIdioma);
	      p4.add( bOK );
	      p4.add( bCancelar );
	      
	      tela.add(p1);
	      tela.add(p2);
	      tela.add(p3);
	      tela.add(p4);
	      
	      setSize( 300, 200 );
	      setLocation( 300, 300 );
	   
	   
	      setVisible( true );
	               
	   }
	   
	   public void actionPerformed( ActionEvent evento )
	   {
	   
	      if( evento.getSource( ) == bOK )
	      {
	         TelaMenus telaprincipal = new TelaMenus(bundle);
	         setVisible(false);
	        
	      }
	      
	      if( evento.getSource( ) == bCancelar )
	      {
	         setVisible(false);
	         System.exit(0);
	      }
	   }
	   
	   public static void main(String args[]){
		   TelaLogin telaT = new TelaLogin();
		   
	   }
}

