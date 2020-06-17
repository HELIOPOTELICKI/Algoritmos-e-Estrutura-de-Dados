/*
 * Trabalho 3 - Tabelas de Dispersão
 * 
 * Grupo: Trab3-10
 *		Hélio Potelicki; 
 *		João Vitor Persuhn;
 *		Luis Augusto Kühn.
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