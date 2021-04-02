package by.epam_training.java_online.module5.task4_cave_and_dragon.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.epam_training.java_online.module5.task4_cave_and_dragon.bean.Treasure;
import by.epam_training.java_online.module5.task4_cave_and_dragon.dao.CaveAndDragonDAO;
import by.epam_training.java_online.module5.task4_cave_and_dragon.dao.CaveAndDragonDAOException;
import by.epam_training.java_online.module5.task4_cave_and_dragon.dao.util.TreasureFactory;
import by.epam_training.java_online.module5.task4_cave_and_dragon.dao.util.TreasureMaker;

public class CaveAndDragonDAOImpl implements CaveAndDragonDAO {
	private static final String LOCATION = "C:/Cave and Dragon/";
	private static final File TREASURE_SOURCE = new File(LOCATION + "treasures.txt");

	public CaveAndDragonDAOImpl() {
		new File(LOCATION).mkdir();
	}

	@Override
	public boolean createTreasureFile() throws CaveAndDragonDAOException {

		if (TREASURE_SOURCE.exists()) {
			return false;
		} else {

			try (FileWriter writer = new FileWriter(TREASURE_SOURCE, true);) {

				List<Treasure> tresures = TreasureMaker.makeTreasure();
				StringBuffer tresuresBufferData = new StringBuffer();

				for (Treasure t : tresures) {
					tresuresBufferData.append(t.getTreasureInfo() + "\n");
				}

				String tresuresData = tresuresBufferData.toString();

				writer.write(tresuresData);

			} catch (IOException e) {
				throw new CaveAndDragonDAOException(e);
			}

			return true;
		}
	}

	@Override
	public List<Treasure> readTreasureFile() throws CaveAndDragonDAOException {

		TreasureFactory factory = new TreasureFactory();
		int value = 0;
		int inventaryNumber = 0;
		String line;
		List<Treasure> result = new ArrayList<Treasure>();

		try (BufferedReader reader = new BufferedReader(new FileReader(TREASURE_SOURCE));) {

			while ((line = reader.readLine()) != null) {

				String[] lines = line.split("\\|");

				inventaryNumber = Integer.parseInt(lines[0].trim());
				String treasureType = lines[1].trim();
				value = Integer.parseInt(lines[2].trim());
				String description = lines[3].trim();

				result.add(factory.createTreasure(treasureType, value, description, inventaryNumber));
			}

			if (result.isEmpty())
				throw new CaveAndDragonDAOException("The file is empty!");

		} catch (FileNotFoundException e) {
			throw new CaveAndDragonDAOException(e);
		} catch (IOException e) {
			throw new CaveAndDragonDAOException(e);
		}

		return result;
	}

}
