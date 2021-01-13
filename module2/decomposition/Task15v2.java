/* Условие задачи:
Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую
последовательность (например, 1234, 5789). Для решения задачи использовать декомпозицию.
 
Рекурсия.
Для n = 8  Time: 0 hours 0 mins 0.2 sec
*/

package by.epam_training.java_online.module2.decomposition;

public class Task15v2 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		Task15v2 task = new Task15v2();
		int n = 8;

		task.findStrictlyIncreasingNum(1, " ", n);

		long finish = System.currentTimeMillis();
		task.showTime(start, finish);

	}

	/*
	 * Вывод всех n-значных чисел, цифры в которых образуют строго возрастающую
	 * последовательность. out - сохраняет текущий номер выхода в виде строки, 
	 * start - Текущая начальная цифра, которую  нужно учитывать
	 */
	void findStrictlyIncreasingNum(int start, String out, int n) {  

		if (n == 0) { // Если число становится N-разрядным, выводим его
			System.out.println(out + " ");
			return;
		}

		for (int i = start; i <= 9; i++) { // начинаем с (предыдущая цифра + 1) до 9
			String str = out + Integer.toString(i); // добавляем текущую цифру к номеру
			findStrictlyIncreasingNum(i + 1, str, n - 1); // рекурсивно для следующей цифры
		}

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

}
