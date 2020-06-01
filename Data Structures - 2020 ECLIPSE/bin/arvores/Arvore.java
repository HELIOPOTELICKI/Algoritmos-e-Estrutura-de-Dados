package arvores;

public class Arvore<T> {
	private NoArvore<T> raiz = null;

	// Construtor
	public Arvore() {
	}

	// Metodos

	public void setRaiz(NoArvore<T> no) {
		this.raiz = no;
	}

	public NoArvore<T> getRaiz() {
		return this.raiz;
	}

	public boolean vazia() {
		return raiz == null;
	}

	public NoArvore<T> pertence(T info) {
		if (this.vazia()) {
			return null;
		} else {
			return raiz.pertence(info);
		}
	}

	@Override
	public String toString() {
		if (this.vazia()) {
			return "<>";
		} else {
			return raiz.imprimePre();
		}
	}

	public int getAltura() {
		if (vazia()) {
			return -1;
		} else if (raiz.getFilho() == null) {
			return 0;
		} else {
			return raiz.calculaNivel() - 1;
		}
	}
}