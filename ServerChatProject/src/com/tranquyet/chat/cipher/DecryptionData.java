package com.tranquyet.chat.cipher;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tranquyet.chat.object.User;

public class DecryptionData {
	private static Pattern createUser = Pattern
			.compile(Dictionary.session_open + Dictionary.user_name + ".*" + Dictionary.user_name_close
					+ Dictionary.port_open + ".*" + Dictionary.port_close + Dictionary.session_close);;
	private static Pattern users = Pattern.compile(Dictionary.session_accept_open + " " + Dictionary.user_open
			+ Dictionary.user_name + ".+" + Dictionary.user_name_close + Dictionary.ip_open + ".+" + Dictionary.ip_close
			+ Dictionary.port_open + "[0-9]+" + Dictionary.port_close + Dictionary.user_close + ")*"
			+ Dictionary.session_accept_close);
	private static Pattern request = Pattern.compile(Dictionary.session_live + Dictionary.user_name + "[^<>]+"
			+ Dictionary.user_name_close + Dictionary.status_open + " " + Dictionary.serverOn + Dictionary.serverOff
			+ " " + Dictionary.status_close + Dictionary.session_die);
	private static Pattern message = Pattern
			.compile(Dictionary.chat_message_open + ".*" + Dictionary.chat_message_close);
	private static Pattern checkFile = Pattern.compile(Dictionary.file_open + ".*" + Dictionary.file_close);

	private static Pattern comment = Pattern.compile(Dictionary.file_ack_open + ".*" + Dictionary.file_ack_close);

	public static List<String> getUser(String message) {
		List<String> user = new ArrayList<String>();
		if (createUser.matcher(message).matches()) {
			Pattern findUser = Pattern.compile(Dictionary.user_name + ".*" + Dictionary.user_name_close);
			Pattern findPort = Pattern.compile(Dictionary.port_open + " [0-9]* " + Dictionary.port_close);
			Matcher find = findUser.matcher(message);
			if (find.find()) {
				String name = find.group(0);
				user.add(name.substring(11, name.length() - 11));
				find = findPort.matcher(message);
				if (find.find()) {
					String port = find.group(0);
					user.add(port.substring(6, port.length() - 7));
				} else {
					return null;
				}

			} else {
				return null;
			}
		} else {
			return null;
		}
		return user;
	}

	public static List<User> getAllUser(String message) {
		List<User> user = new ArrayList<User>();
		Pattern findUser = Pattern.compile(Dictionary.user_open + Dictionary.user_name + " [^<>]* "
				+ Dictionary.user_name_close + Dictionary.ip_open + " [^<>]* " + Dictionary.ip_close
				+ Dictionary.port_open + " [0-9]* " + Dictionary.port_close + Dictionary.user_close);
		Pattern findName = Pattern.compile(Dictionary.user_name + ".*" + Dictionary.user_name_close);
		Pattern findPort = Pattern.compile(Dictionary.port_open + "[0-9]*" + Dictionary.port_close);
		Pattern findIp = Pattern.compile(Dictionary.ip_open + ".*" + Dictionary.ip_close);
		if (users.matcher(message).matches()) {
			Matcher find = findUser.matcher(message);
			while (find.find()) {
				String person = find.group(0);
				String data;
				User userTemp = new User();
				Matcher findInfo = findName.matcher(person);
				if (findInfo.find()) {
					data = findInfo.group(0);
					userTemp.setNameUser(data.substring(11, data.length() - 11));
				}
				findInfo = findIp.matcher(person);
				if (findInfo.find()) {
					data = findInfo.group(0);
					userTemp.setHostUser(findInfo.group(0).substring(5, data.length() - 5));
				}
				findInfo = findPort.matcher(person);
				if (findInfo.find()) {
					data = findInfo.group(0);
					userTemp.setPortUser(Integer.parseInt(data.substring(6, data.length() - 7)));
				}
				user.add(userTemp);

			}
		} else {
			return null;
		}
		return user;
	}

	public static String getMessage(String mess) {
		if (message.matcher(mess).matches()) {
			int start = Dictionary.chat_message_open.length();
			int end = mess.length() - Dictionary.chat_message_close.length();
			System.out.println(start + " <> " + end);
			String message = mess.substring(start, end);
			return message;
		}
		return null;
	}

	public static String getNameRequest(String message) {
		Pattern checkRequest = Pattern.compile(Dictionary.chat_request_open + Dictionary.user_name + " [^<>]* "
				+ Dictionary.user_name_close + Dictionary.chat_request_close);
		if (checkRequest.matcher(message).matches()) {

			String name = message.substring((Dictionary.chat_request_open + Dictionary.user_name).length(),
					message.length() - (Dictionary.user_name + Dictionary.chat_request_close).length());
			return name;
		}
		return null;
	}

	public static boolean checkFile(String name) {
		if (checkFile.matcher(name).matches()) {
			return true;
		}
		return false;
	}

	public static boolean checkComment(String message) {
		if (comment.matcher(message).matches()) {
			return true;
		}
		return false;
	}

	public static List<User> updateUserOnline(List<User> userList, String message) {
		Pattern alive = Pattern.compile(Dictionary.status_open + Dictionary.serverOn + Dictionary.status_close);
		Pattern removeUser = Pattern.compile(Dictionary.user_name + " [^<>]* " + Dictionary.user_name_close);
		if (request.matcher(message).matches()) {
			Matcher checkState = alive.matcher(message);
			if (checkState.find()) {
				return userList;
			}
			checkState = removeUser.matcher(message);
			if (checkState.find()) {
				String findUser = checkState.group(0);
				int size = userList.size();
				String name = findUser.substring(11, findUser.length() - 11);
				for (int i = 0; i < size; i++) {
					if (name.equals(userList.get(i).getNameUser())) {
						userList.remove(i);
						break;
					}
				}
			}
		}
		return userList;
	}
}
