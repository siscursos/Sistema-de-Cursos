package db;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class ConnectionFactoryTest {

	@Test
	public void testObterConexao() {
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			assertNotNull("testa se a conexao nao e nula", conn);
			assertTrue("é um objeto conexao", conn instanceof Connection );
		} catch (SQLException e) {
			e.printStackTrace();
			fail("gerou SQLException");
		}
	}

}
