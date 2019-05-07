package modelos.ajuda;

@SuppressWarnings("serial")
public class AjudaException extends RuntimeException {
	
	public AjudaException() {
		super();
	}

	public AjudaException(String msg) {
		super(msg);
	}
	
	public AjudaException(RuntimeException erro) {
		super(erro);
	}
}
