package modelos.ajuda;

public abstract class Ajuda {
	
	
	private String disciplina;
	private String matriculaAluno;
	private String matriculaTutor;
	private boolean concluida;
	
	
	public Ajuda(String matrAluno, String disciplina) {
		if (matrAluno == null || matrAluno.trim().equals("")) {
			throw new AjudaException(new NullPointerException("Matricula do Aluno nao pode ser null ou em branco."));
		}
		else if (disciplina == null || disciplina.trim().equals("")) {
			throw new AjudaException(new NullPointerException("Disciplina nao pode ser null ou em branco."));
		} else {
			this.matriculaAluno = matrAluno;
			this.disciplina = disciplina;
			this.concluida = false;
		}
	}
	
	public void setMatriculaTutor(String matriculaTutor) {
		this.matriculaTutor = matriculaTutor;
	}

	public String getMatriculaTutor() {
		return this.matriculaTutor;
	}
	
	public String getDisciplina() {
		return this.disciplina;
	}
	
	public String getMatriculaAluno() {
		return this.matriculaAluno;
	}
	
	public void setConcluirAjuda() {
		this.concluida = true;
	}
	
	public boolean getConclusaoAjuda() {
		return this.concluida;
	}
	
	@Override
	public String toString() {
		return "Tutor - " + this.matriculaTutor +", disciplina - " + this.disciplina;
	}
}
