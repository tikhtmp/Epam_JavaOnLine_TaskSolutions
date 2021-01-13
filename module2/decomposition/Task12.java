/* Условие задачи:
Даны натуральные числа К и N. Написать метод(методы) формирования массива А, элементами которого
являются числа, сумма цифр которых равна К и которые не большее N.
*/

package by.epam_training.java_online.module2.decomposition;

import java.util.Arrays;

public class Task12 {

	public static void main(String[] args) {

		Task12 task = new Task12();
		int k = 13;
		int n = 160;
		System.out.println("K = " + k + "   N = " + n);
		int j = 0;
		int[] array = new int[0];

		for (int i = 1; i < n; i++) {
			int[] arr = task.createArray(i);

			if (task.getSumArray(arr) == k) {
				array = Arrays.copyOf(array, array.length + 1);
				array[j] = i;
				j++;
			}
		}

		task.printArray(array);
	}

	/* Формирование массива с из int числа с элементами из цифр от 0 до 9 */
	public int[] createArray(int num) {

		int[] array = new int[0];
		int tmp = num;
		int i = 0;

		while (tmp > 0) {
			array = Arrays.copyOf(array, array.length + 1);
			array[i] = tmp % 10;
			tmp = tmp / 10;
			i++;
		}

		int dim = array.length - 1;

		for (int j = 0; j < (dim + 1) / 2; j++) { // чтобы порядок элементов массива соответствовал порядку цифр исходного числа													
			int tmpNum = array[j];
			array[j] = array[dim - j];
			array[dim - j] = tmpNum;
		}

		return array;
	}

	/* Вывод одномерного int массива в консоль */
	public void printArray(int arr[]) {

		for (int num : arr) {
			System.out.print(num + " ");
		}

		System.out.println();
	}

	/* Сумма элементов одномерного int массива */
	public int getSumArray(int arr[]) {
		int sum = 0;

		for (int num : arr) {
			sum += num;
		}

		return sum;
	}

}
