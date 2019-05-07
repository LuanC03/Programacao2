package systemTrackingThings.Item;

public abstract class BluRay extends Item {
	
	protected int duracao;
	protected Classificacao classificacao;

	/**
	 * Construtor da classe BluRay.
	 * 
	 * @param nome
	 *            Nome em String, herdado de Item.
	 * @param valor
	 *            Valor em double, herdado de Item.
	 * @param duracao
	 *            Duracao do BluRay em inteiro.
	 * @throws Nome
	 *             e valor invalido, relativo ao cadastro de itens.
	 * @author Caio Simplicio
	 * @param classificacao
	 *            Classificacao do BluRay, em Enum.
	 * @author Luan Carlos
	 * @version 1.1 
	 */
	public BluRay(String nome, double valor, int duracao, Classificacao classificacao) {
		super(nome, valor);
		this.duracao = duracao;
		this.classificacao = classificacao;
	}

	/**
	 * Get Duracao que retorna inteiro referente a duracao do BluRay e
	 * getClassificacao que retorna estado referente a Classificacao Indicativa
	 * do BluRay
	 * 
	 * @author Luan Carlos
	 * @version 1.1
	 */
	public int getDuracao() {
		return duracao;
	}

	public Classificacao getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}
	
	
}
