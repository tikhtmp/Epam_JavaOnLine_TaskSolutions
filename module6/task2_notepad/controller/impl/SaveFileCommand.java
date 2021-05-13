package by.epam_training.java_online.module6.task2_notepad.controller.impl;

import by.epam_training.java_online.module6.task2_notepad.controller.Command;
import by.epam_training.java_online.module6.task2_notepad.service.ServiceException;
import by.epam_training.java_online.module6.task2_notepad.service.ServiceProvider;
import by.epam_training.java_online.module6.task2_notepad.service.impl.ServiceImpl;

public class SaveFileCommand implements Command {

	@Override
	public String execute(String params) {

		ServiceProvider provider = ServiceProvider.getInstance();
		ServiceImpl serviceImpl = provider.getServiceImpl();
		try {
			serviceImpl.saveNotes(params);
		} catch (ServiceException e) {
			//логирование
			return "Error saving the file!";
		}
		return "File saved";
	}
}
