/*
 * Counting Sort
 * Alunos: Hélio Potelicki, Luis Felipe Zaguini, Pedro Roweder
 */

package ordenacao;

import java.util.Arrays;

public class Teste {
	public static void main(String[] args) {
		int[] arr = { 15, 4, 12, 13, 1, 2, 7, 5, 14, 4, 12, 13, 1, 2, 7, 5, 11, 4, 12, 13, 1, 2, 7, 5};
		System.out.println(Arrays.toString(arr));
		Counting ob = new Counting();
		ob.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}