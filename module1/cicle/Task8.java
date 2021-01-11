/*
Циклы. Задача 8.
Условие: Даны два числа. Определить цифры, входящие в запись как первого так и второго числа.
 */

package by.epam_training.java_online.module1.cicle;

import java.util.Scanner;

public class Task8 {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		@SuppressWarnings("unused")
		String str;

		/* ввод первого числа */
		long first = 0L;
		System.out.println("Input first number (type long): ");
		while (!scan.hasNextLong()) {
			str = scan.next();
			System.out.println("Wrong type! Try again.");
		}
		first = scan.nextLong();
		first = Math.abs(first); // на случай если пользователь введет отрицательное число

		/* ввод второго числа */
		long second = 0L;
		System.out.println("Input second number (type long): ");
		while (!scan.hasNextLong()) {
			str = scan.next();
			System.out.println("Wrong type! Try again.");
		}
		second = scan.nextLong();
		second = Math.abs(second); // на случай если пользователь введет отрицательное число

		/* удаление повторяющихся цифр из первого числа */
		long fullNum = first;
		long shortNum;
		long result = 0L;
		boolean contained = false;
		int beforeLast;
		int last;
		int j = 0;

		System.out.print("The first number contains figures: ");

		while (fullNum >= 1) {

			beforeLast = (int) (fullNum % 10);
			shortNum = fullNum / 10;

			while (shortNum >= 1) {
				last = (int) (shortNum % 10);

				if (last == beforeLast) {
					contained = true;
				}

				shortNum = shortNum / 10;
			}

			if (contained == false) {
				System.out.print(beforeLast + " ");
				result = result + beforeLast * (long) Math.pow(10, j);
				j++;

			}

			fullNum = fullNum / 10;
			contained = false;
		}

		first = result;

		/*
		 * Удаление повторяющихся цифр из второго числа. Было бы правильнее сделать
		 * отдельный метод для удаления лишних цифр, но на этом этапе обучения
		 * декомпозиция не предполагается.
		 */
		fullNum = second;
		beforeLast = 0;
		last = 0;
		result = 0L;
		j = 0;

		System.out.println();
		System.out.print("The second number contains figures: ");

		while (fullNum >= 1) {
			beforeLast = (int) (fullNum % 10);
			shortNum = fullNum / 10;

			while (shortNum >= 1) {
				last = (int) (shortNum % 10);

				if (last == beforeLast) {
					contained = true;
				}

				shortNum = shortNum / 10;
			}

			if (contained == false) {
				System.out.print(beforeLast + " ");
				result = result + beforeLast * (long) Math.pow(10, j);
				j++;

			}

			fullNum = fullNum / 10;
			contained = false;
		}
		second = result;

		/* нахождение общих цифр в двух числах*/
		int currentFirst;
		int currentSecond;
		long secondNum = second; // Полное второе число используется многократно, поэтому необходимо сохранить
									// его изначальное значение

		System.out.println();
		System.out.print("Common figures are: ");

		while (first >= 1) {
			currentFirst = (int) (first % 10);

			while (second >= 1) {
				currentSecond = (int) (second % 10);

				if (currentFirst == currentSecond) {
					System.out.print((currentFirst + " "));
				}

				second = second / 10;
			}

			first = first / 10;
			second = secondNum;
		}
	}
}
