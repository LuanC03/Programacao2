package exceptionsAdicionais;
/**
 * Classe que encapsula a excecao de item indisponivel.
 * @author Luan Carlos
 * @since 1.4
 */
public class ItemIndisponivelException extends ValorExceptions {
    private static final long serialVersionUID = 1L; // adicionado para suprimir a Warning expedida pelo eclipse
    public ItemIndisponivelException(){
        super("Item emprestado no momento");
    }
}