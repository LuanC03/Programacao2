package testesUnidade;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import systemTrackingThings.Item.BluRayFilme;
import systemTrackingThings.Item.Classificacao;
import systemTrackingThings.Item.Genero;


public class BluRayFilmeTeste {
	
	BluRayFilme blurayFilme1, blurayFilme2, blurayFilme3;

	
	/**
	 * Metodo que instancia os BluRays de Filme para testa-los nos metodos de teste .
	 */
	@Before
	public void criaBluRayFilme() {
		
		blurayFilme1 = new BluRayFilme("Crepusculo", 1.99, 120, Classificacao.QUATORZE_ANOS,Genero.ROMANCE, 2010 );
		blurayFilme2 = new BluRayFilme("300", 29.99, 110, Classificacao.DEZOITO_ANOS,Genero.ACAO, 2008 );
		blurayFilme3 = new BluRayFilme("Argo", 19.99, 150, Classificacao.DEZESSEIS_ANOS,Genero.AVENTURA, 2012 );
		
		
		blurayFilme1.setClassificacao(Classificacao.QUATORZE_ANOS);
		blurayFilme2.setClassificacao(Classificacao.DEZOITO_ANOS);
		blurayFilme3.setClassificacao(Classificacao.DEZESSEIS_ANOS);
		
		blurayFilme1.setGenero(Genero.ROMANCE);
		blurayFilme2.setGenero(Genero.ACAO);
		blurayFilme3.setGenero(Genero.AVENTURA);
		
	}
	
	/**
	 * Metodo que Testa a criacao dos BluRays de Filmes .
	 */
	
	@SuppressWarnings("deprecation")
	@Test
	public void testBluRayFilme(){
		
		assertEquals("Crepusculo", blurayFilme1.getNome());
		assertEquals(1.99, blurayFilme1.getValor());
		assertEquals(120, blurayFilme1.getDuracao());
		assertEquals(Classificacao.QUATORZE_ANOS, blurayFilme1.getClassificacao());
		assertEquals(Genero.ROMANCE, blurayFilme1.getGenero());
		assertEquals(2010, blurayFilme1.getAnoLancamento());
		
		assertEquals("300", blurayFilme2.getNome());
		assertEquals(29.99, blurayFilme2.getValor());
		assertEquals(110, blurayFilme2.getDuracao());
		assertEquals(Classificacao.DEZOITO_ANOS, blurayFilme2.getClassificacao());
		assertEquals(Genero.ACAO, blurayFilme2.getGenero());
		assertEquals(2008, blurayFilme2.getAnoLancamento());
		
		assertEquals("Argo", blurayFilme3.getNome());
		assertEquals(19.99, blurayFilme3.getValor());
		assertEquals(150, blurayFilme3.getDuracao());
		assertEquals(Classificacao.DEZESSEIS_ANOS, blurayFilme3.getClassificacao());
		assertEquals(Genero.AVENTURA, blurayFilme3.getGenero());
		assertEquals(2012, blurayFilme3.getAnoLancamento());
								
	}

}
