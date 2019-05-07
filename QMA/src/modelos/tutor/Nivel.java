package modelos.tutor;

public class Nivel {
	
	private double avaliacao;
	private Doacao nivel;
	
	private void setNivel() {
		if (this.avaliacao > 4.5) {
			this.nivel = new NivelTop();
		}
		else if (this.avaliacao > 3) {
			this.nivel = new NivelTutor();
		}
		else {
			this.nivel = new NivelAprendiz();
		}
	}
	
	public Nivel(double avaliacao) {
		this.avaliacao = avaliacao;
		this.setNivel();
	}
	
	public double getAvaliacao() {
		return this.avaliacao;
	}
	
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = (this.avaliacao * 5 + avaliacao) / 6;
		this.setNivel();
	}
	
	public double getTaxa() {
		return this.nivel.getTaxa(this.avaliacao);
	}
	
	public String getNivel() {
		return this.nivel.toString();
	}
}
