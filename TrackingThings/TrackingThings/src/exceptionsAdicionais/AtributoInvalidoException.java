package exceptionsAdicionais;

public class AtributoInvalidoException extends ValorExceptions {

	private static final long serialVersionUID = 1L;// adicionado para suprimir a Warning expedida pelo eclipse

	public AtributoInvalidoException() {
		super("Atributo invalido");
	}

}
