package by.epam_training.java_online.module4.simple_classes.task4_train.entity;

import java.util.Comparator;

public class DestinationComparator implements Comparator<Train> {
	@Override
	public int compare(Train train1, Train train2) {
		return train1.getDestination().compareTo(train2.getDestination());
	}
}