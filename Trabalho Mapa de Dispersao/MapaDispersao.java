
public class MapaDispersao<K, T> {
	private ListaEncadeada<T>[] tabela;
	private int quantidadaUso = 0;
	private int quantidade;

	public MapaDispersao(int quantidade) {
		tabela = new ListaEncadeada[getProximoPrimo(quantidade)];
	}

	public static int getProximoPrimo(int quantidade) {

		quantidade++;
		while (!isprimo(quantidade)) {
			quantidade++;
		}
		return quantidade;
	}

	private static boolean isprimo(int numero) {
		for (int j = 2; j < numero; j++) {
			if (numero % j == 0)
				return false;
		}
		return true;
	}

	public int calcularHash(K chave) {
		int hashCode = Math.abs(chave.hashCode());
		int hash = hashCode % getProximoPrimo(quantidade);
		return hash;
	}

	public boolean inserir(K chave, T valor) {
		if (this.buscar(chave) != null) {
			throw new IllegalArgumentException("Item ja cadastrado.");
		}
		int indice = calcularHash(chave);
		if (tabela[indice] == null) {
			ListaEncadeada<T> lista = new ListaEncadeada<T>();
			lista.insere(valor);
			tabela[indice] = lista;
		} else {
			tabela[indice].insere(valor);
		}
		quantidadaUso++;
		return true;
	}

	public T remover(K chave) {
		int indice = calcularHash(chave);
		if (tabela[indice] == null) {
			return null;
		}
		ListaEncadeada<T> itens = tabela[indice];
		int posicaoLista = itens.localiza((T) chave);
		T retorno = itens.busca(posicaoLista);
		if (retorno == null) {
			return null;
		}
		itens.retira(posicaoLista);
		quantidadaUso--;
		return retorno;
	}

	public T buscar(K chave) {
		int indice = calcularHash(chave);
		if (tabela[indice] == null) {
			return null;
		}
		ListaEncadeada<T> itens = tabela[indice];
		return itens.busca(itens.localiza((T) chave));
	}

	public int quantosElementos() {
		return quantidadaUso;
	}
}