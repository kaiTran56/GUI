package com.chat.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadThread extends Thread {
	private BufferedReader reader;
	private Socket socket;
	@SuppressWarnings("unused")
	private Client client;

	public ReadThread(Socket socket, Client client) {
		super();
		this.socket = socket;
		this.client = client;

		try {
			this.reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				String message = reader.readLine();
				System.out.println(message);
			} catch (IOException e) {
				System.out.println("[Server]: Good bye, "+this.client.getUserName()+" and see you!");
				break;
			}
		}
	}
}
