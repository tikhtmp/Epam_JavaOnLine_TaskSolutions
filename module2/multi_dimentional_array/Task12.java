/* Условие задачи:
Отсортировать строки матрицы по возрастанию и убыванию значений элементов. 
*/

package by.epam_training.java_online.module2.multi_dimentional_array;

public class Task12 {

	public static void main(String[] args) {

		int line = 8;
		int column = 8;
		int[][] array = new int[line][column];
		Task12 task = new Task12();
		array = task.defineArray(line, column);
		
		System.out.println("Source matrix:");
		task.printArray(array);

		/* Сортировка строки по возрастанию */
		
		for (int i = 0; i < line; i++) {
			task.sortAscending(array[i]);
		}
		
		System.out.println("\nAscending order:");
		task.printArray(array);

		/* Сортировка строки по убыванию */
		
		for (int i = 0; i < line; i++) {
			task.sortDescending(array[i]);
		}
		
		System.out.println("\nDescending order:");
		task.printArray(array);

	}

	/* Сортировка строки по возрастанию */
	public void sortAscending(int[] line) {
		int tmp = 0;

		for (int i = 0; i < line.length - 1; i++) {

			for (int j = i + 1; j < line.length; j++) {

				if (line[i] > line[j]) {
					tmp = line[i];
					line[i] = line[j];
					line[j] = tmp;
				}

			}

		}
	}

	/* Сортировка строки по убыванию */
	public void sortDescending(int[] line) {
		int tmp = 0;

		for (int i = 0; i < line.length - 1; i++) {

			for (int j = i + 1; j < line.length; j++) {

				if (line[i] < line[j]) {
					tmp = line[i];
					line[i] = line[j];
					line[j] = tmp;
				}

			}

		}
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
