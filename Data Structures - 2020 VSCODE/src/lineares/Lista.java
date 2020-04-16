package lineares;

public interface Lista<T> {

	// Metodos

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