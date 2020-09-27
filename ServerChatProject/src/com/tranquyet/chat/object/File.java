package com.tranquyet.chat.object;

import java.io.Serializable;

import com.tranquyet.chat.cipher.Dictionary;

public class File implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String openDictionary = Dictionary.file_open;
	@SuppressWarnings("unused")
	private String closeDictionary = Dictionary.file_close;
	public byte[] file;

	public File() {
		file = new byte[Dictionary.size];
	}

	public File(int size) {
		file = new byte[size];
	}
}
