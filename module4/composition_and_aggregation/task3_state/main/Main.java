/*
Модуль 4. Агрегация и композиция.
Задача 3.
Условие: Создать объет класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль
столицу, количество областей, площадь, областные центры.
*/

package by.epam_training.java_online.module4.composition_and_aggregation.task3_state.main;

import java.util.ArrayList;
import java.util.Arrays;

import by.epam_training.java_online.module4.composition_and_aggregation.task3_state.entity.City;
import by.epam_training.java_online.module4.composition_and_aggregation.task3_state.entity.Region;
import by.epam_training.java_online.module4.composition_and_aggregation.task3_state.entity.State;
import by.epam_training.java_online.module4.composition_and_aggregation.task3_state.view.StateView;

public class Main {

	public static void main(String args[]) {
		City minsk = new City("Minsk");
		Region minskaya = new Region("Minskaya", minsk);
		Region bresckaya = new Region("Bresckaya", new City("Brest"));
		Region grodnenskaja = new Region("Grodnenskaja", new City("Grodna"));
		Region vicebskaja = new Region("Vicebskaja", new City("Vicebsk"));
		Region mahileuskaja = new Region("Mahileuskaja", new City("Mahileu"));
		Region gomelskaja = new Region("Gomelskaja", new City("Gomel"));
		
		State belarus = new State("Belarus", minsk, 207600,
				new ArrayList<Region>(Arrays.asList(minskaya, bresckaya, grodnenskaja, vicebskaja, mahileuskaja, gomelskaja)));
		
		StateView.showCapital(belarus); // показать столицу
		StateView.showNumberOfRegions(belarus); // количество областей
		StateView.showArea(belarus); // площадь
		StateView.showRegionMainCities(belarus); // областные центры
	}
}
