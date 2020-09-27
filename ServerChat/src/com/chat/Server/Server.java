package com.chat.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

/*
 * The main function of Server: accept all the connection from the client and resend the message to  them
 * The functions in Server: 
 * 1, List all the user in system
 * 2, Send the message from client to each others
 * 3, Disconnect to the clients
 * 
 * <!> Notice: the best vital method is broadcastToUser() which uses to receive and retrieve the messages to clients
 * 
 * @author: TranQuyet 
 * 
 * 
 */
public class Server {
	private Set<String> userNameSet;
	private Set<UserThread> userThreadSet;
	private int port;
	private Socket socket;
	private ServerSocket server;

	public Server(int port) {
		this.userNameSet = new HashSet<String>();
		this.userThreadSet = new HashSet<UserThread>();
		this.port = port;
		new UserThread(socket, this);
	}

	public Set<String> getUserNameSet() {
		return userNameSet;
	}

	public void setUserNameSet(Set<String> userNameSet) {
		this.userNameSet = userNameSet;
	}

	public Set<UserThread> getUserThreadSet() {
		return userThreadSet;
	}

	public void setUserThreadSet(Set<UserThread> userThreadSet) {
		this.userThreadSet = userThreadSet;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public ServerSocket getServer() {
		return server;
	}

	public void setServer(ServerSocket server) {
		this.server = server;
	}

	public boolean existedUser() {
		return !this.getUserNameSet().isEmpty();
	}

	public void addUserName(String userName) {
		this.userNameSet.add(userName);
	}

	public void removeUser(String userName, UserThread userThread) {
		boolean removeName = this.userNameSet.remove(userName);
		if (removeName) {
			this.userThreadSet.remove(userThread);
			System.out.println("The user: " + userName + " quitted!");
			System.out.println("Current User(s): " + this.getUserNameSet().toString());
		}
	}

	public void broadcastToUser(String message, UserThread currentUser) {
		this.userThreadSet.stream().forEach(p -> {
			if (p != currentUser) {
				p.sendMessage(message);
			} else {
				p.sendMessage("--->{" + message + "}");
			}
		});
	}

	public void operate() {
		try {
			server = new ServerSocket(this.port);
			while (true) {

				this.socket = server.accept();
				UserThread userConnect = new UserThread(socket, this);
				System.out.println("New user connected to Server");
				this.userThreadSet.add(userConnect);
				userConnect.start();
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void getDiscontion() throws IOException {
		this.socket.close();
		this.server.close();
		
	}

}
