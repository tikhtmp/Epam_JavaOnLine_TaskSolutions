/* Условие задачи: 
Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
1   1   1   ...  1   1   1
2   2   2   ...  2   2   0
3   3   3   ...  3   0   0
.   .   .   .     .  .   .
.   .   .    .    .  .   .
.   .   .     .   .  .   .
n-1 n-1 0   ...   0  0   0
n   0   0   ...   0  0   0 
*/

package by.epam_training.java_online.module2.multi_dimentional_array;

public class Task5 {

	public static void main(String[] args) {

		int n = 8;
		int[][] array = new int[n][n];

		for (int line = 0; line < n; line++) {

			for (int column = 0; column < n; column++) {

				if (column < n - line) {
					array[line][column] = line + 1;
				} else {
					array[line][column] = 0;
				}

			}

		}

		Task5 task = new Task5();
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
