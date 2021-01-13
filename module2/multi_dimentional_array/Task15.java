/* Условие задачи:
Найти наибольший элемент матрицы и заменить все нечетные элементы на него. 

Два варианта решения: 
1. При замене нечетных элементов матрица будет рассматриваться как одномерный массив 
с (кол-во строк) Х (кол-во столбцов) элементов.
2. Нечетный элемент - элемент, у которого индексы и строки и столбца нечетные
*/

package by.epam_training.java_online.module2.multi_dimentional_array;

public class Task15 {

	public static void main(String[] args) {
		Task15 task = new Task15();
		int[][] array = task.defineArray(5, 7);
		
		System.out.println("Source matrix:");
		task.printArray(array);
		int max = Integer.MIN_VALUE;

		for (int line[] : array) {

			for (int elem : line) {

				if (elem > max) {
					max = elem;
				}
			}
		}

		System.out.println("Max value = " + max + "\n");
		int count = 1;

		/* Первый вариант */
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array[0].length; j++) {

				if (count % 2 != 0) {
					array[i][j] = max;
				}
				count++;
			}
		}

		System.out.println("First variant:");
		task.printArray(array);

		/* Второй вариант */
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array[0].length; j++) {

				if ((i + 1) % 2 > 0 && (j + 1) % 2 > 0) {
					array[i][j] = max;
				}
			}
		}

		System.out.println("Second variant:");
		task.printArray(array);

	}

	/* Вывод двумерного int массива в консоль */
	public void printArray(int mArray[][]) {

		for (int line[] : mArray) {

			for (int element : line) {
				System.out.printf("%3d", element);
			}

			System.out.println();
		}
		System.out.println();
	}

	/*
	 * Заполнение двумерного int массива случайными целыми числами от 1 до 99
	 * включительно
	 */
	public int[][] defineArray(int lines, int columns) {
		int[][] arr = new int[lines][columns];

		for (int i = 0; i < lines; i++) {

			for (int j = 0; j < columns; j++) {

				arr[i][j] = (int) (Math.random() * 99) + 1;

			}
		}
		return arr;
	}
}