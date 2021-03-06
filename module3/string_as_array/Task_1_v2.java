/*
Условие: Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
*/

package by.epam_training.java_online.module3.string_as_array;

public class Task_1_v2 {

	public static void main(String[] args) {

		String[] camelName = { "variableOne", "VariableTwo", "variableThreE", "variableFour",
				"variableOneHundredTwentyTwo" };
		String[] snake_name = new String[camelName.length];

		for (int i = 0; i < camelName.length; i++) {
			snake_name[i] = String.valueOf(convertFromCamelIntoSnake(camelName[i].toCharArray()));
		}

		for (int i = 0; i < snake_name.length; i++) {
			System.out.print(camelName[i].toCharArray());
			System.out.print(",  ");
		}

		System.out.println();

		for (int i = 0; i < snake_name.length; i++) {
			System.out.print(snake_name[i]);
			System.out.print(", ");

		}

	}

	/* преобразование строки camelCase в snake_case */
	static char[] convertFromCamelIntoSnake(char name[]) {
		int count = 0;

		for (int i = 1; i < name.length; i++) { // подсчет кол-ва заглавных букв, начиная со второй
			if (Character.isUpperCase(name[i])) {
				count++;
			}
		}

		char[] snakeName = new char[name.length + count];

		for (int i = 0; i < name.length; i++) {
			snakeName[i] = name[i];
		}

		if (Character.isUpperCase(snakeName[0])) { // если первая буква в названии заглавная
			snakeName[0] = Character.toLowerCase(snakeName[0]);
		}

		for (int i = 1; i < snakeName.length; i++) {

			if (Character.isUpperCase(snakeName[i])) {

				for (int j = 0; j < i; j++) {
					snakeName[j] = snakeName[j];
				}

				for (int j = snakeName.length - 1; j > i + 1; j--) {
					snakeName[j] = snakeName[j - 1];
				}

				snakeName[i + 1] = Character.toLowerCase(snakeName[i]);
				snakeName[i] = '_';
			}
		}

		return snakeName;
	}

}
