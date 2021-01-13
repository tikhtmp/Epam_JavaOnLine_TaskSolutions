/* Условие задачи:
Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
дополнительный массив.
*/

package by.epam_training.java_online.module2.sorting;

import java.util.Arrays;

public class Task1 {

	public static void main(String[] args) {

		int[] firstArray = { -15, -18, -1, -120, -17, -62, -4, -55, -2, -41 };
		int[] secondArray = { 10, 8, 11, 92, 10, 5 };
		int k = 3;
		Task1 task = new Task1();
		task.printArray(firstArray);
		task.printArray(secondArray);
		firstArray = Arrays.copyOf(firstArray, firstArray.length + secondArray.length);

		for (int i = k + 1, j = 0; i < secondArray.length + k + 1; i++, j++) {
			firstArray[i + secondArray.length] = firstArray[i];
			firstArray[i] = secondArray[j];
		}

		task.printArray(firstArray);

	}

	/* Вывод массива в консоль */
	public void printArray(int arr[]) {

		for (int num : arr) {
			System.out.print(num + " ");
		}

		System.out.println();
	}

}
