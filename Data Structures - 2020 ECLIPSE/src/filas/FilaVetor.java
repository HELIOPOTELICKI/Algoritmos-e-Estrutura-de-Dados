package filas;

public class FilaVetor<T> implements Fila<T> {

	private int n;
	private int ini;
	private T[] vet;

	public FilaVetor(int tam) {
		this.vet = (T[]) new Object[tam];
	}

	@Override
	public void insere(T v) {
		if (n == vet.length) {
			throw new RuntimeException("Fila cheia");
		}
		vet[this.getFim()] = v;
		n++;
	}

	private int getFim() {
		return (ini + n) % vet.length;
	}

	@Override
	public T retira() {
		if (vazia()) {
			throw new RuntimeException("Fila Vazia");
		}
		T valor = vet[ini];
		vet[ini] = null;
		ini++;
		ini = (ini + 1) % vet.length;
		n--;

		return valor;
	}

	@Override
	public boolean vazia() {
		return this.n == 0;
	}

	@Override
	public void libera() {
		this.vet = (T[]) new Object[this.vet.length];
		this.n = 0;
		this.ini = 0;
	}
	
	@Override
    public String toString() {
        String resultado = "";
        int indice;
        for (int i = 0; i < this.n; i++) {
            indice = (i + ini) % vet.length;
            if (i > 0) {
                resultado += ",";
            }
            resultado = resultado + vet[indice];
        }
        return resultado;
    }

}
