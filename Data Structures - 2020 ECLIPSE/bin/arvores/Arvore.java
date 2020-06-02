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
		NoArvore<T> raiz = getRaiz();

		if (raiz == null) {
			return -1;
		}

		return getAltura(raiz);
	}

	private int getAltura(NoArvore<T> no) {
		if (no == null) {
			return -1;
		}

		int alturaMax = -1;
		NoArvore<T> noAtual = no.getFilho();

		while (noAtual != null) {
			int alturaAtual = getAltura(noAtual);

			if (alturaAtual > alturaMax) {
				alturaMax = alturaAtual;
			}

			noAtual = noAtual.getIrmao();
		}

		return alturaMax + 1;
	}

	public int getNivel(T info) {
		return getNivel(getRaiz(), info, 0);
	}

	public int getNivel(NoArvore<T> no, T info, int nivel) {
		if (no == null) {
			return -1;
		}

		if (no.getInfo().equals(info)) {
			return nivel;
		}

		NoArvore<T> irmao = no.getIrmao();

		while (irmao != null) {
			int resultado = getNivel(irmao, info, nivel);

			if (resultado != -1) {
				return resultado;
			}

			irmao = irmao.getIrmao();
		}

		if (no.getFilho() != null) {
			return getNivel(no.getFilho(), info, nivel + 1);
		}

		return -1;
	}

	public boolean isBalanceada() {
		NoArvore<T> raiz = getRaiz();

		if (raiz == null) {
			return true;
		}

		return isBalanceada(raiz);
	}

	private boolean isBalanceada(NoArvore<T> no) {
		NoArvore<T> irmaoAtual = no.getIrmao();

		return Math.abs(getAltura(irmaoAtual) - getAltura(irmaoAtual.getIrmao())) <= 1;
	}
}