package systemTrackingThings.Emprestimos;

public class Emprestimo {
	
    private String nomeDono;
    private String telefoneDono;
    private String nomeRequerente;
    private String telefoneRequerente;
    private String nomeItem;
    private String dataEmprestimo;
    private int periodo;
    private String dataFinal;
    
    public Emprestimo(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
            String nomeItem, String dataEmprestimo, int periodo) throws Exception {
        this.nomeDono = nomeDono;
        this.telefoneDono = telefoneDono;
        this.nomeRequerente = nomeRequerente;
        this.telefoneRequerente = telefoneRequerente;
        this.nomeItem = nomeItem;
        this.dataEmprestimo = dataEmprestimo;
        this.periodo = periodo;
        this.dataFinal = null;
    }
    public String getNomeDono() {
        return nomeDono;
    }
    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }
    public String getTelefoneDono() {
        return telefoneDono;
    }
    public void setTelefoneDono(String telefoneDono) {
        this.telefoneDono = telefoneDono;
    }
    public String getNomeRequerente() {
        return nomeRequerente;
    }
    public void setNomeRequerente(String nomeRequerente) {
        this.nomeRequerente = nomeRequerente;
    }
    public String getTelefoneRequerente() {
        return telefoneRequerente;
    }
    public void setTelefoneRequerente(String telefoneRequerente) {
        this.telefoneRequerente = telefoneRequerente;
    }
    public String getNomeItem() {
        return nomeItem;
    }
    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }
    public String getDataEmprestimo() {
        return dataEmprestimo;
    }
    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    public int getPeriodo() {
        return periodo;
    }
    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
    public String getDataFinal() {
        return dataFinal;
    }
    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }
}