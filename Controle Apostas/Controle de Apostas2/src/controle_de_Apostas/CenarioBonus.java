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
 * Classe Cenario Bonus
 * @author Luan Carlos da Silva Bezerra
 *
 */
public class CenarioBonus extends Cenario {

	private String descricao;
	private int id;
	private int qtdApostasSeguradasCadastradas;
	private int valorTotalDoRateio;
	private int caixaCenario;
	private String estado;
	private int bonus;
	private int valorTotalDeApostas;
	private HashMap<Integer, ApostaSeguraValor> apostasAsseguradasValor;
	private HashMap<Integer, ApostaSeguraTaxa> apostasAsseguradasTaxa;
	private HashSet<Aposta> apostasSemSeguro;

	/**
	 * Construtor de Cenario Bonus
	 * @param id, Inteiro com o id unico do Cenario
	 * @param descricao, String com a descricao do Cenario
	 * @param bonus, Inteiro com o valor ofericido do bonus
	 * @throws Exception
	 */
	public CenarioBonus(int id, String descricao, int bonus) throws Exception {
		super(id, descricao);
		if (descricao.equals("") || descricao.equals(" ") || descricao == null)
			throw new Exception("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		if (bonus <= 0)
			throw new Exception("Erro no cadastro de cenario: Bonus invalido");
		this.id = id;
		this.bonus = bonus;
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
	 * getBonus
	 * Retorna o bonus do Cenario
	 * @return Inteiro
	 */
	public int getBonus() {
		return bonus;
	}

	/**
	 * setValorTotalDeApostas
	 * @param valor, Inteiro com o novo valor total das apostas 
	 */
	public void setValorTotalDeApostas(int valor) {
		this.valorTotalDeApostas = valor;
	}

	/**
	 * getValorTotalDeApostas
	 * Retorna o valor total de apostas
	 * @return Inteiro
	 */
	public int getValorTotalDeApostas() {
		return valorTotalDeApostas;
	}

	/**
	 * getCaixaCenario
	 * Retorna caixa do cenario
	 * @return Inteiro
	 */
	public int getCaixaCenario() {
		return caixaCenario;
	}

	/**
	 * setCaixaCenario
	 * Altera o valor do caixa Cenario
	 * @param valor, Inteiro com novo valor do Caixa do Cenario
	 */
	public void setCaixaCenario(int valor) {
		this.caixaCenario = valor;
	}

	/**
	 * getEstado
	 * Retorna o Estado do Cenario
	 * @return String
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * setEstado
	 * Altera o Estado do Cenario
	 * @param resultado, boolean com o valor do resultado
	 */
	public void setEstado(boolean resultado) {
		if (resultado)
			this.estado = "Finalizado (ocorreu)";
		else
			this.estado = "Finalizado (n ocorreu)";
	}

	/**
	 * getId
	 * Retorna o id unico do Cenario
	 * @return Inteiro
	 */
	public int getId() {
		return id;
	}

	/**
	 * getDescricao
	 * Retorna a descricao do Cenario
	 * @return String
	 */
	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		String bonusFormatado = "R$ "+String.format("%.2f", (double) bonus/100);
		return id + " - " + descricao + " - " + estado + " - "+bonusFormatado;
	}

	/**
	 * getQtdApostasSeguradasCadastradas
	 * Retorna a quantidade de apostas asseguradas cadastradas
	 * @return Inteiro
	 */
	public int getQtdApostasSeguradasCadastradas() {
		return qtdApostasSeguradasCadastradas;
	}

	/**
	 * setQtdApostasSeguradasCadastradas
	 * Incrementa a quantidade de apostas asseguradas cadastradas
	 */
	private void setQtdApostasSeguradasCadastradas() {
		this.qtdApostasSeguradasCadastradas++;
	}

	/**
	 * adicicionaApostaSemSeguro
	 * Adiciona uma aposta sem seguro ao array do Cenario
	 * @param Aposta
	 */
	public void adicicionaApostaSemSeguro(Aposta aposta) {
		apostasSemSeguro.add(aposta);
	}

	/**
	 * adicionaApostaComSeguroValor
	 * Adiciona uma ApostaSeguraValor ao HashMap do Cenario
	 * @param ApostaSeguraValor
	 */
	public void adicionaApostaComSeguroValor(ApostaSeguraValor aposta) {
		setQtdApostasSeguradasCadastradas();
		aposta.setId(getQtdApostasSeguradasCadastradas());
		apostasAsseguradasValor.put(getQtdApostasSeguradasCadastradas(), aposta);
	} 

	/**
	 * adicionaApostaComSeguroTaxa
	 * Adiciona uma ApostaSeguraTaxa ao HashMap do Cenario
	 * @param ApostaSeguraTaxa
	 */
	public void adicionaApostaComSeguroTaxa(ApostaSeguraTaxa aposta) {
		setQtdApostasSeguradasCadastradas();
		aposta.setId(getQtdApostasSeguradasCadastradas());
		apostasAsseguradasTaxa.put(getQtdApostasSeguradasCadastradas(), aposta);
	}
	
	/**
	 * alteraTipoApostaParaTaxa
	 * Altera o tipo de seguro da aposta de valor para taxa
	 * @param id, Inteiro com o id unico da aposta ligado ao cenario
	 * @param aposta, ApostaSeguraTaxa que sera adicionado ao cenario
	 */
	public void alteraTipoApostaParaTaxa(int id, ApostaSeguraTaxa aposta) {
		apostasAsseguradasValor.remove(id);
		apostasAsseguradasTaxa.put(id, aposta);
	}
	
	/**
	 * alteraTipoApostaParaValor
	 * Altera o tipo de seguro da aposta de valor para taxa
	 * @param id, Inteiro com o id unico da aposta ligado ao cenario
	 * @param aposta, ApostaSeguraValor que sera adicionado ao cenario
	 */
	public void alteraTipoApostaParaValor(int id, ApostaSeguraValor aposta) {
		apostasAsseguradasTaxa.remove(id);
		apostasAsseguradasValor.put(id, aposta);
	}
	
	/**
	 * getValorTotalDoRateio
	 * Retorna o valor total do rateio
	 * @return Inteiro
	 */
	public int getValorTotalDoRateio() {
		return valorTotalDoRateio;
	}

	/**
	 * setValorTotalDoRateio
	 * Altera o Valor do Rateio total do Cenario
	 * @param valor, Inteiro com o novo valor
	 */
	public void setValorTotalDoRateio(int valor) {
		this.valorTotalDoRateio = valor;
	}

	/**
	 * getAposta
	 * Retorna uma ApostaSeguraTaxa
	 * @param idAposta, int com o id da aposta
	 * @return ApostaSeguraTaxa
	 */
	public ApostaSeguraTaxa getAposta(int idAposta) {
		if (apostasAsseguradasTaxa.containsKey(idAposta))
			return apostasAsseguradasTaxa.get(idAposta);
		return null;
	}

	/**
	 * getAposta
	 * Retorna uma ApostaSeguraValor
	 * @param idAposta, int com o id da aposta
	 * @return ApostaSeguraValor
	 */
	public ApostaSeguraValor getApostaSeguraValor(int idAposta) {
		if (apostasAsseguradasValor.containsKey(idAposta))
			return apostasAsseguradasValor.get(idAposta);
		return null;
	}

	/**
	 * valorTotalDeApostas
	 * Retorna o valor total das apostas
	 * @return Interio
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
	 * totalDeApostas
	 * Retorna a quantidade total de apostas realizadas
	 * @return Inteiro
	 */
	public int totalDeApostas() {
		return apostasAsseguradasValor.size() + apostasAsseguradasTaxa.size() + apostasSemSeguro.size();
	}

	/**
	 * exibirApostas
	 * Retorna as apostas feitas
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
	 * calculaValorSeguros
	 * Retorna o valor total dos seguros
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
					valorDosSeguros += (int)(apostasAsseguradasTaxa.get(i).getValor()
							* apostasAsseguradasTaxa.get(i).getTaxa());
				}
			}
		}
		return valorDosSeguros;
	}

	/**
	 * calculaValorApostasPerdedoras
	 * Retorna o valor das apostas perdedoras do Cenario
	 * @param resultado, boolean com o resultado do cenario
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
					if (apostasAsseguradasTaxa.get(i).getPrevisao().equalsIgnoreCase("N VAI ACONTECER"))
						valor += apostasAsseguradasTaxa.get(i).getValor();
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
					if (apostasAsseguradasTaxa.get(i).getPrevisao().equalsIgnoreCase("VAI ACONTECER"))
						valor += apostasAsseguradasTaxa.get(i).getValor();
				}
			}
		}
		return valor;
	}

	/**
	 * encerra
	 * Encerra o cenario
	 * @param resultado, boolean com o resultado cenario
	 * @param taxa, double com a taxa do caixa do sistema
	 */
	public int encerra(boolean resultado, double taxa) {
		int valorApostasPerdedoras = calculaValorApostasPerdedoras(resultado);
		int valorDosSeguros = calculaValorSeguros();
		int valordoCaixaCenario = (int) (valorApostasPerdedoras * taxa) - valorDosSeguros;
		System.out.println(valorApostasPerdedoras + " " + valordoCaixaCenario + " " + valorDosSeguros);
		setCaixaCenario(valordoCaixaCenario);
		setEstado(resultado);
		setValorTotalDoRateio(valorApostasPerdedoras - valordoCaixaCenario + getBonus());
		return valordoCaixaCenario;
	}

	/**
	 * atualizaAtributos
	 * Atualiza alguns atributos do Cenario
	 */
	public void atualizaAtributos() {
		setValorTotalDeApostas(valorTotalDeApostas());
	}
}
