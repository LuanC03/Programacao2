package exceptionsAdicionais;

/**
 * Classe que encapsula a excecao de numero invalido.
 * @author Caio Simplicio
 * @since 1.3 
 */

public class NumeroInvalidoException extends ValorExceptions {
	
	private static final long serialVersionUID = 1L; // adicionado para suprimir a Warning expedida pelo eclipse

	public NumeroInvalidoException(){
		super("Numero invalido.");
	}
}
