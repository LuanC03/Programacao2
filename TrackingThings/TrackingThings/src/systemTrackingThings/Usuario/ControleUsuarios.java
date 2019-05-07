package systemTrackingThings.Usuario;
import java.util.HashSet;

import exceptionsAdicionais.EmailInvalidoException;
import exceptionsAdicionais.NomeInvalidoException;
import exceptionsAdicionais.UsuarioInvalidoException;
import exceptionsAdicionais.UsuarioJaCadastradoException;
import exceptionsAdicionais.ValorExceptions;
import systemTrackingThings.Utilidades.Validador;

/**
 * Controle de usuarios do Sistema Tracking Things.
 *
 * @author Luan Carlos
 * @version 1.1
 */
public class ControleUsuarios {
    public HashSet<Usuario> usuarios = new HashSet<>();
    private String retorno = "";
    private Validador validador = new Validador();
    /**
     * Metodo que ira criar Objeto Usuario.
     * 
     * @param nome
     *            String Nome, que servira como parametro para criacao do Objeto
     *            Usuario
     * @param email
     *            String Email, que servira como parametro para criacao do
     *            Objeto Usuario
     * @param numero
     *            String Numero, que servira como parametro para criacao do
     *            Objeto Usuario
     * @throws Exception
     *             dos parametros sera relancada para o construtor de Usuario,
     *             onde sera tratada.
     * @throws Excepition onde Usuario ja existe ou Email invalido
     * @author Luan Carlos
     * @since 1.1
     */
    public void cadastrarUsuario(String nome, String email, String numero) throws ValorExceptions {
       
        if (!(validador.validaEmail(email))) {
            throw new EmailInvalidoException();
        }
        Usuario usuario = new Usuario(nome, email, numero);
        if(!(usuarios.contains(usuario))) {
        	usuarios.add(usuario);
        } else {
        	throw new UsuarioJaCadastradoException();
        }
    }
    /**
     * Metodo que ira retornar atributo especifico de usuario, de acordo com
     * parametro que vira da fachada
     * 
     * @param nome,
     *            String que servira de parametro da busca de um usuario
     *            especifico.
     * @param telefone,
     *            String que servira de parametro da busca de um usuario
     *            especifico.
     * @param atributo,
     *            String que definira qual atributo sera retornado
     * @return String com o atributo especifico
     * @author Luan Carlos
     */
    public String getInfoUsuario(String nome, String telefone, String atributo) {
        if (atributo.equalsIgnoreCase("Email")) {
            for (Usuario usuario : usuarios) {
                if (usuario.getNome().equals(nome) && usuario.getNumeroCelular().equals(telefone)) {
                    retorno = usuario.getEmail();
                }
            }
        } else if (atributo.equalsIgnoreCase("Telefone")) {
            for (Usuario usuario : usuarios) {
                if (usuario.getNome().equals(nome) && usuario.getNumeroCelular().equals(telefone)) {
                    retorno = (String) usuario.getNumeroCelular();
                }
            }
        } else if (atributo.equalsIgnoreCase("Nome")) {
            for (Usuario usuario : usuarios) {
                if (usuario.getNome().equals(nome) && usuario.getNumeroCelular().equals(telefone)) {
                    retorno = usuario.getNome();
                }
            }
        }else {
        	retorno = "Usuario Inexistente.";
        }
        return retorno;
    }
    
    public void alteraUsuario(String nome, String telefone, String atributo, String valor) throws ValorExceptions {
    	Usuario usuario = procuraUsuario(nome, telefone);
    	if(usuario == null) {
    		throw new UsuarioInvalidoException();
    	}
    	if (atributo.equalsIgnoreCase("Email")) {
			mudaEmailUsuario(usuario, valor);
		} else if (atributo.equalsIgnoreCase("Nome")) {
			mudaNomeUsuario(usuario, valor);
		} else if (atributo.equalsIgnoreCase("Telefone")) {
			mudaCelularUsuario(usuario, valor);
		}
    	    	
    }
    /**
     * Metodo que ira percorrer colecao de usuarios.
     * 
     * @param nome
     *            String Nome, servira de parametro de entrada, e para a busca e
     *            comparacao do Objeto Usuario, por meio de um foreach
     *            comparando o atributo nome por meio do metodo getNome, em
     *            Usuario
     * @return toString do Usuario procurado.
     * @author Luan Carlos
     * @since 1.0
     */
    public Usuario procuraUsuario(String nome, String telefone) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nome) && usuario.getNumeroCelular().equals(telefone)) {
                return usuario;
            }
        }
        return null;
    }
    /**
     * Metodo que ira alterar o atributo nome de Usuario.
     * 
     * @param nome
     *            String Nome, servira para buscar um Usuario especifico na
     *            colecao de usuarios
     * @param novoNome
     *            String NovoNome, ira atualizar o atributo nome de Usuario
     * @author Luan Carlos
     * @since 1.0
     */
    public void mudaNomeUsuario(Usuario usuario, String novoNome) {
    	usuario.setNome(novoNome);
    }
    /**
     * Metodo que ira alterar o atributo email de Usuario.
     * 
     * @param nome
     *            String Nome, servira para buscar um Usuario especifico na
     *            colecao de usuarios
     * @param novoEmail
     *            String NovoEmail, ira atualizar o atributo email de Usuario
     * @author Luan Carlos
     * @throws EmailInvalidoException 
     * @since 1.0
     */
    public void mudaEmailUsuario(Usuario usuario, String novoEmail) throws EmailInvalidoException {
        if (!(validador.validaEmail(novoEmail))) {
            throw new EmailInvalidoException();
        } else {
            usuario.setEmail(novoEmail);
        }
    }
    /**
     * Metodo que ira alterar o atributo numeroCelular de Usuario.
     * 
     * @param nome
     *            String Nome, servira para buscar um Usuario especifico na
     *            colecao de usuarios
     * @param novoCelular
     *            String NovoCelular, ira atualizar o atributo numeroCelular de
     *            Usuario
     * @author Luan Carlos
     * @since 1.0
     */
    public void mudaCelularUsuario(Usuario usuario, String novoCelular) {
        usuario.setNumeroCelular(novoCelular);
    }
    /**
     * Metodo que ira excluir um Usuario especifico da colecao usuarios.
     * 
     * @param nome
     *            String Nome, que servira de parametro de busca para efetuar a
     *            acao de exclusao.
     * @throws NomeInvalidoException 
     * @author Luan Carlos
     * @since 1.1
     */
    public void removerUsuario(String nome, String telefone) throws UsuarioInvalidoException {
    	Usuario usuario = procuraUsuario(nome, telefone);
    	if(!(usuarios.remove(usuario))) {
    		throw new UsuarioInvalidoException();
    	}else {
    		usuarios.remove(usuario);
    	}
    }
}