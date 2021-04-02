package by.epam_training.java_online.module5.task1_text_file.logic;

import by.epam_training.java_online.module5.task1_text_file.entity.Directory;

public class FileLogic {

	private final static FileLogic instance = new FileLogic();

	private FileLogic() {

	}

	public static FileLogic getInstance() {
		return instance;
	}
	
	public Directory getSuperDirectory(Directory dir) {
		int superDirIndex = dir.getPath().size() - 2;
		return dir.getPath().get(superDirIndex);
	}

	public boolean isDirectoryExists(Directory dir) {

		if (dir.getPath() == null) {
			return false;
		} else {
			boolean exists = true;

			for (Directory d : dir.getPath()) {
				if (d.getName() == null)
					exists = false;
			}

			return exists;
		}
	}

	public void deleteDirectory(Directory dir) {
		
		if (dir.getDirectories().size() > 0) {

			for (Directory d : dir.getDirectories()) {
				deleteDirectory(d);
			}
		}
		
		dir.setName(null);
		dir.setPath(null);
		dir.setDirectories(null);
		dir.setFiles(null);
	}

	public boolean checkName(Directory dir, String nameToCheck) {
		if (dir.getDirectories() == null) {
			return false;
		} else {

			for (Directory d : dir.getDirectories()) {

				if (d.getName().equals(nameToCheck))
					return true;
			}
		}

		return false;
	}
}
