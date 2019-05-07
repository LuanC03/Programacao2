package controle_Alunos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlunoTest {
	
	private Aluno aluno1;
	private Aluno aluno2;
	private Aluno aluno3;
	private Aluno aluno4;
	private Aluno aluno5;

	@Before
	public void testAluno() throws Exception {
		aluno1 = new Aluno("123", "Luan Carlos", "CC");
		aluno2 = new Aluno("654", "Matheus Gaudencio", "CC");
		aluno3 = new Aluno("321", "Raianny Cafe", "Engenharia de Materiais");
		aluno4 = new Aluno("456", "Dirceu Macedo", "Contabeis");
		aluno5 = new Aluno("789", "Soraya", "Agricola");
	}

	@Test
	public void testToStringAluno() {
		assertEquals("Aluno: 123 - Luan Carlos - CC", aluno1.toString());
		assertEquals("Aluno: 654 - Matheus Gaudencio - CC", aluno2.toString());
		assertEquals("Aluno: 321 - Raianny Cafe - Engenharia de Materiais", aluno3.toString());
		assertEquals("Aluno: 456 - Dirceu Macedo - Contabeis", aluno4.toString());
		assertEquals("Aluno: 789 - Soraya - Agricola", aluno5.toString());
	}
	
}
