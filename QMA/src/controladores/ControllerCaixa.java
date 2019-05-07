package controladores;

import servicos.ServiceCaixaSistema;

public class ControllerCaixa {
	
	private ServiceCaixaSistema serviceCaixa;

	public ControllerCaixa(ServiceCaixaSistema serviceCaixa) {
		this.serviceCaixa = serviceCaixa;
	}
	
	public void doar(String matriculaTutor, int totalCentavos) {
		if (matriculaTutor == null || matriculaTutor.trim().equals("")) {
			throw new NullPointerException();
		}
		else if (totalCentavos < 0) {
			throw new NumberFormatException("Erro na doacao para tutor: totalCentavos nao pode ser menor que zero");
		}
		else {
			this.serviceCaixa.doar(matriculaTutor, totalCentavos);
		}
	}
	
	public int totalDinheiroTutor(String emailTutor) {
		if (emailTutor == null || emailTutor.trim().equals("")) {
			throw new NullPointerException("Erro na consulta de total de dinheiro do tutor: emailTutor nao pode ser vazio ou nulo");
		}
		return this.serviceCaixa.totalDinheiroTutor(emailTutor);
	}
	
	public int totalDinheiroSistema() {
		return this.serviceCaixa.getValorCaixa();
	}
}