package exceptionsAdicionais;

public class UsuarioJaCadastradoException extends ValorExceptions {
	
	private static final long serialVersionUID = 1L; // adicionado para suprimir a Warning expedida pelo eclipse

	public UsuarioJaCadastradoException(){
		super("Usuario ja cadastrado");
	}
}