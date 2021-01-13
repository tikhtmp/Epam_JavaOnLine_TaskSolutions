/* Условие задачи:
 Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и наименьший элементы.
*/
package by.epam_training.java_online.module2.one_dimentional_array;

public class Task4 {

	public static void main(String[] args) {

		double[] array = { 15.2, -18.8, 1.6, 120.7, 0.0, 45.6, -22.1 };

		Task4 task = new Task4();
		task.printArray(array);

		int indexOfMin = 0;
		int indexOfMax = 0;
		double min = array[0];
		double max = array[0];

		/* поиск минимального и максимального членов массива */
		for (int i = 0; i < array.length; i++) {

			if (array[i] < min) {
				min = array[i];
				indexOfMin = i;
			}

			if (array[i] > max) {
				max = array[i];
				indexOfMax = i;
			}

		}

		System.out.println("Min " + min);
		System.out.println("Max " + max);

		/* Замена местами минимума и макимума */
		double tmp;
		tmp = array[indexOfMin];
		array[indexOfMin] = array[indexOfMax];
		array[indexOfMax] = tmp;

		task.printArray(array);

	}

	/* Вывод массива в консоль */
	public void printArray(double arr[]) {

		for (double num : arr) {
			System.out.print(num + " ");
		}

		System.out.println();
	}

}
