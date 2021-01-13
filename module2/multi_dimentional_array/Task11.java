/* Условие задачи:
Матрицу 10x20 заполнить случайными числами от 0 до 15.
Вывести на экран саму матрицу и номера строк, в которых число 5 встречается три и более раз. 
*/

package by.epam_training.java_online.module2.multi_dimentional_array;

public class Task11 {

	public static void main(String[] args) {

		Task11 task = new Task11();
		int[][] array = new int[10][20];

		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array[0].length; j++) {
				array[i][j] = (int) (Math.random() * 16);
			}
		}

		task.printArray(array);

		System.out.print("Lines that contains at least than three '5':   ");

		for (int i = 0; i < array.length; i++) {
			int count = 0;

			for (int j = 0; j < array[0].length; j++) {

				if (array[i][j] == 5) {
					count++;
				}

				if (count == 3) {
					System.out.print("'" + (i + 1) + "'   ");
					break;
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

}
