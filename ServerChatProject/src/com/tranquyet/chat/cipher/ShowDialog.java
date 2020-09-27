package com.tranquyet.chat.cipher;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ShowDialog {
	public static int present(JFrame frame , String message, boolean check) {
		if(check) {
			return JOptionPane.showConfirmDialog(frame, message, null, JOptionPane.YES_NO_CANCEL_OPTION);
			
		}
		JOptionPane.showConfirmDialog(frame, message);
		return -1;
	}
}
