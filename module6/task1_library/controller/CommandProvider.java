package by.epam_training.java_online.module6.task1_library.controller;


import java.util.HashMap;
import java.util.Map;

import by.epam_training.java_online.module6.task1_library.controller.impl.AddBookCommand;
import by.epam_training.java_online.module6.task1_library.controller.impl.AddReaderCommand;
import by.epam_training.java_online.module6.task1_library.controller.impl.GetBookCommand;
import by.epam_training.java_online.module6.task1_library.controller.impl.LendBookCommand;
import by.epam_training.java_online.module6.task1_library.controller.impl.LoginationCommand;
import by.epam_training.java_online.module6.task1_library.controller.impl.ProposeBookCommand;
import by.epam_training.java_online.module6.task1_library.controller.impl.RemoveReaderCommand;
import by.epam_training.java_online.module6.task1_library.controller.impl.RemovingBookCommand;
import by.epam_training.java_online.module6.task1_library.controller.impl.SearchBookCommand;
import by.epam_training.java_online.module6.task1_library.controller.impl.StartApplicationCommand;
import by.epam_training.java_online.module6.task1_library.controller.impl.TakeLendedBookBackCommand;
import by.epam_training.java_online.module6.task1_library.controller.impl.ViewBookCommand;

public class CommandProvider {

	private Map<String, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put("startApplication", new StartApplicationCommand());
		commands.put("logination", new LoginationCommand());
		commands.put("viewBooks", new ViewBookCommand());
		commands.put("searchBooks", new SearchBookCommand());
		commands.put("proposeBook", new ProposeBookCommand());
		commands.put("addBook", new AddBookCommand());
		commands.put("removeBook", new RemovingBookCommand());
		commands.put("getBook", new GetBookCommand());
		commands.put("addUser", new AddReaderCommand());
		commands.put("removeUser", new RemoveReaderCommand());
		commands.put("lendBook", new LendBookCommand());
		commands.put("takeBookBack", new TakeLendedBookBackCommand());
	}

	public Command getCommand(String commandName) {
		Command command;
		command = commands.get(commandName);
		return command;
	}

}
