/* Условие задачи: 
Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
1   2   3   ...   n
n  n-1 n-2  ...   1
1   2   3   ...   n
n  n-1 n-2  ...   1
.   .   .   .     .
.   .   .    .    .
.   .   .     .   .
n  n-1 n-2  ...   1 
*/

package by.epam_training.java_online.module2.multi_dimentional_array;

public class Task4 {

	public static void main(String[] args) {

		int n = 8;
		int[][] array = new int[n][n];

		for (int line = 0; line < n; line++) {

			for (int column = 0; column < n; column++) {
				
				if ((line + 1) % 2 != 0) {
					array[line][column] = column + 1;
				} else {
					array[line][column] = n - column;
				}
			
			}

		}

		Task4 task = new Task4();
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
