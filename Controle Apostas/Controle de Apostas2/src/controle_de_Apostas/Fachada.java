/**
 * UFCG- Universidade Federal de Campina Grande
 * @author Luan Carlos da Silva Bezerra
 * Matricula 116110100
 * Graduando em Ciencia da Computacao
 */
package controle_de_Apostas;

import easyaccept.EasyAccept;

public class Fachada {

	private static ControleAposta sistema;

	public static void main(String[] args) {
		sistema = new ControleAposta();
		args = new String[] { "controle_de_Apostas.Fachada", "acceptance_test/us1_test.txt",
				"acceptance_test/us2_test.txt", "acceptance_test/us3_test.txt", "acceptance_test/us4_test.txt",
				"acceptance_test/us5_test.txt", "acceptance_test/us6_test.txt" };
		EasyAccept.main(args);
	}

	public void inicializa(int caixa, double taxa) throws Exception {
		sistema.inicializa(caixa, taxa);
	}

	public int getCaixa() {
		return sistema.getCaixa();
	}

	public void cadastrarCenario(String descricao) throws Exception {
		sistema.cadastrarCenario(descricao);
	}

	public void cadastrarCenario(String descricao, int bonus) throws Exception {
		sistema.cadastrarCenarioBonus(descricao, bonus);
	}

	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) throws Exception {
		sistema.cadastrarAposta(cenario, apostador, valor, previsao);
	}

	public void cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorSeguro,
			int custo) throws Exception {
		sistema.cadastrarApostaSeguraValor(cenario, apostador, valor, previsao, valorSeguro, custo);
	}

	public void cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa,
			int custo) throws Exception {
		sistema.cadastrarApostaSeguraTaxa(cenario, apostador, valor, previsao, taxa, custo);
	}

	public void alterarSeguroValor(int cenario, int apostaAssegurada, int valor) throws Exception {
		sistema.alterarSeguroValor(cenario, apostaAssegurada, valor);
	}

	public void alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) throws Exception {
		sistema.alterarSeguroTaxa(cenario, apostaAssegurada, taxa);
	}

	public int valorTotalDeApostas(int cenario) throws Exception {
		return sistema.valorTotalDeApostas(cenario);
	}

	public int totalDeApostas(int cenario) throws Exception {
		return sistema.totalDeApostas(cenario);
	}

	public String exibirCenario(int cenario) throws Exception {
		return sistema.exibirCenario(cenario);
	}

	public void fecharAposta(int cenario, boolean resultado) throws Exception {
		sistema.fecharAposta(cenario, resultado);
	}

	public int getCaixaCenario(int cenario) throws Exception {
		return sistema.getCaixaCenario(cenario);
	}

	public int getTotalRateioCenario(int cenario) throws Exception {
		return sistema.getTotalRateioCenario(cenario);
	}
}
