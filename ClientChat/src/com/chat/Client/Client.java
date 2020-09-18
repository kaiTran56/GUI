package com.chat.Client;

import java.io.IOException;
import java.net.Socket;

public class Client {
	private String userName;
	private int port;

	public Client(int port) {
		super();
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void execute() {
		try {
			Socket socket = new Socket("localhost", port);

			System.out.println("Connected to ChatServer: ");
			new WriteThread(socket, this).start();
			new ReadThread(socket, this).start();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
