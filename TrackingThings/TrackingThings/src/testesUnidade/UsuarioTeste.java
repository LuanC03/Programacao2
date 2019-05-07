package testesUnidade;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
	/**
	 * Classe de testes relativa a classe Usuario.
	 * 
	 * @author Arthur Santos
	 */

import systemTrackingThings.Usuario.Usuario;





	public class UsuarioTeste {

		Usuario usuario1, usuario2;

		
		/**
		 * Método que instancia dois usuários para testá-los nos métodos de teste.
		 */
		@Before
		public void criaUsuarios() {
			usuario1 = new Usuario("Arthur", "arthur.santos@ccc.ufcg.edu.br", "83 98728-5231");
			usuario2 = new Usuario("Ash", "ashdoṕokemon@live.com", "4002 8922");
		}
		
		/**
		 * Método que faz a autenticidade dos dados passados na criação dos usuários.
		 */
		@Test
		public void testUsuario() {
			assertEquals("Arthur", usuario1.getNome());
			assertEquals("arthur.santos@ccc.ufcg.edu.br", usuario1.getEmail());
			assertEquals("83 98728-5231", usuario1.getNumeroCelular());
			
			assertEquals("Ash", usuario2.getNome());
			assertEquals("ashdopokemon@live.com", usuario2.getEmail());
			assertEquals("4002 8922", usuario2.getNumeroCelular());

		}
		
		/**
		 * Método que checa se os objetos criados pertencem de fato a uma mesma classe.
		 */
		@Test
		public void testClasseDosUsuarios() {
			assertTrue(usuario1.getClass() == usuario2.getClass());
		}

}

