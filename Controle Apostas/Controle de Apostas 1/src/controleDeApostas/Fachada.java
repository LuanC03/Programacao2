package controleDeApostas;

import java.util.ArrayList;
import java.util.HashMap;

public class Fachada {

	private Caixa sistema;
	private HashMap<Integer, Cenario> cenarios;
	private ArrayList<Aposta> todasApostas = new ArrayList<>();
	private int numeracao = 0;
	private final static String N = System.lineSeparator();
	
	public Fachada() {
		// TODO Auto-generated constructor stub
	}

	public void inicializa(int caixa, double taxa) {
		try {
			sistema = new Caixa(caixa, taxa);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public int getCaixa() {
		return sistema.getCaixa();
	}
	
	public void cadastraCenarios(String descricao) {		
		Cenario cenario;
		try {
			numeracao ++;
			cenario = new Cenario(numeracao, descricao);
			cenarios.put(numeracao, cenario);
		} catch (Exception e) {
			numeracao --;
			e.printStackTrace();
		}
		
	}
	
	public String exibirCenario(int cenario) {
		return cenarios.get(cenario).toString();
	}
	
	public String exibirCenarios() {
		String retorno = "";
		for (int i = 0; i < cenarios.size(); i++) {
			retorno += exibirCenario(i+1)+N;
		}
		return retorno;
	}
	
	public void cadastraAposta(int cenario, String apostador, int valor, String previsao) {
		Aposta novaAposta;
		try {
			novaAposta = new Aposta(cenario, apostador, valor, previsao);
			todasApostas.add(novaAposta);
			cenarios.get(cenario).adicionaAposta(novaAposta);
		} catch (Exception e) {
			System.out.println(e);;
		}
		
	}
	
	public int valorTotalDeApostas(int cenario) {
		return cenarios.get(cenario).valorTotalApostas();
	}
	
	public int totalDeApostas(int cenario) {
		return cenarios.get(cenario).totalApostas();
	}
	
	public String exibeApostas(int cenario) {
		return cenarios.get(cenario).retornaApostas();
	}
	
	public void fecharAposta(int cenario, boolean ocorreu) {
		cenarios.get(cenario).encerraCenario(ocorreu, sistema.getTaxa());
	}
	
	public int getCaixaCenario(int cenario) {
		int valor = cenarios.get(cenario).getCaixaCenario();
		sistema.setCaixa(valor);
		return valor;
	}
	
	public int getTotalRateioCenario(int cenario) {
		return cenarios.get(cenario).getValorDoRateio();
	}
}
