
public class MapaDispersao<K,T> {
	private ListaEncadeada<T>[] tabela;
	private int populado = 0;
	private int quantidade;
	
	public MapaDispersao (int quantidade) {
		this.quantidade = getProximoPrimo(quantidade);
		tabela = new ListaEncadeada[this.quantidade];
	}
	
	public int getProximoPrimo(int quantidade) {
		return quantidade;
	}

	public int calcularHash(K chave) {
		int hashCode = Math.abs(chave.hashCode());
		int hash = hashCode % quantidade;
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
		populado++;
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
		populado--;
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
		return populado;
	}
}