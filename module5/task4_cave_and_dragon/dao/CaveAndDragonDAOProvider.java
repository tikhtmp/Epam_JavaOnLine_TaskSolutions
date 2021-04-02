package by.epam_training.java_online.module5.task4_cave_and_dragon.dao;

import by.epam_training.java_online.module5.task4_cave_and_dragon.dao.impl.CaveAndDragonDAOImpl;

public class CaveAndDragonDAOProvider {
	
	private static final CaveAndDragonDAOProvider instance = new CaveAndDragonDAOProvider();
	private CaveAndDragonDAOImpl caveAndDragonDAOImpl = new CaveAndDragonDAOImpl();
	
	private CaveAndDragonDAOProvider() {}
	
	public static CaveAndDragonDAOProvider getInstance() {
		return instance;
	}
	
	public CaveAndDragonDAOImpl getCaveAndDragonDAOImpl() {
		return caveAndDragonDAOImpl;
	}

}
