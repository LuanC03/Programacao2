package modelos.ajuda;

public class AjudaPresencial extends Ajuda {

	private String horario;
	private String dia;
	private String localInteresse;
	
	public AjudaPresencial(String matrAluno, String disciplina, String horario, String dia, String localInteresse) {
		super(matrAluno, disciplina);
		if (localInteresse == null || localInteresse.trim().equals("")) {
			throw new AjudaException(new NullPointerException("Local de interesse nao pode ser null ou em branco."));
		}
		else if (horario == null || horario.trim().equals("")) {
			throw new AjudaException(new NullPointerException("Horario nao pode ser null ou em branco."));
		}
		else if (dia == null || dia.trim().equals("")) {
			throw new AjudaException(new NullPointerException("Dia nao pode ser null ou em branco."));
		} else {
			this.localInteresse = localInteresse;
			this.horario = horario;
			this.dia = dia;
		}
	}
	
	public String getHorario() {
		return this.horario;
	}
	
	public String getDia() {
		return this.dia;
	}
	
	public String getLocalInteresse() {
		return this.localInteresse;
	}
	
	@Override
	public String toString() {
		return "Tutor - " + super.getMatriculaTutor() + ", horario - " + this.horario
				+ ", dia - " + this.dia + ", local - " + this.localInteresse + ", disciplina - " + super.getDisciplina();
	}
}
