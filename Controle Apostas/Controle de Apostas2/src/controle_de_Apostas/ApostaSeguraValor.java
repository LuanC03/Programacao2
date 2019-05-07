/**
 * UFCG- Universidade Federal de Campina Grande
 * @author Luan Carlos da Silva Bezerra
 * Matricula 116110100
 * Graduando em Ciencia da Computacao
 */
package controle_de_Apostas;

/**
 * Classe Aposta Segura Valor
 * 
 * @author Luan Carlos da Silva Bezerra
 *
 */
public class ApostaSeguraValor {

	private int cenario;
	private String apostador;
	private int valor;
	private String previsao;
	private int valorSeguro;
	private int custo;
	private int id;

	/**
	 * Construtor de ApostaSeguraValor
	 * 
	 * @param cenario,
	 *            Inteiro com o cenario que a Aposta esta atrelada
	 * @param apostador,
	 *            String Com o nome do autor da Aposta
	 * @param valor,
	 *            Inteiro com o Valor da Aposta
	 * @param previsao,
	 *            String com o palpite da Aposta
	 * @param valorSeguro,
	 *            Inteiro com o valor da aposta que sera assegurado
	 * @param custo,
	 *            Inteiro com o custo do seguro
	 * @throws Exception
	 */
	public ApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorSeguro, int custo)
			throws Exception {
		if (cenario <= 0)
			throw new Exception("Erro no cadastro de aposta assegurada por valor: Cenario invalido");
		if (apostador.trim().equals("") || apostador == null)
			throw new Exception(
					"Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo");
		if (valor <= 0)
			throw new Exception(
					"Erro no cadastro de aposta assegurada por valor: Valor nao pode ser menor ou igual a zero");
		if (previsao.trim().equals("") || previsao == null)
			throw new Exception("Erro no cadastro de aposta assegurada por valor: Previsao nao pode ser vazia ou nula");
		else if (previsao.equals("VAI ACONTECER") || previsao.equals("N VAI ACONTECER"))
			this.previsao = previsao;
		else
			throw new Exception("Erro no cadastro de aposta assegurada por valor: Previsao invalida");
		if (valorSeguro <= 0)
			throw new Exception(
					"Erro no cadastro de aposta assegurada por valor: Valor Segurado nao pode ser menor ou igual a zero");
		this.cenario = cenario;
		this.id = 0;
		this.apostador = apostador;
		this.valor = valor;
		this.valorSeguro = valorSeguro;
		this.custo = custo;
	}

	/**
	 * getId Retorna o id da ApostaSeguraValor, associada a Key dela no HashMap pertencente ao
	 * cenario/cenarioBonus
	 * 
	 * @return Inteiro
	 */
	public int getId() {
		return id;
	}

	/**
	 * Alterara o id da ApostaSeguraValor, associada a Key dela no HashMap pertencente ao
	 * cenario/cenarioBonus
	 * 
	 * @param novoID,
	 *            Inteiro com o novo Id da ApostaSeguraValor
	 */
	public void setId(int novoID) {
		this.id = novoID;
	}

	/**
	 * getCenario Retorna o id do cenario que a ApostaSeguraValor esta atrelada
	 * 
	 * @return Inteiro
	 */
	public int getCenario() {
		return cenario;
	}

	/**
	 * getApostador Retorna o nome do autor da ApostaSeguraValor
	 * 
	 * @return String
	 */
	public String getApostador() {
		return apostador;
	}

	/**
	 * getValor Retorna o valor da ApostaSeguraValor
	 * 
	 * @return Inteiro
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * getPrevisao Retorna a previsao da ApostaSeguraValor
	 * 
	 * @return String
	 */
	public String getPrevisao() {
		return previsao;
	}

	/**
	 * getValorSeguro Retorna o valor assegurado da ApostaSeguraValor
	 * 
	 * @return Inteiro
	 */
	public int getValorSeguro() {
		return valorSeguro;
	}

	/**
	 * getCusto Retorna o custo do seguro da ApostaSeguraValor
	 * 
	 * @return String
	 */
	public int getCusto() {
		return custo;
	}

	/**
	 * toString Retorna a representacao textual da ApostaSeguraValor
	 * 
	 * @return String
	 */
	public String toString() {
		return apostador + " - R$" + valor + ",00 - " + previsao + " - ASSEGURADA (VALOR) - R$ " + valorSeguro;
	}
}
