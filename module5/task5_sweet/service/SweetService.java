package by.epam_training.java_online.module5.task5_sweet.service;

import java.util.ArrayList;
import java.util.List;

import by.epam_training.java_online.module5.task5_sweet.bean.GiftBag;
import by.epam_training.java_online.module5.task5_sweet.bean.Packaging;
import by.epam_training.java_online.module5.task5_sweet.bean.Sweet;
import by.epam_training.java_online.module5.task5_sweet.service.util.PackagingFactory;
import by.epam_training.java_online.module5.task5_sweet.service.util.RequestValidator;
import by.epam_training.java_online.module5.task5_sweet.service.util.SweetFactory;

public class SweetService {

	public static GiftBag createGiftBag(String giftData) throws SweetServiceException {
		
		if (!RequestValidator.requestIsValid(giftData)) {
			throw new SweetServiceException("Wrong request data");
		}

		String[] data = giftData.split(",");
		String packagingData = data[0];
		Packaging packaging = PackagingFactory.createPackaging(packagingData);
		
		List<Sweet> sweets = new ArrayList<Sweet>();

		for (int i = 1; i < data.length; i++) {
			sweets.add(SweetFactory.createSweet(data[i]));
		}

		return new GiftBag(packaging, sweets);
	}

}
