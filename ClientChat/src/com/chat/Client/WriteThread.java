package com.chat.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class WriteThread extends Thread {
	private PrintWriter writer;
	private Socket socket;
	private Client client;

	public WriteThread(Socket socket, Client client) {
		super();
		this.socket = socket;
		this.client = client;

		try {
			this.writer = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nEnter the Name: ");
		String userName;
		try {
			userName = br.readLine();
			client.setUserName(userName);
			writer.println(userName);
			String text;
			do {
				text = br.readLine();
				writer.println(text);
			} while (!text.equals("bye"));

			this.socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
