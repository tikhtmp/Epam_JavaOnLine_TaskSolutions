package by.epam_training.java_online.module6.task1_library.service.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IdGenerator {

	public static <T> int generateId(List<T> list, int prefferedID) {

		int newId = 1;
		int currentId = 0;
		boolean isAvailable = true;
		List<Integer> idList = new ArrayList<Integer>();

		for (T item : list) {
			currentId = Integer.parseInt(item.toString().split(",")[0].split("=")[1]);
			idList.add(currentId);

			if (currentId == prefferedID) {
				isAvailable = false;
			}
		}

		if (isAvailable) {
			newId = prefferedID;
		} else {

			Collections.sort(idList);

			for (Integer id : idList) {

				if (newId != id)
					break;

				newId++;
			}
		}

		return newId;
	}
}
