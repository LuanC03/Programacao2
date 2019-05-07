/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - UFCG
 * LABORATORIO DE PROGRAMACAO 2
 * ALUNOS - CAIO TORRES - FRANCIVALDO CABRAL - LUAN CARLOS
 * MATRICULAS -  -  - 116.110.100
 * PROJETO FINAL - QUEM ME AJUDA
 */
package tutorTestes;

import static org.junit.Assert.*;

import org.junit.Test;

import modelos.tutor.Disciplina;
import modelos.tutor.TutorException;

/**
 * Classe de Testes referente a Disciplina
 * 
 * @author
 * @version 1.0
 *
 */
public class DisciplinaTeste {
	private Disciplina disciplinaTeste;
	private Disciplina disciplinaTeste2;

	/**
	 * Testa a criacao de disciplina com o nome nulo
	 * 
	 * @throws Exception
	 */
	@Test(expected = TutorException.class)
	public void disciplinaNomeNuloTeste() throws Exception {
		disciplinaTeste = new Disciplina(null, 5);
	}

	/**
	 * Testa a criacao de disciplina com o nome vazio
	 * 
	 * @throws Exception
	 */
	@Test(expected = TutorException.class)
	public void disciplinaNomeVazioTeste() throws Exception {
		disciplinaTeste = new Disciplina(" ", 5);
	}

	/**
	 * Testa a criacao de disciplina com o proficiencia invalida
	 * 
	 * @throws Exception
	 */
	@Test(expected = TutorException.class)
	public void disciplinaProficienciaInvalidaTeste() throws Exception {
		disciplinaTeste = new Disciplina("Programacao", 6);
	}

	/**
	 * Testa a criacao de disciplina com o proficiencia invalida
	 * 
	 * @throws Exception
	 */
	@Test(expected = TutorException.class)
	public void disciplinaProficienciaZeroTeste() throws Exception {
		disciplinaTeste = new Disciplina("Programacao", 0);
	}

	/**
	 * Testa a criacao de disciplina com o proficiencia invalida
	 * 
	 * @throws Exception
	 */
	@Test(expected = TutorException.class)
	public void disciplinaProficienciaNegativaTeste() throws Exception {
		disciplinaTeste = new Disciplina("Programacao", -1);
	}

	/**
	 * Testa a representacao Textual da Disciplina
	 * 
	 * @throws Exception
	 */
	@Test
	public void toStringTeste() throws Exception {
		disciplinaTeste = new Disciplina("Programação 2", 4);
		assertEquals("Programação 2 - 4", disciplinaTeste.toString());
	}

	@Test
	public void equalsNomeDisciplinasIguaisTeste() {
		disciplinaTeste = new Disciplina("Programação 2", 4);
		disciplinaTeste2 = new Disciplina("Programação 2", 5);
		assertEquals(true, disciplinaTeste.equals(disciplinaTeste2));
	}
	
	@Test
	public void equalsNomeDisciplinasDiferentesTeste() {
		disciplinaTeste = new Disciplina("Programação 2", 4);
		disciplinaTeste2 = new Disciplina("Programação 1", 5);
		assertEquals(false, disciplinaTeste.equals(disciplinaTeste2));
	}

}
