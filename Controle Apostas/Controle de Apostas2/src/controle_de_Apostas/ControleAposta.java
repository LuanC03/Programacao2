/**
 * UFCG- Universidade Federal de Campina Grande
 * @author Luan Carlos da Silva Bezerra
 * Matricula 116110100
 * Graduando em Ciencia da Computacao
 */
package controle_de_Apostas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class ControleAposta {

	private HashMap<Integer, Cenario> cenarios = new HashMap<>();
	private Caixa caixaSistema;
	private int id = 1;
	ArrayList<Cenario> cenariosOrdenados;
	private Comparator<Cenario> comparator;

	private Cenario procuraCenario(int cenario) throws Exception {
		if (cenarios.containsKey(cenario))
			return cenarios.get(cenario);
		else
			return null;
	}

	public void inicializa(int caixa, double taxa) throws Exception {
		caixaSistema = new Caixa(caixa, taxa);
	}

	public int getCaixa() {
		return caixaSistema.getCaixa();
	}

	private void adicionaValorAoCaixa(int valor) {
		caixaSistema.adicionaValor(valor);
	}

	private void retiraValorDoCaixa(int valor) {
		caixaSistema.retiraValor(valor);
	}

	public void cadastrarCenario(String descricao) throws Exception {
		Cenario cenario = new Cenario(id, descricao);
		cenarios.put(id, cenario);
		id++;
	}

	public void cadastrarCenarioBonus(String descricao, int bonus) throws Exception {
		Cenario cenario = new CenarioBonus(id, descricao, bonus);
		retiraValorDoCaixa(bonus);
		cenarios.put(id, cenario);
		id++;
	}

	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) throws Exception {
		Cenario cenarioProcurado = procuraCenario(cenario);
		if (cenario <= 0)
			throw new Exception("Erro no cadastro de aposta: Cenario invalido");
		else if (cenarioProcurado == null)
			throw new Exception("Erro no cadastro de aposta: Cenario nao cadastrado");
		else {
			Aposta aposta = new Aposta(cenario, apostador, valor, previsao);
			cenarios.get(cenario).adicicionaApostaSemSeguro(aposta);
			cenarios.get(cenario).atualizaAtributos();
		}
	}

	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorSeguro,
			int custo) throws Exception {
		if (cenario <= 0)
			throw new Exception("Erro no cadastro de aposta assegurada por valor: Cenario invalido");
		else if (cenarios.containsKey(cenario)) {
			ApostaSeguraValor aposta = new ApostaSeguraValor(cenario, apostador, valor, previsao, valorSeguro, custo);
			cenarios.get(cenario).adicionaApostaComSeguroValor(aposta);
			adicionaValorAoCaixa(custo);

			System.out.println(aposta.getId());
			return aposta.getId();
		} else
			throw new Exception("Erro no cadastro de aposta assegurada por valor: Cenario nao cadastrado");
	}

	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa,
			int custo) throws Exception {
		if (cenario <= 0)
			throw new Exception("Erro no cadastro de aposta assegurada por taxa: Cenario invalido");
		else if (cenarios.containsKey(cenario)) {
			ApostaSeguraTaxa aposta = new ApostaSeguraTaxa(cenario, apostador, valor, previsao, taxa, custo);
			adicionaValorAoCaixa(custo);
			cenarios.get(cenario).adicionaApostaComSeguroTaxa(aposta);
			System.out.println(aposta.getId());
			return aposta.getId();
		} else
			throw new Exception("Erro no cadastro de aposta assegurada por taxa: Cenario nao cadastrado");
	}

	public void alterarSeguroValor(int cenario, int idAposta, int valor) throws Exception {
		Cenario cenarioProcurado = procuraCenario(cenario);
		if (cenario <= 0)
			throw new Exception("Erro no cadastro de aposta assegurada por valor: Cenario invalido");
		else if (cenarioProcurado == null)
			throw new Exception("Erro no cadastro de aposta assegurada por valor: Cenario nao cadastrado");
		else {
			ApostaSeguraTaxa apostaProcurada = procuraApostaSeguraTaxa(cenario, idAposta);
			if (apostaProcurada == null)
				throw new Exception();
			else {
				ApostaSeguraValor aposta = new ApostaSeguraValor(cenario, apostaProcurada.getApostador(),
						apostaProcurada.getValor(), apostaProcurada.getPrevisao(), valor, apostaProcurada.getCusto());
				cenarioProcurado.alteraTipoApostaParaValor(apostaProcurada.getId(), aposta);
				aposta.setId(apostaProcurada.getId());
			}
		}

	}

	private ApostaSeguraTaxa procuraApostaSeguraTaxa(int cenario, int idAposta) {
		ApostaSeguraTaxa aposta = cenarios.get(cenario).getApostaSeguraTaxa(idAposta);
		if (aposta == null)
			return null;
		else
			return aposta;
	}

	private ApostaSeguraValor procuraApostaSeguraValor(int cenario, int idAposta) {
		ApostaSeguraValor aposta = cenarios.get(cenario).getApostaSeguraValor(idAposta);
		if (aposta == null)
			return null;
		else
			return aposta;
	}

	public void alterarSeguroTaxa(int cenario, int idAposta, double taxa) throws Exception {
		Cenario cenarioProcurado = procuraCenario(cenario);
		if (cenario <= 0)
			throw new Exception("Erro no cadastro de aposta assegurada por taxa: Cenario invalido");
		else if (cenarioProcurado == null)
			throw new Exception("Erro no cadastro de aposta assegurada por taxa: Cenario nao cadastrado");
		else {
			ApostaSeguraValor apostaProcurada = (ApostaSeguraValor) procuraApostaSeguraValor(cenario, idAposta);
			if (apostaProcurada == null)
				throw new Exception();
			else {
				ApostaSeguraTaxa aposta = new ApostaSeguraTaxa(cenario, apostaProcurada.getApostador(),
						apostaProcurada.getValor(), apostaProcurada.getPrevisao(), taxa, apostaProcurada.getCusto());
				cenarioProcurado.alteraTipoApostaParaTaxa(apostaProcurada.getId(), aposta);
				aposta.setId(apostaProcurada.getId());
			}
		}
	}

	public int valorTotalDeApostas(int cenario) throws Exception {
		if (cenario <= 0)
			throw new Exception("Erro na consulta do valor total de apostas: Cenario invalido");
		else if (procuraCenario(cenario) == null)
			throw new Exception("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		else
			return cenarios.get(cenario).valorTotalDeApostas();
	}

	public int totalDeApostas(int cenario) throws Exception {
		if (cenario <= 0)
			throw new Exception("Erro na consulta do total de apostas: Cenario invalido");
		else if (procuraCenario(cenario) == null)
			throw new Exception("Erro na consulta do total de apostas: Cenario nao cadastrado");
		else
			return cenarios.get(cenario).totalDeApostas();
	}

	public String exibirCenario(int cenario) throws Exception {
		if (cenario < 0)
			throw new Exception("Erro na consulta de cenario: Cenario invalido");
		else if (procuraCenario(cenario) == null)
			throw new Exception("Erro na consulta de cenario: Cenario nao cadastrado");
		return cenarios.get(cenario).toString();
	}

	public void fecharAposta(int cenario, boolean resultado) throws Exception {
		if (cenario <= 0)
			throw new Exception("Erro ao fechar aposta: Cenario invalido");
		else if (procuraCenario(cenario) == null)
			throw new Exception("Erro ao fechar aposta: Cenario nao cadastrado");
		else if (procuraCenario(cenario).getEstado().equals("Finalizado (ocorreu)")
				|| procuraCenario(cenario).getEstado().equals("Finalizado (n ocorreu)"))
			throw new Exception("Erro ao fechar aposta: Cenario ja esta fechado");
		else
			adicionaValorAoCaixa(cenarios.get(cenario).encerra(resultado, caixaSistema.getTaxa()));
	}

	public int getCaixaCenario(int cenario) throws Exception {
		if (cenario <= 0)
			throw new Exception("Erro na consulta do caixa do cenario: Cenario invalido");
		else if (procuraCenario(cenario) == null)
			throw new Exception("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		else if (procuraCenario(cenario).getEstado().equals("Nao finalizado"))
			throw new Exception("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		else
			return cenarios.get(cenario).getCaixaCenario();
	}

	public int getTotalRateioCenario(int cenario) throws Exception {
		if (cenario <= 0)
			throw new Exception("Erro na consulta do total de rateio do cenario: Cenario invalido");
		else if (procuraCenario(cenario) == null)
			throw new Exception("Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		else if (procuraCenario(cenario).getEstado().equals("Nao finalizado"))
			throw new Exception("Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		else
			return cenarios.get(cenario).getValorTotalDoRateio();
	}

	private ArrayList<Cenario> criaList() {
		cenariosOrdenados = new ArrayList<>();
		for (int i = 0; i < cenarios.size(); i++) {
			if (cenarios.containsKey(i))
				cenariosOrdenados.add(cenarios.get(i));
		}
		return cenariosOrdenados;
	}
		
	public void alterarOrdem(String ordem) throws Exception {
		cenariosOrdenados = criaList();
		if (ordem.equalsIgnoreCase("Cadastro")) {
			//ordem natural
		} else if (ordem.equalsIgnoreCase("Nome")) {
			comparator = new DescricaoComparator();
		} else if (ordem.equalsIgnoreCase("Apostas")) {
			comparator = new ApostasComparator();
		}else {
			throw new Exception("Tipo de Ordenacao falho");
		}
		Collections.sort(cenariosOrdenados, comparator);
		}
	
	
}
