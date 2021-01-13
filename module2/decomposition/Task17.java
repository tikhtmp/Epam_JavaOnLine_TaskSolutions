/* Условие задачи:
Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д.
Сколько таких действий надо произвести, чтобы получился нуль? 
Для решения задачи использовать декомпозицию
  
Мои примечания:
Получится ли обязательно нуль?
Решение для условия "пока результат больше нуля"
Можно просто поделить число на сумму его цифр
*/

package by.epam_training.java_online.module2.decomposition;

public class Task17 {

	public static void main(String[] args) {

		Task17 task = new Task17();
		int n = 12348;
		int sum = task.getSumOfNumbers(n);
		int iteration1 = n / sum;

		System.out.println("sum " + sum);
		int iteration2 = 0;

		while (n >= 0) {
			n = n - sum;

			if (n >= 0) {
				iteration2++;
			}
		}

		System.out.println("iterations1 " + iteration2);
		System.out.println("iterations2 " + iteration1);

	}

	/* Сумма цифр числа */
	public int getSumOfNumbers(int num) {

		int sum = 0;

		while (num > 0) {
			sum = sum + num % 10;
			num = num / 10;
		}

		return sum;
	}

}
