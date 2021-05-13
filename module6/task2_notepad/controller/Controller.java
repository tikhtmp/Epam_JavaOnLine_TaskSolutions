package by.epam_training.java_online.module6.task2_notepad.controller;

public class Controller {

	private static CommandProvider provider = new CommandProvider();

	public String doAction(String request) {

		String commandType = request.split("\\*")[0].trim();
		String params = request.split("\\*")[1];
		Command command = provider.getCommand(commandType);
		String response = command.execute(params);

		return response;
	}

}
