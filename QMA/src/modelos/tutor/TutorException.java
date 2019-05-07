package modelos.tutor;

@SuppressWarnings("serial")
public class TutorException extends RuntimeException {
	
	public TutorException() {
		super();
	}
	
	public TutorException(RuntimeException re) {
		super(re);
	}
	
	public TutorException(String msg) {
		super(msg);
	}

}
