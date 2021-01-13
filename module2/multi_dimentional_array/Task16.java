/* Условие задачи:
Магическим квадратом порядка n называется квадратная матрица размера nxn, составленная из чисел 1, 2, 3,...,n^2 так,
что суммы по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны между собой. Построить такой квадрат.

Мое примечание:
Магический квадрат можно построить, начиная с размерности 3. Так как не известен никакой общий метод построения
всех магических квадратов данного порядка n, то в данной задаче по моему выбору был реализован алгоритм построения магического квадрата
нечетного порядка (Индийский метод).
*/

package by.epam_training.java_online.module2.multi_dimentional_array;

public class Task16 {

	public static void main(String[] args) {

		Task16 task = new Task16();
		int dimention = 9;
		int[][] array = new int[dimention][dimention];
		int line = 0;
		int column = dimention / 2;
		array[line][column] = 1;

		for (int i = 2; i <= dimention * dimention; i++) {

			line = line - 1;
			column = column + 1;

			if ((column > dimention - 1) && (line < 0)) {
				line = 1;
				column = dimention - 1;
			} else {

				if (line < 0) {
					line = dimention - 1;
				}

				if (column > dimention - 1) {
					column = 0;
				}

				if (array[line][column] != 0) {
					line = line + 2;
					column = column - 1;
				}
			}

			array[line][column] = i;

		}

		task.printArray(array);
		
		if (task.testMagic(array)) {
			System.out.println("The square is magic.");
		} else {
			System.out.println("The square is not magic.");
		}
	}

	/* Проверка на магичность */
	public boolean testMagic(int anArray[][]) {
		int sum = 0;

		for (int elem : anArray[0]) {
			sum += elem;
		}

		int sumDiagDown = 0;
		int sumDiagUp = 0;

		for (int i = 0; i < anArray.length; i++) {
			int sumLine = 0;
			int sumColumn = 0;

			for (int j = 0; j < anArray[0].length; j++) {
				sumLine += anArray[i][j];
				sumColumn += anArray[j][i];

				if (i == j) {
					sumDiagDown += anArray[i][j];
				}

				if (i == anArray.length - j - 1) {
					sumDiagUp += anArray[i][j];
				}
			}

			if (sumLine != sum || sumColumn != sum) {
				return false;
			}
		}

		if (sumDiagDown != sum || sumDiagUp != sum) {
			return false;
		}

		return true;
	}

	/* Вывод двумерного int массива в консоль */
	public void printArray(int anArray[][]) {

		for (int line[] : anArray) {

			for (int element : line) {
				System.out.printf("%3d", element);
			}

			System.out.println();
		}
		System.out.println();
	}

}
