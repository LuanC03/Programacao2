package p2_cg;

public class Veterano extends Usuario {

	private int x2p;
	
	public Veterano(String nome_Usuario, String nome_Login, double cash_Virtual, 
			String tipo_Usuario,int valor_Total_Compras, int x2p) throws Exception {
		super(nome_Usuario, nome_Login, tipo_Usuario, valor_Total_Compras);
		this.x2p = x2p;
	}

	public int getX2p() {
		return x2p;
	}

	public void setX2p(int x2p) {
		this.x2p = x2p;
	}

	

}
