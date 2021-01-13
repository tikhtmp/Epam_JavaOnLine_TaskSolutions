/* Условие задачи:
Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел.
*/

package by.epam_training.java_online.module2.decomposition;

public class Task2 {

	public static void main(String[] args) {

		int first = 32;
		int second = 12;
		int third = 16;
		int fourth = 36;

		Task2 task = new Task2();

		System.out.println("Max divisor = " + task.findMaxDivisorFour(first, second, third, fourth));

	}

	public int findMaxDivisorFour(int first, int second, int third, int fourth) {
		return findMaxDivisor(findMaxDivisor(first, second), findMaxDivisor(third, fourth));
	}

	/* Поиск наибольшего общего делителя двух натуральных чисел */
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

		/* Простой перебор: */
		// div=Integer.min(first, second);
		// while (first % div != 0 || second % div != 0) {
		// div--;
		// }
		// return div;

	}

}
