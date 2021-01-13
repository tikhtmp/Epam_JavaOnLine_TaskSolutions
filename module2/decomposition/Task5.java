/* Условие задачи:
Составить программу, которая в массиве A[N] находит второе по величине число 
(вывести на печать число,которое меньше максимального элемента массива, 
но больше всех других элементов).
 
 Варианты решения:
1. Найти максимум массива. Затем найти максимум из массива, исключив предыдущий максимум
2. Упорядочить массив по возрастанию. Предпоследний элемент - искомое. Если максимуму равны
одновременно несколько элементов, найти первое меньшее.
*/

package by.epam_training.java_online.module2.decomposition;

public class Task5 {

	public static void main(String[] args) {
		int[] array = { 1, 6, 9, 21, 12, 22, 32, 54, 62, 54 };
		int max = Integer.MIN_VALUE;
		int preMax = Integer.MIN_VALUE;

		for (int element : array) {

			if (element > max) {
				max = element;
			}
		}

		System.out.println("Max = " + max);

		for (int element : array) {

			if ((element > preMax) && element < max) {
				preMax = element;
			}
		}

		System.out.println("PreMax = " + preMax);
	}
}
