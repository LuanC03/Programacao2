package exceptionsAdicionais;

public class UsuarioInvalidoException extends ValorExceptions {
	
	private static final long serialVersionUID = 1L; // adicionado para suprimir a Warning expedida pelo eclipse

	public UsuarioInvalidoException(){
		super("Usuario invalido");
	}
}
