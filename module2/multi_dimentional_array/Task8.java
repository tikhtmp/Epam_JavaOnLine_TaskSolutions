/* Условие задачи: 
В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить
на соответствующие им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит
пользователь с клавиатуры.
*/

package by.epam_training.java_online.module2.multi_dimentional_array;

import java.util.Scanner;

public class Task8 {

	public static void main(String[] args) {

		int[][] array = { { 8, 40, -15, -5, 8, 11, -2 }, { 2, 0, 5, -18, 24, 44, 16 }, { 16, 22, 9, -33, 27, 22, 6 },
				{ 6, 2, 19, 47, 18, 0, 49 }, { 3, 39, -19, 23, 17, -8, -10 }, { 13, 9, -9, -43, 25, 20, 0 },
				{ -4, 22, 40, 30, 28, -22, 4 }, { 11, 15, 0, 0, 8, -2, 44 } };

		Task8 task = new Task8();

		System.out.println("Input number of the first column:");
		int first = task.inputPositiveInt(array.length) - 1;

		System.out.println("Input number of the second column:");
		int second = task.inputPositiveInt(array.length) - 1;

		System.out.println("Source matrix:");
		task.printArray(array);
		System.out.println();

		/* Замена местами двух столбцов */
		int tmp = 0;
		for (int i = 0; i < array.length; i++) {
			tmp = array[i][first];
			array[i][first] = array[i][second];
			array[i][second] = tmp;
		}

		System.out.println("Result matrix:");
		task.printArray(array);

	}

	/* Вывод двумерного int массива в консоль */
	public void printArray(int mArray[][]) {

		for (int line[] : mArray) {

			for (int element : line) {
				System.out.printf("%5d", element);
			}

			System.out.println();
		}
	}

	/* Ввод положительного числа от 1 до max включительно */
	public int inputPositiveInt(int max) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		@SuppressWarnings("unused")
		String str;
		int result = 0;

		do {
			while (!scan.hasNextInt()) {
				str = scan.next();
				System.out.println("Wrong value! Try again.");
			}

			result = scan.nextInt();

			if (result <= 0 || result > max) {
				System.out.println("The number must be from 1 to " + max);
			}

		} while (result <= 0 || result > max);

		return result;
	}
}
