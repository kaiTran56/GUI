package com.tranquyet.chat.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.tranquyet.chat.cipher.DecryptionData;
import com.tranquyet.chat.cipher.Dictionary;
import com.tranquyet.chat.object.User;

public class Server {
	private List<User> userList;
	private ServerSocket server;
	private Socket socket;
	private ObjectOutputStream writer;
	private ObjectInputStream reader;
	private Intermediary inter = new Intermediary();

	public Server(int port) throws IOException {

		server = new ServerSocket(port);

		this.userList = new ArrayList<User>();
		(new ThreadConnection()).start();

	}

	public void stop() {
		inter.setStop(true);
		try {

			server.close();
			System.out.println("Goodbye!");

		} catch (IOException e) {
			System.out.println("Goodbye!");
		}

	}

	private String sendSession() {
		String message = Dictionary.session_accept_open;
		int size = userList.size();
		for (int i = 0; i < size; i++) {
			User user = this.userList.get(i);
			message += Dictionary.user_open;
			message += Dictionary.user_name;
			message += user.getNameUser();
			message += Dictionary.user_name_close;
			message += Dictionary.ip_open;
			message += user.getHostUser();
			message += Dictionary.ip_close;
			message += Dictionary.port_open;
			message += user.getPortUser();
			message += Dictionary.port_close;
			message += Dictionary.user_close;
		}
		message += Dictionary.session_accept_close;
		return message;
	}

	private void saveUser(String name, String host, int port) {
		User userTemp = new User();
		if (this.userList.size() == 0) {
			userList = new ArrayList<User>();
		}
		userTemp.setUser(name, host, port);
		userList.add(userTemp);
	}

	private boolean checkExist(String name) {
		this.userList.stream().filter(p -> {
			if (p.getNameUser().equals(name)) {
				return true;
			} else {
				return false;
			}
		});
		return false;
	}

	public boolean connectToServer() throws IOException, ClassNotFoundException {

		socket = server.accept();
		reader = new ObjectInputStream(socket.getInputStream());
		String message = (String) reader.readObject();
		List<String> messageList = DecryptionData.getUser(message);
		ServerGUI.updateMessage(message);
		if (messageList != null) {
			if (!checkExist(messageList.get(0))) {
				saveUser(messageList.get(0), socket.getInetAddress().toString(), Integer.parseInt(messageList.get(1)));
				ServerGUI.updateMessage(messageList.get(0));
				ServerGUI.increaseQuantity();
			} else {
				return false;
			}
		} else {
			int size = userList.size();
			DecryptionData.updateUserOnline(userList, message);
			if (size != userList.size()) {
				inter.setExit(true);
				ServerGUI.decreaseQuantity();
			}
		}
		return true;

	}

	public class ThreadConnection extends Thread {

		@Override
		public void run() {
			try {
				while (!inter.isStop()) {
					if (connectToServer()) {

						try {
							writer = new ObjectOutputStream(socket.getOutputStream());
							writer.writeObject(sendSession());
							writer.flush();
							writer.close();
						} catch (IOException e) {
							System.out.println("Turn off!");
						}

					} else {

						writer = new ObjectOutputStream(socket.getOutputStream());
						writer.writeObject(Dictionary.session_reject);
						writer.flush();
						writer.close();
					}

				}
			} catch (Exception e) {
				System.out.println("Turn off!");
			}
		}
	}

}
