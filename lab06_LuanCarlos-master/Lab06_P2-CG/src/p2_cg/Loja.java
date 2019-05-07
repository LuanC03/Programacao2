package p2_cg;

public class Loja {

	private Usuario[] Usuarios;
	private double cash_Virtual;
	private static int valor_Total;
		
	private void Venda(){
		for (int i = 0; i < Usuarios.length; i++) {
			if(Usuarios[i].equals(Usuario.getNome_Login())){
				if(getCash_Virtual() > Jogo.getPreco()){
					setCash_Virtual(getCash_Virtual() - Jogo.getPreco());
					setValor_Total(Jogo.getPreco());
	}}}}
	public static int getValor_Total() {
		return valor_Total;
	}
	
	public double getCash_Virtual() {
		return cash_Virtual;
	}

	public void setCash_Virtual(double cash_Virtual) {
		this.cash_Virtual = cash_Virtual;
	}

	public Usuario[] getUsuarios() {
		return Usuarios;
	}

	public void setValor_Total(double valor_Total) {
		Loja.valor_Total = (int) valor_Total;
	}

	
}
