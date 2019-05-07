package controladores;

import servicos.ServiceTutor;

public class ControllerTutor {
	
	private ServiceTutor serviceTutor;
	
	public ControllerTutor(ServiceTutor serviceTutor) {
		this.serviceTutor = serviceTutor;	
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		if (matricula == null || matricula.trim().equals("")) {
			throw new NullPointerException("Erro na definicao de papel: Matricula invalida");
		}
		else if (disciplina == null || disciplina.trim().equals("")) {
			throw new NullPointerException("Erro na definicao de papel: Disciplina invalida");
		}
		else if (proficiencia < 1) {
			throw new NullPointerException("Erro na definicao de papel: Proficiencia invalida");
		}
		this.serviceTutor.addTutor(matricula, disciplina, proficiencia);
	}
	
	public String recuperaTutor(String matricula) {
		if (!this.serviceTutor.containsTutor(matricula)) {
			throw new NullPointerException("Erro na busca por tutor: Tutor nao encontrado");
		}
		return this.serviceTutor.getToStringTutor(matricula);
	}
	
	public String listarTutores() {
		return this.serviceTutor.getAllTutores();
	}
	
	public String pegarNota(String matriculaTutor) {
		if (matriculaTutor == null || matriculaTutor.trim().equals("")) {
			throw new NullPointerException();
		} else {
			return this.serviceTutor.getNota(matriculaTutor);	
		}
	}

	public String pegarNivel(String matriculaTutor) {
		if (matriculaTutor == null || matriculaTutor.trim().equals("")) {
			throw new NullPointerException();
		} else {
			return this.serviceTutor.getNivel(matriculaTutor);
		}
	}	
}
