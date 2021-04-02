package by.epam_training.java_online.module5.task5_bouquet.service.util;

import by.epam_training.java_online.module5.task5_bouquet.bean.Carnation;
import by.epam_training.java_online.module5.task5_bouquet.bean.Flower;
import by.epam_training.java_online.module5.task5_bouquet.bean.Rose;
import by.epam_training.java_online.module5.task5_bouquet.bean.Tulip;

public class FlowerFactory {

	public static Flower createFlower(String flowerData) {

		String[] data = flowerData.split("=");
		String flowerType = data[0].trim(); 
		String color = data[1].trim().split("\\,")[0];
		String description = data[1].trim().split("\\,")[1];

		if (flowerType.equalsIgnoreCase("Rose")) {
			return new Rose(color, description);
		}

		if (flowerType.equalsIgnoreCase("Tulip")) {
			return new Tulip(color, description);
		}

		if (flowerType.equalsIgnoreCase("Carnation")) {
			return new Carnation(color, description);
		}

		return null;
	}

}
