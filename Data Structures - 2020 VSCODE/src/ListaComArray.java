import java.util.ArrayList;

public class ListaComArray<T> implements Lista<T> {
    private int proximo = 0;
    private int limite;
    private T[] vetor;

    public ListaComArray(int limite) {
        this.limite = limite;
        vetor = (T[]) new Object[limite];
    }

    public boolean estaVazia() {
        return proximo == 0;
    }

    public boolean estaCheia() {
        return proximo == vetor.length;
    }

    public int quantidade() {
        return proximo;
    }

    public String imprime() {
        StringBuilder resultado = new StringBuilder();

        for(int atual = 0; atual < proximo; atual++) {
            String separador = atual ==  proximo - 1 ? "" : ", ";
            resultado.append(vetor[atual]).append(separador);
        }

        return resultado.toString();
    }

    public void insere(T valor) {
        if(proximo == vetor.length) {
            throw new ListaException("Lista cheia");
        }

        vetor[proximo++] = valor;
    }

    public void insere(T valor, int posicao) {
        if(posicao < 0 || posicao > proximo || proximo == vetor.length) {
            throw new ListaException("Fora dos limites");
        }

        T salvo;

        for(int atual = posicao; atual <= proximo; atual++) {
            salvo = vetor[atual];
            vetor[atual] = valor;
            valor = salvo;
        }

        proximo++;
    }

    public T retira(int posicao) {
        if(posicao < 0 || posicao > proximo) {
            throw new ListaException("Fora dos limites");
        }

        T retirado = vetor[posicao];

        if (proximo - 1 - posicao >= 0) {
            System.arraycopy(vetor, posicao + 1, vetor, posicao, proximo - 1 - posicao);
        }

        proximo--;

        return retirado;
    }

    public T busca(int posicao) {
        if(posicao < 0 || posicao > proximo) {
            throw new ListaException("Fora dos limites");
        }

        return vetor[posicao];
    }

    public int localiza(T valor) {
        for(int atual = 0; atual < proximo; atual++) {
            if(vetor[atual].equals(valor)) {
                return atual;
            }
        }

        return -1;
    }

    public ListaComArray concatena(ListaComArray outra) {
        ListaComArray uniao = new ListaComArray(quantidade() + outra.quantidade());

        for(T item: vetor) {
            uniao.insere(item);
        }

        for(int i = 0; i < outra.quantidade(); i++) {
            uniao.insere(outra.busca(i));
        }

        return uniao;
    }

    public ArrayList<ListaComArray<T>> divide(int larguraBloco) {
        ArrayList<ListaComArray<T>> resultado = new ArrayList<>();

        for(int i = 0; i < proximo; i++) {
            if(resultado.size() == 0 || resultado.get(resultado.size() - 1).quantidade() == larguraBloco) {
                resultado.add(new ListaComArray(larguraBloco));
            }

            resultado.get(resultado.size() - 1).insere(vetor[i]);
        }

        return resultado;
    }

    public ListaComArray<T> copia() {
        ListaComArray nova = new ListaComArray(limite);

        for(T item: vetor) {
            nova.insere(item);
        }

        return nova;
    }
}
