package by.epam_training.java_online.module5.task1_text_file.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import by.epam_training.java_online.module5.task1_text_file.view.FileView;

public class TextFile extends File<TextFile> {

	private List<Directory> path = new LinkedList<Directory>();
	private String content;

	public TextFile() {
	}

	public TextFile(Directory dir, String name) {
		super(name);
		path = new LinkedList<Directory>(dir.getPath());
	}

	public String getName() {
		return super.getName();
	}

	public void setName(String name) {
		super.setName(name);
	}

	public List<Directory> getPath() {
		return path;
	}

	public void setPath(List<Directory> path) {
		this.path = path;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void displayFilePath() {
		int last = getPath().size() - 1;
		Directory dir = getPath().get(last);
		FileView.getInstance().displayPath(dir);
	}

	public void addContent(String addingContent) {
		setContent(getContent().concat(addingContent));
	}

	@Override
	public void rename(String newName) {
		this.setName(newName);
	}

	@Override
	public void displayContent() {
		System.out.println(getContent());
	}

	@Override
	public void displayInfo() {

		if (getName() != null) {
			System.out.print("File name: " + getName());
			System.out.print(", location: ");
			displayFilePath();
			System.out.println();
		} else {
			System.out.println("The file doesn't exist");
		}
	}

	@Override
	public TextFile create(Directory dir, String name) {
		TextFile newTextFile = new TextFile(dir, name);
		ArrayList<File<?>> newFiles = (ArrayList<File<?>>) dir.getFiles();
		newFiles.add(newTextFile);
		return newTextFile;
	}

	@Override
	public void delete() {
		int last = getPath().size() - 1;
		Directory dir = getPath().get(last);
		dir.getFiles().remove(this);
		setName(null);
		setPath(null);
		setContent(null);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
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

		TextFile other = (TextFile) obj;

		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;

		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;

		return true;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "[name=" + getName() + ", path=" + path + ", content=" + content + "]";
	}
}
