package by.epam_training.java_online.module5.task1_text_file.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import by.epam_training.java_online.module5.task1_text_file.logic.FileLogic;
import by.epam_training.java_online.module5.task1_text_file.view.FileView;

public class Directory extends File<Directory> {
	private List<Directory> path = new LinkedList<Directory>();
	private List<Directory> directories = new ArrayList<Directory>();
	private List<File<?>> files = new ArrayList<File<?>>();

	public Directory() {
	}

	public Directory(String name) {
		super(name);
		path.add(this);
	}

	public void setPath(List<Directory> path) {
		this.path = path;
	}

	public List<Directory> getPath() {
		return path;
	}

	public void setDirectories(List<Directory> directories) {
		this.directories = directories;
	}

	public List<Directory> getDirectories() {
		return directories;
	}

	public void setFiles(List<File<?>> files) {
		this.files = files;
	}

	public List<File<?>> getFiles() {
		return files;
	}

	public void addSubDirectory(Directory insert) {
		directories.add(insert);
		LinkedList<Directory> newPath = new LinkedList<Directory>(path);
		newPath.add(insert);
		insert.setPath(newPath);
	}

	public void addFile(File<?> insertedFile) {
		files.add(insertedFile);
	}

	@Override
	public Directory create(Directory dir, String name) {
		Directory newDirectory = new Directory(name);
		directories.add(newDirectory);
		LinkedList<Directory> newPath = new LinkedList<Directory>(path);
		newPath.add(newDirectory);
		newDirectory.setPath(newPath);
		return newDirectory;
	}

	@Override
	public void rename(String newName) {
		setName(newName);
	}

	@Override
	public void delete() {
		FileLogic process = FileLogic.getInstance();
		Directory superDir = process.getSuperDirectory(this);
		superDir.getDirectories().remove(this);
		process.deleteDirectory(this);
	}

	@Override
	public void displayContent() {
		FileView.getInstance().displayContent(this);
	}

	@Override
	public void displayInfo() {
		FileView.getInstance().displayPath(this);
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		final int prime = 31;
		result = result * prime + ((path == null) ? null : path.hashCode());
		result = result * prime + ((directories == null) ? null : directories.hashCode());
		result = result * prime + ((files == null) ? null : files.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;

		Directory other = (Directory) obj;

		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;

		if (directories == null) {
			if (other.directories != null)
				return false;
		} else if (!directories.equals(other.directories))
			return false;

		if (files == null) {
			if (other.files != null)
				return false;
		} else if (!files.equals(other.files))
			return false;

		return true;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " [name=" + getName() + ", path=" + path + ", directories=" + directories + ", files=" + files
				+ "]";
	}


}
