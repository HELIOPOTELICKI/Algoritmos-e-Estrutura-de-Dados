package lineares;

public class ListaComArray<T> implements Lista<T> {
	private T[] vetor;
	private int proximo = 0;

	// Construtor
	public ListaComArray() {
		vetor = (T[]) new Object[100];
	}

	public ListaComArray(int tamanho) {
		vetor = (T[]) new Object[tamanho];
	}

	// Metodos
	@Override
	public void insere(T valor) {
		if (proximo == vetor.length) {
			expande();
		}
		vetor[proximo] = valor;
		proximo++;
	}

	private void expande() {
		T[] novoVetor = (T[]) new Object[vetor.length * 2]; // Dobrar o tamanho atual
		for (int i = 0; i < vetor.length; i++) {
			novoVetor[i] = vetor[i];
		}
		vetor = novoVetor;
	}

	@Override
	public void insere(T valor, int posicao) {
		if (posicao < 0 || posicao > proximo) {
			throw new ListaException("Poicao Invalida");
		}
		if (proximo == vetor.length) {
			expande();
		}
		T temp;
		for (int i = posicao; i <= proximo; i++) {
			temp = vetor[i];
			vetor[i] = valor;
			valor = temp;
		}
		proximo++;
	}

	@Override
	public int localiza(T valor) {
		for (int i = 0; i < proximo; i++) {
			if (vetor[i].equals(valor)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public T retira(int posicao) {
		if (posicao < 0 || posicao >= proximo) {
			throw new ListaException("Poicao Invalida");
		}
		T retorno = vetor[posicao];
		for (int i = posicao; i < proximo - 1; i++) {
			vetor[i] = vetor[i + 1];
		}
		proximo--;
		vetor[proximo] = null; // Opcional
		return retorno;
	}

	@Override
	public String imprime() {
		String retorno = "[";
		for (int i = 0; i < proximo; i++) {
			retorno += vetor[i].toString() + ", ";
		}
		retorno += "]";
		return retorno;
	}

	@Override
	public Lista<T> concatena(Lista<T> outra) {
		int novoTamanho = this.getQuantidade() + outra.getQuantidade();

		Lista<T> nova = new ListaComArray<T>(novoTamanho);

		for (int i = 0; i < proximo; i++) {
			nova.insere(vetor[i]);
		}
		for (int i = 0; i < outra.getQuantidade(); i++) {
			nova.insere(outra.busca(i));
		}
		return nova;
	}

	@Override
	public T busca(int posicao) {
		return vetor[posicao];
	}

	@Override
	public int getQuantidade() {
		return this.proximo;
	}

	@Override
	public Lista<T> divide() {
		Lista<T> nova = new ListaComArray<>();
		int meio = this.getQuantidade() / 2;

		for (int i = meio; i < proximo; i++) {
			nova.insere(vetor[i]);
			vetor[i] = null;
		}
		proximo = meio;
		return nova;
	}

	@Override
	public Lista<T> copia() {
		Lista<T> nova = new ListaComArray<>();
		for (int i = 0; i < proximo; i++) {
			nova.insere(vetor[i]);
		}
		return nova;
	}

	@Override
	public boolean estaVazia() {
		return (proximo == 0);
	}
}
