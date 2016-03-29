package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection obtemConexao() throws SQLException {
		 	String url      = "jdbc:mysql://localhost/"; // localizacao do servidor
	        String dbName   = "db_curso";                 // nome do banco de dados
	        String driver   = "com.mysql.jdbc.Driver";   // nome do driver de conexao
	        String userName = "root";                  // nome do usuario do banco
	        String password = "251921";                  // respectiva senha
		return DriverManager
				.getConnection(url + dbName, userName, password);
	}

}