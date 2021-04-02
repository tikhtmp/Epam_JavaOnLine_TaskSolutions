package by.epam_training.java_online.module5.task4_cave_and_dragon.dao;

import java.util.List;

import by.epam_training.java_online.module5.task4_cave_and_dragon.bean.Treasure;

public interface CaveAndDragonDAO {
	
	public boolean createTreasureFile() throws CaveAndDragonDAOException;
	public List<Treasure> readTreasureFile() throws CaveAndDragonDAOException;

}
