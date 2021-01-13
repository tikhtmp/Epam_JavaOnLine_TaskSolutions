/* Условие задачи:
Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число
единиц равно номеру столбца.

Мое примечание:
Из условия следует, что количество столбцов должно быть меньше или равно количеству строк.
*/

package by.epam_training.java_online.module2.multi_dimentional_array;

public class Task14 {

	public static void main(String[] args) {

		Task14 task = new Task14();
		int m = 0;
		int n = 1;

		/* Генерация размера матрицы (число столбцов должно быть меньше или равно числу строк) */
		while (n > m) {
			m = (int) (Math.random() * 9 + 2); // для удобства просмотра результата число строк задается в пределах 2 - 10
			n = (int) (Math.random() * 9 + 2);
		}
		
		int[][] array = new int[m][n];
		array = task.transpose(array);

		/* Первоначальное определение элементов матрицы */
		int count = 0;

		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array[0].length; j++) {

				if (count < i + 1) {  
					array[i][j] = 1;
					count++;
				} else {
					array[i][j] = 0;
				}

			}

			count = 0;
		}
		

		/* Построчное перемешивание нулей и единиц */
		for (int i = 0; i < array.length; i++) {
			task.mixArray(array[i]);
		}

		array = task.transpose(array);
		task.printArray(array);

	}

	/* Обмен местами двух элементов одномерного массива */
	public void swap(int[] arr, int firstIndex, int secondIndex) {
		int tmp;
		tmp = arr[firstIndex];
		arr[firstIndex] = arr[secondIndex];
		arr[secondIndex] = tmp;
	}

	/* Перемешивание элементов одномерного массива */
	public void mixArray(int[] arr) {
		int randomIndex = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			randomIndex = (int) (Math.random() * arr.length);
			swap(arr, i, randomIndex);
		}
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
}
