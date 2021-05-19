/*
Модуль 6. Задание 3. Архив.
Условие: создайте клиент-серверное приложение "Архив".

Общие требования к заданию:
 - В архиве хранятся Дела (например, студентов). Архив находится на сервере.
 - Клиент, в зависимости от прав, может запросить дело на просмотр, внести в
   него изменения или создать новое дело.

Требование к коду лабораторной работы:
 - Для реализации сетевого соединения используйте сокеты.
 - Формат хранения данных на сервере - xml-файлы.
 */
package by.epam_training.java_online.module6.task3_archive.main;

import by.epam_training.java_online.module6.task3_archive.socket.Server;
import by.epam_training.java_online.module6.task3_archive.view.View;

public class Main {

	public static void main(String[] args) {

		Server server = new Server();
		server.start();
		View.startApp();
		
		System.out.println("End app...");
	}
}
