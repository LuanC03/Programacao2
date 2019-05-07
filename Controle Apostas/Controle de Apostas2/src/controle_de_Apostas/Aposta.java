/**
 * UFCG- Universidade Federal de Campina Grande
 * @author Luan Carlos da Silva Bezerra
 * Matricula 116110100
 * Graduando em Ciencia da Computacao
 */
package controle_de_Apostas;

/**
 * Classe Aposta
 * @author Luan Carlos da Silva Bezerra
 *
 */
public class Aposta {

	private int cenario;
	private String apostador;
	private int valor;
	private String previsao;

	/**
	 * Construtor de Aposta
	 * @param cenario, Inteiro com o cenario que a Aposta esta atrelada
	 * @param apostador, String Com o nome do autor da Aposta
	 * @param valor, Inteiro com o Valor da Aposta
	 * @param previsao, String com o palpite da Aposta
	 * @throws Exception
	 */
	public Aposta(int cenario, String apostador, int valor, String previsao) throws Exception {
		if (cenario <= 0)
			throw new Exception("Erro no cadastro de aposta: Cenario invalido");
		if (apostador.trim().equals("") ||apostador == null)
			throw new Exception("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		if (valor <= 0)
			throw new Exception("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		if (previsao.trim().equals("")|| previsao == null)
			throw new Exception("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		if (previsao.equals("VAI ACONTECER") || previsao.equals("N VAI ACONTECER"))
			this.previsao = previsao;
		else
			throw new Exception("Erro no cadastro de aposta: Previsao invalida");
		this.cenario = cenario;
		this.apostador = apostador;
		this.valor = valor;
	}

	/**
	 * getCenario
	 * Retorna o id do cenario que a Aposta esta atrelada
	 * @return Inteiro
	 */
	public int getCenario() {
		return cenario;
	}

	/**
	 * getApostador
	 * Retorna o nome do autor da Aposta
	 * @return String
	 */
	public String getApostador() {
		return apostador;
	}

	/**
	 * getValor
	 * Retorna o valor da Aposta
	 * @return Inteiro
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * getPrevisao
	 * Retorna a previsao da Aposta
	 * @return String
	 */
	public String getPrevisao() {
		return previsao;
	}

	/**
	 * toString
	 * Retorna a representacao textual da Aposta
	 * @return Inteiro
	 */
	public String toString() {
		return apostador + " - R$" + valor + ",00 - " + previsao;
	}

}
