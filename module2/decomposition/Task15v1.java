/* Условие задачи:
Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую
последовательность (например, 1234, 5789). Для решения задачи использовать декомпозицию.
 
Мои примечания:
Простой перебор с предварительным вычислением минимального и максимального значений поиска.
Для n=8 Time: 0 hours 0 mins 2.660 sec
*/

package by.epam_training.java_online.module2.decomposition;

import java.util.Arrays;

public class Task15v1 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Task15v1 task = new Task15v1();
		int n = 8; // 1 < n < 10
		int min = task.getMim(n);
		int max = task.getMax(n);
		System.out.println("Min = " + min);
		System.out.println("Max = " + max);

		for (int i = min; i <= max; i++) {

			if (task.isAscending(task.createArray(i))) {
				System.out.println(i);
			}
		}

		long finish = System.currentTimeMillis();
		task.showTime(start, finish);

	}

	/* Формирование минимального значения для поиска */
	public int getMim(int num) {
		int[] number = new int[num];

		for (int i = 0; i < number.length; i++) {
			number[i] = i + 1;
		}

		return getIntNumber(number);
	}

	/* Формирование максимального значения для поиска */
	public int getMax(int num) {
		int[] number = new int[num];
		int length = number.length;

		for (int i = 0; i < length; i++) {
			number[length - i - 1] = 9 - i;
		}

		return getIntNumber(number);
	}

	/* Формирование массива с элементами из цифр натурального числа */
	public int[] createArray(int num) {

		int[] array = new int[0];
		int tmp = num;
		int i = 0;

		while (tmp > 0) {
			array = Arrays.copyOf(array, array.length + 1);
			array[i] = tmp % 10;
			tmp = tmp / 10;
			i++;
		}

		int dim = array.length - 1;

		for (int j = 0; j < (dim + 1) / 2; j++) { // реверс массива, чтобы порядок элементов массива соответствовал порядку цифр
			int tmpNum = array[j];
			array[j] = array[dim - j];
			array[dim - j] = tmpNum;
		}

		return array;
	}

	/* Получить int число из массива int чисел от 0 до 9 */
	public int getIntNumber(int[] arr) {
		int number = 0;
		int length = arr.length;
		int i = 0;

		while (i < length) {
			number = number + arr[i] * (int) Math.pow(10, (length - i - 1));
			i++;
		}

		return number;
	}

	/* Проверка числа на строгое возрастание его цифр */
	public boolean isAscending(int arr[]) {
		int length = arr.length;
		int i = 0;

		while (i < length - 1) {

			if (arr[i] >= arr[i + 1]) {
				return false;
			}

			i++;
		}

		return true;

	}

	/* Вывод в консоль времени работы программы */
	public void showTime(long start, long finish) {
		long time = finish - start;
		int part = (int) time % 1000;
		time = time / 1000;
		System.out.print("Time: ");
		int hour = (int) (time / 3600);
		System.out.print(hour + " hours ");
		int min = (int) (time - hour * 3600) / 60;
		System.out.print(min + " mins ");
		int sec = (int) (time - hour * 3600 - min * 60);
		System.out.println(sec + "." + part + " sec");
	}
}
