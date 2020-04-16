package filas;

public interface Fila<T> {

	T retira() throws Exception;

	boolean vazia();

	void libera();

	void insere(T v);

}