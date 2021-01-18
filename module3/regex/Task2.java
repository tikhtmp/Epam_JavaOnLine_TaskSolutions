/*
Условие: Дана строка, содержащая следующий текст (xml-документ):
<notes>
	<note id = "1">
		<to>Вася</to>
		<from>Света</from>
		<heading>Напоминание</heading>
		<body>Позвони мне завтра!</body>
	</note>
	<note id = "2">
		<to>Петя</to>
		<from>Маша</from>
		<heading>Важное напоминание</heading>
		<body/>
	</note>
</notes>
 Напишите анализатор, позволяющий ПОСЛЕДОВАТЕЛЬНО возвращать содержимое узлов xml-документа и его тип (открывающий тег, 
 закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами XML для решения данной задачи нельзя.
 */
package by.epam_training.java_online.module3.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {

	public static void main(String[] args) {
		String testXml = "<notes>\n\t<note id = \"1\">\n\t\t<to>Вася</to>\n\t\t<from>Света</from>\n\t\t<heading>Напоминание</heading>\n"
				+ "\t\t<body>Позвони мне завтра!</body>\n\t</note>\n\t<note id = \"2\">\n\t\t<to>Петя</to>\n\t\t<from>Маша</from>\n"
				+ "\t\t<heading>Важное напоминание</heading>\n\t\t<body/>\n\t</note>\n</notes>";
		System.out.println(testXml);
		System.out.println("************************************************\n");

		StringBuilder text = new StringBuilder(testXml);
		Pattern tag = Pattern.compile("<[a-zA-z].+?>"); // шаблон тега
		Pattern tagContent = Pattern.compile(" .*?>"); // шаблон содержимого тега
		Matcher findTag = tag.matcher(testXml);

		while (findTag.find()) {
			StringBuilder tagHead = new StringBuilder((text.substring(findTag.start(), findTag.end()))); // открывающий
																											// тег
			if (tagHead.charAt(tagHead.length() - 2) != '/') { // если тег не пустой

				StringBuilder tagTail = new StringBuilder(tagHead); // закрывающий тег
				StringBuilder content = new StringBuilder(); // содержимое тега
				Matcher findTagContent = tagContent.matcher(tagHead.toString());

				if (findTagContent.find()) { // если в теге есть содержимое
					content.append(tagHead.substring(findTagContent.start(), findTagContent.end() - 1));
					tagTail.delete(findTagContent.start(), findTagContent.end() - 1);
				}

				tagTail.insert(1, "/");
				System.out.println("tag head: " + tagHead);
				System.out.println("tag tail: " + tagTail);
				System.out.println("tag content: " + content);

				int start = findTag.end();
				int end = testXml.indexOf(tagTail.toString(), start);
				String blocContent = testXml.substring(start, end); // содержимое узла
				System.out.println("content: " + blocContent);

			} else { // если тег без тела
				System.out.println("tag:" + testXml.substring(findTag.start(), findTag.end()));
				System.out.println("type: empty tag");
			}

			System.out.println("----------------------------------------");
		}
	}
}
