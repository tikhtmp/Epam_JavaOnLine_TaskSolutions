package by.epam_training.java_online.module6.task3_archive.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import by.epam_training.java_online.module6.task3_archive.bean.Client;
import by.epam_training.java_online.module6.task3_archive.dao.ClientDAO;
import by.epam_training.java_online.module6.task3_archive.dao.DAOException;
import by.epam_training.java_online.module6.task3_archive.dao.util.DataConverter;

public class ClientDAOImpl implements ClientDAO {

	private static final String CLIENTS_PATH = "C:/Archive/clients.xml";

	private List<Client> readFile() throws DAOException {

		List<Client> clients = new ArrayList<Client>();
		XMLInputFactory factory = XMLInputFactory.newInstance();
		InputStream input = null;
		String currentLogin = null;
		String currentPassword = null;
		boolean currentIsAdmin = false;

		try {

			input = new FileInputStream(new File(CLIENTS_PATH));
			XMLEventReader eventReader = factory.createXMLEventReader(input);

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();

					if (startElement.getName().getLocalPart().equals("Client")) {
						event = eventReader.nextEvent();
						continue;
					}

					if (startElement.getName().getLocalPart().equals("Login")) {
						event = eventReader.nextEvent();
						currentLogin = event.asCharacters().getData();
						continue;
					}

					if (startElement.getName().getLocalPart().equals("Password")) {
						event = eventReader.nextEvent();
						currentPassword = event.asCharacters().getData();
						continue;
					}

					if (startElement.getName().getLocalPart().equals("isAdmin")) {
						event = eventReader.nextEvent();
						currentIsAdmin = Boolean.parseBoolean(event.asCharacters().getData());
						continue;
					}

				}

				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();

					if (endElement.getName().getLocalPart().equals("Client")) {
						Client currentClient = new Client(currentLogin, currentPassword, currentIsAdmin);
						clients.add(currentClient);
					}
				}
			}

		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (XMLStreamException e) {
			throw new DAOException(e);
		}

		return clients;

	}

	@Override
	public String getClients() throws DAOException {

		List<Client> clients = new ArrayList<Client>();
		String result;
		clients = readFile();
		result = DataConverter.convertClientsIntoString(clients);

		return result;
	}

	@Override
	public String logIn(String login, String password) throws DAOException {

		List<Client> clients = new ArrayList<Client>();
		clients = readFile();
		String encryptedPassword = getEncryptedPassword(password);

		for (Client c : clients) {

			if (c.getLogin().equals(login) && c.getPassword().equals(encryptedPassword)) {
				return Boolean.toString(c.isAdmin());
			}
		}

		return "No such client!";
	}

	private static String getEncryptedPassword(String password) throws DAOException {

		MessageDigest digester;

		try {
			digester = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			throw new DAOException(e);
		}

		byte[] bytePassword = password.getBytes();
		byte[] digestPassword = digester.digest(bytePassword);
		String encryptedPassword = DatatypeConverter.printHexBinary(digestPassword);
		return encryptedPassword;
	}

}
