package testes;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import factory.ConnectionBDFactory;

public class ConnectionFactoryTeste {
	@Test
	public void testObterConexao() {
		try {
			Connection conn = ConnectionBDFactory.obtemConexao();
			assertNotNull("testa se a conexao nao e nula", conn);
			assertTrue("é um objeto conexao", conn instanceof Connection );
		} catch (SQLException e) {
			e.printStackTrace();
			fail("gerou SQLException");
		}
	}
}
