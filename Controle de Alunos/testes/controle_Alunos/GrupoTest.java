package controle_Alunos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GrupoTest {
	private Grupo grupo1;
	private Grupo grupo2;
	private Grupo grupo3;
	private Grupo grupo4;
	private Grupo grupo5;

	@Before
	public void testGrupo() {
		grupo1 = new Grupo("AA");
		grupo2 = new Grupo("CC");
		grupo3 = new Grupo("LP2");
		grupo4 = new Grupo("Calculo");
		grupo5 = new Grupo("Listas");
	}

	@Test
	public void testToStringGrupo() {
		assertEquals("Grupo: AA", grupo1.toString());
		assertEquals("Grupo: CC", grupo2.toString());
		assertEquals("Grupo: LP2", grupo3.toString());
		assertEquals("Grupo: Calculo", grupo4.toString());
		assertEquals("Grupo: Listas", grupo5.toString());
	}
}
