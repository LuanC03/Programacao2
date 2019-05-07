package modelos.aluno;

public class Aluno implements Comparable<Aluno> {
	private String nome;
	private String matricula;
	private int codigoCurso;
	private String telefone;
	private String email;

	private void checkCadastro(String nome, String matricula, String email, int condigoDoCurso) {
		if (nome == null || nome.trim().equals(""))
			throw new AlunoException(new NullPointerException("Nome nao pode ser null ou em branco."));
		else if (matricula == null || matricula.trim().equals(""))
			throw new AlunoException(new NullPointerException("Matricula nao pode ser null ou em branco."));
		else if (email == null || email.trim().equals(""))
			throw new AlunoException(new NullPointerException("Email nao pode ser null ou em branco."));
		else if (codigoCurso < 0)
			throw new AlunoException(new NumberFormatException("Codigo do curso nao pode ser negativo"));
	}

	public Aluno(String nome, String matricula, int codigoDoCurso, String telefone, String email) {
		this.checkCadastro(nome, matricula, email, codigoDoCurso);
		this.nome = nome;
		this.matricula = matricula;
		this.codigoCurso = codigoDoCurso;
		this.telefone = telefone;
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public int getCodigoDoCurso() {
		return this.codigoCurso;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public String getEmail() {
		return this.email;
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

	@Override
	public int compareTo(Aluno outroAluno) {
		return this.nome.compareTo(outroAluno.nome);
	}

	@Override
	public String toString() {
		return this.telefone.equals("")
				? this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " + this.email
				: this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " + this.telefone + " - "
						+ this.email;
	}

}
