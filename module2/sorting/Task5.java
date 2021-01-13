/* Условие задачи:
Сортировка вставками. Дана последовательность чисел a1 , a2 , ... , an . Требуется переставить числа в порядке
возрастания. Делается это следующим образом. Пусть - a1 , a2 , ... , an упорядоченная последовательность, т. е.
a1 <= a2 <= ... <= an . Берется следующее число a(i+1) и вставляется в последовательность так, чтобы новая
последовательность была тоже возрастающей. Процесс производится до тех пор, пока все элементы от i+1 до n
не будут перебраны. Примечание. Место помещения очередного элемента в отсортированную часть производить
с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции.
*/

package by.epam_training.java_online.module2.sorting;

import java.util.Arrays;

public class Task5 {

	public static void main(String[] args) {

		int[] array = { 88, 62, 9, 12, 11, 0, -31, 32, 38, 22 };
		Task5 task = new Task5();
		task.printArray(array);
		int[] tmpArray = Arrays.copyOf(array, 1);

		for (int i = 0; i < array.length - 1; i++) {
			int elem = array[i + 1];
			tmpArray = task.insertElement(tmpArray, elem);
		}

		array = Arrays.copyOf(tmpArray, tmpArray.length);

		task.printArray(array);

	}

	/* Вставка элемента в массив */
	public int[] insertElement(int arrayInserted[], int element) {

		int index = findIndex(arrayInserted, element);
		arrayInserted = Arrays.copyOf(arrayInserted, arrayInserted.length + 1);

		for (int i = arrayInserted.length - 1; i > index; i--) {
			swap(arrayInserted, i, i - 1);
		}

		arrayInserted[index] = element;

		return arrayInserted;

	}

	/* Двоичный поиск индекса вставки элемента в массив */
	public int findIndex(int arr[], int num) {
		int index = -1;
		int first = 0;
		int last = arr.length - 1;

		if (last == 0) { // для массива из одного элемента
			if (num >= arr[0]) {
				return 1;
			} else if (num < arr[0]) {
				return 0;
			}
		}

		if (last == 1) { // для массива из двух элементов
			if (num >= arr[1]) {
				return 2;
			} else if (num < arr[1] && num >= arr[0]) {
				return 1;
			} else {
				return 0;
			}
		}

		while (last > first) { // двоичный поиск для массивов из >2 элементов

			int mid = (first + last) / 2;

			if (num == arr[mid]) {
				index = mid + 1;
				break;
			} else if (num > arr[mid]) {
				first = mid + 1;
			} else if (num < arr[mid]) {
				last = mid;
			}

			index = last;
		}

		if (index == arr.length - 1 && num >= arr[arr.length - 1]) { // если добавляемое число больше любого из исходного отсортированного массива																		
			index = arr.length;
		}

		return index;
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
			System.out.printf("%4d", element);
		}

		System.out.println();
	}

}
