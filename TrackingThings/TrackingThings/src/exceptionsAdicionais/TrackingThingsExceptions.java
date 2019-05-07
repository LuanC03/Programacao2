package exceptionsAdicionais;

/**
 * Superclasse de exceções do software Tracking Things.
 * @author Caio Simplicio
 * @since 1.3 
 */
public class TrackingThingsExceptions extends Exception {
	
	private static final long serialVersionUID = 1L; // adicionado para suprimir a Warning expedida pelo eclipse
	private String msg;
	
	public TrackingThingsExceptions(String msg){
		super(msg);
		this.msg = msg;
	}
	/**
	 * Metodo getMessage que serah usada em todas as classes herdeiras.
	 * @author Caio Simplicio
	 * @return String correspondente ao valor do erro.
	 * @since 1.3
	 */
	public String getMessage(){
		return msg;
	}
}
