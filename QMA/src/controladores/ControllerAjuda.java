package controladores;

import servicos.ServiceAjuda;

public class ControllerAjuda {
	
	private ServiceAjuda serviceAjuda;
	
	public ControllerAjuda(ServiceAjuda serviceAjuda) {
		this.serviceAjuda = serviceAjuda;
	}
	
	public int pedirAjudaPresencial (String matrAluno, String disciplina, String horario, String dia, String localInteresse) {
		if (matrAluno == null || matrAluno.trim().equals("")) {
			throw new NullPointerException("Erro no pedido de ajuda presencial: matricula de aluno nao pode ser vazio ou em branco");
		}
		else if (disciplina == null || disciplina.trim().equals("")) {
			throw new NullPointerException("Erro no pedido de ajuda presencial: disciplina nao pode ser vazio ou em branco");
		}
		else if (horario == null || horario.trim().equals("")) {
			throw new NullPointerException("Erro no pedido de ajuda presencial: horario nao pode ser vazio ou em branco");
		}
		else if (dia == null || dia.trim().equals("")) {
			throw new NullPointerException("Erro no pedido de ajuda presencial: dia nao pode ser vazio ou em branco");
		}
		else if (localInteresse == null || localInteresse.trim().equals("")) {
			throw new NullPointerException("Erro no pedido de ajuda presencial: local de interesse nao pode ser vazio ou em branco");
		}
		return this.serviceAjuda.cadastrarAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse);
	}
	
	public int pedirAjudaOnline (String matrAluno, String disciplina) {
		if (matrAluno == null || matrAluno.trim().equals("")) {
			throw new NullPointerException("Erro no pedido de ajuda online: matricula de aluno nao pode ser vazio ou em branco");
		}
		if (disciplina == null || disciplina.trim().equals("")) {
			throw new NullPointerException("Erro no pedido de ajuda online: disciplina nao pode ser vazio ou em branco");
		}
		return this.serviceAjuda.cadastrarAjudaOnline(matrAluno, disciplina);
	}
	
	public String pegarTutor(int idAjuda) {
		if (idAjuda < 0) {
			throw new NullPointerException("Erro ao tentar recuperar tutor : id nao pode menor que zero ");
		}
		return this.serviceAjuda.getTutorAjuda(idAjuda);
	}
	
	public String getInfoAjuda(int idAjuda, String atributo) {
		if (idAjuda < 0) {
			throw new NullPointerException("Erro ao tentar recuperar info da ajuda : id nao pode menor que zero ");
		}
		if (atributo == null || atributo.trim().equals("")) {
			throw new NullPointerException("Erro ao tentar recuperar info da ajuda : atributo nao pode ser vazio ou em branco");
		}
		else {
			return this.serviceAjuda.getInfoAjuda(idAjuda, atributo);
		}
	}
	
	public void avaliarTutor(int id, int nota) {
		this.serviceAjuda.concluirAjuda(id, nota);
	}

}
