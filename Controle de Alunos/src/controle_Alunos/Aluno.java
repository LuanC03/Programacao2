package controle_Alunos;

public class Aluno {
	
	private String matricula;
	private String nome;
	private String curso;

	@SuppressWarnings("unused")
	public Aluno(String matricula, String nome, String curso)throws Exception {
		if(matricula.equals("")||matricula.equals(" "))
			throw new Exception("Matricula Nao Pode Ser Vazia");
		if(matricula == null)
			throw new Exception("Matricula Nao Pode Ser Nulo");
		if(nome.equals("")||nome.equals(" "))
			throw new Exception("Nome Nao Pode Ser Vazia");
		if(nome == null)
			throw new Exception("Nome Nao Pode Ser Nulo");
		if(curso.equals("")||curso.equals(" "))
			throw new Exception("Curso Nao Pode Ser Vazia");
		if(curso == null)
			throw new Exception("Curso Nao Pode Ser Nulo");
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getCurso() {
		return curso;
	}

	@Override
	public String toString() {
		return "Aluno: " +this.matricula+" - "+this.nome+" - "+this.curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

}
