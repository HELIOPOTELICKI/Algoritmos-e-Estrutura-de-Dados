/*
 * Counting Sort
 * Alunos: H�lio Potelicki, Luis Felipe Zaguini, Pedro Roweder
 */

package ordenacao;

public interface Sort<T extends Comparable<T>> {
	void sort(T[] vetor);
}