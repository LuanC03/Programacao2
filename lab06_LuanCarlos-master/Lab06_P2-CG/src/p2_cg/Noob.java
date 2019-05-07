package p2_cg;

public class Noob extends Usuario {

	private int x2p;
	
	public Noob(String nome_Usuario, String nome_Login, double cash_Virtual, String tipo_Usuario, int x2p) throws Exception {
		super(nome_Usuario, nome_Login, tipo_Usuario, x2p);
		this.x2p = x2p;
	}
	@Override
	public int getX2p() {
		return x2p;
	}
	
	public void setX2p(int x2p) {
		this.x2p = x2p;
	}

}
