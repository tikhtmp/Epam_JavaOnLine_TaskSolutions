package by.epam_training.java_online.module6.task2_notepad.controller;

import java.util.HashMap;
import java.util.Map;

import by.epam_training.java_online.module6.task2_notepad.controller.impl.FindNotesCommand;
import by.epam_training.java_online.module6.task2_notepad.controller.impl.GetNotesCommand;
import by.epam_training.java_online.module6.task2_notepad.controller.impl.GetTopicsCommand;
import by.epam_training.java_online.module6.task2_notepad.controller.impl.SaveFileCommand;

public class CommandProvider {
	
	private Map<String, Command> commands = new HashMap<String, Command>();
	
	public CommandProvider(){
		commands.put("getNotes", new GetNotesCommand());
		commands.put("saveFile", new SaveFileCommand());
		commands.put("getTopics", new GetTopicsCommand());
		commands.put("findNotes", new FindNotesCommand());
	}
	
	public Command getCommand(String commandName) {
		return commands.get(commandName);
	}

}
