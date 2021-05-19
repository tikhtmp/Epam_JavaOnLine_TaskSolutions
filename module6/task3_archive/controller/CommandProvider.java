package by.epam_training.java_online.module6.task3_archive.controller;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
	
	private static Map<String, Command> commands = new HashMap<String, Command>();
	
	public CommandProvider() {
		commands.put("getStudents", new GetStudentsCommand());
		commands.put("getClients", new GetClientsCommand());
		commands.put("getStudent", new GetStudentCommand());
		commands.put("login", new LoginCommand());
		commands.put("addStudent", new AddStudentCommand());	
		commands.put("deleteStudent", new DeleteStudentCommand());
	}
	
	public Command getCommand(String commandName) {
		Command command;
		command = commands.get(commandName);
		return command;		
	}

}
