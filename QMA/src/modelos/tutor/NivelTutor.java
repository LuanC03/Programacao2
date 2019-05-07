package modelos.tutor;

public class NivelTutor implements Doacao {

	@Override
	public double getTaxa(double avaliacao) {
		return 0.80;
	}

	@Override
	public String toString() {
		return "Tutor";
	}
}
