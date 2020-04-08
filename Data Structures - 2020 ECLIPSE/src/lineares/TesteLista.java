package lineares;

public class TesteLista {
	public static void main(String[] args) {
		Lista<String> lista = new ListaComArray<>();
		System.out.println(lista.imprime());
		lista.insere("A");
		lista.insere("B");
		System.out.println("Esperado A,B = " + lista.imprime());
		lista.insere("C", 0);
		System.out.println("Esperado C,A,B = " + lista.imprime());
		try {
			lista.insere("NAO", 10);
			System.out.println("PROBLEMAS: inseriu no indice 10");
		} catch (ListaException le) {
			System.out.println("Esta OK. nao inseriu");
		}
		System.out.println("Esperado C,A,B = " + lista.imprime());
		int pos = lista.localiza("B");
		System.out.println("Esperado 2 = " + pos);
		pos = lista.localiza("BA");
		System.out.println("Esperado -1 = " + pos);
		String elem = lista.retira(0);
		System.out.println("Esperado C = " + elem);
		System.out.println("Esperado A,B = " + lista.imprime());

		Lista<String> lista2 = new ListaComArray();
		lista2.insere("X");
		lista2.insere("Y");
		lista2.insere("Z");
		System.out.println("Lista 2 = " + lista2.imprime());

		Lista<String> lista3;
		lista3 = lista.concatena(lista2);
		System.out.println("Lista 3 (concatenacao de 1 e 2)= " + lista3.imprime());
		lista3.insere("N");

		Lista<String> lista4, lista5;
		lista4 = lista3.divide();
		System.out.println("Lista 3 (dividida) = " + lista3.imprime());
		System.out.println("Lista 4 (divisao de 3) = " + lista4.imprime());
		lista4.insere("AA", 0);
		System.out.println("Lista 4 com AA na primeira posicao = " + lista4.imprime());

		lista5 = lista4.copia();
		System.out.println("Lista 5 (copia de 4) = " + lista5.imprime());

	}
}
