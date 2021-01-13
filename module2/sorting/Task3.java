/* Условие задачи:
Сортировка выбором. Дана последовательность чисел a1 <= a2 <= ... <= an. Требуется переставить элементы так,
чтобы они были расположены по убыванию. Для этого в массиве, начиная с первого, выбирается наибольший
элемент и ставится на первое место, а первый - на место наибольшего. Затем, начиная со второго, эта процедура
повторяется. Написать алгоритм сортировки выбором.
*/

package by.epam_training.java_online.module2.sorting;

public class Task3 {

	public static void main(String[] args) {

		int[] array = { 8, 8, 12, 14, 23, 25, 31, 32, 38, 47 };

		Task3 task = new Task3();
		task.printArray(array);

		/* Сортировка по убыванию */
		for (int i = 0; i < array.length; i++) {
			int indexOfMax = task.findMax(array, i); // поиск индекса максимального значения
			task.swap(array, i, indexOfMax); // замена местами текущего и максимального элементов
		}

		task.printArray(array);

	}

	/* Поиск индекса максимумального значения на участке одномерного int массива, начиная с индекса ind */
	public int findMax(int[] arr, int ind) {
		int indexOfMax = ind;
		int max = Integer.MIN_VALUE;

		for (int i = ind; i < arr.length; i++) {

			if (arr[i] > max) {
				max = arr[i];
				indexOfMax = i;
			}
		}

		return indexOfMax;
	}

	/* Обмен местами двух элементов одномерного int массива */
	public void swap(int[] arr, int firstIndex, int secondIndex) {
		int tmp;
		tmp = arr[firstIndex];
		arr[firstIndex] = arr[secondIndex];
		arr[secondIndex] = tmp;
	}

	/* Вывод одномерного int массива в консоль */
	public void printArray(int arr[]) {

		for (int element : arr) {
			System.out.printf("%3d", element);
		}

		System.out.println();
	}

}
