/* Условие задачи: 
Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
*/

package by.epam_training.java_online.module2.multi_dimentional_array;

public class Task3 {

	public static void main(String[] args) {
		
		int[][] array = { { 8, 40, -15, -5, 8, 11, -2 }, { 2, 0, 5, -18, 24, 44, 16 }, { 16, 22, 9, -33, 27, 22, 6 },
				{ 6, 2, 19, 47, 18, 0, 49 }, { 3, 39, -19, 23, 17, -8, -10 }, { 13, 9, -9, -43, 25, 20, 0 },
				{ -4, 22, 40, 30, 28, -22, 4 } };

		Task3 task = new Task3();
		task.printArray(array);
		System.out.println();
		int k =3;
		int p = 7;
		
		System.out.print(k + "th line: ");
		
		for (int line = 0; line < array.length; line++) {

			for (int column = 0; column < array[0].length; column++) {

				if (k-1 == line) {
					System.out.printf("%5d", array[line][column]);
				}
			
			}

		}
		System.out.println();		

		System.out.print(p + "th column: ");
		
		for (int line = 0; line < array.length; line++) {

			for (int column = 0; column < array[0].length; column++) {

				if (p-1 == column) {
					System.out.printf("%5d", array[line][column]);
				}
			
			}

		}
		System.out.println();		

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
