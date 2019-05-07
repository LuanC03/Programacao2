package p2_cg;

public class Biblioteca extends Jogo{
	
	private double max_Score;
	
	public Biblioteca(String nome_Game, double preco, double score, boolean zerou, double max_Score) throws Exception {
		super(nome_Game, preco, score, zerou);
		this.max_Score = max_Score;
	}

	@Override
	public double getMax_Score() {
		return max_Score;
	}

	@Override
	public void setMax_Score(double max_Score) {
		this.max_Score = max_Score; 
		
	}

}
