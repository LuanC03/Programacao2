package p2_cg;

public abstract class Jogo {

	private String nome_Game;
	private static double preco;
	private int partidas_Jogadas = 0;
	private int zeradas = 0;
	private boolean zerou;
	private double score;
	public Jogo (String nome_Game, double preco, double score, boolean zerou) throws Exception{
		if (nome_Game == null || nome_Game.trim().equals("")) {
			throw new Exception("O Jogo tem que ter um nome.");
		}
		this.nome_Game = nome_Game;
		Jogo.preco = preco;
		this.score = score;
		this.zerou = zerou;
	}

	public boolean registraJogada() {
		setPartidas_Jogadas(getPartidas_Jogadas()+1);
		if(getScore() > getMax_Score()){
			setMax_Score(getScore());
	}
		if(zerou){
		setZeradas(getZeradas()+1);
		return true;}else{return false;}
	}
	
	public int getPartidas_Jogadas() {
		return partidas_Jogadas;
	}

	public void setPartidas_Jogadas(int partidas_Jogadas) {
		this.partidas_Jogadas = partidas_Jogadas;
	}

	public int getZeradas() {
		return zeradas;
	}

	public void setZeradas(int zeradas) {
		this.zeradas = zeradas;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getNome_Game() {
		return nome_Game;
	}

	public static double getPreco() {
		return preco;
	}
	
	public abstract double getMax_Score();

	public abstract void setMax_Score(double max_Score);
				
}
