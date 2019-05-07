package testesUnidade;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import systemTrackingThings.Item.BluRayShow;
import systemTrackingThings.Item.Classificacao;

public class BluRayShowTeste {
	
	BluRayShow blurayShow1, blurayShow2, blurayShow3;

	
	/**
	 * Metodo que instancia os BluRays de Shows para testa-los nos metodos de teste .
	 */
	@Before
	public void criaBluRayShow() {
		
		blurayShow1 = new BluRayShow("RBD ao vivo", 11.99, 60, Classificacao.DEZESSEIS_ANOS, "Rebelde", 20 );//nome, valor, duracao, classficacao, nomeArtista e faixas
		blurayShow2 = new BluRayShow("O Rappa na Rocinha", 19.99, 100, Classificacao.DEZOITO_ANOS, "O Rappa", 32);
		blurayShow3 = new BluRayShow("O Grande Encontro", 29.99, 50, Classificacao.QUATORZE_ANOS, "Ze Ramalho", 15);
		
		
		blurayShow1.setClassificacao(Classificacao.DEZESSEIS_ANOS);
		blurayShow2.setClassificacao(Classificacao.DEZOITO_ANOS);
		blurayShow3.setClassificacao(Classificacao.QUATORZE_ANOS);
		
		
		
	}
	
	/**
	 * Metodo que Testa a criacao dos BluRays de Shows .
	 */
	
	@SuppressWarnings("deprecation")
	@Test
	public void testBluRayFilme(){
		
		assertEquals("RBD ao vivo", blurayShow1.getNome());
		assertEquals(11.99, blurayShow1.getValor());
		assertEquals(60, blurayShow1.getDuracao());
		assertEquals(Classificacao.DEZESSEIS_ANOS, blurayShow1.getClassificacao());
		assertEquals("Rebelde", blurayShow1.getNomeArtista());
		assertEquals(20, blurayShow1.getNumeroFaixas());
		

		
		assertEquals("O Rappa na Rocinha", blurayShow2.getNome());
		assertEquals(19.99, blurayShow2.getValor());
		assertEquals(100, blurayShow2.getDuracao());
		assertEquals(Classificacao.DEZOITO_ANOS, blurayShow2.getClassificacao());
		assertEquals("O Rappa", blurayShow1.getNomeArtista());
		assertEquals(32, blurayShow1.getNumeroFaixas());

		
		assertEquals("O Grande Encontro", blurayShow3.getNome());
		assertEquals(29.99, blurayShow3.getValor());
		assertEquals(50, blurayShow3.getDuracao());
		assertEquals(Classificacao.DEZOITO_ANOS, blurayShow3.getClassificacao());
		assertEquals("Ze Ramalho", blurayShow1.getNomeArtista());
		assertEquals(15, blurayShow1.getNumeroFaixas());

								
	}




}