/*
Модуль 4. Агрегация и композиция.
Задача 1.
Условие: Создать объет класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на консоль текст,
заголовок текста.  
*/
package by.epam_training.java_online.module4.composition_and_aggregation.task1_text.main;

import java.util.List;

import by.epam_training.java_online.module4.composition_and_aggregation.task1_text.entity.Sentence;
import by.epam_training.java_online.module4.composition_and_aggregation.task1_text.entity.Text;
import by.epam_training.java_online.module4.composition_and_aggregation.task1_text.logic.TextLogic;
import by.epam_training.java_online.module4.composition_and_aggregation.task1_text.view.TextView;

public class Main {

	public static void main(String[] args) {
		TextLogic process = TextLogic.getInstance();
		TextView textViewing = TextView.getInstance();

		String title = "		The Cop and the Anthem.\n";
		Sentence testTitle = process.getSentence(title);
		List<Sentence> testContent = process.getTestText();
		Text testText = new Text(testTitle, testContent);

		textViewing.display(testText); // вывод текста с заголовком
		textViewing.displayTitle(testText); // вывод заголовка
		System.out.println("\n");

		process.addContent(testText, process.getTestText()); // дополнение текста
		textViewing.display(testText); // вывод текста с дополнением
	}
}
