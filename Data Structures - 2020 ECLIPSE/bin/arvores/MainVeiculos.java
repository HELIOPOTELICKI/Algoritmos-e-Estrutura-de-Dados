package arvores;

public class MainVeiculos {

	public static void main(String[] args) {

		Veiculo a = new Veiculo("MJT-7432", "Fusca", 1912, "Pedro");
		Veiculo b = new Veiculo("MIT-8008", "Celta", 1999, "Douglas");
		Veiculo c = new Veiculo("MEI-4665", "Gol", 2002, "Carlos");
		Veiculo d = new Veiculo("MIO-6668", "Fusca", 1915, "Aline");
		Veiculo e = new Veiculo("DIO-3333", "Celta", 1999, "Fausto");
		Veiculo f = new Veiculo("PAO-6472", "C3", 2007, "Carolina");
		Veiculo g = new Veiculo("CAO-2890", "C4", 2012, "Kelvin");
		Veiculo h = new Veiculo("UVA-3939", "BMW", 2015, "Zé");
		Veiculo i = new Veiculo("OVO-0000", "Gol", 2000, "Joshua");
		Veiculo j = new Veiculo("ABC-1234", "Ferrari", 2015, "Marta");

		Veiculo[] arrayVeiculos = { a, b, c, d, e, f, g, h, i, j };

		ArvoreBST<Veiculo> arvore = new ArvoreBST<>();

		for (int cont = 0; cont < arrayVeiculos.length; cont++) {
			arvore.inserir(arrayVeiculos[cont]);
		}

		System.out.println(arvore);
		System.out.println("\n" + arvore.toStringOrdered());
	}
}