package testesUnidade;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exceptionsAdicionais.TrackingThingsExceptions;
import systemTrackingThings.Item.BluRaySerie;
import systemTrackingThings.Item.Classificacao;
import systemTrackingThings.Item.Genero;

public class BluRaySerieTeste {

	BluRaySerie bluraySerie1, bluraySerie2, bluraySerie3;

	
	/**
	 * Metodo que instancia os BluRays de Shows para testa-los nos metodos de teste .
	 * @throws TrackingThingsExceptions 
	 */
	@Before
	public void criaBluRayShow() throws TrackingThingsExceptions {
		
		
		bluraySerie1 = new BluRaySerie("Walking Dead", 29.99, 120 ,  Classificacao.DEZESSEIS_ANOS, Genero.TERROR, 1, "zumbis, zumbis, zumbis");//nome, valor,duracao, class, genero, temporada, descricao
		bluraySerie2 = new BluRaySerie("Game of Thrones", 39.99, 180, Classificacao.DEZOITO_ANOS, Genero.AVENTURA, 6, "The Winter is Here");
		bluraySerie3 = new BluRaySerie("Vikings", 11.99, 100, Classificacao.QUATORZE_ANOS, Genero.ACAO, 2, "Rei Ragnar");
		
		
		bluraySerie1.setClassificacao(Classificacao.DEZESSEIS_ANOS);
		bluraySerie2.setClassificacao(Classificacao.DEZOITO_ANOS);
		bluraySerie3.setClassificacao(Classificacao.QUATORZE_ANOS);
		
		bluraySerie1.setGenero(Genero.TERROR);
		bluraySerie2.setGenero(Genero.AVENTURA);
		bluraySerie3.setGenero(Genero.ACAO);
		
		
		
		
	}
	
	/**
	 * Metodo que Testa a criacao dos BluRays de Series .
	 */
	
	@SuppressWarnings("deprecation")
	@Test
	public void testBluRayFilme(){
		
		assertEquals("Walking Dead", bluraySerie1.getNome());
		assertEquals(29.99, bluraySerie1.getValor());
		assertEquals(120, bluraySerie1.getDuracao());
		assertEquals(Classificacao.DEZESSEIS_ANOS, bluraySerie1.getClassificacao());
		assertEquals(Genero.TERROR, bluraySerie1.getGenero());
		assertEquals(1, bluraySerie1.getColecaoTemporada());
		assertEquals("zumbis, zumbis, zumbis", bluraySerie1.getDescricao());
		

		
		assertEquals("Game of Thrones", bluraySerie2.getNome());
		assertEquals(39.99, bluraySerie2.getValor());
		assertEquals(180, bluraySerie2.getDuracao());
		assertEquals(Classificacao.DEZOITO_ANOS, bluraySerie2.getClassificacao());
		assertEquals(Genero.AVENTURA, bluraySerie2.getGenero());
		assertEquals(6, bluraySerie2.getColecaoTemporada());
		assertEquals("The Winter is Here", bluraySerie2.getDescricao());

		
		assertEquals("Vikings", bluraySerie3.getNome());
		assertEquals(11.99, bluraySerie3.getValor());
		assertEquals(100, bluraySerie3.getDuracao());
		assertEquals(Classificacao.QUATORZE_ANOS, bluraySerie3.getClassificacao());
		assertEquals(Genero.ACAO, bluraySerie3.getGenero());
		assertEquals(2, bluraySerie3.getColecaoTemporada());
		assertEquals("Rei Ragnar", bluraySerie3.getDescricao());
								
	}

}
