package servicos;

import java.util.HashMap;
import java.util.Map;

import modelos.tempo.Horario;
import modelos.tempo.Local;

public class ServiceHorarioLocais {

	private ServiceTutor serviceTutor;
	private Map<String, Local> locaisAtendimento;
	private Map<String, Horario> horarios;
	
	public ServiceHorarioLocais(ServiceTutor serviceTutor) {
		this.serviceTutor = serviceTutor;
		this.locaisAtendimento = new HashMap<>();
		this.horarios = new HashMap<>();
	}
	
	public void cadastrarHorario(String email, String horario, String dia) {
		if (!this.serviceTutor.getAllTutores().contains(email)) {
			throw new NullPointerException("Erro no cadastrar horario: tutor nao cadastrado");
		} 
		else if (this.horarios.containsKey(email)) {
			this.addHorario(email, horario, dia);
		} 
		else {
			this.horarios.put(email, new Horario(horario, dia));
		}
	}
	
	public void addHorario(String email, String horario, String dia) {
		this.horarios.get(email).addHorario(horario, dia);
	}

	public boolean contemHorario(String email, String horario, String dia) {
		if (this.horarios.containsKey(email) && this.horarios.get(email).contemDia(dia)) {
			return this.horarios.get(email).getHorario(dia).equals(horario);
		} return false;
		
	}

	public void cadastrarLocal(String email, String local) {
		if (!this.serviceTutor.getAllTutores().contains(email)) {
			throw new NullPointerException("Erro no cadastrar local de atendimento: tutor nao cadastrado");
		}
		else if (this.locaisAtendimento.containsKey(email)) {
			this.locaisAtendimento.get(email).addLocal(local);
		} else {
			this.locaisAtendimento.put(email, new Local(local));
		}
	}
	
	public boolean contemLocal(String email, String local) {
		if (this.horarios.containsKey(email)) {
			return this.locaisAtendimento.get(email).contemLocal(local);
		} return false;
	}
}
