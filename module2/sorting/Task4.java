/* Условие задачи:
Сортировка обменами. Дана последовательность чисел a1 <= a2 <= ... <= an.Требуется переставить числа 
в порядке возрастания. Для этого сравниваются два соседних числа a(i) и a(i+1). Если a(i) > a(i+1), то делается перестановка.
Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания.
Составить алгоритм сортировки, подсчитывая при этом количества перестановок.
*/

package by.epam_training.java_online.module2.sorting;

public class Task4 {

	public static void main(String[] args) {
		int[] array = { 10, 8, 12, 12, 11, 5, 31, 32, 38, 47 };

		Task4 task = new Task4();
		task.printArray(array);
		int count = 0;
		boolean isSorted = false;

		while (!isSorted) {

			isSorted = true;

			for (int i = 1; i < array.length; i++) {

				if (array[i - 1] > array[i]) {
					task.swap(array, i - 1, i);
					count++;
					isSorted = false;
				}
			}
		}

		task.printArray(array);
		System.out.println("   Number of the swaps: " + count);

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
