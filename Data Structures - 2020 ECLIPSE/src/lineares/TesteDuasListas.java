package lineares;

public class TesteDuasListas {
	public static void main(String[] args) {
		System.out.println("TESTE COM LISTAS DE AMBAS AS CLASSES");
		System.out.println("\nJoão e Maria vão ao supermercado, com uma única lista de compras.");
		Lista<String> lista = new ListaEncadeada<>();
		lista.insere("arroz");
		lista.insere("batata");
		lista.insere("café");
		lista.insere("detergente");
		System.out.println("Esperado arroz, batata, café, detergente = " + lista.imprime());
		System.out.println("\nMaria lembrou que também precisava de fósforos e anotou no início da lista.");
		lista.insere("fósforos", 0);
		System.out.println("Esperado fósforos, arroz, batata, café, detergente = " + lista.imprime());

		System.out
				.println("João passou na frente da gôndola dos cereais e verificou se arroz e feijão estavam na lista");
		int pos = lista.localiza("arroz");
		System.out.println("Esperado 1 = " + pos);
		pos = lista.localiza("feijão");
		System.out.println("Esperado -1 = " + pos);
		System.out.println("Como arroz estava na lista, pegou arroz e riscou da lista.");
		String elem = lista.retira(1);
		System.out.println("Esperado arroz = " + elem);
		System.out.println("Agora a lista tem (Esperado fósforos, batata, café, detergente) = " + lista.imprime());

		System.out.println("\nMaria lembrou que já havia outra lista de supermercado, que estava em seu bolso:");
		Lista<String> lista2 = new ListaComArray<>();
		lista2.insere("tomate");
		lista2.insere("cebola");
		lista2.insere("cenoura");
		System.out.println("Lista 2(Array) Esperado tomate,cebola,cenoura = " + lista2.imprime());
		System.out.println(
				"Como estava na frente da gôndola da cebola, já pegou e tirou da lista, mas lembrou que também precisava de ovos:");
		elem = lista2.retira(1);
		lista2.insere("ovos", 0);
		System.out.println("Esperado ovos,tomate,cenoura = " + lista2.imprime());

		System.out.println("\nComo estavam com pressa, resolveram juntar as duas listas");
		Lista<String> lista3, lista3A;
		lista3 = lista.concatena(lista2);
		System.out.println(
				"Lista João Esperado fósforos,batata,café,detergente,ovos,tomate,cenoura = " + lista3.imprime());
		lista3A = lista2.concatena(lista);
		System.out.println(
				"Lista Maria Esperado ovos,tomate,cenoura,fósforos,batata,café,detergente = " + lista3A.imprime());

		System.out.println(
				"E aí fizeram uma confusão, juntando tudo de novo... \nEsperado fósforos; batata; café; detergente; ovos; tomate; cenoura; ovos; tomate; cenoura; fósforos; batata; café; detergente");
		lista3 = lista3.concatena(lista3A);
		System.out.println("Nova Lista = " + lista3.imprime());

		System.out.println("\nPara resolver o problema, dividiram a lista ");
		Lista<String> lista4, lista5;
		lista4 = lista3.divide();
		System.out.println("João (dividida) Esperado = fósforos; batata; café; detergente; ovos; tomate; cenoura\n"
				+ lista3.imprime());
		System.out.println(
				"Maria (divisão da Nova lista) Esperado = ovos; tomate; cenoura; fósforos; batata; café; detergente\n"
						+ lista4.imprime());
		System.out.println("E Maria anotou mais uma coisa: chá");
		lista4.insere("chá", 0);
		System.out.println("Lista Maria Esperado = chá; ovos; tomate; cenoura; fósforos; batata; café; detergente\n"
				+ lista4.imprime());

		System.out.println(
				"E Maria entregou uma cópia da lista para João Esperado = chá; ovos; tomate; cenoura; fósforos; batata; café; detergente");
		lista5 = lista4.copia();
		System.out.println("João copiada de Maria = " + lista5.imprime());

		System.out.println(
				"Por fim, Maria ainda acrescenta em sua lista mais um item: esponja\nEsperado = chá; ovos; tomate; cenoura; fósforos; batata; café; detergente; esponja");
		lista4.insere("esponja");
		System.out.println("Lista Maria = " + lista4.imprime());
		System.out.println(
				"Mas do João permanece a mesma\nEsperado = chá; ovos; tomate; cenoura; fósforos; batata; café; detergente\n\t\t "
						+ lista5.imprime());

	}
}
