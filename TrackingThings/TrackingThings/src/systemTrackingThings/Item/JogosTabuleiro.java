package systemTrackingThings.Item;

import java.util.ArrayList;

/**
 * Classe JogosTabuleiro, que cria e altera os atributos relativos a Jogos de Tabuleiro
 * @author Caio Simplicio 
 * @version 1.4
 */


public class JogosTabuleiro extends Item {
	
	private ArrayList<String> pecasPerdidas;
	
	/**
	 * A classe possui dois construtores, para criar o objeto na melhor opcao.
	 * @author Caio Simplicio 
	 * @version 1.4
	 */

	public JogosTabuleiro(String nome, Double valor) {
		super(nome, valor);
		this.pecasPerdidas = new ArrayList<>();
	}
	
	public JogosTabuleiro(String nome, Double valor, ArrayList<String> pecasPerdidas) {
		super(nome, valor);
		this.pecasPerdidas = pecasPerdidas;
	}
	
	/**
	 * Metodo que faz a verificacao se no Array de pecas, possui mais de um elemento, 
	 * assumindo que se for maior que 0 o tamanho, possui pecas em falta.
	 * @author Caio Simplicio 
	 * @version 1.4
	 */

	public boolean retornaSeEstaCompleto(){
		return pecasPerdidas.size() == 0;
	}


}
