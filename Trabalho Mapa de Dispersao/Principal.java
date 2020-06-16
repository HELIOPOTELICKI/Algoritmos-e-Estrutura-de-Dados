
public class Principal {

	public static void main(String[] args) {
		MapaDispersao<String,Veiculo> mapa = new MapaDispersao<String,Veiculo>(500);

		Veiculo a = new Veiculo("MJT-7432", "Fusca", 1912, "Pedro");
		Veiculo b = new Veiculo("MIT-8008", "Celta", 1999, "Douglas");
		Veiculo c = new Veiculo("MEI-4665", "Gol", 2002, "Carlos");
		Veiculo d = new Veiculo("MIO-6668", "Fusca", 1915, "Aline");
		Veiculo e = new Veiculo("DIO-3333", "Celta", 1999, "Fausto");
		Veiculo f = new Veiculo("PAO-6472", "C3", 2007, "Carolina");
		Veiculo g = new Veiculo("CAO-2890", "C4", 2012, "Kelvin");
		Veiculo h = new Veiculo("UVA-3939", "BMW", 2015, "Seu Zé");
		Veiculo i = new Veiculo("OVO-0000", "Gol", 2000, "Joshua");
		Veiculo j = new Veiculo("ABC-1234", "Ferrari", 2015, "Marta");
		
		Veiculo[] arrayVeiculos = { a, b, c, d, e, f, g, h, i};

		// inserir()
		for (int cont = 0; cont < arrayVeiculos.length; cont++) {
			mapa.inserir(arrayVeiculos[cont].getPlaca() ,arrayVeiculos[cont]);
		}
		
		// buscar()
		System.out.printf("Busca por -> OVO-0000: %s", mapa.buscar("OVO-0000"));
		System.out.printf("Busca por -> UVA-3939: %s", mapa.buscar("UVA-3939"));
		System.out.printf("Busca por -> MIO-6668: %s", mapa.buscar("MIO-6668"));
		
		// remover()
		mapa.remover("UVA-3939");
		System.out.printf("\nUVA-3939 removido do mapa");
		System.out.printf("\nBusca por -> UVA-3939: %s", mapa.buscar("UVA-3939"));
		
		System.out.printf("\n\nAdiciona ABC-1234");
		mapa.inserir(j.getPlaca(), j);
		System.out.printf("\nBusca por -> ABC-1234: %s", mapa.buscar("ABC-1234"));
		
		// quantosElementos()
		System.out.printf("\nMapa com 9 elementos -> resposta = %s", mapa.quantosElementos());	
	}
}