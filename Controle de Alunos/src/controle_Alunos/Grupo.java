package controle_Alunos;

public class Grupo {
	
	private String nome;

	public Grupo(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	@Override
	public String toString() {
		return "Grupo: " + nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Grupo other = (Grupo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
