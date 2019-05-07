package servicos;

import java.util.ArrayList;
import java.util.List;

import modelos.ajuda.Ajuda;
import modelos.ajuda.AjudaOnline;
import modelos.ajuda.AjudaPresencial;

public class ServiceAjuda {

	private ServiceTutor serviceTutor;
	private ServiceHorarioLocais serviceHL;
	private ServiceAluno serviceAluno;
	private List<Ajuda> ajudas;
	
	public ServiceAjuda(ServiceTutor serviceTutor, ServiceHorarioLocais serviceHL, ServiceAluno serviceAluno) {
		this.ajudas = new ArrayList<>();
		this.serviceTutor = serviceTutor;
		this.serviceHL = serviceHL;
		this.serviceAluno = serviceAluno;
	}
	
	private String setTutorAjuda(String disciplina, String horario, String dia, String local) {
		List<String> matriculas = new ArrayList<>();
		for (String matricula : this.serviceTutor.searchTutor(disciplina).split(",")) {
			String email = serviceAluno.getInfoAluno(matricula, "Email");
			if (serviceHL.contemHorario(email, horario, dia) && serviceHL.contemLocal(email, local)) {
				matriculas.add(matricula);
			}
		}
		String[] input = matriculas.toArray(new String[matriculas.size()]);
		return this.serviceTutor.melhorTutorAvaliado(input);
	}
	
	public int cadastrarAjudaPresencial(String matrAluno, String disciplina, String horario, String dia, String localInteresse) {
		this.ajudas.add(new AjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse));
		int id = this.ajudas.size();
		this.ajudas.get(id - 1).setMatriculaTutor(this.setTutorAjuda(disciplina, horario, dia, localInteresse));
		return this.ajudas.size();
	}
	
	private String setTutorAjuda(String disciplina) {
		List<String> matriculas = new ArrayList<>();
		for (String matricula : this.serviceTutor.searchTutor(disciplina).split(",")) {
			matriculas.add(matricula);
		}
		String[] input = matriculas.toArray(new String[matriculas.size()]);
		return this.serviceTutor.melhorTutorAvaliado(input);
	}
	
	public int cadastrarAjudaOnline (String matrAluno, String disciplina) {
		this.ajudas.add(new AjudaOnline(matrAluno, disciplina));
		int id = this.ajudas.size();
		this.ajudas.get(id - 1).setMatriculaTutor(this.setTutorAjuda(disciplina));
		return id;
	}
	
	
	public String getTutorAjuda(int id) {
		if (id > this.ajudas.size()) {
			throw new NullPointerException("Erro ao tentar recuperar tutor : id nao encontrado ");
		} else {
			return this.ajudas.get(id - 1).toString();
		}
		
	}

	public String getInfoAjuda(int id, String atributo) {
		if (id > this.ajudas.size()) {
			throw new NullPointerException("Erro ao tentar recuperar info da ajuda : id nao encontrado ");
		}
		switch(atributo.toLowerCase()) {
		
		case "disciplina":
			return this.ajudas.get(id - 1).getDisciplina();
		case "horario":
			return ((AjudaPresencial) this.ajudas.get(id - 1)).getHorario();
		case "dia":
			return ((AjudaPresencial) this.ajudas.get(id - 1)).getDia();
		case "localinteresse": 
			return ((AjudaPresencial) this.ajudas.get(id - 1)).getLocalInteresse();
		default :
			throw new NullPointerException("Erro ao tentar recuperar info da ajuda : atributo nao encontrado");
		}
	}
	
	public void concluirAjuda(int id, int nota) {
		if (this.ajudas.size() == 12) {	
			this.ajudas.get(11);
		}
		if (nota < 0) {
			throw new NumberFormatException("Erro na avaliacao de tutor: nota nao pode ser menor que 0");
		}
		else if (nota > 5) {
			throw new NumberFormatException("Erro na avaliacao de tutor: nota nao pode ser maior que 5");
		}
		else if (id > this.ajudas.size()) {
			throw new NullPointerException("Erro na avaliacao de tutor: id nao encontrado ");
		}
		else if (this.ajudas.get(id - 1).getMatriculaTutor() == null) {
			throw new NullPointerException("Erro na avaliacao de tutor: Ajuda nao atribuida a tutor");
		}
		else if (this.ajudas.get(id - 1).getConclusaoAjuda()) {
			throw new NullPointerException("Erro na avaliacao de tutor: Ajuda ja avaliada");
		}
		else {
			this.ajudas.get(id - 1).setConcluirAjuda();
			this.serviceTutor.avaliarTutor(nota, this.ajudas.get(id - 1).getMatriculaTutor());
		}
	}
}
