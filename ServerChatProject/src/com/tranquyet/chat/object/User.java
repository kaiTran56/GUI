package com.tranquyet.chat.object;

public class User {
	private String nameUser;
	private String hostUser;
	private int portUser;

	public void setUser(String name, String host, int port) {
		nameUser = name;
		hostUser = host;
		portUser = port;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getHostUser() {
		return hostUser;
	}

	public void setHostUser(String hostUser) {
		this.hostUser = hostUser;
	}

	public int getPortUser() {
		return portUser;
	}

	public void setPortUser(int portUser) {
		this.portUser = portUser;
	}
	
}
