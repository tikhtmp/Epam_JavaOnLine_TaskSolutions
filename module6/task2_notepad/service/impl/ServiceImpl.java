package by.epam_training.java_online.module6.task2_notepad.service.impl;

import by.epam_training.java_online.module6.task2_notepad.bean.Criteria;
import by.epam_training.java_online.module6.task2_notepad.bean.Topic;
import by.epam_training.java_online.module6.task2_notepad.dao.DAOException;
import by.epam_training.java_online.module6.task2_notepad.dao.DAOProvider;
import by.epam_training.java_online.module6.task2_notepad.dao.impl.DAOImpl;
import by.epam_training.java_online.module6.task2_notepad.service.CriteriaFactory;
import by.epam_training.java_online.module6.task2_notepad.service.Service;
import by.epam_training.java_online.module6.task2_notepad.service.ServiceException;

public class ServiceImpl implements Service {

	private DAOImpl daoImpl = DAOProvider.getInstance().getDAOImpl();

	@Override
	public String getNotes() throws ServiceException {
		String notes;

		try {
			notes = daoImpl.getNotes();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return notes;
	}

	@Override
	public void saveNotes(String notes) throws ServiceException {

		try {
			daoImpl.saveNotes(notes);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public String findNotes(String params) throws ServiceException {
		CriteriaFactory criteriaFactory = new CriteriaFactory();
		Criteria criteria = criteriaFactory.makeCriteria(params);

		try {
			return daoImpl.findNotes(criteria);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	public String getTopics() {

		StringBuilder topics = new StringBuilder();
		int i = 0;

		for (Topic t : Topic.values()) {
			String line = String.format("%2s - %s\n", ++i, t.name());
			topics.append(line);
		}
		return topics.toString();
	}

}
