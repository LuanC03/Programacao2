package systemTrackingThings.Item;

import java.util.ArrayList;

import systemTrackingThings.Usuario.Status;

/**

* Controle de Itens do Tracking Things

*

* @author Lucca Bongiovi

* @version 1.0

*/

public class ControleItem {
	
	
	public ArrayList<Item> itens = new ArrayList<>();	
	private String retorno = "";
	
	/**

     * Metodo que cria Objeto Item
     * 
     * @param nome
     *            String Nome, que servira como parametro para criacao do Objeto
     *            Item
     * @param valor
     *            Double valor, que servira como parametro para criacao do Objeto
     *            Item
     * @param status
     *            Status status, que servira como parametro para criacao do Objeto
     *            Item
     * @throws Exception
     *             dos parametros sera relancada para o construtor de Item, onde
     *             sera tratada.
     * @author Lucca Bongiovi

     * @since 1.0

     */
	
	
    public void adicionaItem(String nome, Double valor, Status status) throws Exception {

        Item item = new Item(nome, valor);

        itens.add(item);
    }

    /**

     * Metodo que ira percorrer colecao de Itens.
     * 
     * @param nome
     *            String Nome, servira de parametro de entrada, e para a busca e
     *            comparacao do Objeto Item, por meio de um foreach comparando o
     *            atributo nome por meio do metodo getNome, em Usuario
     * @return toString do Item procurado.

     * @author Lucca Bongiovi

     * @since 1.0

     */
    
    public String procuraItem(String nome) {

        for (Item item : itens) {

            if (item.getNome().equals(nome)) {

                retorno = item.toString();

            } else {

                retorno = "Item nao Cadastrado.";
            }
        }
        return retorno;
    }
    
    /**

     * Metodo que ira alterar o atributo nome do Item.
     * 
     * @param nome
     *        String Nome,  servira para buscar um Item especifico na colecao de Itens
     * @param novoNome
     *            String NovoNome, ira atualizar o atributo nome do Item
     * @return do novo toString do Item em questao.
     * @author Lucca Bongiovi
     * @since 1.0

     */
    
    public String mudaNomeItem(String nome, String novoNome) {

        for (Item item : itens) {

            if (item.getNome().equals(nome)) {

                item.setNome(novoNome);

                retorno = item.toString();
            }
        }
        return retorno;
    }
    

    /**
     * Metodo que ira alterar o atributo valor do Item.
     * 
     * @param nome
     *            String Nome, servira para buscar um Item na colecao
     *            de itens
     * @param novoValor
     *            double novoValor, vai atualizar o atributo valor de Item
     * @return do novo double valor do Item.
     * @author Lucca Bongiovi
     * @since 1.0
     */
    
    
    public double mudaValorItem(String nome, double novoValor) {

        for (Item item : itens) {

            if (item.getNome().equals(nome)) {

                item.setValor(novoValor);

                retorno = item.toString();
            }
        }
        return 0;
    }
    
    
    /**
     * Metodo que ira alterar o Status status do Item.
     * 
     * @param nome
     *            String Nome, servira para buscar um Item na colecao
     *            de itens
     * @param novoStatus
     *            Status novoStatus, vai atualizar o Status do Item
     * @return do novo status do Item
     * @author Lucca Bongiovi
     * @since 1.0
     */
    
    public Status mudaStatusItem(String nome, Status novoStatus) {

        for (Item item : itens) {

            if (item.getNome().equals(nome)) {
            	
                item.setStatus(novoStatus);

                retorno = item.toString();
            }
        }
        return novoStatus;
    }
    
    /**
     * Metodo que ira excluir o Item.
     * 
     * @param nome
     * @author Lucca Bongiovi
     * @since 1.0
     */
    
    
    public void excluirItem(String nome) {
        for (Item item : itens) {
        	
            if (item.getNome().equals(nome)) {
            	
                itens.remove(item);
            }
        }
    }
    
    
    //Falta implementacao da parte do Hash para interligar o Item com o Usuario
    

	

}