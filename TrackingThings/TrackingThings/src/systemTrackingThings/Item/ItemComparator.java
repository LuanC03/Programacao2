package systemTrackingThings.Item;

import java.util.Comparator;

/** Classe ItemComparator que define a estrategia de ordenacao da classe Item
 * @author Caio Simplicio
 * @since 1.4
 */

public class ItemComparator implements Comparator<Item> {
	
	/** Metodo compare que define a estrategia de ordenacao por nome do item.
	  * @author Caio Simplicio
	  * @return inteiro correspondente a comparacao dos valores
	  * @since 1.4
	  */
	@Override
	public int compare(Item item1, Item item2) {
		return item1.getNome().compareTo(item2.getNome());
	}

}
