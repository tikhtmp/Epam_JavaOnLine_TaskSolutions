/* Условие задачи:
Даны дроби p1/q1, p2/q2,... pn/qn (pi , qi - натуральные). Составить программу, которая приводит эти дроби к общему
знаменателю и упорядочивает их в порядке возрастания.
*/

package by.epam_training.java_online.module2.sorting;

public class Task8 {

	public static void main(String[] args) {

		int[][] fraction = { { 2, 5 }, { 3, 8 }, { 7, 12 }, { 1, 4 } };
		Task8 task = new Task8();
		task.printFraction(fraction);
		int minMultiple = 1;

		for (int i = 0; i < fraction.length; i++) {
			minMultiple = task.findLeastMultiple(minMultiple, fraction[i][1]);
		}

		System.out.println("Min multiple = " + minMultiple);

		for (int i = 0; i < fraction.length; i++) {
			fraction[i][0] = fraction[i][0] * minMultiple / fraction[i][1];
			fraction[i][1] = minMultiple;
		}

		task.printFraction(fraction);
		int[] numerator = new int[fraction.length];

		for (int i = 0; i < fraction.length; i++) {
			numerator[i] = fraction[i][0];
		}

		task.sortAcsending(numerator);

		for (int i = 0; i < fraction.length; i++) {
			fraction[i][0] = numerator[i];
		}
		task.printFraction(fraction);

	}

	/* Поиск наименьшего общего кратного */
	public int findLeastMultiple(int first, int second) {
		return (first * second) / findMaxDivisor(first, second);
	}

	/* Поиск наибольшего общего делителя */
	public int findMaxDivisor(int first, int second) {

		/* Алгоритм Евклида */
		while (second != 0) {
			int tmp = second;
			second = first % second;
			first = tmp;
		}

		return first;

		/* простой перебор: 
		while (first % div != 0 || second % div != 0) {
		div--;
		 }
		 return div;
		 */

	}

	/* Сортировка по возрастанию */
	public void sortAcsending(int arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {

			for (int j = 0; j < arr.length - 1; j++) {

				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
					j--;
				}
			}
		}
	}

	/* Обмен местами двух элементов одномерного int массива */
	public void swap(int[] arr, int firstIndex, int secondIndex) {
		int tmp;
		tmp = arr[firstIndex];
		arr[firstIndex] = arr[secondIndex];
		arr[secondIndex] = tmp;
	}

	/* Вывод массива int дробей в консоль */
	public void printFraction(int arr[][]) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i][0]);
			System.out.print("/");
			System.out.print(arr[i][1]);
			System.out.print("   ");
		}

		System.out.println();
	}

}
