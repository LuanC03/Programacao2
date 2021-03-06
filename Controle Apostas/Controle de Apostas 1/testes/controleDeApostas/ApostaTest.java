package controleDeApostas;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ApostaTest {

	private Aposta aposta1;
	private Aposta aposta2;
	@SuppressWarnings("unused")
	private Aposta aposta3;
	@SuppressWarnings("unused")
	private Aposta aposta4;
	
	@Before
	public void criaApostaTest() throws Exception {
		aposta1 = new Aposta(1, "Luan Carlos", 1500, "Vai Acontecer");
		aposta2 = new Aposta(2, "Raianny", 100, "n Vai Acontecer");
	}
	
	@Test(expected = Exception.class)
	public void criaApostaComApostadorVazio() throws Exception {
		aposta3 = new Aposta(3, "", 7150, "N vai Acontecer");
		aposta4 = new Aposta(3, " ", 7856, "vai acontecer");		
	}
	
	@Test(expected = Exception.class)
	public void criaApostaComApostadorNulo() throws Exception {
		aposta3 = new Aposta(3, null, 7150, "N vai Acontecer");
		aposta4 = new Aposta(3, null, 7856, "vai acontecer");		
	}
	
	@Test(expected = Exception.class)
	public void criaApostaComValorMenorOuIgualAZero() throws Exception {
		aposta3 = new Aposta(3, "Jose", 0, "N vai Acontecer");
		aposta4 = new Aposta(3, "Maria", -456, "vai acontecer");		
	}
	
	@Test(expected = Exception.class)
	public void criaApostaComPrevisaoVazia() throws Exception {
		aposta3 = new Aposta(3, "Jose", 7150, "");
		aposta4 = new Aposta(3, "Maria", 7856, " ");		
	}
	
	@Test(expected = Exception.class)
	public void criaApostaComPrevisaoNula() throws Exception {
		aposta3 = new Aposta(3, "Jose", 7150, null);
		aposta4 = new Aposta(3, "Maria", 7856, null);		
	}
		
	@Test
	public void representacaoTextualTest() {
		assertEquals("Luan Carlos - R$1500,00 - VAI ACONTECER", aposta1.toString());
		assertEquals("Raianny - R$100,00 - N VAI ACONTECER", aposta2.toString());
		
	}
	
	

}
