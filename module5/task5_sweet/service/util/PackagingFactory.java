package by.epam_training.java_online.module5.task5_sweet.service.util;

import by.epam_training.java_online.module5.task5_sweet.bean.Box;
import by.epam_training.java_online.module5.task5_sweet.bean.Packaging;
import by.epam_training.java_online.module5.task5_sweet.bean.PaperBag;
import by.epam_training.java_online.module5.task5_sweet.bean.PlasticBag;

public class PackagingFactory {

	public static Packaging createPackaging(String packagingData) {

		String[] data = packagingData.split("=");
		String packagingType = data[0];
		String description = data[1];

		if (packagingType.equalsIgnoreCase("Box")) {
			return new Box(description);
		}

		if (packagingType.equalsIgnoreCase("PaperBag")) {
			return new PaperBag(description);
		}

		if (packagingType.equalsIgnoreCase("PlasticBag")) {
			return new PlasticBag(description);
		}

		return null;
	}
}
