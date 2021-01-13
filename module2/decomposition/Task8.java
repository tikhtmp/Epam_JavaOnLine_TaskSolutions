/* Условие задачи:
Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов
массива с номерами от k до m.
*/

package by.epam_training.java_online.module2.decomposition;

public class Task8 {

	public static void main(String[] args) {

		Task8 task = new Task8();
		int[] array = { 1, 9, 21, 12, 22, 33, 54, 62, 54 };

		System.out.println(task.getSum(array, 0));
		System.out.println(task.getSum(array, 2));
		System.out.println(task.getSum(array, 3));

	}

	public int getSum(int[] arr, int index) {
		int sum = 0;

		for (int i = index; i < index + 3; i++) {
			sum += arr[i];
		}

		return sum;
	}
}
