/* Условие задачи: 
 В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число.
 Если таких чисел несколько, то определить наименьшее из них.
 
 Алгоритм решения:
 1. Посчитать число нулевых значений в массиве.
 2. Создать новый массив, где повторяющиеся цифры заменить нулями.
 3. Посчитать кол-во уникальных чисел и создать массив из них.
 4. Создать массив из кол-ва повторов уникальных чисел.
 5. Выбрать минимум из массива уникальных чисел при помощи массива повторов.
*/

package by.epam_training.java_online.module2.one_dimentional_array;

public class Task9 {

	public static void main(String[] args) {

		int[] array = { 15, 18, 1, 120, 18, 18, 0, 4, -22, 18, -2, 18, 2, 2, -22, -22, 2, 2, 120, 1, 1, 1, 1, 0, -22,
				-22, 0, 0, 0 };
		int[] tempArray = array.clone();
		Task9 task = new Task9();
		task.printArray(array);
		int numberOfNil = 0;

		/* Подсчет количества нулевых значений */
		for (int i = 0; i < array.length; i++) {

			if (array[i] == 0) {
				numberOfNil++;
			}
		}

		/* Замещение нулями повторяющихся значений */
		for (int i = 0; i < tempArray.length; i++) {

			for (int j = i + 1; j < tempArray.length; j++) {

				if (tempArray[i] == tempArray[j]) {
					tempArray[j] = 0;
				}
			}
		}

		/* Размер массива, состоящего только из уникальных цифр */
		int count = 0;
		for (int member : tempArray) {

			if (member != 0) {
				count++;
			}
		}

		/* Массив, состоящий только из уникальных цифр */

		if (numberOfNil > 0) { // если в исходном массиве есть нулевые значения, это нужно учесть
			count++;
		}

		int[] filteredArray = new int[count];
		int i = 0;

		for (int member : tempArray) {

			if (member != 0) {
				filteredArray[i] = member;
				i++;
			}

		}

		/* Массив, состоящий из количества повторений уникальных цифр в исходном массиве */
		int[] isRepeated = new int[count];

		for (int j = 0; j < filteredArray.length; j++) {

			int quantity = 0;

			for (int member : array) {
				if (filteredArray[j] == member) {
					quantity++;
				}

				isRepeated[j] = quantity;
			}

		}

		/* Поиск наиболее часто повторяющихся цифр и минимальной из них */
		System.out.print("Most common numbers are: ");
		int max = 0;

		for (int member : isRepeated) {

			if (member > max) {
				max = member;
			}

		}

		int j = 0;
		int min = Integer.MAX_VALUE;

		for (int member : isRepeated) {

			if (member == max) {
				System.out.print(filteredArray[j] + " "); // вывод наиболее часто повторяющихся цифр

				if (filteredArray[j] < min) {// поиск минимального значения из наиболее часто повторяющихся цифр
					min = filteredArray[j];
				}
			}

			j++;
		}

		System.out.println();
		System.out.println("Minimum is: " + min);
	}

	/* Вывод массива в консоль */
	public void printArray(int arr[]) {

		for (int num : arr) {
			System.out.print(num + " ");
		}

		System.out.println();
	}

}
