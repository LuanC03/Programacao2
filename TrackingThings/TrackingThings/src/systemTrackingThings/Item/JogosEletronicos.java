package systemTrackingThings.Item;

/**
 * Classe JogosEletronicos, que herda Item. 
 * @author Luan Carlos 
 * @version 1.0
 */

public class JogosEletronicos extends Item {
	
	private String nome;
	private Plataformas plataformas;

	/**
	 * Construtor do Objeto JogosEletronicos, extends do Objeto Item.
	 * @param nome Nome em String, herdado de Item.
	 * @param valor Valor em double, herdado de Item.
	 * @param plataformas Enum de plataformas, implementado de Plataformas
	 * @throws Exception
	 */
	public JogosEletronicos(String nome, double valor, String plataformas) {
		super(nome, valor);
		this.nome = nome;
		if(plataformas.equalsIgnoreCase("PC")) {
			this.plataformas = Plataformas.PC;
		} else if (plataformas.equalsIgnoreCase("MAC")) {
			this.plataformas = Plataformas.MAC;
		} else if (plataformas.equalsIgnoreCase("PS3")) {
			this.plataformas = Plataformas.PS3;
		} else if (plataformas.equalsIgnoreCase("PS4")) {
			this.plataformas = Plataformas.PS4;
		} else if( plataformas.equalsIgnoreCase("XBOX360")) {
			this.plataformas = Plataformas.XBOX360;
		} else if (plataformas.equalsIgnoreCase("XBOX_ONE")) {
			this.plataformas = Plataformas.XBOX_ONE;
		} else if (plataformas.equalsIgnoreCase("NINTENDO_3DS")) {
			this.plataformas = Plataformas.NINTENDO_3DS;
		} else {
			this.plataformas = Plataformas.OUTRO;
		}
	}

	/**
	 * Gets de Nome e Plataformas para recuperar atributos do Objeto JogosEletronicos
	 * HashCode e Equals trabalhando em cima dos parametros nome e plataformas, para verificar
	 * se existem dois Objetos JogosEletronicos iguais.
	 * @author Luan Carlos 
	 */
	
	public String getNome() {
		return nome;
	}

	public Plataformas getPlataformas() {
		return plataformas;
	}	
	

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPlataformas(String plataformas) {
		if(plataformas.equalsIgnoreCase("PC")) {
			this.plataformas = Plataformas.PC;
		} else if (plataformas.equalsIgnoreCase("MAC")) {
			this.plataformas = Plataformas.MAC;
		} else if (plataformas.equalsIgnoreCase("PS3")) {
			this.plataformas = Plataformas.PS3;
		} else if (plataformas.equalsIgnoreCase("PS4")) {
			this.plataformas = Plataformas.PS4;
		} else if( plataformas.equalsIgnoreCase("XBOX360")) {
			this.plataformas = Plataformas.XBOX360;
		} else if (plataformas.equalsIgnoreCase("XBOX_ONE")) {
			this.plataformas = Plataformas.XBOX_ONE;
		} else if (plataformas.equalsIgnoreCase("NINTENDO_3DS")) {
			this.plataformas = Plataformas.NINTENDO_3DS;
		} else {
			this.plataformas = Plataformas.OUTRO;
		}

	}

	@Override
	public String toString() {
		return "JogosEletronicos [nome=" + nome + ", plataformas=" + plataformas + ", valor=" + valor + ", status="
				+ status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((plataformas == null) ? 0 : plataformas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		JogosEletronicos other = (JogosEletronicos) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (plataformas != other.plataformas)
			return false;
		return true;
	}


	
}
