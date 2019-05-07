/**
 * UFCG- Universidade Federal de Campina Grande
 * @author Luan Carlos da Silva Bezerra
 * Matricula 116110100
 * Graduando em Ciencia da Computacao
 */
package controleDeApostas;

import java.util.ArrayList;

/**
 * Classe responsavel por armazenar e manipular os atributos e metodos do Objeto Cenario
 * @author Luan Carlos da Silva Bezerra
 *
 */
public class Cenario {

	private final String NAO_OCORREU = "Nao Ocorreu";
    private final String FINALIZADO_nOCORREU = "Finalizado (n ocorreu)";
    private final String FINALIZADO_OCORREU = "Finalizado (ocorreu)";
    private static final String N = System.lineSeparator();
	private ArrayList<Aposta> apostas;
	private int numeracao;
	private String descricao;
	private String estado;
	private int caixaCenario;
	private int valorDoRateio;
	
	/**
	 * Construtor do objeto Cenario
	 * @param numeracao, int referente a classificacao de Cenario.
	 * @param descricao, String contendo uma hipotese que pode se concretizar ou nao.
	 * @throws Exception 
	 */
	public Cenario(int numeracao, String descricao) throws Exception {
		if(descricao.equals("")||descricao.equals(" ")||descricao == null)
			throw new Exception("Descricao nao pode ser Nula ou Vazia");
		this.numeracao = numeracao;
		this.descricao = descricao;
		this.caixaCenario = 0;
		this.valorDoRateio = 0;
		this.estado = NAO_OCORREU;
		apostas = new ArrayList<>();
	}

	/**
	 * Retornara o atributo Numeracao de Cenario
	 * @return int
	 */
	public int getNumeracao() {
		return numeracao;
	}
	
	/**
	 * Retornara o atributo Estado de Cenario
	 * @return String
	 */
	public String getEstado() {
		return this.estado;
	}

	/**
	 * Retornara o atributo Descricao de Cenario
	 * @return String
	 */
	public String getDescricao() {
		return descricao;
	}
	
	/**
	 * Ira adicionar uma Aposta ja realizada a colecao de Apostas do Cenario
	 * @param aposta, Aposta realizada no Cenario
	 */
	public void adicionaAposta(Aposta aposta) {
		apostas.add(aposta);
	}
	
	/**
	 * Retornara o valor total apostado no Cenario
	 * @return int
	 */
	public int valorTotalApostas() {
		int retorno = 0;
		for (Aposta aposta : apostas) {
			retorno += aposta.getValor();
		}
		return retorno; 
	}
	
	/**
	 * Retornara a quantidade de Apostas feitas no Cenario
	 * @return
	 */
	public int totalApostas() {
		return apostas.size();
	}
	
	/**
	 * Retornara representacao textual das Apostas feitas no Cenario
	 * @return String
	 */
	public String retornaApostas() {
		String retorno = toString()+N+"Apostas:"+N;
		for (Aposta aposta : apostas) {
			retorno += aposta.toString()+N;
		}
		return retorno;
	}
	
	/**
	 * Ira alterar o atributo referente ao valor arrecadado no Cenario, que posteriormente sera
	 * adicionado ao Caixa do sistema.
	 * @param valor, int contendo valor arrecadado no Cenario.
	 */
	public void setCaixaCenario(int valor) {
		this.caixaCenario = valor;
	}

	/**
	 * Retornara o valor arrecadado no Cenario
	 * @return int
	 */
	public int getCaixaCenario() {		
		return this.caixaCenario;
	}
	
	/**
	 * Alterara o atributo referente a premiacao que sera feito o rateio das Apostas entre
	 * as vencedoras.
	 * @param valor, int contendo o valor da premiacao
	 */
	public void setValorDoRateio(int valor) {
		this.valorDoRateio = valor;
	}

	/**
	 * Retornara o valor do premio a ser dividido do Cenario.
	 * @return int
	 */
	public int getValorDoRateio() {		
		return this.valorDoRateio;
	}
	
	/**
	 * Ira finalizar o Cenario, determinando os valores referentes ao Caixa do sistema e 
	 * o valor da premiacao.
	 * @param ocorreu, booleean contendo o estado final do Cenario.
	 * @param taxa, double contendo a taxa padrao do sistema.
	 */
	public void encerraCenario(boolean ocorreu, double taxa) {
		int valor = 0;
		if(ocorreu) {
			this.estado = FINALIZADO_OCORREU;
		}
		else if(!ocorreu) {
			this.estado = FINALIZADO_nOCORREU;
		}
		for (Aposta aposta : apostas) {
			if(!aposta.getPrevisao().equals(estado))
				valor += aposta.getValor();
		}
		int caixa = (int) (valor * taxa);
		setCaixaCenario(caixa);
		setValorDoRateio(valor-caixa);
	}
	
	/**
	 * Ira retornar a representacao textual do cenario.
	 */
	public String toString() {
		return this.numeracao+" - "+this.descricao+" - "+this.estado;
	}
}
