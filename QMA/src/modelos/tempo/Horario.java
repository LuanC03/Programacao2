package modelos.tempo;

import java.util.HashMap;
import java.util.Map;

public class Horario {
	
	private Map<String, String> database;
	
	public Horario(String horario, String dia) {
		if (horario == null || horario.trim().equals("")) {
			throw new TempoException(new NullPointerException("Erro na criacao de horario: Horario nao pode ser null ou em branco."));
		}
		else if (dia == null || dia.trim().equals("")) {
			throw new TempoException(new NullPointerException("Erro na criacao de horario: Dia nao pode ser null ou em branco."));
		} else {
			this.database = new HashMap<>();
			this.addHorario(horario, dia);
		}
	}
	
	public void addHorario(String horario, String dia) {
		if (horario == null || horario.trim().equals("")) {
			throw new TempoException(new NullPointerException("Erro ao adcionar horario: Horario nao pode ser null ou em branco."));
		}
		else if (dia == null || dia.trim().equals("")) {
			throw new TempoException(new NullPointerException("Erro ao adcionar horario: Dia nao pode ser null ou em branco."));
		} else {
			this.database.put(dia, horario);
		}
		
	}
	
	public String getHorario(String dia) {
		if (!this.database.containsKey(dia)) {
			throw new TempoException(new IllegalArgumentException("Erro ao recuperar horario: Dia nao cadastrado."));
		}
		return this.database.get(dia);
	}
	
	public String getAllHorarios() {
		String saida = "";
		for (String dia : this.database.keySet()) {
			saida += dia + System.lineSeparator() +  this.database.get(dia) + "\n";
		}
		return saida;
	} 
	
	public String getDias() {
		String saida = "";
		for (String dia : this.database.keySet()) {
			saida += dia + System.lineSeparator();
		}
		return saida;
	}
	
	public boolean contemDia(String dia) {
		return this.database.containsKey(dia);
	}
}
