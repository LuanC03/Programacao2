package controle_Alunos;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ControleAlunosTest {

	private ControleAlunos sistema = new ControleAlunos();
	private Aluno aluno1;
	private Aluno aluno2;
	private Aluno aluno3;
	private Aluno aluno4;
	private Aluno aluno5;
	
	@Before
	public void CadastraAluno() throws Exception {
		aluno1 = new Aluno("123", "Luan", "CC");
		aluno2 = new Aluno("654", "Matheus Gaudencio", "CC");
		aluno3 = new Aluno("321", "Raianny Cafe", "Engenharia de Materiais");
		aluno4 = new Aluno("456", "Dirceu Macedo", "Contabeis");
		aluno5 = new Aluno("789", "Soraya", "Agricola");
	}
	
	@Test
	public void testBuscaAluno() {
		assertEquals(sistema.buscaAluno("123"), aluno1);
		assertEquals(sistema.buscaAluno("654"), aluno2);
		assertEquals(sistema.buscaAluno("321"), aluno3);
		assertEquals(sistema.buscaAluno("456"), aluno4);
		assertEquals(sistema.buscaAluno("789"), aluno5);
	}

}
