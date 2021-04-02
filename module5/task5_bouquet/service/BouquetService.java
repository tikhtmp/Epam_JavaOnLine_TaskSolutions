package by.epam_training.java_online.module5.task5_bouquet.service;

import java.util.ArrayList;
import java.util.List;

import by.epam_training.java_online.module5.task5_bouquet.bean.Bouquet;
import by.epam_training.java_online.module5.task5_bouquet.bean.Flower;
import by.epam_training.java_online.module5.task5_bouquet.bean.Packaging;
import by.epam_training.java_online.module5.task5_bouquet.service.util.FlowerFactory;
import by.epam_training.java_online.module5.task5_bouquet.service.util.PackagingFactory;
import by.epam_training.java_online.module5.task5_bouquet.service.util.RequestValidator;

public class BouquetService {

	public static Bouquet createBouquet(String bouquetData) throws BouquetServiceException {

		if (!RequestValidator.requestIsValid(bouquetData)) {
			throw new BouquetServiceException("Wrong request data");
		}

		String[] data = bouquetData.split("\\|");
		Packaging packaging = PackagingFactory.createPackaging(data[0].trim());
		List<Flower> flowers = new ArrayList<Flower>();

		for (int i = 1; i < data.length; i++) {
			flowers.add(FlowerFactory.createFlower(data[i]));
		}

		return new Bouquet(packaging, flowers);
	}
}
