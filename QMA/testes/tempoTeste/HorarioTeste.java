/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - UFCG
 * LABORATORIO DE PROGRAMACAO 2
 * ALUNOS - CAIO TORRES - FRANCIVALDO CABRAL - LUAN CARLOS
 * MATRICULAS -  -  - 116.110.100
 * PROJETO FINAL - QUEM ME AJUDA
 */
package tempoTeste;

import org.junit.Test;

import modelos.tempo.Horario;
import modelos.tempo.TempoException;

/**
 * Classe de Testes referente a Horario
 * 
 * @author
 * @version 1.0
 *
 */
public class HorarioTeste {
	@SuppressWarnings("unused")
	private Horario horarioTeste;

	/**
	 * Testa a criacao de um horario com a hora nulo
	 */
	@Test(expected = TempoException.class)
	public void horarioHoraNuloTeste() {
		horarioTeste = new Horario(null, "segunda");
	}

	/**
	 * Testa a criacao de um horario com a hora vazia
	 */
	@Test(expected = TempoException.class)
	public void horarioHoraVaziaTeste() {
		horarioTeste = new Horario("  ", "segunda");
	}

	/**
	 * Testa a criacao de um horario com o dia nulo
	 */
	@Test(expected = TempoException.class)
	public void horarioDiaNuloTeste() {
		horarioTeste = new Horario("15:00", null);
	}

	/**
	 * Testa a criacao de um horario com o dia vazio
	 */
	@Test(expected = TempoException.class)
	public void horarioDiaVazioTeste() {
		horarioTeste = new Horario("15:00", " ");
	}

}
