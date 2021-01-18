/*
Условие: Создать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом
три различных операции: 
- отсортировать абзацы по количеству предложений; 
- в каждом предложении отсортировать слова по длине; 
- отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства -
  по алфавиту. 
 */
package by.epam_training.java_online.module3.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {

	public static void main(String[] args) {
		String testString = "\tSoapy sat on a seat in Madison Square, New York, and looked up at the sky. A dead leaf fell onto his arm.\r"
				+ "Winter was coming, and Soapy knew that he must make his plans. He moved unhappily on his seat.\r\n"
				+ "\tHe wanted three months in a nice, warm prison, with food and good friends. This was how he usually spent his winters.\r"
				+ "And now it was time, because, at night on his seat in the square, three newspapers did not keep out the cold.\r\n"
				+ "\tSo Soapy decided to go to prison, and at once began to try his first plan. It was usually easy.\r"
				+ "He ate dinner in an expensive restaurant. Then he told them he had no money and they called a policeman. Nice and easy, with no trouble.\r\n";

		/* сортировка текста по количеству предложений в абзаце */
		String sortedBySentenceNumber = sortText(testString, "\n", "[!?.:]+");
		System.out.println(sortedBySentenceNumber);

		/* сортировка слов в предложении по длине */
		String[] blocSentence = testString.split("[!?.:]+");
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < blocSentence.length; i++) {
			sb.append(sortText(blocSentence[i], "[\\s.,!?:;]+", ""));
		}

		String sortedByWordLength = sb.toString();
		System.out.println(sortedByWordLength);

		/* Сортировка лексем по убыванию количества вхождений заданного символа */
		String testSentence = "He wanted threee monthse inee a nicee, warmeeeee e prison, with food and gooeeed frieeeeends sffaseeeee.";
		System.out.println(testSentence);
		String sortedSentence = toSortSentence(testSentence, "e");
		System.out.println(sortedSentence);
	}

	/* Сортировка лексем по убыванию количества вхождений заданного символа */
	static String toSortSentence(String text, String symbol) {
		String[] blocWord = text.split("[\\s.,!?:;]+");
		Pattern input = Pattern.compile(symbol);
		int i = 0;
		int max = 0;
		int[] inputs = new int[blocWord.length];

		for (String word : blocWord) {

			int count = 0;
			Matcher matcher = input.matcher(word);

			while (matcher.find()) { // определение количества вхождений в текущем слове
				count++;
			}

			if (max < count) { // определение максимального количества вхождений
				max = count;
			}

			inputs[i++] = count; // формирование массива из количества вхождений в каждом слове предложения
		}

		int[] order = setOrder(inputs);
		String sorted = collectString(blocWord, order);
		String[] sortedLine = sorted.split("[\\s.,!?:;]+");
		StringBuilder result = new StringBuilder();

		for (int j = max; j >= 0; j--) {
			StringBuilder sb = new StringBuilder();

			for (int k = sortedLine.length - 1; k >= 0; k--) {

				if (inputs[k] == j) {
					sb.append(sortedLine[k]).append(" "); // сброрка подстроки по количеству вхождений
				}
			}

			String[] bloc = sb.toString().toLowerCase().split("[\\s.,!?:;]+");
			Arrays.sort(bloc); // сортировка слов по алфавиту в текущей подстроке
			StringBuilder sbSorted = new StringBuilder();

			for (int l = 0; l < bloc.length; l++) {
				sbSorted.append(bloc[l]).append(" "); // сборка подстроки из отсортированных по алфавиту слов
			}

			if (j == max)
				sbSorted.deleteCharAt(sbSorted.length() - 1); // удаление лишнего пробела в подстроке с максимом
																// вхождений
			result.append(sbSorted); // сборка строки-результата
		}

		return result.deleteCharAt(result.length() - 1).toString();
	}

	/* Сортировка текста по размеру его частей */
	static String sortText(String text, String firstSplitter, String secondSplitter) {

		String[] blocList = text.split(firstSplitter);
		int[] blockSize = new int[blocList.length];

		for (int i = 0; i < blocList.length; i++) {

			blockSize[i] = blocList[i].split(secondSplitter).length;
		}

		int[] order = new int[blocList.length];
		order = setOrder(blockSize);
		String result = collectString(blocList, order);

		return result + "\n";
	}

	/* Определения порядка "сборки" строки */
	static int[] setOrder(int[] sizes) {
		int[] order = new int[sizes.length];

		for (int i = 0; i < order.length; i++) {
			order[i] = i;
		}

		int tmpOrder = 0;
		int tmpSizes = 0;

		for (int i = 0; i < order.length - 1; i++) {

			for (int j = i + 1; j < order.length; j++) {

				if (sizes[i] > sizes[j]) {
					tmpOrder = order[j];
					order[j] = order[i];
					order[i] = tmpOrder;

					tmpSizes = sizes[j];
					sizes[j] = sizes[i];
					sizes[i] = tmpSizes;
				}
			}
		}

		return order;
	}

	/* "сборка" строки из частей в переданном порядке */
	static String collectString(String[] text, int[] order) {
		StringBuilder sb = new StringBuilder();

		for (int j = 0; j < text.length; j++) {

			sb.append(text[order[j]]);

			if (j != order.length - 1) {
				sb.append(" ");
			}
		}

		return sb.toString();
	}

}
