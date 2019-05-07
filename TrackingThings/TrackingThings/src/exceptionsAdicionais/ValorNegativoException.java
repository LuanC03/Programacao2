package exceptionsAdicionais;

/**
 * Classe que encapsula a excecao de valor negativo.
 * @author Caio Simplicio
 * @since 1.3 
 */
public class ValorNegativoException extends ValorExceptions {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;// adicionado para suprimir a Warning expedida pelo eclipse

	public ValorNegativoException(){
		super("Valor invalido por ser negativo.");
	}
}
