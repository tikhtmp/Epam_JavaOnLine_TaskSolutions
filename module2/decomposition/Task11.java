/* Условие задачи:
Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.
*/

package by.epam_training.java_online.module2.decomposition;

public class Task11 {

	public static void main(String[] args) {

		Task11 task = new Task11();
		int first = 32408;
		int second = 4548;

		if (task.getNumberOfDigits(first) > task.getNumberOfDigits(second)) {
			System.out.println("Number " + first + " has more digits than number " + second);
		} else if (task.getNumberOfDigits(first) < task.getNumberOfDigits(second)) {
			System.out.println("Number " + second + " has more digits than number " + first);
		} else {
			System.out.println("Numbers have equal quantity of digits");
		}

	}

	public int getNumberOfDigits(int num) {
		int dig = 0;

		while (num > 0) {
			num = num / 10;
			dig++;
		}

		return dig;
	}
}
