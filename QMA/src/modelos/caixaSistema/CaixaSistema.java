package modelos.caixaSistema;

public class CaixaSistema {

	private int caixaSistema;
	
	public CaixaSistema(int valorInicial) {
		this.caixaSistema = valorInicial;
	}

	public int getCaixa() {
		return this.caixaSistema;
	}
	
	public void addValor(int valor) {
		this.caixaSistema += valor;
	}
	
}
