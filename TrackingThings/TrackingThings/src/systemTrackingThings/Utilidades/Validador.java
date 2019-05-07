package systemTrackingThings.Utilidades;

/**
 * Classe Validador, que encapsula metodos de valida�ao.
 * @author Caio Simplicio 
 * @version 1.4
 */

public class Validador {

	public Validador() {
		
	}
	
	/**
	 * Metodo de validacao de email, utilizo de alguns metodos dos tipos char e String,
	 * fazendo upcast e downcast dos tipos, e fazendo interacoes sobre eles para poder compara-los.
	 * @param email Email a ser verificado
	 * @return Boolean true para email valido, false para email invalido.
	 */
	public boolean validaEmail(String email) {
		char [] letras = email.toCharArray();
		char arroba = '@';
		int contadorDeArrobas = 0;
		int posicaoDaArroba = 0;
		for (int i = 0; i < letras.length; i++) {
			if(letras[i] == arroba) {
				contadorDeArrobas += 1;
				posicaoDaArroba = i;
			}
		}
		if(contadorDeArrobas > 1 || contadorDeArrobas == 0) {
			return false;
		}
		
		for (int j = posicaoDaArroba+1; j < letras.length; j++) {
			String letra = Character.toString(letras[j]);
			if(letra.equals(".")) {
				return true;
			}
		}
		
		return false;	
		
	}
}
