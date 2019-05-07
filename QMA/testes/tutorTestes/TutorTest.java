/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - UFCG
 * LABORATORIO DE PROGRAMACAO 2
 * ALUNOS - CAIO TORRES - FRANCIVALDO CABRAL - LUAN CARLOS
 * MATRICULAS -  -  - 116.110.100
 * PROJETO FINAL - QUEM ME AJUDA
 */
package tutorTestes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import modelos.aluno.Aluno;
import modelos.tempo.Horario;
import modelos.tutor.Disciplina;
import modelos.tutor.Tutor;
import modelos.tutor.TutorException;

/**
 * Classe de Testes referente a Tutor
 * 
 * @author
 * @version 1.3
 * @author Luan Carlos
 */
public class TutorTest {
	private Tutor tutorTeste;
	@SuppressWarnings("unused")
	private Tutor tutorTeste2;
	@SuppressWarnings("unused")
	private Aluno alunoTeste;
	@SuppressWarnings("unused")
	private Aluno alunoTeste2;
	private Disciplina disciplinaTeste;
	private Disciplina disciplinaTeste2;
	@SuppressWarnings("unused")
	private Horario horarioTeste;

	/**
	 * Inicializa objetos testes
	 * 
	 * @author
	 * @version 1.0
	 * @throws Exception
	 * 
	 */
	@Before
	public void setUp() throws Exception {
		alunoTeste = new Aluno("Francis", "111222333", 55, "999-999", "francis@andrade.com");
		alunoTeste2 = new Aluno("Andrade", "111222333", 55, "888-888", "andrade@andrade.com");
		disciplinaTeste = new Disciplina("Programacao 2", 4);
		disciplinaTeste2 = new Disciplina("Lab. de Prog. 2", 3);
		tutorTeste = new Tutor("111222333", "francis@andrade.com", disciplinaTeste, 1);
		horarioTeste = new Horario("16:00", "segunda");
	}

	/**
	 * Testa a criacao de um Tutor com o Aluno nulo
	 * 
	 * @author Luan Carlos
	 * @version 1.1
	 * @throws NullPointerException
	 */
	@Test(expected = TutorException.class)
	public void criaTutorMatriculaNuloTeste() throws Exception {
		tutorTeste = new Tutor(null, "francis@andrade.com", disciplinaTeste, 1);
	}

	/**
	 * Testa a criacao de um Tutor com o Aluno nulo
	 * 
	 * @author Luan Carlos
	 * @version 1.1
	 * @throws NullPointerException
	 */
	@Test(expected = TutorException.class)
	public void criaTutorMatriculaVaziaTeste() throws Exception {
		tutorTeste = new Tutor("    ", "francis@andrade.com", disciplinaTeste, 1);
	}

	/**
	 * Testa a criacao de um Tutor com a Disciplina Nula
	 * 
	 * @author Luan Carlos
	 * @version 1.1
	 * @throws Exception
	 */
	@Test(expected = TutorException.class)
	public void criaTutorEmailNuloTeste() throws Exception {
		tutorTeste = new Tutor("111222333", null, disciplinaTeste, 1);
	}

	/**
	 * Testa a criacao de um Tutor com a Disciplina Nula
	 * 
	 * @author Luan Carlos
	 * @version 1.1
	 * @throws Exception
	 */
	@Test(expected = TutorException.class)
	public void criaTutorEmailVazioTeste() throws Exception {
		tutorTeste = new Tutor("111222333", "  ", disciplinaTeste, 1);
	}

	/**
	 * Testa a criacao de um Tutor com a Disciplina Nula
	 * 
	 * @author Luan Carlos
	 * @version 1.1
	 * @throws Exception
	 */
	@Test(expected = TutorException.class)
	public void criaTutorDisciplinaNulaTeste() throws Exception {
		tutorTeste = new Tutor("111222333", "francis@andrade.com", null, 1);
	}

	/**
	 * Testa a adicao de uma nova disciplina valida a colecao de disciplinas do
	 * Tutor
	 * 
	 * @author
	 * @version 1.0
	 * @throws Exception
	 */
	@Test
	public void addDisciplinaTeste() throws Exception {
		tutorTeste.addDisciplina(disciplinaTeste2);
	}

	/**
	 * Testa a adicao de uma nova disciplina nula a colecao de disciplinas do Tutor
	 * 
	 * @author Luan Carlos
	 * @version 1.1
	 * @throws Exception
	 */
	@Test(expected = TutorException.class)
	public void addDisciplinaNulaTeste() throws Exception {
		tutorTeste.addDisciplina(null);
	}

	/**
	 * Testa a adicao de uma nova disciplina valida mas ja adicionada a colecao de
	 * disciplinas do Tutor
	 * 
	 * @author
	 * @version 1.0
	 * @throws Exception
	 */
	@Test(expected = TutorException.class)
	public void addDisciplinaJaAdicionadaTeste() throws Exception {
		tutorTeste.addDisciplina(disciplinaTeste);
	}

	/**
	 * Testa a exibicao todas disciplinas cadastradas na colecao de disciplinas do
	 * Tutor
	 * 
	 * @author
	 * @version 1.0
	 * @throws Exception
	 * @author Luan Carlos
	 * @version 1.3
	 */
	@Test
	public void exibeDisciplinasTeste() throws Exception {
		tutorTeste.addDisciplina(disciplinaTeste2);
		assertEquals("Lab. de Prog. 2 - 3" + System.lineSeparator() + "Programacao 2 - 4" + System.lineSeparator(),
				tutorTeste.exibeDisciplinas());
	}

	/**
	 * Testa a representacao textual do Tutor
	 * 
	 * @author
	 * @version 1.0
	 */
	@Test
	public void toStringTeste() {
		assertEquals("111222333 - francis@andrade.com", tutorTeste.toString());
	}

}
