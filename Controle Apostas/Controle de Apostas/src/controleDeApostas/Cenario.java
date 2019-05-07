/**
 * UFCG- Universidade Federal de Campina Grande
 * @author Luan Carlos da Silva Bezerra
 * Matricula 116110100
 * Graduando em Ciencia da Computacao
 */
package controleDeApostas;

import java.util.ArrayList;
import java.util.HashMap;

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
	private HashMap<Integer, Aposta> apostasAsseguradas;
	private int numeracao;
	private String descricao;
	private String estado;
	private int bonus;
	private int caixaCenario;
	private int valorDoRateio;
	
	/**
	 * Construtor do objeto Cenario sem bonus
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
		this.bonus = 0;
		this.estado = NAO_OCORREU;
		apostas = new ArrayList<>();
		apostasAsseguradas = new HashMap<>();
	}
	
	/**
	 * Construtor do objeto Cenario com bonus
	 * @param numeracao, int referente a classificacao de Cenario.
	 * @param descricao, String contendo uma hipotese que pode se concretizar ou nao.
	 * @param bonus, int referente ao bonus oferecido no cenario.
	 * @throws Exception 
	 */
	public Cenario(int numeracao, String descricao, int bonus) throws Exception {
		if(descricao.equals("")||descricao.equals(" ")||descricao == null)
			throw new Exception("Descricao nao pode ser Nula ou Vazia");
		if(bonus <= 0)
			throw new Exception("Bonus nao pode ser igual ou menor que zero");
		this.numeracao = numeracao;
		this.descricao = descricao;
		this.caixaCenario = 0;
		this.valorDoRateio = 0;
		this.bonus = bonus;
		this.estado = NAO_OCORREU;
		apostas = new ArrayList<>();
		apostasAsseguradas = new HashMap<>();
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
	 * Retornara o atributo inteiro Bonus
	 * @return
	 */
	public int getBonus() {
		return this.bonus;
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
		for (int i = 0; i < apostasAsseguradas.size(); i++) {
			if(apostasAsseguradas.containsKey(i))
				retorno += apostasAsseguradas.get(i).getValor();
		}
		return retorno; 
	}
	
	/**
	 * Retornara a quantidade de Apostas feitas no Cenario
	 * @return
	 */
	public int totalApostas() {
		int retorno = apostasAsseguradas.size()+ apostas.size();
		return retorno;
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
		for (int i = 0; i < apostasAsseguradas.size(); i++) {
			if(apostasAsseguradas.containsKey(i))
				retorno += apostasAsseguradas.get(i).toString()+N;
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
	 *Ira finalizar o Cenario, determinando os valores referentes ao Caixa do sistema e o valor da premiacao.
	 * @param ocorreu, booleean contendo o estado final do Cenario.
	 * @param taxa, double contendo a taxa padrao do sistema.
	 */
	public void encerraCenario(boolean ocorreu, double taxa) {
		int valor = 0;
		int valorSeguros = 0;
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
		for (int i = 0; i < apostasAsseguradas.size(); i++) {
			if(apostasAsseguradas.containsKey(i)) {
				if(!apostasAsseguradas.get(i).getPrevisao().equals(estado)) {
					valorSeguros += apostasAsseguradas.get(i).getValorSeguro();
					valorSeguros += apostasAsseguradas.get(i).getValor()*apostasAsseguradas.get(i).getTaxa();
					valor += apostasAsseguradas.get(i).getValor();
				}
			}
		}
		int caixa = (int) (valor * taxa);
		setCaixaCenario(caixa-valorSeguros);
		setValorDoRateio(getValorDoRateio()+(valor-caixa));
	}
	
	/**
	 * Ira retornar a representacao textual do cenario.
	 */
	public String toString() {
		if(this.bonus == 0) {
			return this.numeracao+" - "+this.descricao+" - "+this.estado;
		}else {
			return this.numeracao+" - "+this.descricao+" - "+this.estado+" - R$"+this.bonus+",00";
		}
	}

	/**
	 * Adiciona uma nova aposta Assegurada ao HashMap pertencente ao cenario;
	 * @param posicaoDaAposta, chave correspondente a Nova Aposta no hashMap do cenario 
	 * @param novaAposta, nova aposta indexada ao HashMap do cenario.
	 */
	public void adicionaApostaAssegurada(int posicaoDaAposta, Aposta novaAposta) {
		apostasAsseguradas.put(posicaoDaAposta, novaAposta);		
	}
	
	/**
	 * Retorna uma aposta Assegurada pertencente ao cenario;
	 * @param posicao, Chave do HashMap
	 * @return aposta Assegurada
	 */
	public Aposta retornaApostaAssegurada(int posicao) {
		return apostasAsseguradas.get(posicao);
	}
	
	/**
	 * Altera o tipo do seguro da aposta para Valor
	 * @param aposta, A Aposta que foi alterada
	 * @param posicaoDaAposta, chave da Aposta no HashMap de apostas asseguradas do cenario.
	 */
	public void alteraTipoApostaAsseguradaParaValor(Aposta aposta, int posicaoDaAposta) {
		apostasAsseguradas.remove(posicaoDaAposta);
		adicionaApostaAssegurada(posicaoDaAposta, aposta);
	}
	
	/**
	 * Altera o tipo do seguro da aposta para Taxa
	 * @param aposta, A Aposta que foi alterada
	 * @param posicaoDaAposta, chave da Aposta no HashMap de apostas asseguradas do cenario.
	 */
	public void alteraTipoApostaAsseguradaParaTaxa(Aposta aposta, int posicaoDaAposta) {
		apostasAsseguradas.remove(posicaoDaAposta);
		adicionaApostaAssegurada(posicaoDaAposta, aposta);
	}
}
