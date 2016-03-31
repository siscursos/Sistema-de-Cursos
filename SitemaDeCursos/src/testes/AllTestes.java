package testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AlunoDAOTeste.class, AlunoTeste.class, AlunoTOTeste.class,
 		CursoDAOTeste.class, CursoTeste.class, CursoTOTeste.class,
		ConnectionFactoryTeste.class })
public class AllTestes {

}
