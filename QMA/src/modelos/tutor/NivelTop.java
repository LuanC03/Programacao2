package modelos.tutor;

public class NivelTop implements Doacao {

	@Override
	public double getTaxa(double avaliacao) {
		return Double.valueOf(String.valueOf(0.90 + ((avaliacao - 4.5) / 10)).substring(0, 4).replace(',', '.'));
	}
	
	@Override
	public String toString() {
		return "TOP";
	}

}
