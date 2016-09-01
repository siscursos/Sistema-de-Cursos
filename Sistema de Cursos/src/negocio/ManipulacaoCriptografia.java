package negocio;
import java.io.File;

public class ManipulacaoCriptografia {
	String texto     = null;
	String sMsgCifrada   = null;
	String sMsgDecifrada = null;
	byte[] bTexto = null;
    byte[] bMsgCifrada = null;
    byte[] bMsgDecifrada = null;
	
	public ManipulacaoCriptografia(String txt){
		texto = txt;
	}
	
	public void criptografaTexto() throws Exception{
		bTexto = texto.getBytes("ISO-8859-1");
		Criptografia cripto = new Criptografia();
		cripto.geraChave(new File ("chave.simetrica"));
		cripto.geraCifra(bTexto, new File ("chave.simetrica"));
	}
}
