package systemTrackingThings.Emprestimos;
import java.util.ArrayList;
import exceptionsAdicionais.EmprestimoNaoEncontradoException;
import exceptionsAdicionais.ItemIndisponivelException;
import systemTrackingThings.Item.Item;
import systemTrackingThings.Usuario.Status;

public class ControleEmprestimos {
    private Emprestimo emprestimo;
    public ArrayList<Emprestimo> emprestimos;
    public ArrayList<Item> itens;
    
    
    public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
            String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) throws Exception {
        for (Item item : itens) {
            if (Status.DISPONIVEL.equals(item.getStatus())) {
                try {
                    emprestimo = new Emprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem,
                            dataEmprestimo, periodo);
                    item.alteraStatus();
                } catch (ItemIndisponivelException e) {
                    throw new ItemIndisponivelException();
                }
            }
        }
        emprestimos.add(emprestimo);
    }
    public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
            String nomeItem, String dataEmprestimo, String dataDevolucao) throws EmprestimoNaoEncontradoException {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getNomeDono().equalsIgnoreCase(nomeDono)
                    && emprestimo.getNomeItem().equalsIgnoreCase(nomeItem)
                    && emprestimo.getNomeRequerente().equalsIgnoreCase(nomeRequerente)
                    && emprestimo.getTelefoneDono().equals(telefoneDono)
                    && emprestimo.getTelefoneRequerente().equals(telefoneRequerente)
                    && emprestimo.getDataEmprestimo().equals(dataEmprestimo)) {
                emprestimo.setDataFinal(dataDevolucao);
                for (Item item : itens) {
                    if (Status.INDISPONIVEL.equals(item.getStatus())
                            && emprestimo.getNomeItem().equalsIgnoreCase(nomeItem)) {
                        item.alteraStatus();
                    }
                }
            }else {
                throw new EmprestimoNaoEncontradoException();
            }
        }
    }
    
}