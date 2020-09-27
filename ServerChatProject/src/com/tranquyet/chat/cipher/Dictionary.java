package com.tranquyet.chat.cipher;

public class Dictionary {
	public static int in_Valid = -1;
	public static int size = 2000000;
	
	public static String session_open = "session: ";
	public static String session_close = "/session";
	public static String session_live = "<living>";
	public static String session_die = "</living>";
	
	public static String user_name="user_name: ";
	public static String user_name_close = "/user_name";
	
	public static String port_open ="port: ";
	public static String port_close = "/port";
	
	public static String status_open = "status: ";
	public static String status_close = "/status";
	public static String session_reject = "<deny>";
	public static String session_accept_open= "<accept>";
	public static String session_accept_close = "</accept>";
	public static String chat_request_open = "<chat_request>";
	public static String chat_request_close = "</chat_request>";
	public static String ip_open = "IP";
	public static String ip_close = "/IP";
	public static String chat_reject = "</chat_accept>";
	public static String chat_accept = "<chat_accept>";
	public static String chat_message_open = "message";
	public static String chat_message_close = "/message";
	public static String user_open = "user_open";
	public static String user_close = "/user_open";
	public static String file_open = "File";
	public static String file_close = "/File";
	public static String file_noack = "<file_noack>";
	public static String file_ack_open = "<file_ack>";
	public static String file_ack_close = "</file_ack>";
	public static String file_data_begin = "file_data_begin";
	public static String file_data_open = "<file_data>";
	public static String file_data_close = "</file_data>";
	public static String file_data_end = "/file_data_end!";
	public static String chat_close ="Close!";
	
	public static String serverOn = "Running...";
	public static String serverOff = "Stop!";
}
