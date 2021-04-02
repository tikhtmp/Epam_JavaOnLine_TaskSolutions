package by.epam_training.java_online.module5.task5_bouquet.service.util;

public class RequestValidator {

	public static boolean requestIsValid(String request) {

		String[] data = request.split("\\|");
		String packingType = data[0].split("=")[0];
		packingType = packingType.trim();

		if (packingType.equalsIgnoreCase("paper") || packingType.equalsIgnoreCase("box")
				|| packingType.equalsIgnoreCase("basket")) {

		} else {
			return false;
		}

		String flowerType;

		for (int i = 1; i < data.length; i++) {
			flowerType = data[i].split("=")[0];
			flowerType = flowerType.trim();

			if (flowerType.equalsIgnoreCase("rose") || flowerType.equalsIgnoreCase("tulip")
					|| flowerType.equalsIgnoreCase("carnation")) {

			} else {
				return false;
			}
		}

		return true;
	}

}
