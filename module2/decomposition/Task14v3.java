/* Условие задачи:
Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр,
возведенная в степень n, равна самому числу. Найти все числа Армстронга от 1 до k. Для решения задачи
использовать декомпозицию.
 
Мои примечания:
Третий вариант решения - усовершенствованный. Используется заранее созданная таблица степеней чисел от 0 до 9. 
Перебор чисел производится с использованием двух "фильтров": 
1. Каждая цифра числа не меньше предыдущей и не больше последующей.
2. Исключается набор цифр, из которых состоят уже найденные числа Армстронга. 
для k = 100,000,000 время работы программы 0 mins 20.839 sec
*/

package by.epam_training.java_online.module2.decomposition;

import java.util.Arrays;

public class Task14v3 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		Task14v3 task = new Task14v3();
		int k = 100000000;
		long[][] matrix = task.createDegreeMatrix(10);

		long[] armstrongArray = new long[0];
		int count = 0;

		for (int i = 1; i < k; i++) {
			long[] numArr = task.createArray(i);

			if (task.whetherCheck(numArr)) { // Каждая цифра числа должна быть не меньше предыдущей и не больше последующей.
				long aNum = task.getSum(numArr, matrix);

				if (task.isArmstrong(aNum, matrix)) { // Проверка на "армстронговость"

					if (task.ifAlreadyIs(aNum, armstrongArray)) { // Проверка: нет ли уже числа Армстронга с таким же набором цифр? 
						boolean isIn = false;

						for (int j = 0; j < armstrongArray.length; j++) {

							if (aNum == armstrongArray[j]) {
								isIn = true;
								break;
							}
						}

						if (isIn == false) {
							armstrongArray = Arrays.copyOf(armstrongArray, armstrongArray.length + 1);
							armstrongArray[count] = aNum;
							count++;
						}
					}
				}
			}
		}

		task.sortAcsending(armstrongArray);
		task.printArray(armstrongArray);

		long finish = System.currentTimeMillis();
		task.showTime(start, finish);

	}

	/* Создание матрицы степеней чисел от 0 до 9 */
	public long[][] createDegreeMatrix(int num) {
		long[][] matrix = new long[num][num];

		for (int i = 0; i < num; i++) {

			for (int j = 0; j < num; j++) {
				matrix[i][j] = (long) Math.pow(i, j);
			}
		}

		return matrix;
	}

	/* Формирование массива с элементами из цифр натурального числа */
	public long[] createArray(long num) {

		long[] array = new long[0];
		long tmp = num;
		int i = 0;

		while (tmp > 0) {
			array = Arrays.copyOf(array, array.length + 1);
			array[i] = tmp % 10;
			tmp = tmp / 10;
			i++;
		}

		int dim = array.length - 1;

		for (int j = 0; j < (dim + 1) / 2; j++) { // чтобы порядок элементов массива соответствовал порядку цифр
			long tmpNum = array[j];
			array[j] = array[dim - j];
			array[dim - j] = tmpNum;
		}

		return array;
	}

	/* Будем ли проверять число? (Да, если каждая цифра числа не меньше предыдущей и не больше последующей).*/
	public boolean whetherCheck(long arr[]) {
		int i = 2;
		int length = arr.length;

		while (i < length - 1) {

			if (((arr[i] < arr[i - 1]) || (arr[i] > arr[i + 1]))) {
				return false;
			}

			i++;
		}

		return true;
	}

	/* Вычисление суммы цифр числа в степени его разряда */
	public long getSum(long[] numArr, long[][] matrix) {
		int length = numArr.length;
		long sum = 0;

		for (int j = 0; j < length; j++) {
			int index = (int) (numArr[j]);
			sum = sum + matrix[index][length];
		}

		return sum;
	}

	/* Проверка является ли число числом Армстронга */
	public boolean isArmstrong(long num, long[][] matrix) {

		long sum = getSum(createArray(num), matrix);

		if (sum == num) {
			return true;
		} else
			return false;
	}

	/* Проверяем нет ли уже числа с такими же цифрами в результирующей матрице */
	public boolean ifAlreadyIs(long num, long arr[]) {
		long[] arr1 = createArray(num);
		sortAcsending(arr1);

		for (int i = 0; i < arr.length; i++) {
			long[] arr2 = createArray(arr[i]);
			sortAcsending(arr2);

			if (Arrays.equals(arr1, arr2)) {
				return false;
			}
		}
		return true;
	}

	/* Сортировка по возрастанию */
	public void sortAcsending(long arr[]) {
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
	public void swap(long[] arr, int firstIndex, int secondIndex) {
		long tmp;
		tmp = arr[firstIndex];
		arr[firstIndex] = arr[secondIndex];
		arr[secondIndex] = tmp;
	}

	/* Вывод одномерного long массива в консоль */
	public void printArray(long arr[]) {

		for (long num : arr) {
			System.out.print(num + " ");
		}

		System.out.println();
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
