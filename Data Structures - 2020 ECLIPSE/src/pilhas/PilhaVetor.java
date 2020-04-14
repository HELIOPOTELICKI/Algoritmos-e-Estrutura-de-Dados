public class PilhaVetor<T> implements Pilha<T> {
	private int tam;
	private int n = 0;
	private T[] vetor;

	public PilhaVetor(int tam) {
		this.tam = tam;
		vetor = (T[]) new Object[tam];
	}

	@Override
	public void push(T v) throws Exception {
		if (this.n == this.tam) {
			throw new Exception("Pilha cheia");
		}

		this.vetor[n] = v;
		this.n++;
	}

	@Override
	public T pop() throws Exception {
		if (this.vazia()) {
			throw new Exception("Pilha Vazia");
		}

		T res = this.vetor[n - 1];
		this.vetor[n - 1] = null;
		this.n--;

		return res;
	}

	@Override
	public T peek() {
		if (vazia()) {
			return null;
		} else {
			return this.vetor[n - 1];
		}
	}

	@Override
	public boolean vazia() {
		return this.n == 0;
	}

	@Override
	public void libera() {
		this.n = 0;
		this.vetor = (T[]) new Object[tam];
	}
}