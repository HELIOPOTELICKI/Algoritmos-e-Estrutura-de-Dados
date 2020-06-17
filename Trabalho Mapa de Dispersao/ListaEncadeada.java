
public class ListaEncadeada<T> implements Lista<T> {
	private ItemLista<T> primeiro; // = null
	private ItemLista<T> ultimo; // = null
	private int qtdeElementos; // = 0

	@Override
	public void insere(T valor) {
		ItemLista<T> novo = new ItemLista<>();
		novo.setInfo(valor);
		if (this.estaVazia()) {
			primeiro = novo;
		} else {
			ultimo.setProx(novo);
		}
		ultimo = novo;
		qtdeElementos++;
	}

	@Override
	public void insere(T valor, int posicao) {
		if (posicao < 0 || posicao > qtdeElementos) {
			throw new ListaException("Posição inválida");
		}
		if (posicao == qtdeElementos || this.estaVazia()) { // última posição
			this.insere(valor);
		} else {
			ItemLista<T> novo = new ItemLista<>();
			novo.setInfo(valor);
			if (posicao == 0) { // primeira posição
				novo.setProx(primeiro);
				primeiro = novo;
			} else { // posição intermediária
				ItemLista<T> anterior = this.descobre(posicao - 1);
				novo.setProx(anterior.getProx());
				anterior.setProx(novo);
			}
			qtdeElementos++;
		}
	}

	@Override
	public int localiza(T valor) {
		ItemLista<T> atual = primeiro;
		int contador = 0;
		while (atual != null) {
			if (atual.getInfo().equals(valor)) {
				return contador;
			}
			atual = atual.getProx();
			contador++;
		}
		return -1;
	}

	public int ultimoIndiceDe(T x) {
		int ultimoIndice = -1;
		ItemLista<T> p = primeiro;
		int contador = 0;

		while (p != null) {
			if (p.getInfo().equals(x)) {
				ultimoIndice = contador;
			}

			p = p.getProx();
			contador++;
		}

		return ultimoIndice;
	}

	@Override
	public T retira(int posicao) {
		if (posicao < 0 || posicao > qtdeElementos) {
			throw new ListaException("Posição inválida");
		}
		T retorno = null;
		if (posicao == 0) { // primeira posição
			retorno = primeiro.getInfo();
			primeiro = primeiro.getProx();
			if (primeiro == null) {
				ultimo = null;
			}
		} else {
			ItemLista<T> anterior = this.descobre(posicao - 1);
			if (posicao == qtdeElementos - 1) { // última posição
				retorno = ultimo.getInfo();
				ultimo = anterior;
				ultimo.setProx(null);
			} else { // posição intermediária
				ItemLista<T> atual = anterior.getProx();
				retorno = atual.getInfo();
				anterior.setProx(atual.getProx());
			}
		}
		qtdeElementos--;
		return retorno;
	}

	@Override
	public String imprime() {
		String resultado = "[";
		ItemLista<T> atual = primeiro;
		while (atual != null) {
			resultado = resultado + atual.getInfo().toString();
			atual = atual.getProx();
			if (atual != null) {
				resultado += ", ";
			}
		}
		return resultado + "]";
	}

	public String imprimeInverso() {
		String resultado = null;
		ItemLista<T> atual = primeiro;
		while (atual != null) {
			if (resultado == null) {
				resultado = atual.getInfo().toString();
			} else {
				resultado = atual.getInfo().toString() + ", " + resultado;
			}
			atual = atual.getProx();
		}
		return "[ " + resultado + " ]";
	}

	@Override
	public T busca(int posicao) {
		if (posicao > 0 && posicao < qtdeElementos) {
			return this.descobre(posicao).getInfo();
		}
		return null;
	}

	@Override
	public boolean estaVazia() {
		return (primeiro == null);
	}

	@Override
	public int getQuantidade() {
		return this.qtdeElementos;
	}

	@Override
	public Lista<T> concatena(Lista<T> outra) {
		ListaEncadeada<T> nova = new ListaEncadeada<>();
		// não é a maneira mais otimizada
		for (int i = 0; i < this.getQuantidade(); i++) {
			nova.insere(this.busca(i));
		}
		// é importante o formato abaixo para garantir a operação independente do tipo
		// de Lista (ComArray ou Encadeada)
		for (int i = 0; i < outra.getQuantidade(); i++) {
			nova.insere(outra.busca(i));
		}
		return nova;
	}

	@Override
	public Lista<T> divide() {
		if (this.estaVazia()) {
			return null;
		}
		ListaEncadeada<T> nova = new ListaEncadeada<>();
		int meio = (this.getQuantidade() / 2);
		if (meio == 0) {
			return nova; // só há um elemento na lista original, portanto não dá para dividir
		}
		ItemLista<T> itemAntMeio = this.descobre(meio - 1);
		nova.setPrimeiro(itemAntMeio.getProx());
		itemAntMeio.setProx(null);
		nova.setUltimo(this.ultimo);
		nova.setQuantidade(this.getQuantidade() - meio);
		this.ultimo = itemAntMeio;
		this.qtdeElementos = meio;

		return nova;
	}

	@Override
	public Lista<T> copia() {
		ListaEncadeada<T> nova = new ListaEncadeada<>();
		ItemLista<T> atual = this.primeiro;
		while (atual != null) {
			nova.insere(atual.getInfo());
			atual = atual.getProx();
		}
		return nova;
	}

	private ItemLista<T> descobre(int posicao) {
		ItemLista<T> atual = primeiro;
		int contador = 0;
		while (atual != null) {
			if (contador == posicao) {
				return atual;
			}
			atual = atual.getProx();
			contador++;
		}
		return null;
	}

	private void setPrimeiro(ItemLista<T> i) {
		this.primeiro = i;
	}

	private void setUltimo(ItemLista<T> i) {
		this.ultimo = i;
	}

	private void setQuantidade(int tam) {
		this.qtdeElementos = tam;
	}

}