package by.epam_training.java_online.module6.task3_archive.socket;

import java.io.*;
import java.net.Socket;

public class AppClient {

	private static Socket clientSocket;
	private static BufferedReader clientIn;
	private static BufferedWriter clientOut;

	public String sendRequest(String request) {
		String response = "Error server connection!";

		try {
			try {
				clientSocket = new Socket("localhost", 8888);

				clientIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				clientOut = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
				clientOut.write(request + "\n");
				clientOut.flush();
				response = clientIn.readLine();

			} finally {
				clientSocket.close();
				clientIn.close();
				clientOut.close();
			}
		} catch (IOException e) {
			System.err.println(e);
		}

		return response;
	}
}