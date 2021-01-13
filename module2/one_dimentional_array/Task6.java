/* Условие задачи:
Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых
являются простыми числами.
*/

package by.epam_training.java_online.module2.one_dimentional_array;

public class Task6 {

	public static void main(String[] args) {

		double [] array = { 15.2, -18.8, 1.6, 120.7, 0.0, 45.6, -22.1 };
		double sum = array[2]; // первое простое число "2", поэтому сумма инициализируется вторым элементом
		Task6 task = new Task6();

		for (int i = 3; i < array.length; i++) {

			if (task.checkIfPrime(i)) { // если индекс массива простое число, добавляем к сумме соответствующий элемент
				sum += array[i];
			}
		}

		System.out.println(sum);
	}

	/* Проверка индекса массива на простоту. Используется самый примитивный алгоритм */
	public boolean checkIfPrime(int index) {

		boolean isPrime = false;

		for (int i = 2; i < index; i++) {

			if (index % i == 0) {
				isPrime = false;
				break;
			} else {
				isPrime = true;
			}

		}

		return isPrime;
	}
}