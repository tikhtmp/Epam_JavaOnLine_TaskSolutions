package by.epam_training.java_online.module5.task5_bouquet.service.util;

import by.epam_training.java_online.module5.task5_bouquet.bean.Basket;
import by.epam_training.java_online.module5.task5_bouquet.bean.Box;
import by.epam_training.java_online.module5.task5_bouquet.bean.Packaging;
import by.epam_training.java_online.module5.task5_bouquet.bean.Paper;

public class PackagingFactory {

	public static Packaging createPackaging(String packagingData) {

		String[] data = packagingData.split("=");
		String color = data[1].split(",")[0];
		String description = data[1].split(",")[1];

		if (data[0].equalsIgnoreCase("paper")) {
			return new Paper(color, description);
		}

		if (data[0].equalsIgnoreCase("box")) {
			return new Box(color, description);
		}

		if (data[0].equalsIgnoreCase("basket")) {
			return new Basket(color, description);
		}

		return null;
	}
}
