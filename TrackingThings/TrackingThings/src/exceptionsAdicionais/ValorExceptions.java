package exceptionsAdicionais;

/**
 * Superclasse que encapsula excecoes de valores do sistema.
 * @author Caio Simplicio
 * @since 1.3 
 */
public class ValorExceptions extends TrackingThingsExceptions {

	
	private static final long serialVersionUID = 1L; // adicionado para suprimir a Warning expedida pelo eclipse
	@SuppressWarnings("unused")
	private String msg;
	
	public ValorExceptions(String msg){
		super(msg);
		this.msg = msg;
	}
	
}
