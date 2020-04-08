public class PilhaLista<T> implements Pilha<T> {
  private ItemLista<T> topo;

  @Override
  public void push(T v) {
    if (topo == null) {
      topo = new ItemLista<T>(v);
    } else {
      ItemLista<T> novo = new ItemLista<T>(v);
      novo.setProx(topo);
      topo = novo;
    }
  }

  @Override
  public T pop() throws Exception {
    if (topo == null) {
      throw new Exception("Não existem elementos a serem retirados");
    }

    T item = topo.getInfo();
    topo = topo.getProx();

    return item;
  }

  @Override
  public T peek() {
    if (topo == null) {
      return null;
    }
    return topo.getInfo();
  }

  @Override
  public boolean vazia() {
    return topo == null;
  }

  @Override
  public void libera() {
    topo = null;
  }

}