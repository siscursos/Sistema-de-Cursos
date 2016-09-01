package db;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class MysqlConnect {

	   public Connection conn;
	   public MysqlConnect() {
	        conn            = null;
		     String url      = "jdbc:mysql://localhost/"; // localizacao do servidor
	        String dbName   = "db_curso";                 // nome do banco de dados
	        String driver   = "com.mysql.jdbc.Driver";   // nome do driver de conexao
	        //String userName = "root";                  // nome do usuario do banco
	        String userName = "alunos";                  // nome do usuario do banco
	        //String password = "251921";                  // respectiva senha
	        String password = "alunos";                  // respectiva senha
	        try {
	            Class.forName(driver);
	            conn = DriverManager.getConnection(url + dbName, userName, password);
	        }
	        catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Erro no Banco de Dados!");
	            e.printStackTrace();
	        }
	    }

	    public Connection getConnection() {
	      return conn;
	    }
	    public void closeConnection() {
	        try                { conn.close(); }
	        catch(Exception e) { e.printStackTrace(); }
	    }
}
