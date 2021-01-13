/* Условие задачи:
Даны две последовательности a1 <= a2 <= ... <= an и b1 <= b2 <=...<= bm . Образовать из них новую последовательность
чисел так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать.
*/

package by.epam_training.java_online.module2.sorting;

import java.util.Arrays;

public class Task2 {

	public static void main(String[] args) {

		int[] firstArray = { 1, 2, 8, 12, 17, 21, 22, 25, 31, 38 };
		int[] secondArray = { 2, 7, 11, 22, 33, 45 };

		Task2 task = new Task2();
		task.printArray(firstArray);
		task.printArray(secondArray);
		firstArray = Arrays.copyOf(firstArray, firstArray.length + secondArray.length);

		for (int i = firstArray.length - secondArray.length, j = 0; j < secondArray.length; i++, j++) {
			firstArray[i] = secondArray[j];
		}

		task.sortAscending(firstArray);
		task.printArray(firstArray);

	}

	/* Сортировка элементов одномерного int массива по возрастанию */
	public void sortAscending(int[] line) {
		int tmp = 0;

		for (int i = 0; i < line.length - 1; i++) {

			for (int j = i + 1; j < line.length; j++) {

				if (line[i] > line[j]) {
					tmp = line[i];
					line[i] = line[j];
					line[j] = tmp;
				}

			}

		}
	}

	/* Вывод массива в консоль */
	public void printArray(int arr[]) {

		for (int element : arr) {
			System.out.printf("%3d", element);
		}

		System.out.println();
	}

}
