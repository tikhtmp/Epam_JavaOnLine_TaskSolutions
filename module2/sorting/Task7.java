/* Условие задачи:
 Пусть даны две неубывающие последовательности действительных чисел a1 <= a 2 <= a2 <=... <= an и b1 <= b2 <= ...<= bm.
 Требуется указать те места, на которые нужно вставлять элементы последовательности b1 <= b2 <= ...<= bm в первую
 последовательность так, чтобы новая последовательность оставалась возрастающей.
 
 Мое примечание:
 Места надо определить для одиночной вставки элементов второй последовательности или нужно составить новую неубывающую
 последовательность из двух заданных? Здесь решение для "слияния" двух последовательностей.
*/

package by.epam_training.java_online.module2.sorting;

public class Task7 {

	public static void main(String[] args) {
		int[] firstArray = { 1, 2, 9, 11, 12, 22, 32, 38, 62, 88 };
		int[] secondArray = { 5, 9, 12, 24, 43 };
		int[] insertIndex = new int[secondArray.length];
		Task7 task = new Task7();

		for (int i = 0; i < secondArray.length; i++) {

			insertIndex[i] = task.findIndex(firstArray, secondArray[i]);
			insertIndex[i] += i;
		}

		System.out.print("First array:     ");
		task.printArray(firstArray);
		System.out.print("Second array:    ");
		task.printArray(secondArray);
		System.out.print("Insert indexes:  ");
		task.printArray(insertIndex);

		/* "Слияние" двух заданных массивов */
		int[] array = new int[firstArray.length + secondArray.length];
		int j = 0;
		int k = 0;
		int m = 0;

		for (int i = 0; i < array.length; i++) {

			if (i == insertIndex[m]) {
				array[i] = secondArray[k++];

				if (m < insertIndex.length - 1) { // иначе на последней итерации m++ дает ошибку переполнения
					m++;
				}
				
			} else {
				array[i] = firstArray[j++];
			}
		}

		task.printArray(array);

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

	/* Вывод одномерного int массива в консоль */
	public void printArray(int arr[]) {

		for (int element : arr) {
			System.out.printf("%4d", element);
		}

		System.out.println();
	}

}
