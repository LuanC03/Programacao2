package controladores;

import modelos.aluno.Aluno;
import servicos.ServiceAluno;

public class ControllerAluno {

	private ServiceAluno serviceAluno;
	
	public ControllerAluno(ServiceAluno serviceAluno) {
		this.serviceAluno = serviceAluno;
	}

	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		if (nome == null || nome.trim().equals("")) {
			throw new NullPointerException("Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo");
		}
		if (matricula == null || matricula.trim().equals("")) {
			throw new NullPointerException("Erro no cadastro de matricula: Matricula nao pode ser vazio ou nulo");
		}
		else if (!email.matches("[a-zA-Z0-9_.-]+@{1}[a-zA-Z0-9_.-]*\\.+[a-z]{2,4}")) {
			throw new NullPointerException("Erro no cadastro de aluno: Email invalido");
		}
		else if (this.serviceAluno.containsAluno(matricula)) {
			throw new NullPointerException("Erro no cadastro de aluno: Aluno de mesma matricula ja cadastrado");
		}
		
		this.serviceAluno.addAluno(new Aluno(nome, matricula, codigoCurso, telefone, email));
	}

	public String recuperaAluno(String matricula) {
		if (!this.serviceAluno.containsAluno(matricula)) {
			throw new NullPointerException("Erro na busca por aluno: Aluno nao encontrado");
		}
		return this.serviceAluno.toStringAluno(matricula);
	}

	public String listarAlunos() {
		return this.serviceAluno.getAllAlunos();
	}

	public String getInfoAluno(String matricula, String atributo) {
		if (!this.serviceAluno.containsAluno(matricula)) {
			throw new NullPointerException("Erro na obtencao de informacao de aluno: Aluno nao encontrado");
		}
		return this.serviceAluno.getInfoAluno(matricula, atributo.toLowerCase());
	}
}
