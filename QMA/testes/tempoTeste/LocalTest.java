package tempoTeste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modelos.tempo.Local;

public class LocalTest {
	private Local localTeste;
	
	@Before
	public void setUp() {
		localTeste = new Local("Serra do Jatobá");
	}
	
	@Test
	public void contemLocalTeste() {
		assertEquals(true, localTeste.contemLocal("Serra do Jatobá"));
	}
	
	@Test
	public void contemLocalFalseTeste() {
		assertEquals(false, localTeste.contemLocal("biblioteca"));
	}
	
	@Test
	public void removeLocalTeste() {
		
	}

}
