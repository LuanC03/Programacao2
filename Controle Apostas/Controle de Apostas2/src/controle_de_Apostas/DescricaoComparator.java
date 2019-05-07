package controle_de_Apostas;

import java.util.Comparator;

public class DescricaoComparator implements Comparator<Cenario> {
	
	public int compare(Cenario cenario, Cenario outroCenario) {
		if (outroCenario.getDescricao().compareTo(cenario.getDescricao()) == 1)
			return 1;
		else if (outroCenario.getDescricao().compareTo(cenario.getDescricao()) == -1)
			return -1;
		else
			return 0;
	}
	
}
