package by.epam_training.java_online.module5.task5_sweet.view;

import by.epam_training.java_online.module5.task5_sweet.bean.GiftBag;
import by.epam_training.java_online.module5.task5_sweet.bean.Sweet;

public class SweetView {

	public static void displayGiftBag(GiftBag gift)	{

		System.out.println("----------------------------------------------------");
		System.out.println("The GiftBag is composed with:");

		System.out.println("Sweets: ");

		for (Sweet sweet : gift.getSweets()) {

			String giftInfo = sweet.getClass().getSimpleName() + ": " + sweet.getDescription();
			System.out.printf("%10s%s\n", " ", giftInfo);
		}

		System.out.println("Packaging: ");
		String packagingInfo = gift.getPackaging().getClass().getSimpleName() + ": "
				+ gift.getPackaging().getDescription();
		System.out.printf("%10s%s\n", " ", packagingInfo);

		System.out.println("----------------------------------------------------");
	}
}
