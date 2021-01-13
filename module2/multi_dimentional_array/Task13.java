/* Условие задачи:
Отсортировать стобцы матрицы по возрастанию и убыванию значений эементов. 
*/
package by.epam_training.java_online.module2.multi_dimentional_array;

public class Task13 {

	public static void main(String[] args) {
		int line = 4;
		int column = 5;
		int[][] array = new int[line][column];
		Task13 task = new Task13();
		
		array = task.defineArray(line, column);
		System.out.println("Source matrix:");		
		task.printArray(array);
		
		/*Для того чтобы можно было использовать готовые методы из прошлого задания, исходная матрица транспонируетя. */
		int[][] transposedArray = new int[column][line];

		/* Сортировка по возрастанию. */
		transposedArray = task.transpose(array); 

		for (int i = 0; i < transposedArray.length; i++) {
			task.sortAscending(transposedArray[i]);
		}

		array = task.transpose(transposedArray);
		System.out.println("Ascending order:");
		task.printArray(array);

		/* Сортировка по убыванию */
		transposedArray = task.transpose(array);

		for (int i = 0; i < transposedArray.length; i++) {
			task.sortDescending(transposedArray[i]);
		}

		array = task.transpose(transposedArray);
		System.out.println("Descending order:");
		task.printArray(array);

	}

	/* Транспонирование матрицы */
	public int[][] transpose(int[][] arr) {

		int[][] transpArray = new int[arr[0].length][arr.length];

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[0].length; j++) {
				transpArray[j][i] = arr[i][j];
			}
		}
		return transpArray;
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
				System.out.printf("%3d", element);
			}

			System.out.println();
		}
		System.out.println();
	}

	/* Заполнение двумерного int массива случайными целыми числами от 1 до 99 включительно */
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
