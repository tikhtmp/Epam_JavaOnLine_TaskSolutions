/* Условие задачи: 
Сформировать квадратную матрицу порядка N по правилу:
A[I, J] = sin ( (I^2 - J^2) / N )
и подсчитать количество положительных элементов в ней.
*/

package by.epam_training.java_online.module2.multi_dimentional_array;

public class Task7 {

	public static void main(String[] args) {

		int n = 8;
		double sum = 0.0;
		double[][] array = new double[n][n];
		Task7 task = new Task7();

		for (int line = 0; line < n; line++) {

			for (int column = 0; column < n; column++) {
				array[line][column] = Math.sin((line * line) - (column * column) / n);
				if (array[line][column] > 0.0) {
					sum += array[line][column];
				}
			}

		}

		task.printArray(array);
		System.out.println("The sum of the positeves is: " + sum);

	}

	public void printArray(double mArray[][]) {

		for (double line[] : mArray) {

			for (double element : line) {
				System.out.printf("%15.10f", element);
			}

			System.out.println();
		}
	}

}
