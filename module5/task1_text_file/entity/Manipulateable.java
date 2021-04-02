package by.epam_training.java_online.module5.task1_text_file.entity;

import by.epam_training.java_online.module5.task1_text_file.entity.Directory;

interface Manipulateable<T> {

	T create(Directory dir, String name);
	
	void delete ();

	void rename(String newName);

}
