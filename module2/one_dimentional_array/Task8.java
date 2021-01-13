/* Условие задачи:
Дана последовательность целых чисел a1 , a2 , ... , an . Образовать новую последовательность, выбросив из
исходной те члены, которые равны  min( a1 , a2 , ... , an ).
*/

package by.epam_training.java_online.module2.one_dimentional_array;

public class Task8 {

	public static void main(String[] args) {
		int[] array = { 15, -18, 1, 120, -18, -18, 0, 4, -18, -2, -18 };
		Task8 task = new Task8();
		System.out.print("Source array: ");
		task.printArray(array);
		int min = array[0];
		int numberOfMin = 0;

		/*Минимум */
		for (int member : array) {

			if (member < min) {
				min = member;
			}
		}

		/* 
		 * Количество членов массива, равных минимуму, чтобы определить размер нового массива */
		for (int member : array) {

			if (member == min) {
				numberOfMin++;
			}

		}

		int[] updatedArray = new int[array.length - numberOfMin];  
		int j = 0;

		/* Новый массив */
		for (int member : array) {

			if (member != min) {
				updatedArray[j++] = member;
			}
		}

		System.out.print("Final array: ");
		task.printArray(updatedArray);
	
	}

	/* Вывод массива в консоль */
	public void printArray(int arr[]) {

		for (int num : arr) {
			System.out.print(num + " ");
		}

		System.out.println();
	}

}
