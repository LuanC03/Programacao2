package systemTrackingThings;

import java.io.File;
import java.util.ArrayList;

import easyaccept.EasyAccept;
import exceptionsAdicionais.UsuarioInvalidoException;
import exceptionsAdicionais.ValorExceptions;
import systemTrackingThings.Item.Item;
import systemTrackingThings.Item.JogosEletronicos;
import systemTrackingThings.Usuario.ControleUsuarios;
import systemTrackingThings.Usuario.Usuario;


public class TrackingThingsFacade {
	
	private ControleUsuarios controle = new ControleUsuarios();
	
	public void iniciarSistema(){
		
	}
	public void fecharSistema() {
		
	}
	
	public void cadastrarUsuario(String nome, String telefone, String email) throws ValorExceptions{
		controle.cadastrarUsuario(nome, email, telefone);		
	}
	
	public String getInfoUsuario(String nome, String telefone, String atributo){
		return controle.getInfoUsuario(nome, telefone, atributo);
	}
	
	public void removerUsuario(String nome, String telefone) throws UsuarioInvalidoException{
		controle.removerUsuario(nome, telefone);
	}
	
	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) throws ValorExceptions {
		controle.alteraUsuario(nome, telefone, atributo, valor);
	}
	
	public void cadastraEletronico(String nomeUser, String telefoneUser, String nomeItem, double precoItem, String plataforma) {
		Usuario usuario = controle.procuraUsuario(nomeUser, telefoneUser);
		Item eletronico = new JogosEletronicos(nomeItem, precoItem, plataforma);
		usuario.adicionaItemEmprestavel(eletronico);
	}
	
	public static void main(String[] args) throws Exception {
	       
	       ArrayList<String> testes = new ArrayList<>();
	       testes.add("easyaccept" + File.separator + "us1_test.txt");
	       testes.add("easyaccept" + File.separator + "us2_test.txt");
	       testes.add("easyaccept" + File.separator + "us3_test.txt");
	       testes.add("easyaccept" + File.separator + "us4_test.txt");
	       EasyAccept.executeEasyAcceptTests("systemTrackingThings.TrackingThingsFacade", testes);
	}
}
