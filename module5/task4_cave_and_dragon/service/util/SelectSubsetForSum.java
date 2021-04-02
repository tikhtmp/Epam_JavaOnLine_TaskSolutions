package by.epam_training.java_online.module5.task4_cave_and_dragon.service.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.epam_training.java_online.module5.task4_cave_and_dragon.bean.Treasure;
import by.epam_training.java_online.module5.task4_cave_and_dragon.dao.CaveAndDragonDAOException;
import by.epam_training.java_online.module5.task4_cave_and_dragon.dao.impl.CaveAndDragonDAOImpl;

public class SelectSubsetForSum {

	private static boolean isDone = false;
	public static List<Integer> result = new ArrayList<Integer>();

	// dp [i] [j] будет хранить true, если сумма j
	// возможна с элементами массива от 0 до i.

	static boolean[][] dp;

	static void display(ArrayList<Integer> v)

	{
		System.out.println(v);
	}

	// Рекурсивная функция для печати всех подмножеств с
	// помощь dp [] []. Вектор p [] хранит текущее подмножество.

	static void findSubsetsRec(int arr[], int i, int sum, ArrayList<Integer> p) {

		// Если мы достигли конца и сумма не равна нулю. Мы печатаем
		// p [] только если arr [0] равно sun ИЛИ dp [0] [sum] true

		while (!isDone) {

			if (i == 0 && sum != 0 && dp[0][sum])

			{
				p.add(arr[i]);
				result.addAll(p);
				p.clear();
				isDone = true;
				return;
			}

			// Если сумма становится 0

			if (i == 0 && sum == 0) {

				result.addAll(p);
				p.clear();
				isDone = true;
				return;
			}

			// Если заданная сумма может быть достигнута после игнорирования
			// текущего элемента.

			if (dp[i - 1][sum]) {

				// Создать новый вектор для хранения пути

				ArrayList<Integer> b = new ArrayList<>();

				b.addAll(p);

				findSubsetsRec(arr, i - 1, sum, b);
			}

			// Если данная сумма может быть достигнута после рассмотрения
			// текущего элемента.

			if (sum >= arr[i] && dp[i - 1][sum - arr[i]]) {

				p.add(arr[i]);

				findSubsetsRec(arr, i - 1, sum - arr[i], p);

			}
		}
	}

	// Печатает все подмножества arr [0..n-1] с суммой 0.
	public static void findAllSubsets(int arr[], int n, int sum) {

		if (n == 0 || sum < 0)
			return;

		// Сумма 0 всегда может быть достигнута с 0 элементами

		dp = new boolean[n][sum + 1];

		for (int i = 0; i < n; ++i) {

			dp[i][0] = true;

		}

		// Сумма arr [0] может быть достигнута с одним элементом

		if (arr[0] <= sum)

			dp[0][arr[0]] = true;

		// Заполняем остальные записи в dp [] []

		for (int i = 1; i < n; ++i)

			for (int j = 0; j < sum + 1; ++j)

				dp[i][j] = (arr[i] <= j) ? (dp[i - 1][j] || dp[i - 1][j - arr[i]]) : dp[i - 1][j];

		if (dp[n - 1][sum] == false) {

//			System.out.println("There are no subsets with" + " sum " + sum);

			return;
		}

		// Теперь рекурсивно обходим dp [] [], чтобы найти все
		// пути из dp [n-1] [sum]

		ArrayList<Integer> p = new ArrayList<>();

		findSubsetsRec(arr, n - 1, sum, p);
	}

	// Программа драйвера для проверки вышеуказанных функций

	public static void main(String args[]) throws IOException, CaveAndDragonDAOException

	{

		int arr[] = { 2, 5, 1, 4, 3 };
		CaveAndDragonDAOImpl tdi = new CaveAndDragonDAOImpl();
		List<Treasure> treasures = tdi.readTreasureFile();
		int arrTreasures[] = new int[treasures.size()];

		for (int i = 0; i < treasures.size(); i++) {
			arrTreasures[i] = treasures.get(i).getValue();
		}

		arr = arrTreasures;

		int n = arr.length;

		int sum = 1000;

		findAllSubsets(arr, n, sum);
	}
}
