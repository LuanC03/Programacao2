/**
 * UFCG- Universidade Federal de Campina Grande
 * @author Luan Carlos da Silva Bezerra
 * Matricula 116110100
 * Graduando em Ciencia da Computacao
 */
package controle_de_Apostas;

/**
 * Classe Caixa
 * @author Luan Carlos da Silva Bezerra
 *
 */
public class Caixa {

	private int valorDoCaixa;
	private double taxa;
	
	/**
	 * Construtor de Caixa
	 * @param valorDoCaixa, Inteiro com valor inicial do caixa
	 * @param taxa, double com valor da taxa que sera cobrada sobre os cenarios
	 * @throws Exception
	 */
	public Caixa(int valorDoCaixa, double taxa) throws Exception {
		if(valorDoCaixa < 0)
			throw new Exception("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		if(taxa < 0)
			throw new Exception("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		
		this.valorDoCaixa = valorDoCaixa;
		this.taxa = taxa;
	}

	/**
	 * getCaixa
	 * Retorna o valor do caixa
	 * @return Inteiro
	 */
	public int getCaixa() {
		return valorDoCaixa;
	}
	
	/**
	 * setCaixa
	 * Altera o valor do Caixa
	 */
	private void setCaixa(int valor) {
		this.valorDoCaixa = valor;
	}
	
	/**
	 * getTaxa
	 * Retorna a taxa Atribuida ao sistema
	 * @return Double
	 */
	public double getTaxa() {
		return taxa;
	}

	/**
	 * adicionaValor
	 * Adiciona novo valor ao caixa
	 */
	public void adicionaValor(int valor) {
		int novoValor = (getCaixa()+valor);
		setCaixa(novoValor);		
	}

	/**
	 * retiraValor
	 * Retira valor do caixa
	 * @return Inteiro
	 */
	public void retiraValor(int valor) {
		int novoValor = (getCaixa()-valor);
		setCaixa(novoValor);
	}
}
