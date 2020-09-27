package com.tranquyet.chat.cipher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EncryptionData {
	private static Pattern checkMessage = Pattern.compile("[^<>]*[<>]");

	public static String getCreateUser(String name, String port) {
		return Dictionary.session_open + Dictionary.user_name + " " + name + Dictionary.user_name_close
				+ Dictionary.port_open + " " + port + Dictionary.port_close + Dictionary.session_close;
	}

	public static String sendRequest(String name) {
		return Dictionary.session_live + Dictionary.user_name + " " + name + Dictionary.user_name_close
				+ Dictionary.status_open + Dictionary.serverOn + Dictionary.status_close + Dictionary.session_die;
	}

	public static String setMessage(String message) {
		Matcher findMess = checkMessage.matcher(message);
		String result = "";
		while (findMess.find()) {
			String subMessage = findMess.group(0);
			System.out.println("subMessage: " + subMessage);
			int start = subMessage.length();
			char messageChar = message.charAt(subMessage.length() - 1);
			System.out.println("messageChar: " + messageChar);
			result += subMessage;
			subMessage = message.substring(start, message.length());
			message = subMessage;
			findMess = checkMessage.matcher(message);
		}
		result += message;

		return Dictionary.chat_message_open + result + Dictionary.chat_message_close;
	}

	public static String sendRequestChat(String name) {
		return Dictionary.chat_request_open + Dictionary.user_name + name + Dictionary.user_name_close
				+ Dictionary.chat_request_close;
	}

	public static String sendFile(String name) {
		return Dictionary.file_open + " " + name + " " + Dictionary.file_close;
	}

	public static String exit(String name) {
		return Dictionary.session_live + Dictionary.user_name + " " + name + " " + Dictionary.user_name_close
				+ Dictionary.status_open + Dictionary.serverOff + Dictionary.status_close + Dictionary.session_die;
	}
}
