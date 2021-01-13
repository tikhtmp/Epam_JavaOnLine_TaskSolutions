/* Условие задачи: 
Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
1   1   1   ...  1   1   1
0   1   1   ...  1   1   0
0   0   1   ...  1   0   0
.   .   .   .     .  .   .
.   .   .    .    .  .   .
.   .   .     .   .  .   .
0   1   1   ...  1   1   0
1   1   1   ...  1   1   1 
*/

package by.epam_training.java_online.module2.multi_dimentional_array;

public class Task6 {

	public static void main(String[] args) {
		int n = 8;
		int[][] array = new int[n][n];

		for (int line = 0; line < n / 2; line++) { // матрица формируется по две строки одновременно от крайних строк к центральным

			for (int column = 0; column < n; column++) {

				if (column >= line && column < n - line) {
					array[line][column] = 1;
					array[n - line - 1][column] = 1;
				}

			}

		}

		Task6 task = new Task6();
		task.printArray(array);

	}

	public void printArray(int mArray[][]) {

		for (int line[] : mArray) {

			for (int element : line) {
				System.out.printf("%3d", element);
			}

			System.out.println();
		}
	}

}
