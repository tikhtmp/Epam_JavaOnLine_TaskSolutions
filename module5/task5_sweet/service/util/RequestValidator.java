package by.epam_training.java_online.module5.task5_sweet.service.util;

public class RequestValidator {

	public static boolean requestIsValid(String request) {

		String[] data = request.split(",");
		String packingType = data[0].split("=")[0];
		packingType = packingType.trim();

		if (packingType.equalsIgnoreCase("paperbag") || packingType.equalsIgnoreCase("box")
				|| packingType.equalsIgnoreCase("plasticbag")) {

		} else {
			return false;
		}

		String sweetType;

		for (int i = 1; i < data.length; i++) {
			sweetType = data[i].split("=")[0];
			sweetType = sweetType.trim();

			if (sweetType.equalsIgnoreCase("candy") || sweetType.equalsIgnoreCase("chocolate")
					|| sweetType.equalsIgnoreCase("cookie")) {

			} else {
				return false;
			}
		}

		return true;
	}

}
