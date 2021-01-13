/* Условие задачи: 
Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой
столбец содержит максимальную сумму.
*/

package by.epam_training.java_online.module2.multi_dimentional_array;

public class Task9 {

	public static void main(String[] args) {

		int[][] array = { { 8, 40, 15, 5, 8, 11, 2 }, { 2, 0, 5, 18, 24, 44, 16 }, { 16, 22, 9, 33, 27, 22, 6 },
				{ 6, 2, 19, 47, 18, 0, 49 }, { 3, 39, 19, 23, 17, 8, 10 }, { 13, 9, 9, 43, 25, 20, 0 },
				{ 4, 22, 40, 30, 28, 22, 4 }, { 11, 15, 0, 0, 8, 2, 44 } };

		Task9 task = new Task9();
		task.printArray(array);
		System.out.println();

		int[] sum = new int[array[0].length];

		for (int i = 0; i < array[0].length; i++) {

			for (int j = 0; j < array.length; j++) {
				sum[i] += array[j][i];
			}
		}

		int sumMax = 0;
		int maxColumn = 0;
		int i = 0;

		for (int element : sum) {
			System.out.printf("%5d", element);

			if (element > sumMax) {
				sumMax = element;
				maxColumn = i + 1;
			}
			
			i++;
		}

		System.out.println();
		System.out.println("   Max sum = " + sumMax);
		System.out.println("   Column №" + maxColumn);

	}

	/* Вывод двумерного int массива в консоль */
	public void printArray(int mArray[][]) {

		for (int line[] : mArray) {

			for (int element : line) {
				System.out.printf("%5d", element);
			}

			System.out.println();
		}
	}

}
