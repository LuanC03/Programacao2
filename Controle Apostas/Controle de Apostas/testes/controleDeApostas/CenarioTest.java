package controleDeApostas;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CenarioTest {

	private Cenario cenario1;
	private Cenario cenario2;
	private Cenario cenario3;
	private Cenario cenario4;
	private Aposta aposta1;
	private Aposta aposta2;
	private Aposta aposta3;

	@Before
	public void criaCenariosTest() throws Exception {
		cenario1 = new Cenario(-5, "Pagar LP2");
		cenario2 = new Cenario(9, "Pagar C2");
		cenario3 = new Cenario(7, "Pagar TC", 100);
	}

	@Before
	public void adicionaApostasValidasAosCenariosTest() throws Exception {
		aposta1 = new Aposta(1, "Luan Carlos", 1500, "Vai Acontecer");
		aposta2 = new Aposta(2, "Raianny", 100, "n Vai Acontecer", 0.5, 20);
		aposta3 = new Aposta(3, "Darius", 1000, "Vai Acontecer", 100, 20);
	}

	@Test(expected = Exception.class)
	public void criaCenariosDescricaoVaziaTest() throws Exception {
		cenario3 = new Cenario(1, "");
		cenario4 = new Cenario(2, " ");
	}

	@Test(expected = Exception.class)
	public void criaCenariosDescricaoNulaTest() throws Exception {
		cenario3 = new Cenario(1, null);
		cenario4 = new Cenario(2, null);
	}

	@Test
	public void representacaoTextualCenarioNaoFinalizadoTest() {
		cenario2.encerraCenario(true, 1);
		cenario3.encerraCenario(false, 1);
		assertEquals("-5 - Pagar LP2 - Nao Ocorreu", cenario1.toString());
		assertEquals("9 - Pagar C2 - Finalizado (ocorreu)", cenario2.toString());
		assertEquals("7 - Pagar TC - Finalizado (n ocorreu) - R$100,00", cenario3.toString());
	}

	@Test
	public void valorDasApostasDoCenarioTest() {
		cenario1.adicionaAposta(aposta1);
		cenario1.adicionaAposta(aposta2);
		cenario2.adicionaAposta(aposta1);
		cenario3.adicionaAposta(aposta1);
		assertEquals(1600, cenario1.valorTotalApostas());
		assertEquals(1500, cenario2.valorTotalApostas());
		assertEquals(1500, cenario3.valorTotalApostas());
	}

	@Test
	public void quantidadeDeApostasNoCenarioTest() throws Exception {
		cenario4 = new Cenario(4, "Entregar o Projeto");
		cenario1.adicionaAposta(aposta1);
		cenario1.adicionaAposta(aposta2);
		cenario2.adicionaAposta(aposta1);
		cenario3.adicionaAposta(aposta1);
		assertEquals(0, cenario4.totalApostas());
		assertEquals(1, cenario3.totalApostas());
		assertEquals(1, cenario2.totalApostas());
		assertEquals(2, cenario1.totalApostas());
	}

	@Test
	public void representacaoDasApostasNoCenario() {
		cenario1.adicionaAposta(aposta1);
		cenario1.adicionaAposta(aposta2);
		cenario2.adicionaAposta(aposta1);
		assertEquals(
				"-5 - Pagar LP2 - Nao Ocorreu\nApostas:\nLuan Carlos - R$1500,00 - VAI ACONTECER\nRaianny - R$100,00 - N VAI ACONTECER - ASSEGURADA (TAXA) - 50%\n",
				cenario1.retornaApostas());
		assertEquals("9 - Pagar C2 - Nao Ocorreu\nApostas:\nLuan Carlos - R$1500,00 - VAI ACONTECER\n",
				cenario2.retornaApostas());
	}

	@Test
	public void encerraCenarioTest() {
		cenario1.adicionaAposta(aposta1);
		cenario1.adicionaAposta(aposta2);
		cenario2.adicionaAposta(aposta1);
		cenario2.adicionaAposta(aposta2);
		cenario3.adicionaAposta(aposta1);
		cenario3.adicionaAposta(aposta2);
		cenario3.adicionaAposta(aposta3);
		cenario1.encerraCenario(false, 0.15);
		cenario2.encerraCenario(true, 0.017);
		cenario3.encerraCenario(false, 0.15);
		assertEquals(225, cenario1.getCaixaCenario());
		assertEquals(1275, cenario1.getValorDoRateio());
		assertEquals(1, cenario2.getCaixaCenario());
		assertEquals(99, cenario2.getValorDoRateio());
		assertEquals(375, cenario3.getCaixaCenario());
		assertEquals(2125, cenario3.getValorDoRateio());
		assertEquals("-5 - Pagar LP2 - Finalizado (n ocorreu)", cenario1.toString());
		assertEquals("9 - Pagar C2 - Finalizado (ocorreu)", cenario2.toString());
	}

	@Test
	public void alteraTipoDeSeguroTest() {
		cenario2.adicionaAposta(aposta2);
		cenario2.adicionaAposta(aposta3);
		cenario2.alteraTipoApostaAsseguradaParaValor(aposta3, 2);
		cenario2.alteraTipoApostaAsseguradaParaTaxa(aposta2, 3);
		assertEquals(aposta2, cenario2.retornaApostaAssegurada(3));
		assertEquals(aposta3, cenario2.retornaApostaAssegurada(2));
	}

}
