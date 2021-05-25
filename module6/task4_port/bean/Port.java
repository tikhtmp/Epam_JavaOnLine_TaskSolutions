package by.epam_training.java_online.module6.task4_port.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import by.epam_training.java_online.module6.task4_port.util.ShipTraffic;
import by.epam_training.java_online.module6.task4_port.view.View;

public class Port implements Comparable<Port>, Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private final Queue<Ship> loadingQueue = new LinkedBlockingDeque<Ship>();
	private final Queue<Ship> landingQueue = new LinkedBlockingDeque<Ship>();
	private final List<Berth> berthes = new ArrayList<Berth>();
	private int warehouseCapacity;
	private int containersInTheStore;

	public Port() {
	}

	public Port(String name, int warehouseCapacity, int inTheStore) {
		this.name = name;
		this.setContainersInTheStore(inTheStore);
		this.warehouseCapacity = warehouseCapacity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public synchronized Queue<Ship> getLoadingQueue() {
		return loadingQueue;
	}

	public synchronized Queue<Ship> getLandingQueue() {
		return landingQueue;
	}

	public List<Berth> getBerthes() {
		return berthes;
	}

	public synchronized int getWarehouseCapacity() {
		return warehouseCapacity;
	}

	public synchronized void setWarehouseCapacity(int warehouseCapacity) {
		this.warehouseCapacity = warehouseCapacity;
	}

	public synchronized int getContainersInTheStore() {
		return containersInTheStore;
	}

	public synchronized void setContainersInTheStore(int containersInTheStore) {
		this.containersInTheStore = containersInTheStore;
	}

	@Override
	public int compareTo(Port other) {
		return name.compareTo(other.name);
	}

	public class Berth extends Thread {
		private String id;
		private int productivity;

		public Berth() {
		}

		public Berth(String id, int productivity) {
			this.id = id;
			this.productivity = productivity;
		}

		@Override
		public void run() {
			int freeSpace;
			int containersInTheStore;
			double percentage;

			while (ShipTraffic.isActive) {
				containersInTheStore = Port.this.getContainersInTheStore();
				freeSpace = Port.this.getWarehouseCapacity() - containersInTheStore;
				percentage = (double) freeSpace / (double) Port.this.getWarehouseCapacity() * 100.0;

				// если склады заполнены более чем на 70%, приоритет получает выгрузка
				if (percentage > 70.0) {
					landCargo(freeSpace, containersInTheStore, percentage);

					// если склады заполнены менее чем на 30%, приоритет получает погрузка
				} else if (percentage < 30.0) {
					loadShip(freeSpace, containersInTheStore, percentage);

					// если склады заполнены на 30-70%, обе очереди имеют одинаковый приоритет
				} else if (Math.random() > 0.5) {
					landCargo(freeSpace, containersInTheStore, percentage);
				} else {
					loadShip(freeSpace, containersInTheStore, percentage);
				}
			}
		}

		private void landCargo(int freeSpace, int containersInTheStore, double percentage) {

			Ship processedShip;
			String report;
			int processingTime; // время выгрузки
			int cargo;
			LinkedBlockingDeque<Ship> queue = (LinkedBlockingDeque<Ship>) landingQueue;
			processedShip = queue.pollFirst();

			if (processedShip != null) {
				cargo = processedShip.getCapacity();

				// если на складах достаточно места - корабль выгружается
				if (freeSpace >= cargo) {

					processingTime = cargo / productivity;
					containersInTheStore = containersInTheStore + cargo;
					Port.this.setContainersInTheStore(containersInTheStore);

					report = String.format( // отчет о выгрузке
							"%s : unloading %s=%s containers, containersInTheStore=%s free space=%s(%.2f%s%s, unloading queue has %s ships ",
							id, processedShip.getName(), processedShip.getCapacity(), containersInTheStore, freeSpace,
							percentage, "%), processing time - ", processingTime, landingQueue.size());

					View.display(report);

					try {
						sleep(processingTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				} else {
					queue.addLast(processedShip); // иначе корабль возвращается в очередь
					View.display(
							id + ": impossible to unload the " + processedShip.getName() + ". No space in the store.");
				}

			}

		}

		private void loadShip(int freeSpace, int containersInTheStore, double percentage) {
			Ship processedShip;
			String report;
			int processingTime; // время погрузки
			int cargo;
			LinkedBlockingDeque<Ship> queue = (LinkedBlockingDeque<Ship>) loadingQueue;

			processedShip = queue.pollFirst();

			if (processedShip != null) {
				cargo = processedShip.getCapacity();

				// если на складах достаточно контейнеров - корабль загружается
				if (containersInTheStore >= cargo) {

					processingTime = cargo / productivity;
					containersInTheStore = containersInTheStore - cargo;
					Port.this.setContainersInTheStore(containersInTheStore);

					report = String.format( // отчет о загрузке
							"%s : loading %s=%s containers, containersInTheStore=%s free space=%s(%.2f%s%s, loading queue has %s ships ",
							id, processedShip.getName(), processedShip.getCapacity(), containersInTheStore, freeSpace,
							percentage, "%), processing time - ", processingTime, loadingQueue.size());

					View.display(report);

					try {
						sleep(processingTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				} else {
					queue.addLast(processedShip); // иначе корабль возвращается в очередь
					View.display(id + ": impossible to load the " + processedShip.getName()
							+ ". There are not enough containers in the warehouse.");
				}

			}
		}
	}
}
