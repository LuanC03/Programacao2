package exceptionsAdicionais;

/**
 * Classe de excecao relativa a nome invalido.
 * @author Caio Simplicio
 * @since 1.3 
 */
public class NomeInvalidoException extends ValorExceptions {

	
	private static final long serialVersionUID = 1L; // adicionado para suprimir a Warning expedida pelo eclipse
	
	public NomeInvalidoException(){
		super("Nome inválido");
	}
}
