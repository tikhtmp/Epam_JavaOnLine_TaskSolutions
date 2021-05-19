package by.epam_training.java_online.module6.task3_archive.controller;

public class Controller {

	private CommandProvider provider = new CommandProvider();

	public String doAction(String request) {

		String commandName = request.split("\\:")[0];
		String params = request.split("\\:")[1];
		String response;

		Command currentCommand = provider.getCommand(commandName);
		response = currentCommand.execute(params);

		return response;
	}

}
