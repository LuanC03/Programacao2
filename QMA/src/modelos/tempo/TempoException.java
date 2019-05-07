package modelos.tempo;

@SuppressWarnings("serial")
public class TempoException extends RuntimeException {
	
	public TempoException() {
		super();
	}
	
	public TempoException(String msg) {
		super(msg);
	}
	
	public TempoException(RuntimeException erro) {
		super(erro);
	}

}
