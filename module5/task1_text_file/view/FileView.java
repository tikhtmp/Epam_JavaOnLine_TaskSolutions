package by.epam_training.java_online.module5.task1_text_file.view;

import by.epam_training.java_online.module5.task1_text_file.entity.Directory;
import by.epam_training.java_online.module5.task1_text_file.entity.File;
import by.epam_training.java_online.module5.task1_text_file.logic.FileLogic;

public class FileView {

	private static final FileView instance = new FileView();

	private FileView() {

	}

	public static FileView getInstance() {
		return instance;
	}

	/* вывод в консоль полного пути директории */
	public void displayPath(Directory dir) {

		if (FileLogic.getInstance().isDirectoryExists(dir)) {

			for (Directory d : dir.getPath()) {
				System.out.print(d.getName() + "\\");
			}

		} else {
			System.out.println("You tried to display info of an unexisting directory.\n");
		}
	}

	/* вывод в консоль содержимого директории */
	public void displayContent(Directory dir) {

		if (FileLogic.getInstance().isDirectoryExists(dir)) {
			displayPath(dir);
			System.out.println(" contains:");

			/* вывод списка вложенных директорий */
			System.out.format("%3s%12s", "", "directories:\n");

			if (dir.getDirectories().size() > 0) {

				for (Directory d : dir.getDirectories()) {
					System.out.format("%15s%s\n", "", d.getName());
				}

			} else {
				System.out.format("%15s%s\n", "", "no nested directories");
			}

			/* вывод списка файлов */
			System.out.format("%3s%12s", "", "files:\n");

			if (dir.getFiles().size() > 0) {

				for (File<?> f : dir.getFiles()) {
					System.out.format("%-15s%s\n", "", f.getName());
				}

			} else {
				System.out.format("%15s%s\n", "", "no files");
			}
			System.out.println();

		} else

			System.out.println("You tried to display an unexisting directory.");
	}
	
	public void displayLine() {
		System.out.println("--------------------------------------------------------------------");
	}
	
}
