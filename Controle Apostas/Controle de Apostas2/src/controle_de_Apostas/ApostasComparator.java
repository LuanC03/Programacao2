package controle_de_Apostas;

import java.util.Comparator;

public class ApostasComparator implements Comparator<Cenario> {

	public int compare(Cenario cenario, Cenario outroCenario) {
		return cenario.totalDeApostas() - outroCenario.totalDeApostas();
	}
}
