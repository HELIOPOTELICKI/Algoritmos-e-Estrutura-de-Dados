/*
 * Trabalho 3 - Tabelas de Dispers�o
 * 
 * Grupo: Trab3-10
 *		H�lio Potelicki; 
 *		Jo�o Vitor Persuhn;
 *		Luis Augusto K�hn.
 */

public class ItemLista<T> {
	private T info;
	private ItemLista<T> prox;
	
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public ItemLista<T> getProx() {
		return prox;
	}
	public void setProx(ItemLista<T> prox) {
		this.prox = prox;
	}
}
