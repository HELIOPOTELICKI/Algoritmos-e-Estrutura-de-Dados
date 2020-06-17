/*
 * Trabalho 3 - Tabelas de Dispers�o
 * 
 * Grupo: Trab3-10
 *		H�lio Potelicki; 
 *		Jo�o Vitor Persuhn;
 *		Luis Augusto K�hn.
 */

public interface Lista<T> {

	void insere(T valor);

	void insere(T valor, int posicao);

	int localiza(T valor);

	T retira(int posicao);

	String imprime();

	Lista<T> concatena(Lista<T> outra);

	T busca(int posicao);

	int getQuantidade();

	Lista<T> divide();

	Lista<T> copia();

	boolean estaVazia();

}