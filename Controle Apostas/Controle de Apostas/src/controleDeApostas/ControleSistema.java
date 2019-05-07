package controleDeApostas;

import java.util.ArrayList;
import java.util.HashMap;

import easyaccept.EasyAccept;

/**
 * Classe que Manipula o sistema
 * @author Luan Carlos da Silva Bezerra
 *
 */
public class ControleSistema {

	private Caixa sistema;
	private HashMap<Integer, Cenario> cenarios;
	private ArrayList<Aposta> todasApostas = new ArrayList<>();
	private int numeracao = 0;
	private int qtdApostasAsseguradas = 0;
	private final static String N = System.lineSeparator();

	
	public static void main(String[] args) {
		args =  new String[] {"controleDeApostas.ControleSistema", "acceptance_test/us1_test.txt"};
		EasyAccept.main(args);
	}
	
	/**
	 * Inicializa o Caixa do Sistema.
	 * @param caixa, valor inteiro referente ao caixa inicial
	 * @param taxa, taxa cobrada sobre as apostas
	 */
	public void inicializa(int caixa, double taxa) {
		try {
			sistema = new Caixa(caixa, taxa);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Retornara o valor atual contido no Caixa
	 * @return valor Inteiro
	 */
	public int getCaixa() {
		return sistema.getCaixa();
	}

	/**
	 * Cadastra um novo Cenario.
	 * @param descricao, String referente a possibilidade que podera ocorrer ou nao
	 */
	public void cadastraCenarios(String descricao) {
		Cenario cenario;
		try {
			numeracao++;
			cenario = new Cenario(numeracao, descricao);
			cenarios.put(numeracao, cenario);
		} catch (Exception e) {
			numeracao--;
			e.printStackTrace();
		}

	}

	/**
	 * Cadastra um cenario com o Bonus
	 * @param descricao, String referente a possibilidade que podera ocorrer ou nao
	 * @param bonus, Inteiro com a bonificacao contida no cenario
	 * @return Inteiro referente a posicao dele no HashMap que armazena os cenarios
	 * @throws Exception, sera lancada excecao quando o Caixa nao poder pagar o possivel bonus ofericido no cenario
	 */
	public int cadastraCenarios(String descricao, int bonus) throws Exception {
		Cenario cenario;
		if ((getCaixa() - bonus) < 0) {
			throw new Exception("Erro no Cadastro do Cenario: Caixa não comporta o bonus oferecido.");
		} else {
			try {
				numeracao++;
				cenario = new Cenario(numeracao, descricao, bonus);
				cenarios.put(numeracao, cenario);
				cenario.setValorDoRateio(cenario.getValorDoRateio() + bonus);
				sistema.retiraValorCaixa(bonus);
				return numeracao;
			} catch (Exception e) {
				numeracao--;
				e.printStackTrace();
				return 0;
			}
		}
	}

	/**
	 * Retornara um Cenario especifico
	 * @param cenario, Inteiro referente a posicao dele no HashMap que armazena os cenarios
	 * @return String com as informacoes de um Cenario especifico
	 */
	public String exibirCenario(int cenario) {
		return cenarios.get(cenario).toString();
	}

	/**
	 * Retornara todos os cenarios cadastrados
	 * @return String com informacoes de todos os cenarios cadastrados, um por linha
	 */
	public String exibirCenarios() {
		String retorno = "";
		for (int i = 0; i < cenarios.size(); i++) {
			if(cenarios.containsKey(i))
				retorno += exibirCenario(i) + N;
		}
		return retorno;
	}

	/**
	 * Cadastra uma nova Aposta a um cenario especifico
	 * @param cenario, Inteiro que liga a aposta a um cenario especifico
	 * @param apostador, String que contem o nome do autor da aposta
	 * @param valor, Inteiro valor apostado
	 * @param previsao, String com o palpite da aposta
	 */
	public void cadastraAposta(int cenario, String apostador, int valor, String previsao) {
		Aposta novaAposta;
		try {
			novaAposta = new Aposta(cenario, apostador, valor, previsao);
			todasApostas.add(novaAposta);
			cenarios.get(cenario).adicionaAposta(novaAposta);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Retorna o valor apostado em um cenario especifico
	 * @param cenario, Inteiro com a referencia sobre qual cenario foi pesquisado
	 * @return Inteiro valor de todas as apostas do cenario
	 */
	public int valorTotalDeApostas(int cenario) {
		return cenarios.get(cenario).valorTotalApostas();
	}

	/**
	 * Retornara a quantidade de apostas realizadas em um cenario especifico
	 * @param cenario, Inteiro referente a identificacao do cenario especifico
	 * @return Inteiro com a quantidade de apostas realizadas no cenario
	 */
	public int totalDeApostas(int cenario) {
		return cenarios.get(cenario).totalApostas();
	}

	/**
	 * Retorna todas as informacoes sobre as apostas realizadas em um cenario especifico
	 * @param cenario, Inteiro referente a identificacao do cenario especifico
	 * @return String contendo as informacoes das apostas realizadas no cenario
	 */
	public String exibeApostas(int cenario) {
		return cenarios.get(cenario).retornaApostas();
	}

	/**
	 * Encerra um cenario especifico
	 * @param cenario, Inteiro referente a qual cenario sera encerrado
	 * @param ocorreu, Booleano com a informacao se ocorreu ou nao o cenario
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		cenarios.get(cenario).encerraCenario(ocorreu, sistema.getTaxa());
	}

	/**
	 * Retorna o caixa do cenario, e repassa o valor devido ao caixa do sistema
	 * @param cenario, Inteiro referente a qual cenario esta retornado o valor
	 * @return Inteiro com o valor do caixa do Cenario
	 */
	public int getCaixaCenario(int cenario) {
		int valor = cenarios.get(cenario).getCaixaCenario();
		sistema.adicionaValorCaixa(valor);
		return valor;
	}

	/**
	 * Retornara o valor que sera fracionado entre as apostas vencedoras
	 * @param cenario, Inteiro referente a qual cenario sera encerrado
	 * @return Inteiro referente o valor que sera divido entre os vencedores
	 */
	public int getTotalRateioCenario(int cenario) {
		return cenarios.get(cenario).getValorDoRateio();
	}

	/**
	 * Cadastra uma nova Aposta com um valor assegurado
	 * @param cenario, Inteiro referente a qual cenario sera encerrado
	 * @param apostador, String com o nome do autor da Aposta
	 * @param valor, Inteiro com o valor apostado
	 * @param previsao, String com o palpite da aposta
	 * @param valorSeguro, Inteiro com o valor que sera devolvido caso a aposta seja perdedora
	 * @param custo, Inteiro com o custo da efetivacao da aposta
	 * @return Inteiro com a posicao da aposta no HashMap das apostas Asseguradas
	 */
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorSeguro,
			int custo) {
		Aposta novaAposta;
		qtdApostasAsseguradas++;
		try {
			novaAposta = new Aposta(cenario, apostador, valor, previsao, valorSeguro, custo);
			todasApostas.add(novaAposta);
			cenarios.get(cenario).adicionaApostaAssegurada(qtdApostasAsseguradas, novaAposta);
			return qtdApostasAsseguradas;
		} catch (Exception e) {
			System.out.println(e);
			qtdApostasAsseguradas--;
			return 0;
		}
	}

	/**
	 * Cadastra uma nova Aposta com um valor assegurado
	 * @param cenario, Inteiro referente a qual cenario sera encerrado
	 * @param apostador, String com o nome do autor da Aposta
	 * @param valor, Inteiro com o valor apostado
	 * @param previsao, String com o palpite da aposta
	 * @param taxa, Double com a taxa sobre o valor apostado que sera devolvido caso a aposta seja perdedora
	 * @param custo, Inteiro com o custo da efetivacao da aposta
	 * @return Inteiro com a posicao da aposta no HashMap das apostas Asseguradas
	 */
	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa,
			int custo) {
		Aposta novaAposta;
		qtdApostasAsseguradas++;
		try {
			novaAposta = new Aposta(cenario, apostador, valor, previsao, taxa, custo);
			todasApostas.add(novaAposta);
			cenarios.get(cenario).adicionaApostaAssegurada(qtdApostasAsseguradas, novaAposta);
			return qtdApostasAsseguradas;
		} catch (Exception e) {
			System.out.println(e);
			qtdApostasAsseguradas--;
			return 0;
		}
	}

	/**
	 * Altera o tipo da Aposta de Taxa para Valor
	 * @param cenario, Inteiro referente a qual cenario sera encerrado
	 * @param apostaAssegurada, nteiro com a posicao da aposta no HashMap das apostas Asseguradas
	 * @param valor, Inteiro com o valor que sera devolvido caso a aposta seja perdedora
	 * @return Inteiro com a posicao da aposta no HashMap das apostas Asseguradas
	 * @throws Exception, sera lancada caso a Aposta nao esteja cadastrada previamente
	 */
	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) throws Exception {
		Aposta aposta = procuraApostaAssegurada(cenario, apostaAssegurada);
		Aposta novaAposta = new Aposta(cenario, aposta.getApostador(), aposta.getValor(), aposta.getPrevisao(), valor,
				aposta.getCusto());
		cenarios.get(cenario).alteraTipoApostaAsseguradaParaTaxa(novaAposta, apostaAssegurada);
		return apostaAssegurada;

	}

	/**
	 * Altera o tipo da Aposta de Valor para Taxa
	 * @param cenario, Inteiro referente a qual cenario sera encerrado
	 * @param apostaAssegurada, Inteiro com a posicao da aposta no HashMap das apostas Asseguradas
	 * @param taxa, Double com a Taxa sobre o valor da aposta que sera devolvido caso a aposta seja perdedora
	 * @return Inteiro com a posicao da aposta no HashMap das apostas Asseguradas
	 * @throws Exception, sera lancada caso a Aposta nao esteja cadastrada previamente
	 */
	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) throws Exception {
		Aposta aposta = procuraApostaAssegurada(cenario, apostaAssegurada);
		Aposta novaAposta = new Aposta(cenario, aposta.getApostador(), aposta.getValor(), aposta.getPrevisao(), taxa,
				aposta.getCusto());
		cenarios.get(cenario).alteraTipoApostaAsseguradaParaTaxa(novaAposta, apostaAssegurada);
		return apostaAssegurada;
	}

	/**
	 * Retorna uma aposta especifica
	 * @param cenario, Inteiro referente a qual cenario sera encerrado
	 * @param apostaAssegurada, Inteiro com a posicao da aposta no HashMap das apostas Asseguradas
	 * @return Uma Aposta
	 * @throws Exception sera lancada caso a Aposta nao esteja cadastrada previamente
	 */
	private Aposta procuraApostaAssegurada(int cenario, int apostaAssegurada) throws Exception {
		Aposta aposta = cenarios.get(cenario).retornaApostaAssegurada(apostaAssegurada);
		if (aposta == null)
			throw new Exception("Esta Aposta Não Existe");
		else
			return aposta;
	}
}
