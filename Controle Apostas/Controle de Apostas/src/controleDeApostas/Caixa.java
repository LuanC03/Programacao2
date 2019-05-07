/**
 * UFCG- Universidade Federal de Campina Grande
 * @author Luan Carlos da Silva Bezerra
 * Matricula 116110100
 * Graduando em Ciencia da Computacao
 */
package controleDeApostas;

/**
 * Classe Caixa, responsavel por manter os atributos do Objeto Caixa
 * @author Luan Carlos da Silva Bezerra
 *
 */
public class Caixa {
	
	private int caixa;
	private double taxa;

	/**
	 * Construtor do objeto Caixa
	 * @param caixa, int contendo o valor inicial do caixa
	 * @param taxa, double contendo a taxa padrao que sera utilizada na finalizacao das apostas
	 * @throws Exception 
	 */
	public Caixa(int caixa, double taxa) throws Exception {
		if(caixa <= 0)
			throw new Exception("Valor do Caixa tem que ser Positivo");
		if(taxa <= 0)
			throw new Exception("Taxa do Caixa tem que ser Positiva");
		this.caixa = caixa;
		this.taxa = taxa;
	}

	/**
	 * Retornara valor atual do Caixa
	 * @return int
	 */
	public int getCaixa() {
		return caixa;
	}

	/**
	 * Adicionara ao Caixa o valor.
	 * @param caixa, int contendo o valor a ser adicionado ao caixa.
	 */
	public void adicionaValorCaixa(int caixa) {
		this.caixa += caixa;
	}
	/**
	 * Retira valor do Caixa o valor.
	 * @param caixa, int contendo o valor a ser retirado ao caixa.
	 */
	public void retiraValorCaixa(int caixa) {
		this.caixa += caixa;
	}

	/**
	 * Retornara a taxa padrao do sistema
	 * @return double
	 */
	public double getTaxa() {
		return taxa;
	}
}
