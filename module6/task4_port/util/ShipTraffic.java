package by.epam_training.java_online.module6.task4_port.util;

import java.util.Queue;
import by.epam_training.java_online.module6.task4_port.bean.Port;
import by.epam_training.java_online.module6.task4_port.bean.Ship;
import by.epam_training.java_online.module6.task4_port.view.View;

public class ShipTraffic extends Thread {
	private static Queue<Ship> loadingQueue;
	private static Queue<Ship> landingQueue;
	public static boolean isActive;

	public ShipTraffic(Port port) {
		loadingQueue = port.getLoadingQueue();
		landingQueue = port.getLandingQueue();
		isActive = true;
	}

	@Override
	public void run() {

		int period;
		int capacity;
		int cargo;
		int count = 1;
		String name;
		Ship newShip;

		while (isActive) {
			try {
				name = "Ship_" + count++;
				period = generateNumber(800, 1200); // каждые 0.8-1.2 сек приходит новый корабль
				capacity = generateNumber(10000, 20000); // грузоподъемность - от 10 до 20 тыс. контейнеров

				if (Math.random() > 0.5) {
					cargo = capacity;
					newShip = new Ship(name, capacity, cargo);
					landingQueue.add(newShip);
				} else {
					cargo = 0;
					newShip = new Ship(name, capacity, cargo);
					loadingQueue.add(newShip);
				}

				View.display(newShip);
				sleep(period);

				if (count > 100) { // условие окончания работы программы
					isActive = false;
					System.out.println("\nEnd app...");
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private int generateNumber(int min, int max) {
		return min + (int) (Math.random() * (max - min));
	}

}
