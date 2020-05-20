package arvores;

import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;

public class MainBuscaAntecessor {

	public static void main(String[] args) {
		int qtde = Integer.parseInt(JOptionPane.showInputDialog("Quantos elementos?"));
		ArvoreBST<Integer> arvore = new ArvoreBST<>();
		int[] vetor = new int[qtde];
		Random r = new Random();
		int valor;
		
		for (int i=0; i < qtde;i++) {
			valor = r.nextInt(1_0);
			arvore.inserir(valor);
			vetor[i] = valor;
		}
		System.out.println(Arrays.toString(vetor));
		System.out.println(arvore.toString());
		
		int buscaAnt = Integer.parseInt(JOptionPane.showInputDialog("Valor a Buscar o antecessor?"));
		try {
			System.out.println("Antecessor de " + buscaAnt + " é " + arvore.antecessor(arvore.buscar(buscaAnt)).getInfo());
		}catch (NullPointerException e) {
			System.out.println(buscaAnt + " Não possuí antecessor");
		}
		
	}

}