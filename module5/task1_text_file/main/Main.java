/*
Модуль 5. Задача 1.
Условие:
Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
вывести на консоль содержимое, дополнить, удалить. 
*/

package by.epam_training.java_online.module5.task1_text_file.main;

import by.epam_training.java_online.module5.task1_text_file.entity.Directory;
import by.epam_training.java_online.module5.task1_text_file.entity.TextFile;
import by.epam_training.java_online.module5.task1_text_file.view.FileView;

public class Main {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
  		// Создание тестового дерева директорий:
		//
		// Root_
		//      |_d1_ 
    	//      |    |_dir1_
		//      |    |      |_dir15
		//      |    |
		//      |    |_dir2_
		//      |    |      |_dir12
		//      |    |      |_dir13_
		//      |    |      |       |_ dir9
		//      |    |      |       |_dir10
		//      |    |      |       |_dir11
		// 		|    |      |
		//      |    |      |_dir14_
		//      |    |              |_dir7
		//      |    |              |_dir8
		//      |    |
		//      |    |_dir3  
		//      |
		//      |_d2_
		//           |_dir4
		//           |_dir5
		//           |_dir6

		Directory root = new Directory("Root");
		Directory d1 = new Directory("d1");
		Directory d2 = new Directory("d2");
		Directory dir1 = new Directory("dir1");
		Directory dir2 = new Directory("dir2");
		Directory dir3 = new Directory("dir3");
		Directory dir4 = new Directory("dir4");
		Directory dir5 = new Directory("dir5");
		Directory dir6 = new Directory("dir6");
		Directory dir7 = new Directory("dir7");
		Directory dir8 = new Directory("dir8");
		Directory dir9 = new Directory("dir9");
		Directory dir10 = new Directory("dir10");
		Directory dir11 = new Directory("dir11");
		Directory dir12 = new Directory("dir12");
		Directory dir13 = new Directory("dir13");
		Directory dir14 = new Directory("dir14");
		Directory dir15 = new Directory("dir15");

		root.addSubDirectory(d1);
		root.addSubDirectory(d2);
		d1.addSubDirectory(dir1);
		d1.addSubDirectory(dir2);
		d1.addSubDirectory(dir3);
		dir1.addSubDirectory(dir15);
		dir2.addSubDirectory(dir12);
		dir2.addSubDirectory(dir13);
		dir2.addSubDirectory(dir14);
		dir13.addSubDirectory(dir9);
		dir13.addSubDirectory(dir10);
		dir13.addSubDirectory(dir11);
		dir14.addSubDirectory(dir7);
		dir14.addSubDirectory(dir8);
		d2.addSubDirectory(dir4);
		d2.addSubDirectory(dir5);
		d2.addSubDirectory(dir6);

		FileView fileViewing = FileView.getInstance();

		fileViewing.displayLine();
		System.out.println("Displaing content directory dir2");
		fileViewing.displayContent(dir2);
		fileViewing.displayLine();

		System.out.println("Adding a new directory into dir2");
		dir2.addSubDirectory(new Directory("a new directory"));
		fileViewing.displayContent(dir2);
		fileViewing.displayLine();

		System.out.println("Renaming the directory dir12");
		dir12.rename("newName");
		fileViewing.displayContent(dir2);
		fileViewing.displayLine();

		System.out.println("Deleting the directory dir13");
		dir13.delete();
		fileViewing.displayContent(dir2);
		fileViewing.displayLine();

		System.out.println("Creating files in the directory dir2");
		TextFile tx1 = new TextFile(dir2, "A text file tx1");
		dir2.addFile(tx1);
		TextFile tx2 = tx1.create(dir2, "A_text_file_tx2");
		fileViewing.displayContent(dir2);
		fileViewing.displayLine();

		System.out.println("Renaming file in the directory dir2");
		tx1.rename("newName of tx1");
		fileViewing.displayContent(dir2);
		fileViewing.displayLine();

		System.out.println("Deleting file tx1");
		tx1.delete();
		fileViewing.displayContent(dir2);
		fileViewing.displayLine();

		System.out.println("Adding new conteng into file tx2");
		tx2.setContent("Content of tx2");
		System.out.print("Old content: ");
		tx2.displayContent();
		System.out.print("New content: ");
		tx2.addContent(" + Added content of tx2");
		tx2.displayContent();
		fileViewing.displayLine();
	}
}
