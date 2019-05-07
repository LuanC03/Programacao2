package systemTrackingThings.Item;

/**
 * Classe BluRayFilme, que herda BluRay.
 * 
 * @author Luan Carlos
 * @version 1.0
 */

public class BluRayFilme extends BluRay {

	protected Genero genero;
	protected int anoLancamento;

	/**
	 * Construtor de BluRayFilme
	 * 
	 * @param nome
	 *            Nome em String, herdado de Item, por meio de Bluray.
	 * @param valor
	 *            Valor em double, herdado de Item, por meio de Bluray.
	 * @param duracao
	 *            Duracao do BluRay em inteiro, herdado de Bluray.
	 * @param classificacao
	 *            Classificacao do BluRay, herdado de Bluray.
	 * @param genero
	 *            Enum referente a Genero, do BluRayFilme.
	 * @param anoLancamento
	 *            anoLancamento em inteiro do BluRayFilme.
	 * @throws Exception
	 */
	public BluRayFilme(String nome, double valor, int duracao, Classificacao classificacao, Genero genero,
			int anoLancamento) {
		super(nome, valor, duracao, classificacao);
		this.genero = genero;
		this.anoLancamento = anoLancamento;
	}

	/**
	 * Gets gerados para agir sobre os atributos do BluRayFilme. Usa o HashCode
	 * e Equals do Item.
	 * 
	 * @author Luan Carlos
	 * @since 1.0
	 */

	public Genero getGenero() {
		return genero;
	}
	
	public double getValor() {
		return valor;
	}
	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}


}
