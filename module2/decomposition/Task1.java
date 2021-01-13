/* Условие задачи:
Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух
натуральных чисел: НОК( А, В) = A*B / НОДА (А, В)
 
Мое примечание:
НОД находится методом Евклида, как наиболее эффективным из простых.
*/

package by.epam_training.java_online.module2.decomposition;

public class Task1 {

	public static void main(String[] args) {

		int first = 20;
		int second = 15;
		Task1 task = new Task1();

		System.out.println("First number = " + first + "  second number = " + second);
		System.out.println("Max divisor = " + task.findMaxDivisor(first, second));
		System.out.println("Min multiple = " + task.findLeastMultiple(first, second));

	}

	/* Поиск наименьшего общего кратного */
	public int findLeastMultiple(int first, int second) {
		return (first * second) / findMaxDivisor(first, second);
	}

	/* Поиск наибольшего общего делителя */
	public int findMaxDivisor(int first, int second) {

		/* Алгоритм Евклида */
		while (second != first) {

			if (first > second) {
				int tmp = first;
				first = second;
				second = tmp;
			}

			second = second - first;
		}

		return first;
	}
}
