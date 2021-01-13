/* Условие задачи:
Дано натуральное число N. Написать метод(методы) для формирования массива, элементами которого
являются цифры числа N.

Мое примечание:
Должны ли элементы массива идти в том же порядке, что и цифры исходного числа?
*/

package by.epam_training.java_online.module2.decomposition;

import java.util.Arrays;

public class Task10 {

	public static void main(String[] args) {

		Task10 task = new Task10();
		int number = 324089778;
		System.out.println("Source: " + number);
		int[] array = task.createArray(number);
		System.out.print("Array: ");
		
		task.reverseArray(array);
		task.printArray(array);
	}

	/* Формирование массива с элементами из цифр натурального числа */
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

		return array;
	}
	
	public int[] reverseArray(int[] arr) {
		int tmp = arr[0];
		
		for (int i = 0; i < arr.length/2; i++) {
			tmp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = tmp;
		}
		
		return arr;
	}

	/* Вывод одномерного int массива в консоль */
	public void printArray(int arr[]) {

		for (int num : arr) {
			System.out.print(num + " ");
		}

		System.out.println();
	}

}
