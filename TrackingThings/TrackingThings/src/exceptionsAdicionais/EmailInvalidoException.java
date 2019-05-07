package exceptionsAdicionais;

/**
 * Classe que encapsula a excecao de email invalido.
 * @author Caio Simplicio
 * @since 1.3 
 */
public class EmailInvalidoException extends ValorExceptions {

	private static final long serialVersionUID = 1L; // adicionado para suprimir a Warning expedida pelo eclipse

	public EmailInvalidoException(){
		super("E-mail invalido.");
	}
}
