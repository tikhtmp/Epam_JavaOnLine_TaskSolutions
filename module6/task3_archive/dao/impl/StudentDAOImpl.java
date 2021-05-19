package by.epam_training.java_online.module6.task3_archive.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import by.epam_training.java_online.module6.task3_archive.bean.Student;
import by.epam_training.java_online.module6.task3_archive.dao.DAOException;
import by.epam_training.java_online.module6.task3_archive.dao.util.DataConverter;
import by.epam_training.java_online.module6.task3_archive.dao.StudentDAO;

public class StudentDAOImpl implements StudentDAO {

	private static final String PATH = "C:/Archive/students.xml";

	@Override
	public String getStudents() throws DAOException {
		String result;
		List<Student> students = new ArrayList<Student>();
		students = readFile();
		result = DataConverter.convertStudentsIntoString(students);
		return result;
	}

	@Override
	public String getStudent(String id) throws DAOException {
		List<Student> students = new ArrayList<Student>();
		students = readFile();

		for (Student s : students) {

			if (s.getId().equals(id)) {
				return DataConverter.convertStudentIntoString(s);
			}
		}

		return "No student id=" + id;
	}

	private List<Student> readFile() throws DAOException {
		List<Student> students = new ArrayList<Student>();
		XMLInputFactory factory = XMLInputFactory.newInstance();
		InputStream input = null;
		String currentId = null;
		String currentName = null;

		try {

			input = new FileInputStream(new File(PATH));
			XMLEventReader eventReader = factory.createXMLEventReader(input);

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();

					if (startElement.getName().getLocalPart().equals("Student")) {
						event = eventReader.nextEvent();
						continue;
					}

					if (startElement.getName().getLocalPart().equals("Id")) {
						event = eventReader.nextEvent();
						currentId = event.asCharacters().getData();
						continue;
					}

					if (startElement.getName().getLocalPart().equals("Name")) {
						event = eventReader.nextEvent();
						currentName = event.asCharacters().getData();
						continue;
					}
				}

				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();

					if (endElement.getName().getLocalPart().equals("Student")) {
						Student currentStudent = new Student(currentId, currentName);
						students.add(currentStudent);

					}
				}

			}

		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (XMLStreamException e) {
			throw new DAOException(e);
		}

		return students;
	}

	private void saveFile(List<Student> students) throws DAOException {

		XMLOutputFactory output = XMLOutputFactory.newInstance();
		XMLStreamWriter writer;

		try {
			writer = output.createXMLStreamWriter((new FileOutputStream(PATH, false)), "UTF-8");

			writer.writeStartDocument("UTF-8", "1.0");
			writer.writeDTD("\n");
			writer.writeStartElement("Archive");
			writer.writeDTD("\n");

			for (Student s : students) {
				writer.writeDTD("\t");
				writer.writeStartElement("Student");
				writer.writeDTD("\n");

				writer.writeDTD("\t\t");
				writer.writeStartElement("Id");
				writer.writeCharacters(s.getId());
				writer.writeEndElement();
				writer.writeDTD("\n");

				writer.writeDTD("\t\t");
				writer.writeStartElement("Name");
				writer.writeCharacters(s.getName());
				writer.writeEndElement();
				writer.writeDTD("\n");

				writer.writeDTD("\t");
				writer.writeEndElement();
				writer.writeDTD("\n");
			}

			writer.writeEndDocument();

		} catch (FileNotFoundException | XMLStreamException e) {
			throw new DAOException(e);
		}

	}

	@Override
	public String addStudent(String id, String name) throws DAOException {

		Student newStudent = new Student(id, name);
		List<Student> students = new ArrayList<Student>();
		students = readFile();
		students.add(newStudent);
		saveFile(students);

		return "New student was successfully added.";
	}

	@Override
	public String deleteStudent(String id) throws DAOException {
		List<Student> students = new ArrayList<Student>();
		students = readFile();

		for (int i = 0; i < students.size(); i++) {

			if (students.get(i).getId().equals(id)) {
				students.remove(i);
				saveFile(students);
				return "The student " + id + " was successfully deleted.";
			}
		}

		return "No student id=" + id;
	}

}
