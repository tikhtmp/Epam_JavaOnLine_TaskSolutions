package by.epam_training.java_online.module5.task5_bouquet.view;

import java.lang.reflect.Field;

import by.epam_training.java_online.module5.task5_bouquet.bean.Bouquet;
import by.epam_training.java_online.module5.task5_bouquet.bean.Flower;
import by.epam_training.java_online.module5.task5_bouquet.bean.Packaging;

public class ViewBouquet {

	public static void displayBouquet(Bouquet bouquet)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException

	{
		System.out.println("----------------------------------------------------");
		System.out.println("The bouquet is composed with:");

		System.out.println("Flowers: ");

		for (Flower flower : bouquet.getFlowers()) {

			Class<? extends Flower> flowerClass = flower.getClass();
			Field descriptionField = flowerClass.getDeclaredField("description");

			descriptionField.setAccessible(true);
			String description = (String) descriptionField.get(flower);
			descriptionField.setAccessible(false);

			String flowerInfo = flower.getClass().getSimpleName() + ": " + flower.getColor() + "," + description;
			System.out.printf("%10s%s\n", " ", flowerInfo);
		}

		System.out.println("Packaging: ");

		Packaging packaging = bouquet.getPackaging();
		Class<? extends Packaging> packagingClass = packaging.getClass();
		Field descriptionField = packagingClass.getDeclaredField("description");
		
		descriptionField.setAccessible(true);
		String description = (String) descriptionField.get(packaging);
		descriptionField.setAccessible(false);
		
		String packagingInfo = packaging.getClass().getSimpleName() + ": " + packaging.getColor() + "," + description;
		System.out.printf("%10s%s\n", " ", packagingInfo);

		System.out.println("----------------------------------------------------");
	}
}
