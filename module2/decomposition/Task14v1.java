/* Условие задачи:
Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр,
возведенная в степень n, равна самому числу. Найти все числа Армстронга от 1 до k. Для решения задачи
использовать декомпозицию.
 
Мои примечания:
Первый вариант решения - самый простой и неэффективный. Простой перебор чисел с проверкой на "армстронговость".
для k = 100,000,000 время работы программы 1 min 14.408 sec
*/

package by.epam_training.java_online.module2.decomposition;

public class Task14v1 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Task14v1 task = new Task14v1();
		int k = 100000000;

		for (int i = 1; i <= k; i++) {

			if (task.isArmstrong(i)) {
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

	/* Проверка является ли число числом Армстронга */
	public boolean isArmstrong(int num) {

		int tmp = num;
		int curr = 0;
		int sum = 0;
		int degree = 0;

		while (tmp > 0) {
			tmp = tmp / 10;
			degree++;
		}

		tmp = num;

		while (tmp > 0) {
			curr = tmp % 10;
			tmp = tmp / 10;
			sum = sum + (int) Math.pow(curr, degree);
		}

		if (sum == num) {
			return true;
		} else
			return false;
	}

}
