/**
 * UFCG- Universidade Federal de Campina Grande
 * @author Luan Carlos da Silva Bezerra
 * Matricula 116110100
 * Graduando em Ciencia da Computacao
 */
package controle_de_Apostas;

/**
 * Classe ApostaSeguraTaxa
 * @author Luan Carlos da Silva Bezerra
 *
 */
public class ApostaSeguraTaxa{
	
	private int cenario;
	private String apostador;
	private int valor;
	private String previsao;
	private double taxa;
	private int custo;
	private int id;

	/**
	 * Construtor de ApostaSeguraTaxa
	 * @param cenario, Inteiro com o cenario que a Aposta esta atrelada
	 * @param apostador, String Com o nome do autor da Aposta
	 * @param valor, Inteiro com o Valor da Aposta
	 * @param previsao, String com o palpite da Aposta
	 * @param taxa, Double com a taxa sobre o valor da Aposta que sera Segurada
	 * @param custo, Inteiro com o custo do seguro
	 * @throws Exception
	 */
	public ApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa, int custo) throws Exception {
		if (cenario <= 0)
			throw new Exception("Erro no cadastro de aposta assegurada por taxa: Cenario invalido");
		if (apostador.trim().equals("")|| apostador == null)
			throw new Exception("Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo");
		if (valor <= 0)
			throw new Exception("Erro no cadastro de aposta assegurada por taxa: Valor nao pode ser menor ou igual a zero");
		if (previsao.trim().equals("")|| previsao == null)
			throw new Exception("Erro no cadastro de aposta assegurada por taxa: Previsao nao pode ser vazia ou nula");
		if (previsao.equals("VAI ACONTECER") || previsao.equals("N VAI ACONTECER"))
			this.previsao = previsao;
		else
			throw new Exception("Erro no cadastro de aposta assegurada por taxa: Previsao invalida");
		if(taxa <= 0)
			throw new Exception("Erro no cadastro de aposta assegurada por taxa: Taxa nao pode ser menor ou igual a zero");
		this.cenario = cenario;
		this.apostador = apostador;
		this.valor = valor;
		this.taxa = taxa;
		this.custo = custo;
		this.id = 0;
	}
	
	/**
	 * getId
	 * Retorna o id da ApostaSeguraTaxa, associada a Key dela no HashMap pertencente ao cenario/cenarioBonus
	 * @return Inteiro
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Alterara o id da ApostaSeguraTaxa, associada a Key dela no HashMap pertencente ao cenario/cenarioBonus
	 * @param novoID, Inteiro com o novo Id da Aposta
	 */
	public void setId(int novoID) {
		this.id = novoID;
	}
	
	/**
	 * getCenario
	 * Retorna o id do cenario que a ApostaSeguraTaxa esta atrelada
	 * @return Inteiro
	 */
	public int getCenario() {
		return cenario;
	}

	/**
	 * getApostador
	 * Retorna o nome do autor da ApostaSeguraTaxa
	 * @return String
	 */
	public String getApostador() {
		return apostador;
	}

	/**
	 * getValor
	 * Retorna o valor da ApostaSeguraTaxa
	 * @return Inteiro
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * getPrevisao
	 * Retorna a previsao da ApostaSeguraTaxa
	 * @return String
	 */
	public String getPrevisao() {
		return previsao;
	}
	
	/**
	 * getTaxa
	 * Retorna a taxa sobre o valor assegurado da ApostaSeguraTaxa
	 * @return Double
	 */
	public double getTaxa() {
		return taxa;
	}
	
	/**
	 * getCusto
	 * Retorna o custo do Seguro da ApostaSeguraTaxa
	 * @return Inteiro
	 */
	public int getCusto() {
		return custo;
	}

	/**
	 * toString
	 * Retorna a representacao textual da ApostaSeguraTaxa
	 * @return String
	 */
	public String toString() {
		return apostador + " - R$" + valor + ",00 - " + previsao+" - ASSEGURADA (TAXA) - "+taxa;
	}
}
