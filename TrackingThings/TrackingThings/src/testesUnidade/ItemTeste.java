package testesUnidade;

import static org.junit.Assert.*;

import org.junit.Test;

import systemTrackingThings.Item.Item;
import systemTrackingThings.Usuario.Status;

/**
 * Classe de testes de Item.
 * 
 * @author Lucca Bongiovi
 */


import org.junit.Before;


public class ItemTeste {
	
	Item item1, item2, item3;

	
	/**
	 * M�todo que instancia Itens para testa-los nos metodos de teste .
	 */
	@Before
	public void criaItens() {
		item1 = new Item("Pokemon Sun", 99.0);
		item2 = new Item("Pokemon Emerald", 15.0);
		item3 = new Item("War", 70.0);
		
		item1.setStatus(Status.DISPONIVEL);
		item2.setStatus(Status.INDISPONIVEL);
		item3.setStatus(Status.DISPONIVEL);
		
	}
	
	/**
	 * M�todo que Testa a cria��o dos Itens .
	 */
	
	@SuppressWarnings("deprecation")
	@Test
	public void testItens(){
		
		assertEquals("Pokemon Sun", item1.getNome());
		assertEquals(99.0, item1.getValor());
		
		assertEquals("Pokemon Emerald", item2.getNome());
		assertEquals(15.0, item2.getValor());
		
		assertEquals("War", item1.getNome());
		assertEquals(70.0, item3.getValor());
		
	}
	
	/**
	 * M�todo que Testa a altera��o do Status de Item .
	 */
	
	@Test 
	public void testAlteraStatus(){
			
		
		assertEquals(Status.DISPONIVEL, item1.getStatus());
		
		assertEquals(Status.INDISPONIVEL, item2.getStatus());
		
		assertEquals(Status.DISPONIVEL, item3.getStatus());
	
		
	}
	

		
		
	

}
