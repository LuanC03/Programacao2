package classePrincipal;

import fabrica.FabricaSistema;

public class Facade {
	private FabricaSistema fabricaSistema;
	
	public Facade() {
		this.fabricaSistema = new FabricaSistema();
	}
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.fabricaSistema.getAlunoController().cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}
	
	public String recuperaAluno(String matricula) {
		return this.fabricaSistema.getAlunoController().recuperaAluno(matricula);
	}
	
	public String listarAlunos() {
		return this.fabricaSistema.getAlunoController().listarAlunos();
	}
	
	public String getInfoAluno(String matricula, String atributo) {
		return this.fabricaSistema.getAlunoController().getInfoAluno(matricula, atributo);
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		this.fabricaSistema.getTutorController().tornarTutor(matricula, disciplina, proficiencia);
	}
	
	public String recuperaTutor(String matricula) {
		return this.fabricaSistema.getTutorController().recuperaTutor(matricula);
	}
	
	public String listarTutores() {
		return this.fabricaSistema.getTutorController().listarTutores();
	}
	
	public void cadastrarHorario(String email, String horario, String dia) {
		this.fabricaSistema.getHorarioLocalController().cadastrarHorario(email, horario, dia);
	}
	
	public void cadastrarLocalDeAtendimento(String email, String local) {
		this.fabricaSistema.getHorarioLocalController().cadastrarLocalDeAtendimento(email, local);
	}
	
	public boolean consultaHorario(String email, String horario, String dia) {
		return this.fabricaSistema.getHorarioLocalController().consultaHorario(email, horario, dia);
	}
	
	public boolean consultaLocal(String email, String local) {
		return this.fabricaSistema.getHorarioLocalController().consultaLocal(email, local);
	}
	
	public int pedirAjudaPresencial (String matrAluno, String disciplina, String horario, String dia, String localInteresse) {
		return this.fabricaSistema.getAjudaController().pedirAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse);
	}
	
	public int pedirAjudaOnline (String matrAluno, String disciplina) {
		return this.fabricaSistema.getAjudaController().pedirAjudaOnline(matrAluno, disciplina);
	}
	
	public String pegarTutor(int idAjuda) {
		return this.fabricaSistema.getAjudaController().pegarTutor(idAjuda);
	}
	
	public String getInfoAjuda(int idAjuda, String atributo) {
		return this.fabricaSistema.getAjudaController().getInfoAjuda(idAjuda, atributo);
	}
	
	public void avaliarTutor(int idAjuda, int nota) {
		this.fabricaSistema.getAjudaController().avaliarTutor(idAjuda, nota);
	}
	
	public String pegarNota(String matriculaTutor) {
		return this.fabricaSistema.getTutorController().pegarNota(matriculaTutor);
	}
	
	public String pegarNivel(String matriculaTutor) {
		return this.fabricaSistema.getTutorController().pegarNivel(matriculaTutor);
	}

	public void doar(String matriculaTutor, int totalCentavos) {
		this.fabricaSistema.getCaixaController().doar(matriculaTutor, totalCentavos);
	}
	
	public int totalDinheiroTutor(String emailTutor) {
		return this.fabricaSistema.getCaixaController().totalDinheiroTutor(emailTutor);
	}
	
	public int totalDinheiroSistema() {
		return this.fabricaSistema.getCaixaController().totalDinheiroSistema();
	}
}
