package by.epam_training.java_online.module5.task5_sweet.service.util;

import by.epam_training.java_online.module5.task5_sweet.bean.Candy;
import by.epam_training.java_online.module5.task5_sweet.bean.Chocolate;
import by.epam_training.java_online.module5.task5_sweet.bean.Cookie;
import by.epam_training.java_online.module5.task5_sweet.bean.Sweet;

public class SweetFactory {

	public static Sweet createSweet(String sweetData) {

		String[] data = sweetData.split("=");
		String sweetType = data[0].trim();
		String description = data[1].trim();

		if (sweetType.equalsIgnoreCase("Candy")) {
			return new Candy(description);
		}

		if (sweetType.equalsIgnoreCase("Cookie")) {
			return new Cookie(description);
		}

		if (sweetType.equalsIgnoreCase("Chocolate")) {
			return new Chocolate(description);
		}

		return null;
	}

}
