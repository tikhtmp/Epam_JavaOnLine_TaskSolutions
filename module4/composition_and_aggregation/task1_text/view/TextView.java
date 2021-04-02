package by.epam_training.java_online.module4.composition_and_aggregation.task1_text.view;

import by.epam_training.java_online.module4.composition_and_aggregation.task1_text.entity.Sentence;
import by.epam_training.java_online.module4.composition_and_aggregation.task1_text.entity.Text;
import by.epam_training.java_online.module4.composition_and_aggregation.task1_text.entity.Word;

public class TextView {
	
	private static final TextView instance = new TextView();
	
	private TextView(){
	}
	
	public static TextView getInstance() {
		return instance;
	}
	
	
	public void display(Word word) {
		System.out.print(word.getWord());
	}

	public void display(Sentence s) {
		for(Word w : s.getSentence()) {
			System.out.print(w.getWord());			
		}
	}
	
	public void display(Text t) {
		displayTitle(t);
		
		for(Sentence s : t.getContent()) {
			display(s);
		}
		System.out.println("\n");
	}
	
	public void displayTitle(Text t) {
		display(t.getTitle());
	}

}
