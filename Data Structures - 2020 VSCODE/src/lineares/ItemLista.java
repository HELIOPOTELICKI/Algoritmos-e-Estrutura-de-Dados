package lineares;

public class ItemLista<T> {
	private T info;
	private ItemLista<T> prox;

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public ItemLista<T> getProx() {
		return prox;
	}

	public void setProx(ItemLista<T> prox) {
		this.prox = prox;
	}
}
