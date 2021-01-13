/* Условие задачи:
Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми.
*/

package by.epam_training.java_online.module2.decomposition;

public class Task6 {

	public static void main(String[] args) {
		Task6 task = new Task6();
		int first = 13;
		int second = 8;
		int third = 10;

		if (task.checkIsThreePrime(first, second, third)) {
			System.out.println("Numbers " + first + "  " + second + " " + third + " are prime");
		} else {
			System.out.println("Numbers " + first + "  " + second + " " + third + " are not prime");
		}

		first = 33;
		second = 60;
		third = 12;

		if (task.checkIsThreePrime(first, second, third)) {
			System.out.println("Numbers " + first + "  " + second + " " + third + " are prime");
		} else {
			System.out.println("Numbers " + first + "  " + second + " " + third + " are not prime");
		}

	}

	public int findMaxDivisor(int first, int second) {

		/* Алгоритм Евклида нахождения НОД */
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

	/* Проверка трех чисел на взаимную простоту */
	public boolean checkIsThreePrime(int first, int second, int third) {

		if (findMaxDivisor(findMaxDivisor(first, second), third) > 1) {
			return false;
		} else {
			return true;
		}
	}
}
