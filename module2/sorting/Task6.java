/* Условие задачи:
Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию. 
Делается это следующим образом: сравниваются два соседних элемента a(i) и a(i+1). Если a(i) <= a(i+1), то продвигаются
на один элемент вперед. Если a(i) > a(i+1), то производится перестановка и сдвигаются на один элемент назад.
Составить алгоритм этой сортировки.
*/

package by.epam_training.java_online.module2.sorting;

public class Task6 {

	public static void main(String[] args) {
		int[] array = { 88, 62, 9, 12, 11, 0, -31, 32, 38, 22 };
		Task6 task = new Task6();
		task.printArray(array);
		task.sortAcsending(array);
		task.printArray(array);
	}

	/* Сортировка по возрастанию */
	public void sortAcsending(int arr[]) {
		
		for (int i = 0; i < arr.length - 1; i++) {

			for (int j = 0; j < arr.length - 1; j++) {

				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
					j--;
				}
			}
		}
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
