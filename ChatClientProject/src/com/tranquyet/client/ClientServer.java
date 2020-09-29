package com.tranquyet.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.tranquyet.dictionary.Decryption;
import com.tranquyet.dictionary.Dictionary;

public class ClientServer {

	private String username ;
	private ServerSocket serverPeer;
	private int port;
	private boolean isStop = false;


	public ClientServer(String name) throws Exception {
		username = name;
		port = Client.getPort();
		serverPeer = new ServerSocket(port);
		(new WaitPeerConnect()).start();
	}
	
	public void exit() throws IOException {
		isStop = true;
		serverPeer.close();
	}

	class WaitPeerConnect extends Thread {

		Socket connection;
		ObjectInputStream getRequest;

		@Override
		public void run() {
			super.run();
			while (!isStop) {
				try {
					connection = serverPeer.accept();
					getRequest = new ObjectInputStream(connection.getInputStream());
					String message = (String) getRequest.readObject();
					String name = Decryption.getNameRequestChat(message);
					int res = FriendListGui.request("Account: " + name + " want to connect with you !", true);
					ObjectOutputStream send = new ObjectOutputStream(connection.getOutputStream());
					if (res == 1) {
						send.writeObject(Dictionary.CHAT_DENY);

					} else if (res == 0) {
						send.writeObject(Dictionary.CHAT_ACCEPT);
						new ChatGui(username, name, connection, port);
					}
					send.flush();
				} catch (Exception e) {
					break;
				}
			}
			try {
				serverPeer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
