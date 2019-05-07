package fabrica;

import controladores.ControllerAjuda;
import controladores.ControllerAluno;
import controladores.ControllerCaixa;
import controladores.ControllerHorarioLocal;
import controladores.ControllerTutor;
import servicos.ServiceAjuda;
import servicos.ServiceAluno;
import servicos.ServiceCaixaSistema;
import servicos.ServiceHorarioLocais;
import servicos.ServiceTutor;

public final class FabricaSistema {
	private ServiceAluno serviceAluno;
	private ServiceTutor serviceTutor;
	private ServiceHorarioLocais serviceHL;
	private ServiceAjuda serviceAjuda;
	private ServiceCaixaSistema serviceCaixa;
	private ControllerAluno alunoController;
	private ControllerTutor tutorController;
	private ControllerHorarioLocal horarioLocalController;
	private ControllerAjuda ajudaController;
	private ControllerCaixa caixaController;

	public FabricaSistema() {
		this.create();
	}

	public void create() {
		this.serviceAluno = new ServiceAluno();
		this.serviceTutor = new ServiceTutor(this.serviceAluno);
		this.serviceHL = new ServiceHorarioLocais(this.serviceTutor);
		this.serviceAjuda = new ServiceAjuda(this.serviceTutor, this.serviceHL, this.serviceAluno);
		this.serviceCaixa = new ServiceCaixaSistema(this.serviceTutor);
		this.alunoController = new ControllerAluno(this.serviceAluno);
		this.tutorController = new ControllerTutor(this.serviceTutor);
		this.horarioLocalController = new ControllerHorarioLocal(this.serviceHL);
		this.ajudaController = new ControllerAjuda(this.serviceAjuda);
		this.caixaController = new ControllerCaixa(this.serviceCaixa);
	}
	
	public ControllerAluno getAlunoController() {
		return this.alunoController;
	}

	public ControllerTutor getTutorController() {
		return this.tutorController;
	}
	
	public ControllerHorarioLocal getHorarioLocalController() {
		return this.horarioLocalController;
	}
	
	public ControllerAjuda getAjudaController() {
		return this.ajudaController;
	}
	
	public ControllerCaixa getCaixaController() {
		return this.caixaController;
	}

}
