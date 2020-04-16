package filas;

public class FilaLista<T> implements Fila<T> {
	private ItemLista<T> ini;
	private ItemLista<T> fim;

	@Override
	public T retira() throws Exception {
		if (vazia()) {
			throw new RuntimeException("Fila Vazia");
		}

		T item = ini.getInfo();
		ini = ini.getProx();

		if (vazia()) {
			fim = null;
		}
		return item;
	}

	@Override
	public boolean vazia() {
		return (ini == null);
	}

	@Override
	public void libera() {
		this.ini = null;
		this.fim = null;
	}

	@Override
	public void insere(T v) {
		ItemLista<T> novo = new ItemLista<T>(v);
		if (vazia()) {
			ini = novo;
		} else {
			fim.setProx(novo);
		}
		fim = novo;
	}

}
