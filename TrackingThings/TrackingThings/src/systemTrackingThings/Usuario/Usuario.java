package systemTrackingThings.Usuario;

import java.util.HashSet;

import systemTrackingThings.Item.Item;

/**
 * Classe de usuurios do Sistema Tracking Things. 
 * @author Caio Simpl�cio 
 * @version 1.0
 */

public class Usuario {
	private String nome;
	private String email;
	private String numeroCelular;
	private HashSet<Item> itensEmprestaveis;

	/**
	  * Construtor da classe Usuario.
	  * @param 	nome	Nome do usuario.
	  * @param	email 	Email do usuario.
	  * @param	numeroCelular 	Numero do celular do usuario. 	
	  * @throws Nome invalido, E-mail Invalido e Numero invalido, relativos ao cadastro do usuario.
	  * @author Caio Simplacio
	  * @since 1.0
	  */
	public Usuario(String nome, String email, String numeroCelular) {
		this.nome = nome;
		this.email = email;
		this.numeroCelular = numeroCelular;
		this.itensEmprestaveis = new HashSet<>();
	}
	
	/**
	  * Metodo de adiciona item ao set de itens que podem ser emprestados do usuario.
	  * @param 	item 	item a ser adicionado
	  * @author Caio Simplicio
	  * @since 1.0
	  */
	
	public boolean adicionaItemEmprestavel(Item item) {
		return this.itensEmprestaveis.add(item);
	}
	
	/**
	  * Metodo que remove item ao HashSet de itens de usuario.
	  * @param 	item 	item a ser removido
	  * @author Caio Simplicio
	  * @since 1.0
	  */
	
	public boolean removeItem(Item item) {
		return this.itensEmprestaveis.remove(item);
	}
	
	public Item pesquisaItemPeloNome(String nome) {
		for (Item item : itensEmprestaveis) {
			if(item.getNome().equals(nome)) {
				return item;
			}
		}
		return null;
		
	}
	
	/**
	  * Gets e Sets gerados para agir sobre os atributos do Usuario.
	  * @author Caio Simplicio
	  * @since 1.0
	  */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	
	/**
	  * Metodo toString.
	  * @return 	String que representa o nome, email e numero do celular do usuario.
	  * @author Caio Simplicio
	  * @since 1.0
	  */
	@Override
	public String toString() {
		return this.nome + ", " + this.email + ", " + this.numeroCelular;
	}
	
	/**
	  * Metodo hashCode e equals, que compara se dois usuarios sao iguais.
	  * @author Caio Simplicio
	  * @since 1.0
	  */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroCelular == null) ? 0 : numeroCelular.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroCelular == null) {
			if (other.numeroCelular != null)
				return false;
		} else if (!numeroCelular.equals(other.numeroCelular))
			return false;
		return true;
	}

	
	
}
