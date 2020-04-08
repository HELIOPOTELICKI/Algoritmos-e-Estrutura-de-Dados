import java.util.ArrayList;

public class ListaEncadeada<T> implements Lista<T> {
    private ItemLista<T> primeiro;
    private ItemLista<T> ultimo;
    private int quantidade = 0;

    public boolean estaVazia() {
        return ultimo == null;
    }

    public boolean estaCheia() {
        return false;
    }

    public int quantidade() {
        return quantidade;
    }

    public String imprime() {
        StringBuilder resultado = new StringBuilder();
        ItemLista<T> atual = primeiro;

        while(atual != null) {
            resultado.append(atual.getInfo());
            atual = atual.getProx();

            if(atual != null) {
                resultado.append(", ");
            }
        }

        return resultado.toString();
    }

    public void insere(T valor) {
        ItemLista<T> item = new ItemLista<>(valor);

        if(estaVazia()) {
            primeiro = item;
        } else {
            ultimo.setProx(item);
        }

        ultimo = item;
        quantidade++;
    }

    public void insere(T valor, int posicao) {
        conferePosicao(posicao);

        ItemLista<T> item = new ItemLista<>(valor);

        if(posicao == 0) {
            item.setProx(primeiro);
            primeiro = item;

            if(estaVazia()) {
                ultimo = primeiro;
            }
        } else if(posicao == quantidade) {
            ultimo.setProx(item);
            ultimo = item;

            if(estaVazia()) {
                primeiro = ultimo;
            }
        } else {
            ItemLista<T> atual = primeiro;
            ItemLista<T> passado = atual;
            int contador = 0;

            while(posicao != contador) {
                passado = atual;
                atual = atual.getProx();
                contador++;
            }

            item.setProx(atual);
            passado.setProx(item);
        }

        quantidade++;
    }

    public T retira(int posicao) {
        conferePosicao(posicao);

        if(posicao == 0) {
            if(primeiro == null) {
                throw new ListaException("Item inexistente");
            }

            T atual = primeiro.getInfo();
            primeiro = primeiro.getProx();
            quantidade--;

            if(quantidade < 2) {
                ultimo = primeiro;
            }

            return atual;
        } else {
            ItemLista<T> atual = primeiro;
            ItemLista<T> passado = atual;
            int contador = 0;

            while(posicao != contador) {
                passado = atual;
                atual = atual.getProx();
                contador++;
            }

            passado.setProx(atual.getProx());
            quantidade--;

            if(posicao == quantidade) {
                ultimo = passado;
            }

            return atual.getInfo();
        }
    }

    public void conferePosicao(int posicao) {
        if(posicao < 0 || posicao > quantidade) {
            throw new ListaException("Posicao fora dos limites");
        }
    }

    public T busca(int posicao) {
        conferePosicao(posicao);

        ItemLista<T> atual = primeiro;
        int contador = 0;

        while(atual != null) {
            if(contador == posicao) {
                return atual.getInfo();
            }

            atual = atual.getProx();
            contador++;
        }

        return null;
    }

    public int localiza(T valor) {
        ItemLista<T> atual = primeiro;
        int contador = 0;

        while(atual != null) {
            if(atual.getInfo().equals(valor)) {
                return contador;
            }

            atual = atual.getProx();
            contador++;
        }

        return -1;
    }

    public ListaEncadeada<T> concatena(ListaEncadeada<T> outra) {
        ListaEncadeada<T> nova = new ListaEncadeada<T>();

        ItemLista<T> atual = primeiro;

        while(atual != null) {
            nova.insere(atual.getInfo());
            atual = atual.getProx();
        }

        for(int i = 0; i < outra.quantidade(); i++) {
            nova.insere(outra.busca(i));
        }

        return nova;
    }

    public ArrayList<ListaEncadeada<T>> divide(int larguraBloco) {
        ArrayList<ListaEncadeada<T>> resultado = new ArrayList<>();

        for(int i = 0; i < quantidade; i++) {
            if(resultado.size() == 0 || resultado.get(resultado.size() - 1).quantidade() == larguraBloco) {
                resultado.add(new ListaEncadeada());
            }

            resultado.get(resultado.size() - 1).insere(busca(i));
        }

        return resultado;
    }

    @Override
    public ListaEncadeada<T> copia() {
        ListaEncadeada<T> copia = new ListaEncadeada<T>();

        ItemLista<T> atual = primeiro;

        while(atual != null) {
            copia.insere(atual.getInfo());
            atual = atual.getProx();
        }

        return copia;
    }
}
