package modelos.aluno;

@SuppressWarnings("serial")
public class AlunoException extends RuntimeException {
	
	public AlunoException() {
		super();
	}
	
	public AlunoException(String msg) {
		super(msg);
	}
	
	public AlunoException(RuntimeException erro) {
		super(erro);
	}

}
