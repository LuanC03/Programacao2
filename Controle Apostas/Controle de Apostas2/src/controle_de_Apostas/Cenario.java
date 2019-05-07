/**
 * UFCG- Universidade Federal de Campina Grande
 * @author Luan Carlos da Silva Bezerra
 * Matricula 116110100
 * Graduando em Ciencia da Computacao
 */
package controle_de_Apostas;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Classe Cenario
 * 
 * @author Luan Carlos da Silva Bezerra
 *
 */
public class Cenario {

	private String descricao;
	private int id;
	private int qtdApostasSeguradasCadastradas;
	private int valorTotalDoRateio;
	private int caixaCenario;
	private String estado;
	private int valorTotalDeApostas;
	private HashMap<Integer, ApostaSeguraValor> apostasAsseguradasValor;
	private HashMap<Integer, ApostaSeguraTaxa> apostasAsseguradasTaxa;
	private HashSet<Aposta> apostasSemSeguro;

	/**
	 * Construtor de Cenario
	 * 
	 * @param id,
	 *            Inteiro com o id unico de Cenario
	 * @param descricao,
	 *            String com a descricao do Cenario
	 * @throws Exception
	 */
	public Cenario(int id, String descricao) throws Exception {
		if (descricao.equals("") || descricao.equals(" ") || descricao == null)
			throw new Exception("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		this.id = id;
		this.descricao = descricao;
		this.qtdApostasSeguradasCadastradas = 0;
		this.valorTotalDoRateio = 0;
		this.caixaCenario = 0;
		this.valorTotalDeApostas = 0;
		this.estado = "Nao finalizado";
		apostasAsseguradasValor = new HashMap<>();
		apostasAsseguradasTaxa = new HashMap<>();
		apostasSemSeguro = new HashSet<>();
	}

	/**
	 * setValorTotalDeApostas Altera o atributo com o valor total de apostas
	 * 
	 * @param valor,
	 *            Inteiro com o novo valor do total de apostas
	 */
	public void setValorTotalDeApostas(int valor) {
		this.valorTotalDeApostas = valor;
	}

	/**
	 * getValorTotalDeApostas Retorna o valor total de apostas do Cenario
	 * 
	 * @return Inteiro
	 */
	public int getValorTotalDeApostas() {
		return valorTotalDeApostas;
	}

	/**
	 * getCaixaCenario Retorna o valor que esta no caixa do Cenario
	 * 
	 * @return Inteiro
	 */
	public int getCaixaCenario() {
		return caixaCenario;
	}

	/**
	 * setCaixaCenario Altera o valor contido no caixa do Cenario
	 * 
	 * @param valor
	 */
	public void setCaixaCenario(int valor) {
		this.caixaCenario = valor;
	}

	/**
	 * getEstado Retorna o estado do Cenario
	 * 
	 * @return String
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * setEstado Altera o estado do Cenario
	 * 
	 * @param resultado,
	 *            boolean com o resultado do Cenario
	 */
	public void setEstado(boolean resultado) {
		if (resultado)
			this.estado = "Finalizado (ocorreu)";
		else
			this.estado = "Finalizado (n ocorreu)";
	}

	/**
	 * getId Retorna o Id unico do Cenario
	 * 
	 * @return Inteiro
	 */
	public int getId() {
		return id;
	}

	/**
	 * getDescricao Retorna a descricao do Cenario
	 * 
	 * @return String
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * toString Retorna a representacao textual do Cenario
	 * 
	 * @return String
	 */
	public String toString() {
		return id + " - " + descricao + " - " + estado;
	}

	/**
	 * getQtdApostasSeguradasCadastradas retorna a quantidade de apostas Asseguradas
	 * contidas no Cenario
	 * 
	 * @return Inteiro
	 */
	public int getQtdApostasSeguradasCadastradas() {
		return qtdApostasSeguradasCadastradas;
	}

	/**
	 * setQtdApostasSeguradasCadastradas Incrementa a quantidade de apostas
	 * Asseguradas contidas no Cenario
	 */
	private void setQtdApostasSeguradasCadastradas() {
		this.qtdApostasSeguradasCadastradas++;
	}

	/**
	 * adicicionaApostaSemSeguro Adiciona uma aposta sem seguro ao Cenario
	 * 
	 * @param aposta,
	 *            Aposta a ser adicionada
	 */
	public void adicicionaApostaSemSeguro(Aposta aposta) {
		apostasSemSeguro.add(aposta);
		atualizaAtributos();
	}

	/**
	 * adicionaApostaComSeguroValor Adicionara uma nova aposta ao HashMap referente
	 * as apostas asseguradas por valor do Cenario
	 * 
	 * @param aposta,
	 *            ApostaSeguraValor a ser adicionada
	 */
	public void adicionaApostaComSeguroValor(ApostaSeguraValor aposta) {
		setQtdApostasSeguradasCadastradas();
		aposta.setId(getQtdApostasSeguradasCadastradas());
		apostasAsseguradasValor.put(getQtdApostasSeguradasCadastradas(), aposta);
		atualizaAtributos();
	}

	/**
	 * alteraTipoApostaParaTaxa Modificara o tipo da aposta de ApostaSeguraValor
	 * para ApostaSeguraTaxa atrelada ao Cenario
	 * 
	 * @param id,
	 *            Inteiro com a identificacao unica da Aposta
	 * @param aposta,
	 *            ApostaSeguraTaxa, que era ApostaSeguraValor, e sera modificada
	 */
	public void alteraTipoApostaParaTaxa(int id, ApostaSeguraTaxa aposta) {
		apostasAsseguradasValor.remove(id);
		apostasAsseguradasTaxa.put(id, aposta);
	}

	/**
	 * alteraTipoApostaParaValor Modificara o tipo da aposta de ApostaSeguraTaxa
	 * para ApostaSeguraValor atrelada ao Cenario
	 * 
	 * @param id,
	 *            Inteiro com a identificacao unica da Aposta
	 * @param aposta,
	 *            ApostaSeguraValor, que era ApostaSeguraTaxa, e sera modificada
	 */
	public void alteraTipoApostaParaValor(int id, ApostaSeguraValor aposta) {
		apostasAsseguradasTaxa.remove(id);
		apostasAsseguradasValor.put(id, aposta);
	}

	/**
	 * adicionaApostaComSeguroTaxa Adicionara uma nova aposta ao HashMap referente
	 * as apostas asseguradas por valor do Cenario
	 * 
	 * @param aposta,
	 *            ApostaSeguraTaxa a ser adicionada
	 */
	public void adicionaApostaComSeguroTaxa(ApostaSeguraTaxa aposta) {
		setQtdApostasSeguradasCadastradas();
		aposta.setId(getQtdApostasSeguradasCadastradas());
		apostasAsseguradasTaxa.put(getQtdApostasSeguradasCadastradas(), aposta);
		atualizaAtributos();
	}

	/**
	 * getValorTotalDoRateio Retorna o valor que sera dividido entre as apostas
	 * vencedoras do Cenario
	 * 
	 * @return Inteiro
	 */
	public int getValorTotalDoRateio() {
		return valorTotalDoRateio;
	}

	/**
	 * setValorTotalDoRateio Altera o valor de rateio do Cenario
	 * 
	 * @param valor,
	 *            Inteiro com o novo valor de Rateio para o Cenario
	 */
	public void setValorTotalDoRateio(int valor) {
		this.valorTotalDoRateio = valor;
	}

	/**
	 * getApostaSeguraTaxa Retorna uma ApostaSeguraTaxa caso ela esteja cadastrada
	 * ao Cenario, e null caso ainda n�o esteja cadastrada
	 * 
	 * @param idAposta,
	 *            Inteiro com a identificacao unica da aposta no Cenario
	 * @return ApostaSeguraTaxa/null
	 */
	public ApostaSeguraTaxa getApostaSeguraTaxa(int idAposta) {
		if (apostasAsseguradasTaxa.containsKey(idAposta))
			return apostasAsseguradasTaxa.get(idAposta);
		return null;
	}

	/**
	 * getApostaSeguraValor Retorna uma ApostaSeguraValor caso ela esteja cadastrada
	 * ao Cenario, e null caso ainda esteja cadastrada
	 * 
	 * @param idAposta,
	 *            Inteiro com a identificacao unica da aposta no Cenario
	 * @return ApostaSeguraValor/null
	 */
	public ApostaSeguraValor getApostaSeguraValor(int idAposta) {
		if (apostasAsseguradasValor.containsKey(idAposta))
			return apostasAsseguradasValor.get(idAposta);
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cenario other = (Cenario) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/**
	 * valorTotalDeApostas Retorna o valor total apostado no Cenario
	 * 
	 * @return Inteiro
	 */
	public int valorTotalDeApostas() {
		int valorTotal = 0;
		for (int i = 0; i <= apostasAsseguradasValor.size(); i++) {
			if (apostasAsseguradasValor.containsKey(i))
				valorTotal += apostasAsseguradasValor.get(i).getValor();
		}
		for (int i = 0; i <= apostasAsseguradasTaxa.size(); i++) {
			if (apostasAsseguradasTaxa.containsKey(i))
				valorTotal += apostasAsseguradasTaxa.get(i).getValor();
		}
		for (Aposta aposta : apostasSemSeguro) {
			valorTotal += aposta.getValor();
		}
		return valorTotal;
	}

	/**
	 * totalDeApostas Retorna todas as apostas realizadas ao Cenario
	 * 
	 * @return Inteiro
	 */
	public int totalDeApostas() {
		return apostasAsseguradasValor.size() + apostasAsseguradasTaxa.size() + apostasSemSeguro.size();
	}

	/**
	 * exibirApostas Exibe as apostas
	 * 
	 * @return String
	 */
	public String exibirApostas() {
		String retorno = "";
		for (int i = 0; i <= apostasAsseguradasValor.size(); i++) {
			if (apostasAsseguradasValor.containsKey(i))
				retorno += apostasAsseguradasValor.get(i).getValor();
		}
		for (int i = 0; i <= apostasAsseguradasTaxa.size(); i++) {
			if (apostasAsseguradasTaxa.containsKey(i))
				retorno += apostasAsseguradasTaxa.get(i).getValor();
		}
		return retorno;
	}

	/**
	 * calculaValorSeguros Retorna o Valor dos Seguros no Cenario
	 * 
	 * @return Inteiro
	 */
	private int calculaValorSeguros() {
		int valorDosSeguros = 0;
		for (int i = 0; i < apostasAsseguradasValor.size() + apostasAsseguradasTaxa.size(); i++) {
			if (apostasAsseguradasValor.containsKey(i)) {
				if (apostasAsseguradasValor.get(i).getPrevisao().equals("N VAI ACONTECER")) {
					valorDosSeguros += apostasAsseguradasValor.get(i).getValorSeguro();
				}
			}
		}

		for (int i = 0; i < apostasAsseguradasValor.size() + apostasAsseguradasTaxa.size(); i++) {
			if (apostasAsseguradasTaxa.containsKey(i)) {
				if (apostasAsseguradasTaxa.get(i).getPrevisao().equals("N VAI ACONTECER")) {
					valorDosSeguros += apostasAsseguradasTaxa.get(i).getValor()
							* apostasAsseguradasTaxa.get(i).getTaxa();
				}
			}
		}
		return valorDosSeguros;
	}

	/**
	 * calculaValorApostasPerdedoras Retorna o valor das apostas perdedoras
	 * 
	 * @param resultado,
	 *            boolean com o resultado do Cenario
	 * @return Inteiro
	 */
	private int calculaValorApostasPerdedoras(boolean resultado) {
		int valor = 0;
		if (resultado) {
			for (Aposta aposta : apostasSemSeguro) {
				if (aposta.getPrevisao().equalsIgnoreCase("N VAI ACONTECER"))
					valor += aposta.getValor();
			}

			for (int i = 0; i <= apostasAsseguradasValor.size(); i++) {
				if (apostasAsseguradasValor.containsKey(i)) {
					if (apostasAsseguradasValor.get(i).getPrevisao().equalsIgnoreCase("N VAI ACONTECER")) {
						valor += apostasAsseguradasValor.get(i).getValor();
					}
				}
			}

			for (int i = 0; i <= apostasAsseguradasTaxa.size(); i++) {
				if (apostasAsseguradasTaxa.containsKey(i)) {
					if (apostasAsseguradasTaxa.get(i).getPrevisao().equalsIgnoreCase("N VAI ACONTECER")) {
						valor += apostasAsseguradasTaxa.get(i).getValor();
					}
				}
			}

		} else {
			for (Aposta aposta : apostasSemSeguro) {
				if (aposta.getPrevisao().equalsIgnoreCase("VAI ACONTECER"))
					valor += aposta.getValor();
			}

			for (int i = 0; i <= apostasAsseguradasValor.size(); i++) {
				if (apostasAsseguradasValor.containsKey(i)) {
					if (apostasAsseguradasValor.get(i).getPrevisao().equalsIgnoreCase("VAI ACONTECER")) {
						valor += apostasAsseguradasValor.get(i).getValor();
					}
				}
			}

			for (int i = 0; i <= apostasAsseguradasTaxa.size(); i++) {
				if (apostasAsseguradasTaxa.containsKey(i)) {
					if (apostasAsseguradasTaxa.get(i).getPrevisao().equalsIgnoreCase("VAI ACONTECER")) {
						valor += apostasAsseguradasTaxa.get(i).getValor();
					}
				}
			}
		}
		return valor;
	}

	/**
	 * encerra Retorna o valor final do caixa do Cenario
	 * 
	 * @param resultado,
	 *            boolean com o resultado do Cenario
	 * @param taxa,
	 *            double com a taxa do sistema
	 * @return Inteiro
	 */
	public int encerra(boolean resultado, double taxa) {
		int valorApostasPerdedoras = calculaValorApostasPerdedoras(resultado);
		int valorDosSeguros = calculaValorSeguros();
		int valordoCaixaCenario = (int) (valorApostasPerdedoras * taxa) - valorDosSeguros;
		System.out.println(valorApostasPerdedoras + " " + valordoCaixaCenario + " " + valorDosSeguros);
		setCaixaCenario(valordoCaixaCenario);
		setEstado(resultado);
		setValorTotalDoRateio(valorApostasPerdedoras - valordoCaixaCenario);
		return valordoCaixaCenario;
	}

	/**
	 * atualizaAtributos Atualiza o valor total de Apostas
	 */
	public void atualizaAtributos() {
		setValorTotalDeApostas(valorTotalDeApostas());
	}

	/**
	 * removeApostaComSeguroTaxa Remove uma aposta Assegurada Taxa
	 * 
	 * @param id,
	 *            Inteiro com a id unico da aposta
	 */
	public void removeApostaComSeguroTaxa(int id) {
		apostasAsseguradasTaxa.remove(id);
		atualizaAtributos();
	}

	/**
	 * removeApostaComSeguroValor Remove uma aposta Assegurada Valor
	 * 
	 * @param id,
	 *            Inteiro com a id unico da aposta
	 */
	public void removeApostaComSeguroValor(int id) {
		apostasAsseguradasValor.remove(id);
		atualizaAtributos();
	}

}
