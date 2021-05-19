package by.epam_training.java_online.module6.task3_archive.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import by.epam_training.java_online.module6.task3_archive.controller.Controller;

public class Server extends Thread {

	private static Socket clientSocket;
	private static ServerSocket serverSocket;
	private static BufferedReader serverIn;
	private static BufferedWriter serverOut;
	private static Controller controller = new Controller();

	@Override
	public void run() {

		String incomingData = null;
		String outgoingData;

		try {

			try {
				serverSocket = new ServerSocket(8888);
				System.out.println("Сервер запущен!");

				while (true) {
					clientSocket = serverSocket.accept();

					try {
						serverIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
						serverOut = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
						incomingData = serverIn.readLine();

						if (incomingData.equals("finishApp")) {
							break;
						} else {
							outgoingData = controller.doAction(incomingData);
							serverOut.write(outgoingData + "\n");
						}

						serverOut.flush();
					}

					finally {
						clientSocket.close();
						serverIn.close();
						serverOut.close();
					}
				}

			} finally {
				System.out.println("Сервер закрыт!");
				serverSocket.close();
			}

		} catch (IOException e) {
			System.err.println(e);
		}

	}
}