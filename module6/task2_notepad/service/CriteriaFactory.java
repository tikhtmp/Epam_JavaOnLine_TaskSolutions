package by.epam_training.java_online.module6.task2_notepad.service;

import by.epam_training.java_online.module6.task2_notepad.bean.Criteria;

public class CriteriaFactory {

	public Criteria makeCriteria(String params) {
		Criteria criteria = new Criteria();
		String[] data = params.split("\\|");
		String topics;
		String startDate;
		String endDate;
		String email;
		String content;
		String comporator;

		topics = data[0].split("=")[1];
		topics = topics.replaceAll(",", "|");
		startDate = data[1].split("=")[1];
		endDate = data[2].split("=")[1];
		email = data[3].split("=")[1];
		content = data[4].split("=")[1];
		comporator = data[5].split("=")[1];

		criteria.addCriteria(topics, "topic");
		criteria.addCriteria(startDate, "startDate");
		criteria.addCriteria(endDate, "endDate");
		criteria.addCriteria(email, "email");
		criteria.addCriteria(content, "content");
		criteria.addCriteria(comporator, "comporator");

		return criteria;
	}

}
