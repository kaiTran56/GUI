package com.tranquyet.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;

import com.tranquyet.data.User;
import com.tranquyet.dictionary.Decode;
import com.tranquyet.dictionary.Dictionary;
import com.tranquyet.dictionary.Encode;

public class Client {

	public static ArrayList<User> userList;
	private ClientServer server;
	private InetAddress IPserver;
	private int portServer = 8080;
	private String nameUser;

	private static int portClient = 10000;
	private int timeOut = 10000;
	private Socket socketClient;
	private ObjectInputStream serverInputStream;
	private ObjectOutputStream serverOutputStream;

	private boolean isStop = false;

	public Client(String arg, int arg1, String name, String dataUser) throws Exception {
		IPserver = InetAddress.getByName(arg);
		nameUser = name;
		portClient = arg1;
		userList = Decode.getAllUser(dataUser);
		new Thread(new Runnable() {
			@Override
			public void run() {
				updateFriend();
			}
		}).start();
		server = new ClientServer(nameUser);
		(new Request()).start();
	}

	public static int getPort() {
		return portClient;
	}

	public void request() throws Exception {
		socketClient = new Socket();
		SocketAddress addressServer = new InetSocketAddress(IPserver, portServer);
		socketClient.connect(addressServer);
		String msg = Encode.sendRequest(nameUser);
		serverOutputStream = new ObjectOutputStream(socketClient.getOutputStream());
		serverOutputStream.writeObject(msg);
		serverOutputStream.flush();
		serverInputStream = new ObjectInputStream(socketClient.getInputStream());
		msg = (String) serverInputStream.readObject();
		serverInputStream.close();
		userList = Decode.getAllUser(msg);
		new Thread(new Runnable() {

			@Override
			public void run() {
				updateFriend();
			}
		}).start();
	}

	public class Request extends Thread {
		@Override
		public void run() {
			super.run();
			while (!isStop) {
				try {
					Thread.sleep(timeOut);
					request();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void intialNewChat(String IP, int host, String guest) throws Exception {
		final Socket connclient = new Socket(InetAddress.getByName(IP), host);
		ObjectOutputStream sendrequestChat = new ObjectOutputStream(connclient.getOutputStream());
		sendrequestChat.writeObject(Encode.sendRequestChat(nameUser));
		sendrequestChat.flush();
		ObjectInputStream receivedChat = new ObjectInputStream(connclient.getInputStream());
		String msg = (String) receivedChat.readObject();
		if (msg.equals(Dictionary.CHAT_DENY)) {
			FriendTable.request("Your friend denied connect with you!", false);
			connclient.close();
			return;
		}
		new ChatGui(nameUser, guest, connclient, portClient);

	}

	public void exit() throws IOException, ClassNotFoundException {
		isStop = true;
		socketClient = new Socket();
		SocketAddress addressServer = new InetSocketAddress(IPserver, portServer);
		socketClient.connect(addressServer);
		String message = Encode.exit(nameUser);
		serverOutputStream = new ObjectOutputStream(socketClient.getOutputStream());
		serverOutputStream.writeObject(message);
		serverOutputStream.flush();
		serverOutputStream.close();
		server.exit();
	}

	public void updateFriend() {
		int n = userList.size();
		FriendTable.resetList();
		for (int i = 0; i < n; i++) {
			if (!userList.get(i).getName().equals(nameUser)) {
				FriendTable.updateFriendFriendTable(userList.get(i).getName());
			}
		}
	}
}