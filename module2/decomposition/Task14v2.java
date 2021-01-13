/* Условие задачи:
Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр,
возведенная в степень n, равна самому числу. Найти все числа Армстронга от 1 до k. Для решения задачи
использовать декомпозицию.
 
Мои примечания:
Второй вариант решения - с использованием заранее созданной таблицы степеней чисел от 0 до 9.
для k = 100,000,000 время работы программы 0 mins 23.134 sec
*/

package by.epam_training.java_online.module2.decomposition;

import java.util.Arrays;

public class Task14v2 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		Task14v2 task = new Task14v2();
		int k = 100000000;
		long[][] matrix = task.createDegreeMatrix(10);

		for (int i = 0; i < k; i++) {
			int[] numArr = task.createArray(i);
			int length = numArr.length;
			long sum = 0;

			for (int j = 0; j < length; j++) {
				sum = sum + matrix[numArr[j]][length];
			}

			if (sum == i) {
				System.out.println(i);
			}
		}
		
		long finish = System.currentTimeMillis();
		task.showTime(start, finish);
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

		for (int j = 0; j < (dim + 1) / 2; j++) { // чтобы порядок элементов массива соответствовал порядку цифр исходного числа производим реверс массива.
													
			int tmpNum = array[j];
			array[j] = array[dim - j];
			array[dim - j] = tmpNum;
		}

		return array;
	}

	/* Создание матрицы степеней */
	public long[][] createDegreeMatrix(int num) {
		long[][] matrix = new long[num][num];

		for (int i = 0; i < num; i++) {

			for (int j = 0; j < num; j++) {
				matrix[i][j] = (long) Math.pow(i, j);
			}
		}

		return matrix;
	}

}
