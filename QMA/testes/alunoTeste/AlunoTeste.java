/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - UFCG
 * LABORATORIO DE PROGRAMACAO 2
 * ALUNOS - CAIO TORRES - FRANCIVALDO CABRAL - LUAN CARLOS
 * MATRICULAS -  -  - 116.110.100
 * PROJETO FINAL - QUEM ME AJUDA
 */
package alunoTeste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelos.aluno.Aluno;
import modelos.aluno.AlunoException;

/**
 * Classe de Testes, referentes a Aluno
 * 
 * @author
 * @version 1.1
 */
public class AlunoTeste {
	private Aluno alunoTeste;
	private Aluno alunoTeste2;

	/**
	 * Testa a criacao de um Aluno com o nome nulo.
	 * 
	 * @throws Exception
	 * @version 1.0
	 * @author
	 */
	@Test(expected = AlunoException.class)
	public void nomeNuloTeste() throws Exception {
		alunoTeste = new Aluno(null, "112233", 50, "000-000", "francis@andrade.com");
	}

	/**
	 * Testa a criacao de um Aluno com o nome vazio.
	 * 
	 * @throws Exception
	 * @version 1.0
	 * @author
	 */
	@Test(expected = AlunoException.class)
	public void nomeVazioTeste() throws Exception {
		alunoTeste = new Aluno(" ", "112233", 50, "000-000", "francis@andrade.com");
	}

	/**
	 * Testa a criacao de um Aluno com o matricua nulo.
	 * 
	 * @throws Exception
	 * @version 1.1
	 * @author Luan Carlos
	 */
	@Test(expected = AlunoException.class)
	public void matriculaNuloTeste() throws Exception {
		alunoTeste = new Aluno("Ricardo", null, 50, "000-000", "francis@andrade.com");
	}

	/**
	 * Testa a criacao de um Aluno com o matricula vazio.
	 * 
	 * @throws Exception
	 * @version 1.1
	 * @author Luan Carlos
	 */
	@Test(expected = AlunoException.class)
	public void matriculaVazioTeste() throws Exception {
		alunoTeste = new Aluno("Ricardo", " ", 50, "000-000", "francis@andrade.com");
	}

	/**
	 * Testa a criacao de um Aluno com o email nulo.
	 * 
	 * @throws Exception
	 * @version 1.1
	 * @author Luan Carlos
	 */
	@Test(expected = AlunoException.class)
	public void emailNuloTeste() throws Exception {
		alunoTeste = new Aluno("Breno", "112233", 50, "000-000", null);
	}

	/**
	 * Testa a criacao de um Aluno com o email vazio.
	 * 
	 * @throws Exception
	 * @version 1.1
	 * @author Luan Carlos
	 */
	@Test(expected = AlunoException.class)
	public void emailVazioTeste() throws Exception {
		alunoTeste = new Aluno("Breno", "112233", 50, "000-000", " ");
	}

	/**
	 * Testa a Criacao do aluno com um telefone.
	 * 
	 * @throws Exception
	 * @version 1.0
	 * @author
	 */
	@Test
	public void toStringComTelefoneTest() throws Exception {
		alunoTeste = new Aluno("Francis", "111222333", 45, "9999-9999", "francis@andrade.com");
		assertEquals("111222333 - Francis - 45 - 9999-9999 - francis@andrade.com", alunoTeste.toString());
	}

	/**
	 * Teste do equals com Alunos de matriculas iguais.
	 */
	@Test
	public void equalsMatriculasIguaisTeste() {
		alunoTeste = new Aluno("Francis", "111222333", 45, "9999-9999", "francis@andrade.com");
		alunoTeste2 = new Aluno("Andrade", "111222333", 45, "8888-8888", "andrade@andrade.com");
		assertEquals(true, alunoTeste.equals(alunoTeste2));
	}

	/**
	 * Teste do equals com Alunos com matriculas diferentes.
	 */
	@Test
	public void equalsMatriculasDiferentesTeste() {
		alunoTeste = new Aluno("Francis", "111222333", 45, "9999-9999", "francis@andrade.com");
		alunoTeste2 = new Aluno("Francis", "444555666", 45, "9999-9999", "francis@andrade.com");
		assertEquals(false, alunoTeste.equals(alunoTeste2));
	}

}
