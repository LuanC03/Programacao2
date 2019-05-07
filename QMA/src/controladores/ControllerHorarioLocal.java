package controladores;

import servicos.ServiceHorarioLocais;

public class ControllerHorarioLocal {
	
	private ServiceHorarioLocais serviceHL;
	
	public ControllerHorarioLocal(ServiceHorarioLocais serviceHL) {
		this.serviceHL = serviceHL;
	}
	
	public void cadastrarHorario(String email, String horario, String dia) {
		if (email == null || email.trim().equals("")) {
			throw new NullPointerException("Erro no cadastrar horario: email nao pode ser vazio ou em branco");
		}		
		else if (horario == null || horario.trim().equals("")) {
			throw new NullPointerException("Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
		}
		else if (dia == null || dia.trim().equals("")) {
			throw new NullPointerException("Erro no cadastrar horario: dia nao pode ser vazio ou em branco");
		} else {
			this.serviceHL.cadastrarHorario(email, horario, dia);
		}
	}
	
	public boolean consultaHorario(String email, String horario, String dia) {
		return this.serviceHL.contemHorario(email, horario, dia);
	}
	
	public void cadastrarLocalDeAtendimento(String email, String local) {
		if (email == null || email.trim().equals("")) {
			throw new NullPointerException("Erro no cadastrar local de atendimento: email nao pode ser vazio ou em branco");
		}		
		else if (local == null || local.trim().equals("")) {
			throw new NullPointerException("Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		}
		else {
			this.serviceHL.cadastrarLocal(email, local);
		}
	}

	public boolean consultaLocal(String email, String local) {
		return this.serviceHL.contemLocal(email, local);
	}

}
