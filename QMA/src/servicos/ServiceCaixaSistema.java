package servicos;

import modelos.caixaSistema.CaixaSistema;
import servicos.ServiceTutor;

public class ServiceCaixaSistema {
	
	private CaixaSistema caixa;
	private ServiceTutor serviceTutor;
	
	
	public ServiceCaixaSistema(ServiceTutor serviceTutor) {
		this.caixa = new CaixaSistema(0);
		this.serviceTutor = serviceTutor;
	}	
	
	public void addValorCaixa(int valor) {
		this.caixa.addValor(valor);
	}

	public int getValorCaixa() {
		return this.caixa.getCaixa();
	}
	
	public void doar(String matriculaTutor, int totalCentavos) {
		if (!this.serviceTutor.containsTutor(matriculaTutor)) {
			throw new NullPointerException("Erro na doacao para tutor: Tutor nao encontrado");
		}
		int valorDoacao = (int) (totalCentavos * this.serviceTutor.getTaxaAvaliacao(matriculaTutor));
		this.serviceTutor.doar(matriculaTutor, valorDoacao);
		this.caixa.addValor(totalCentavos - valorDoacao);
	}

	public int totalDinheiroTutor(String emailTutor) {
		String matricula = this.serviceTutor.getMatricula(emailTutor);
		if (matricula == null) {
			throw new NullPointerException("Erro na consulta de total de dinheiro do tutor: Tutor nao encontrado");
		}
		else {
			return this.serviceTutor.getTutor(matricula).getCarteira();
		}
	}
}
