package modelos.tutor;

public class NivelAprendiz implements Doacao {

	public double getTaxa(double avaliacao) {
		return Double.valueOf(String.valueOf(0.4 + ((avaliacao - 3) / 10)).substring(0, 4).replace(',', '.'));
	}
	
	@Override
	public String toString() {
		return "Aprendiz";
	}
}
