/*
Условие: Строка Х состоит из нескольких предложений, каждое из которых кончается точкой, 
восклицательным или вопросительным знаком. Определить количество предложений в строке Х. 
 */
package by.epam_training.java_online.module3.string_as_object;

public class Task10 {

	public static void main(String[] args) {
		String testString = "‘That’s my umbrella,’ he said.‘Oh, is it?’ Soapy replied." + 
	                        " ‘Then why don’t you call a policeman? I took it, and you" +
				            " say it’s your umbrella. Go on, then. Call a policeman! Look!" +
	                        " There’s one on the corner.’The umbrella man looked unhappy. " +
				            "‘Well, you know, perhaps I’ve made a mistake. I took it from" + 
				            " a restaurant this morning.";
		System.out.println(testString);
		int count = 0;

		for (int i = 0; i < testString.length(); i++) {

			if (testString.charAt(i) == '.' || testString.charAt(i) == '!' || testString.charAt(i) == '?') {
				count++;
			}
		}

		System.out.println("Number of sentences = " + count);

	}

}
