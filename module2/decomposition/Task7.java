/* Условие задачи:
Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.
*/

package by.epam_training.java_online.module2.decomposition;

public class Task7 {

	public static void main(String[] args) {

		Task7 task = new Task7();
		System.out.println(task.getSumOddFactorial(9));

	}

	public int getSumOddFactorial(int num) {
		int sum = 1;

		for (int i = 3; i <= num; i++) {

			if (i % 2 != 0) {
				sum += getFactorial(i);
			}
		}

		return sum;

	}

	public int getFactorial(int num) {
		int factorial = 1;

		for (int i = 1; i <= num; i++) {
			factorial *= i;
		}

		return factorial;
	}

}
