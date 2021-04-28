package by.epam_training.java_online.module6.task1_library.controller;

public class Controller {
	private CommandProvider provider = new CommandProvider();
	
	public String doAction(String request) {
		
		String[] requestData = request.split("\\*");
		String commandName = requestData[0];
		Command currentCommand = provider.getCommand(commandName);
		String response = currentCommand.execute(requestData);
		return response;		
	}
}
