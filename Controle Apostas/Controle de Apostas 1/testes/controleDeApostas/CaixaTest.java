package controleDeApostas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CaixaTest {

	private Caixa caixa;
	private Caixa caixa1;
	
	@Test
	public void valorDoCaixaTest() throws Exception {
		caixa = new Caixa(456987, 0.01);
		caixa1 = new Caixa(1, 2);
		assertEquals(456987, caixa.getCaixa());
		assertEquals(1, caixa1.getCaixa());
	}

	@Test(expected = Exception.class)
	public void criarCaixaComValorNaoPositivo() throws Exception {
		caixa = new Caixa(0, 0.01);
		caixa1 = new Caixa(-5, 0.2);		
	}
	
	@Test(expected = Exception.class)
	public void criacaoDeCaixaComTaxaNaoPositiva() throws Exception {
		caixa = new Caixa(1, 0);
		caixa1 = new Caixa(5445, -1);
	}
}
