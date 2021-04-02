package by.epam_training.java_online.module4.composition_and_aggregation.task1_text.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import by.epam_training.java_online.module4.composition_and_aggregation.task1_text.entity.Sentence;
import by.epam_training.java_online.module4.composition_and_aggregation.task1_text.entity.Text;
import by.epam_training.java_online.module4.composition_and_aggregation.task1_text.entity.Word;

public class TextLogic {

	private static final TextLogic instance = new TextLogic();

	private TextLogic() {
	}

	public static TextLogic getInstance() {
		return instance;
	}

	public Sentence getSentence(String sentence) {

		String[] wordArray = sentence.split(" ");
		ArrayList<Word> words = new ArrayList<>();

		for (String word : wordArray) {
			words.add(new Word(word + " "));
		}

		return new Sentence(words);
	}

	public List<Sentence> getTestText() {

		Sentence sentence1 = getSentence("	‘That’s my umbrella,’ he said.‘Oh, is it?’ Soapy replied. ");
		Sentence sentence2 = getSentence("\"‘Then why don’t you call a policeman? \"\n");
		Sentence sentence3 = getSentence("I took it, and you say it’s your umbrella. ");
		Sentence sentence4 = getSentence("Go on, then. Call a policeman! Look!");
		Sentence sentence5 = getSentence("There’s one on the corner.’ \n The umbrella man looked unhappy. ");
		Sentence sentence6 = getSentence("‘Well, you know, perhaps I’ve made a mistake.\n");
		Sentence sentence7 = getSentence("I took it from a restaurant this morning.\n");
		
		return new ArrayList<Sentence>(Arrays.asList(sentence1, sentence2, sentence3, sentence4, sentence5, sentence6, sentence7));
	}
	
	public void addContent (Text text, List<Sentence> addingContent){
		
		text.getContent().addAll(addingContent);
	}
}
