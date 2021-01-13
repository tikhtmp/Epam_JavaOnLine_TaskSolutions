package by.epam_training.java_online.module2.decomposition;
/* Условие задачи:
Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры.
Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию.
  
Мои примечания: Простой перебор.
*/

public class Task16 {

	public static void main(String[] args) {

		Task16 task = new Task16();
		int n = 5;
		int min = (int) Math.pow(10, (n - 1));
		int max = (int) (Math.pow(10, n) - 1);
		System.out.println("min " + min);
		System.out.println("max " + max);
		long sum = 0L;

		for (int i = min; i <= max; i++) {

			if (task.isOdd(i)) {
				sum += i;
			}
		}

		System.out.println("sum " + sum);
		System.out.println("Quantity of even in the sum: " + task.findEvenQuantity(sum));

	}

	/* Проверка цифр числа на нечетность */
	public boolean isOdd(int num) {

		while (num > 0) {

			if (num % 2 == 0) {
				return false;
			}
			num = num / 10;
		}

		return true;
	}
	
	/* Подсчет четных цифр числа */
	public int findEvenQuantity(long num) {
		
		int evenQuantity = 0;

		while (num > 0) {

			if (num % 2 == 0) {
				evenQuantity++;
			}
			num = num / 10;
		}

		return evenQuantity;
	}

}
