/* Условие задачи: 
Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего
*/

package by.epam_training.java_online.module2.multi_dimentional_array;

public class Task1 {

	public static void main(String[] args) {
		int[][] array = { { 8, 40, -15, -5, 8, 11, -2 }, { 2, 0, 5, -18, 24, 44, 16 }, { 16, 22, 9, -33, 27, 22, 6 },
				{ 6, 2, 19, 47, 18, 0, 49 }, { 3, 39, -19, 23, 17, -8, -10 } };

		Task1 task = new Task1();
		task.printArray(array);
		System.out.println();

		for (int line = 0; line < array.length; line++) {

			for (int column = 0; column < array[0].length; column++) {

				if ((array[0][column] > array[array.length - 1][column]) && ((column + 1) % 2 != 0)) {

					System.out.printf("%5d", array[line][column]);
				}

			}

			System.out.println();
		}

	}

	public void printArray(int mArray[][]) {

		for (int line[] : mArray) {

			for (int element : line) {
				System.out.printf("%5d", element);
			}

			System.out.println();
		}
	}
}