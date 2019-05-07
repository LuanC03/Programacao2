package systemTrackingThings.Item;

/**
 * Classe BluRaySerie, que herda BluRay
 * 
 * @author Lucca Bongiovi
 * @version 1.0
 */

public class BluRaySerie extends BluRay {

	protected int colecaoTemporada;
	protected int duracaoTotal;
	protected Genero genero;
	protected String descricao;

	/**
	 * Construtor da classe BluRay.
	 * 
	 * @param nome
	 *            Nome em String, herdado de Item, por meio de Bluray.
	 * @param valor
	 *            Valor em double, herdado de Item, por meio de Bluray.
	 * @param duracao
	 *            Duração do BluRay em inteiro, herdado de Bluray.
	 * @param classificacao
	 *            Classificação do BluRay, herdado de Bluray.
	 * @param colecaoTemporada
	 *            Colecao de Temporada do BluRaySerie em String.
	 * @param descricao
	 *            Descricao do BluRaySerie em String.
	 * @param genero
	 *            Enum referente a Genero, do BluRaySerie.
	 * @throws Colecao
	 *             de temporada e descricao , relativo ao cadastro de itens de
	 *             tipo BlurayShow.
	 * @author Lucca Bongiovi
	 * @version 1.0
	 */
	public BluRaySerie(String nome, double valor, int duracao, Classificacao classificacao, Genero genero,
			int colecaoTemporada, String Descricao) {
		super(nome, valor, duracao, classificacao);
		this.genero = genero;
		this.colecaoTemporada = colecaoTemporada;
	}

	/**
	 * Gets gerados para agir sobre os atributos de BlueRaySerie. Usando
	 * HashCode e Equals de Item.
	 * 
	 * @author Lucca Bongiovi
	 * @since 1.0
	 */

	public int getColecaoTemporada() {
		return colecaoTemporada;
	}

	public int getDuracaoTotal() {
		return duracaoTotal;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getDescricao() {
		return descricao;
	}

}