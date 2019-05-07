package systemTrackingThings.Item;

/**
 * Classe BluRayShow, que herda BluRay.
 * 
 * @author Luan Carlos
 * @version 1.0
 */

public class BluRayShow extends BluRay {

	private String nomeArtista;
	private int numeroFaixas;

	/**
	 * Construtor da classe BluRay.
	 * 
	 * @param nome
	 *            Nome em String, herdado de Item, por meio de Bluray.
	 * @param valor
	 *            Valor em double, herdado de Item, por meio de Bluray.
	 * @param duracao
	 *            Duracao do BluRay em inteiro, herdado de Bluray.
	 * @param classificacao
	 *            Classificacao do BluRay, herdado de Bluray.
	 * @param nomeArtista
	 *            Nome Artista do BlurayShow em String.
	 * @param numeroFaixas
	 *            Numero Faixas do BlurayShow em inteiro.
	 * @throws Nome
	 *             do artista e numero de Faixas invalido, relativo ao cadastro
	 *             de itens de tipo BlurayShow.
	 * @author Luan Carlos
	 * @version 1.0
	 */
	public BluRayShow(String nome, double valor, int duracao, Classificacao classificacao, String nomeArtista,
			int numeroFaixas) {
		super(nome, valor, duracao, classificacao);
		this.nomeArtista = nomeArtista;
		this.numeroFaixas = numeroFaixas;
	}

	/**
	 * Gets gerados para agir sobre os atributos do BluRayShow. Usa o HashCode e
	 * Equals do Item.
	 * 
	 * @author Luan Carlos
	 * @since 1.0
	 */

	public String getNomeArtista() {
		return nomeArtista;
	}

	public int getNumeroFaixas() {
		return numeroFaixas;
	}

}
