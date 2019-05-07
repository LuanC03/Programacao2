package p2_cg;

import java.util.ArrayList;

public abstract class Usuario {

	protected String nome_Usuario;
	protected static String nome_Login;
	protected String tipo_Usuario;
	protected int valor_Total_Compras = 0;
	protected ArrayList<Jogo> jogos;
	
	public Usuario(String nome_Usuario, String nome_Login, String tipo_Usuario, int valor_Total_Compras) throws Exception {
		
		if (nome_Usuario == null || nome_Usuario.trim().equals("")){
			throw new Exception("Nome de Usuario é Obrigatorio");
		}
		if (nome_Login == null || nome_Login.trim().equals("")){
			throw new Exception("Nome de Login é Obrigatorio");
		}
		if (tipo_Usuario == null || tipo_Usuario.trim().equals("")){
			throw new Exception("Tipo de Usuario é Obrigatorio");
		}
		Usuario.nome_Login = nome_Login;
		this.nome_Usuario = nome_Usuario;
		this.tipo_Usuario = tipo_Usuario;
		this.jogos = new ArrayList<Jogo>();
		this.valor_Total_Compras = Loja.getValor_Total();
		}
	
	public void Altera_Tipo_Usuario(){
		if(1000 <= getX2p()){
			setTipo_Usuario("Veterano");
		}
	}
	
	protected abstract int getX2p();
	protected abstract void setX2p(int x2p);
	
	public int getValor_Total_Compras() {
		return valor_Total_Compras;
		}
	public void setValor_Total_Compras(int valor_Total_Compras) {
		this.valor_Total_Compras = valor_Total_Compras;
		}
	public String getTipo_Usuario() {
		return tipo_Usuario;
		}
	public void setTipo_Usuario(String tipo_Usuario) {
		this.tipo_Usuario = tipo_Usuario;
		}
	public void setNome_Usuario(String nome_Usuario) {
		this.nome_Usuario = nome_Usuario;
		}
	public void setNome_Login(String nome_Login) {
		Usuario.nome_Login = nome_Login;
		}
	public ArrayList<Jogo> getJogos() {
		return jogos;
		}
	public void setJogos(ArrayList<Jogo> jogos) {
		this.jogos = jogos;
		}
	public String getNome_Usuario() {
		return nome_Usuario;
		}
	public static String getNome_Login() {
		return nome_Login;
		}
	
}
