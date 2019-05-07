package niveisTeste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelos.tutor.Doacao;
import modelos.tutor.NivelAprendiz;

public class NivelAprendizTeste {

	private Doacao nivel = new NivelAprendiz();
	
	
	@Test
	public void test() {
		assertEquals("0.3", String.valueOf(nivel.getTaxa(2)));
	}
	
	@Test
	public void test2() {
		assertEquals("0.37", String.valueOf(nivel.getTaxa(2.7777777778)));
	}

}
