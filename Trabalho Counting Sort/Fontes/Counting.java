/*
 * Counting Sort
 * Alunos: Hélio Potelicki, Luis Felipe Zaguini, Pedro Roweder
 */

package ordenacao;

public class Counting {
	public void sort(int[] vetor) {
		int intervalo = Integer.MIN_VALUE;
		int maior = Integer.MIN_VALUE;

		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] > maior) {
				intervalo = vetor[i];
				maior = intervalo;
			}
		}
		
		intervalo++;

		int[] contagem = new int[intervalo];

		int n = vetor.length;
		int saida[] = new int[n];

		for (int i = 0; i < n; i++) {
			contagem[vetor[i]] += 1;
		}

		for (int i = 1; i < intervalo; i++) {
			contagem[i] += contagem[i - 1];
		}

		for (int i = 0; i < n; i++) {
			saida[contagem[vetor[i]] - 1] = vetor[i];
			contagem[vetor[i]] -= 1;
		}

		for (int i = 0; i < n; i++) {
			vetor[i] = saida[i];
		}
	}
}