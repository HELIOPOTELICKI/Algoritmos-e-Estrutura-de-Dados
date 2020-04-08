public interface Lista<T> {
    boolean estaCheia();

    boolean estaVazia();

    int quantidade();

    String imprime();

    void insere(T valor);

    void insere(T valor, int posicao);

    T retira(int posicao);

    T busca(int posicao);

    int localiza(T valor);

    Lista<T> copia();
}
