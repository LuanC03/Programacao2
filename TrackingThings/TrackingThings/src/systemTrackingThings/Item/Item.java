package systemTrackingThings.Item;

import systemTrackingThings.Usuario.Status;

/**
 * Classe de itens.
 * @author Caio Simplicio 
 * Adicionei Gets e Sets para ajudar na recuperacao de atributos para serem usados posteriormente e hashCode e equals
 * para nao conter dois Item(s) iguais.
 * @author Luan Carlos.
 * @version 1.2
 */

public class Item implements Comparable<Item> {
	
	protected String nome;
	protected double valor;
	protected Status status;
	
	/**
	 * Construtor da classe Item.
	 * @param 	nome 	Nome em String do item.
	 * @param	valor 	Valor em double do item.
	 * @throws Nome e valor invalido, relativo ao cadastro de itens.
	 * @author Caio Simplicio 
	 * @version 1.0
	 */
	public Item(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
		this.status = Status.DISPONIVEL; // O valor esta como Default o DISPONIVEL, podendo ser alterado.
	}
	
	/**
	  * Metodo alteraStatus, que altera o status do item (DISPONIVEL/INDISPONIVEL).
	  * @author Caio Simplicio
	  * @since 1.0
	  */
	public void alteraStatus() {
		if (this.status.equals(Status.DISPONIVEL))
			this.status = Status.INDISPONIVEL;
		else 
			this.status = Status.DISPONIVEL;
	}

	/**
	  * Gets gerados para agir sobre os atributos do Item.
	  * @author Luan Carlos
	  * @since 1.2
	  */
	
	public String getNome() {
		return nome;
	}

	public double getValor() {
		return valor;
	}

	public Status getStatus() {
		return status;
	}
	
	

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	/**
	  * HashCode e Equals, para testar se dois Item(s) sao iguais, utilizando atributo Nome para isso.
	  * @author Luan Carlos
	  * @since 1.1
	  */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/** Metodo compareTo que implementa a interface Comparable.
	  * @author Caio Simplicio
	  * @return inteiro correspondente a comparacao dos valores
	  * @since 1.4
	  */

	@Override
	public int compareTo(Item o) {
		if (this.valor < o.valor) {
            return -1;
        }
        if (this.valor > o.valor) {
            return 1;
        }
        return 0;
	}
	
}