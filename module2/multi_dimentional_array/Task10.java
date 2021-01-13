/* Условие задачи: 
Найти положительные элементы главной диагонали квадратной матрицы.
*/

package by.epam_training.java_online.module2.multi_dimentional_array;

public class Task10 {

	public static void main(String[] args) {
		
		int[][] array = { { 8, 40, -15, -5, 8, 11, -2 }, { 2, -12, 5, -18, 24, 44, 16 }, { 16, 22, 9, -33, 27, 22, 6 },
				{ 6, 2, 19, -47, 18, 0, 49 }, { 3, 39, -19, 23, 17, -8, -10 }, { 13, 9, -9, -43, 25, 20, 0 },
				{ -4, 22, 40, 30, 28, -22, 4 } };

		Task10 task = new Task10();
		task.printArray(array);
		System.out.println();
		
		System.out.print("Positive elements of the main diagonal are: ");
		
		for(int i =0; i < array.length; i++) {
			
			for(int j = 0; j< array[0].length; j++) {
				
				if( i==j && array[i][j]>0) {
					System.out.print(array[i][j] + " ");
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
