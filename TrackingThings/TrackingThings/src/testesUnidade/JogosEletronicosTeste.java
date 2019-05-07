package testesUnidade;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exceptionsAdicionais.TrackingThingsExceptions;
import systemTrackingThings.Item.JogosEletronicos;
import systemTrackingThings.Item.Plataformas;

/**
 * Classe de testes de JogosEletronicos.
 * 
 * @author Lucca Bongiovi
 */

public class JogosEletronicosTeste{
	
	JogosEletronicos jogosEletronicosTest1, jogosEletronicosTest2, jogosEletronicosTest3;
	
	
	/**
	 * Metodo que instancia os Jogos Eletronicos para testa-los nos metodos de teste .
	 * @throws TrackingThingsExceptions 
	 * 
	 */
	@Before
	public void criaJogosEletronicos() throws TrackingThingsExceptions{
		
		jogosEletronicosTest1 = new JogosEletronicos("Pokemon Emerald", 15.00, "NITENDO_3DS");
		jogosEletronicosTest2 = new JogosEletronicos("Pokemon Sun", 99.99, "OUTRO");
		jogosEletronicosTest3 = new JogosEletronicos("Call of Duty", 159.90, "PS4");
		
		
		jogosEletronicosTest1.setPlataformas("NINTENDO_3DS");
		jogosEletronicosTest2.setPlataformas("OUTRO");
		jogosEletronicosTest3.setPlataformas("PS4");
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testBluRayFilme(){
		
		assertEquals("Pokemon Emerald", jogosEletronicosTest1.getNome());
		assertEquals(15.00, jogosEletronicosTest1.getValor());
		assertEquals(Plataformas.NINTENDO_3DS, jogosEletronicosTest1.getPlataformas());
		
		assertEquals("Pokemon Sun", jogosEletronicosTest2.getNome());
		assertEquals(99.99, jogosEletronicosTest2.getValor());
		assertEquals(Plataformas.OUTRO, jogosEletronicosTest2.getPlataformas());
		
		assertEquals("Call of Duty", jogosEletronicosTest3.getNome());
		assertEquals(159.90, jogosEletronicosTest3.getValor());
		assertEquals(Plataformas.PS4, jogosEletronicosTest3.getPlataformas());		
		
	}	
	
}

