/*
Модуль 6. Задание 4. Порт.
Условие: 
Корабли заходят в порт для разгрузки/загрузки контейнеров. Число контейнеров,
находящихся в текущий момент в порту и на корабле, должно быть неотрицательным
и превышающим заданную грузоподъемность судна и вместимость порта. В порту 
работает несколько причалов. У одного причала может стоять один корабль. 
Корабль может загружаться у причала или разгружаться.

Вопросы по условию задачи (возможно, я что-то неправильно понял):
	1. Вместо "Число контейнеров, находящихся в текущий момент в порту и на корабле, 
ДОЛЖНО БЫТЬ НЕОТРИЦАТЕЛЬНЫМ И ПРЕВЫШАЮЩИМ заданную грузоподъемность судна и вместимость порта"
следует, видимо, читать "Число контейнеров, находящихся в текущий момент в порту и на корабле,
НЕ ДОЛЖНО БЫТЬ ОТРИЦАТЕЛЬНЫМ ИЛИ ПРЕВЫШАЮЩИМ заданную грузоподъемность судна и вместимость порта".
	2. Неясен момент перехода условия "корабли" (мн. число) в "корабль" или "судно" (ед. число)
в порту, учитывая, что причалов несколько.
	3. Не понял зачем нужно отталкиваться от количества контейнеров. Проще кажется контролировать
текущее свободное место на портовых складах и запрещать выгрузку, если они заполнены, или, если они
пусты, запрещать погрузку кораблей. Аналогично на корабль может быть загружено (выгружено с него)
не более его емкости.

Описание решения.
	Для простоты будем предполагать, что все корабли загружаются или выгружаются полностью и уходят из
порта.
	В порт заходят загруженные и пустые корабли (данные по ним генерируются рандомно), они ставятся
в две соответствующие очереди. Очереди используются двусторонние, чтобы иметь возможность отказа от
погрузки или выгрузки корабля и возврата его обратно в очередь.
	Корабли в очереди получают приоритет на доступ к причалам в зависимости от ситуации на портовых складах
(если там мало контейнеров, то приоритет получают загруженные корабли, и наоборот). Условие смены 
приоритета: до 30% загрузки складов - приоритет у загруженных кораблей. Свыше 70% загрузки складов - 
приоритет у пустых кораблей. От 30 до 70% - одинаковый приоритет.
	Скорость погрузки корабля считается равной скорости выгрузки. Разные причалы имеют разную производительность.
	Чтобы приложение не работало бесконечно, количество генерируемых объектов "Корабль" ограничено 100.
 */
package by.epam_training.java_online.module6.task4_port.main;

import by.epam_training.java_online.module6.task4_port.bean.Port;
import by.epam_training.java_online.module6.task4_port.util.ShipTraffic;

public class Main {
	public static boolean isActive = true;

	public static void main(String[] args) throws InterruptedException {

		Port port = new Port("Amsterdam", 100_000, 100_000);
		Port.Berth berth1 = port.new Berth("Berth N1", 5);
		Port.Berth berth2 = port.new Berth("Berth N2", 6);
		Port.Berth berth3 = port.new Berth("Berth N3", 7);
		port.getBerthes().add(berth1);
		port.getBerthes().add(berth2);
		port.getBerthes().add(berth3);

		ShipTraffic traffic = new ShipTraffic(port);

		traffic.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(t + "throws exception: " + e);
			}
		});

		traffic.start();

		Thread.sleep(10000); // чтобы накопить корабли в очередях

		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

		berth1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(t + "throws exception: " + e);
			}
		});
		
		berth1.start();
		
		berth2.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(t + "throws exception: " + e);
			}
		});
		
		berth2.start();
		
		berth3.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(t + "throws exception: " + e);
			}
		});
		
		berth3.start();

	}
}
