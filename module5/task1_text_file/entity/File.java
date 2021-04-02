/*
Модуль 5. Задача 1.
Условие:
Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
вывести на консоль содержимое, дополнить, удалить. 
 */

package by.epam_training.java_online.module5.task1_text_file.entity;

public abstract class File<T> implements Manipulateable<T>, Viewable {
	
	private String name;
	
	public File() {
	}
	
	public File(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + ((name == null) ? 0 : name.hashCode());		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		 File<?> other = (File<?>) obj;
		 
		if (name == null) {
			if (other.name != null)
				return false;
		} else	if (!this.name.equals(other.name))
			return false;
	
		return true;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " [name=" + name + "]";
	}
}
