package by.epam_training.java_online.module4.simple_classes.task4_train.entity;

import java.util.Comparator;

public class DepartureComparator implements Comparator<Train> {
	@Override
	public int compare(Train train1, Train train2) {
		return train1.getDepartureTime().get(11) * 60 + train1.getDepartureTime().get(12)
				- train2.getDepartureTime().get(11) * 60 + train2.getDepartureTime().get(12);
	}
}