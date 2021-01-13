/* Условие задачи:
Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2. Для
решения задачи использовать декомпозицию.
*/

package by.epam_training.java_online.module2.decomposition;

import java.util.Arrays;

public class Task13 {

	public static void main(String[] args) {
		int n = 100;
		Task13 task = new Task13();
		
		System.out.println("Primes:");
		task.printArray(task.getPrimes(n * 2));
		System.out.println();
		System.out.println("Twins:");
		task.printTwins(task.getPrimes(n * 2));

	}

	/* Поиск простых чисел на отрезке [n,2n] при помощи решета Эратосфена */
	public int[] getPrimes(int num) {

		boolean[] isPrime = new boolean[num];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;

		int[] arrayOfPrimes = new int[0];

		for (int i = 2; i * i < num; i++) {

			if (isPrime[i]) {

				for (int j = i * i; j < num; j += i) {
					isPrime[j] = false;
				}
			}
		}

		int k = 0;

		for (int j = num / 2; j < isPrime.length; j++) {

			if (isPrime[j]) {
				arrayOfPrimes = Arrays.copyOf(arrayOfPrimes, arrayOfPrimes.length + 1);
				arrayOfPrimes[k] = j;
				k++;
			}
		}

		return arrayOfPrimes;
	}

	/* Вывод близнецов из массива простых чисел в консоль */
	public void printTwins(int arr[]) {

		for (int i = 0; i < arr.length - 1; i++) {

			if (arr[i + 1] - arr[i] == 2) {
				System.out.println(arr[i] + " " + arr[i + 1]);
			}
		}

		System.out.println();
	}

	/* Вывод одномерного int массива в консоль */
	public void printArray(int arr[]) {

		for (int num : arr) {
			System.out.print(num + " ");
		}

		System.out.println();
	}

}
