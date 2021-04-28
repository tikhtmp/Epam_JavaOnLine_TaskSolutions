/*
Модуль 6. Задача 1.
Условие:
Создать консольное приложение "Учет книг в домашней библиотеке".
Общие требования к заданию:
- Система учитывает книги как в электронном, так и в бумажном варианте.
- Существующие роли: пользователь и администратор.
- Пользователь может просматривать книги в каталоге книг, осуществлять поиск книг в каталоге.
- Администратор может модифицировать каталог.
- *При добавлении описания книги в каталог оповещение о ней рассылается на e-mail всем пользователям.
- **При просмотре каталога желательно реализовать постраничный просмотр.
- ***Пользователь может предложить добавить книгу в библиотеку, переслав ее на администратору на e-mail.
- Каталог книг хранится в текстовом файле.
- Данные аутентификации пользователей хранятся в текстовом файле. Пароль не хранится в открытом виде. 
*/
package by.epam_training.java_online.module6.task1_library.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import by.epam_training.java_online.module6.task1_library.view.LibraryView;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, NumberFormatException,
			NoSuchAlgorithmException, InterruptedException {

		LibraryView view = new LibraryView();
		view.startApp();
	}
}
