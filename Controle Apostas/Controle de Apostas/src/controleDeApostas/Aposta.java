/**
 * UFCG- Universidade Federal de Campina Grande
 * @author Luan Carlos da Silva Bezerra
 * Matricula 116110100
 * Graduando em Ciencia da Computacao
 */
package controleDeApostas;

/**
 * Classe Aposta, contem os atributos e metodos referentes ao objeto Aposta.
 * 
 * @author Luan Carlos da Silva Bezerra
 *
 */
public class Aposta {

	private int cenario;
	private String apostador;
	private int valor;
	private String previsao;
	private double taxa;
	private int valorSeguro;
	private int custo;

	private final String FINALIZADO_nOCORREU = "Finalizado (n ocorreu)";
	private final String FINALIZADO_OCORREU = "Finalizado (ocorreu)";

	/**
	 * Construtor do Objeto Aposta
	 * 
	 * @param cenario,
	 *            int referente ao Cenario que a Aposta esta ligada.
	 * @param apostador,
	 *            String contendo o autor da Aposta.
	 * @param valor,
	 *            int referente ao valor da Aposta feita.
	 * @param previsao,
	 *            String referente ao palpite do autor da Aposta.
	 * @throws Exception
	 */
	public Aposta(int cenario, String apostador, int valor, String previsao) throws Exception {
		if (apostador.equals("") || apostador.equals(" ") || apostador == null)
			throw new Exception("Nome do Apostador nao pode ser Nulo ou Vazio");
		if (valor <= 0)
			throw new Exception("Valor da Aposta tem que ser Maior que Zero");
		if (previsao.equals("") || previsao.equals(" ") || previsao == null)
			throw new Exception("Previsao nao pode estar Nula ou Vazia");
		this.cenario = cenario;
		this.apostador = apostador;
		this.valor = valor;
		this.valorSeguro = 0;
		this.taxa = 0;
		this.custo = 0;
		if (previsao.equalsIgnoreCase("VAI ACONTECER"))
			this.previsao = FINALIZADO_OCORREU;
		else if (previsao.equalsIgnoreCase("N VAI ACONTECER"))
			this.previsao = FINALIZADO_nOCORREU;
	}

	/**
	 * Construtor do Objeto Aposta
	 * 
	 * @param cenario,
	 *            int referente ao Cenario que a Aposta esta ligada.
	 * @param apostador,
	 *            String contendo o autor da Aposta.
	 * @param valor,
	 *            int referente ao valor da Aposta feita.
	 * @param previsao,
	 *            String referente ao palpite do autor da Aposta.
	 * @throws Exception
	 */
	public Aposta(int cenario, String apostador, int valor, String previsao, int valorSeguro, int custo)
			throws Exception {
		if (apostador.equals("") || apostador.equals(" ") || apostador == null)
			throw new Exception("Nome do Apostador nao pode ser Nulo ou Vazio");
		if (valor <= 0)
			throw new Exception("Valor da Aposta tem que ser Maior que Zero");
		if (previsao.equals("") || previsao.equals(" ") || previsao == null)
			throw new Exception("Previsao nao pode estar Nula ou Vazia");
		if(valorSeguro <= 0)
			throw new Exception("Valor do Seguro tem que ser maior que zero");
		this.cenario = cenario;
		this.apostador = apostador;
		this.valor = valor;
		this.valorSeguro = valorSeguro;
		this.taxa = 0;
		this.custo = custo;
		if (previsao.equalsIgnoreCase("VAI ACONTECER"))
			this.previsao = FINALIZADO_OCORREU;
		else if (previsao.equalsIgnoreCase("N VAI ACONTECER"))
			this.previsao = FINALIZADO_nOCORREU;
	}

	/**
	 * Construtor do Objeto Aposta
	 * 
	 * @param cenario,
	 *            int referente ao Cenario que a Aposta esta ligada.
	 * @param apostador,
	 *            String contendo o autor da Aposta.
	 * @param valor,
	 *            int referente ao valor da Aposta feita.
	 * @param previsao,
	 *            String referente ao palpite do autor da Aposta.
	 * @throws Exception
	 */
	public Aposta(int cenario, String apostador, int valor, String previsao, double taxa, int custo) throws Exception {
		if (apostador.equals("") || apostador.equals(" ") || apostador == null)
			throw new Exception("Nome do Apostador nao pode ser Nulo ou Vazio");
		if (valor <= 0)
			throw new Exception("Valor da Aposta tem que ser Maior que Zero");
		if (previsao.equals("") || previsao.equals(" ") || previsao == null)
			throw new Exception("Previsao nao pode estar Nula ou Vazia");
		if(taxa <= 0)
			throw new Exception("Taxa tem que ser maior que zero");
		this.cenario = cenario;
		this.apostador = apostador;
		this.valor = valor;
		this.valorSeguro = 0;
		this.taxa = taxa;
		this.custo = custo;
		if (previsao.equalsIgnoreCase("VAI ACONTECER"))
			this.previsao = FINALIZADO_OCORREU;
		else if (previsao.equalsIgnoreCase("N VAI ACONTECER"))
			this.previsao = FINALIZADO_nOCORREU;
	}

	/**
	 * getCenario, responsavel por retornar um atributo de Aposta.
	 * 
	 * @return int
	 */
	public int getCenario() {
		return cenario;
	}

	/**
	 * getValorSeguro, responsavel por retornar um atributo de Aposta.
	 * 
	 * @return int
	 */
	public int getValorSeguro() {
		return valorSeguro;
	}

	/**
	 * getTaxa, responsavel por retornar um atributo de Aposta.
	 * 
	 * @return int
	 */
	public double getTaxa() {
		return taxa;
	}

	/**
	 * getCusto, responsavel por retornar um atributo de Aposta.
	 * 
	 * @return int
	 */
	public int getCusto() {
		return custo;
	}

	/**
	 * getApostador, responsavel por retornar um atributo de Aposta.
	 * 
	 * @return String
	 */
	public String getApostador() {
		return apostador;
	}

	/**
	 * getValor, responsavel por retornar um atributo de Aposta.
	 * 
	 * @return int
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * getPrevisao, responsavel por retornar um atributo de Aposta.
	 * 
	 * @return String
	 */
	public String getPrevisao() {
		return previsao;
	}

	/**
	 * toString de Aposta, responsavel por retornar a representacao textual de Aposta.
	 */
	public String toString() {
		String retorno = "";
		String tipo = "";
		if(previsao.equalsIgnoreCase(FINALIZADO_OCORREU))
			retorno = "VAI ACONTECER";
		if(previsao.equalsIgnoreCase(FINALIZADO_nOCORREU))
			retorno  = "N VAI ACONTECER";
		if(this.taxa > 0) {
			int porCento = (int) (this.taxa * 100);
			tipo += " - ASSEGURADA (TAXA) - "+ porCento +"%";
		}else if(this.valorSeguro > 0)
			tipo += " - ASSEGURADA (VALOR) - R$ "+ this.valorSeguro +",00";
		return this.apostador + " - R$" + valor + ",00 - " + retorno + tipo;		
		
	}
}
