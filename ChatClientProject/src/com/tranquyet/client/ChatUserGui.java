package com.tranquyet.client;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import com.tranquyet.data.DataFile;
import com.tranquyet.dictionary.Decryption;
import com.tranquyet.dictionary.Dictionary;
import com.tranquyet.dictionary.Encryption;

public class ChatUserGui {

	private static String URL = System.getProperty("user.dir");
	private static String TEMP = "/temp/";

	private ChatRoom chat;
	private Socket socketChat;
	private String nameUser = "";
	private String nameGuest = "";
	private String nameFile = "";
	private JFrame frameChatGui;
	private JTextField textName;
	private JPanel panelMessage;
	private JTextPane txtDisplayChat;
	private Label textState, lblReceive;
	private JButton btnDisConnect, btnSend, btnChoose;
	public boolean isStop = false, isSendFile = false, isReceiveFile = false;
	private JProgressBar progressSendFile;
	private JTextField txtPath;
	private int portServer = 0;
	private JTextField txtMessage;
	private JScrollPane scrollPane;

	public ChatUserGui(String user, String guest, Socket socket, int port) {
		nameUser = user;
		nameGuest = guest;
		socketChat = socket;
		this.portServer = port;
		EventQueue.invokeLater(() -> {

			try {
				ChatUserGui window = new ChatUserGui(nameUser, nameGuest, socketChat, portServer, 0);
				window.frameChatGui.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {

			try {
				ChatUserGui window = new ChatUserGui();
				window.frameChatGui.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
	}

	public ChatUserGui() throws BadLocationException, IOException {
		initialize();
	}

	public ChatUserGui(String user, String guest, Socket socket, int port, int a) throws Exception {
		nameUser = user;
		nameGuest = guest;
		socketChat = socket;
		this.portServer = port;
		initialize();
		chat = new ChatRoom(socketChat, nameUser, nameGuest);
		chat.start();
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void updateChatReceive(String message) throws BadLocationException, IOException {
		appendToPane(txtDisplayChat,
				"<div class='left' style='width: 40%; background-color: #f1f0f0;'>" + message + "</div>");
	}

	public void updateChatSend(String message) throws BadLocationException, IOException {
		appendToPane(txtDisplayChat,
				"<table class='bang' style='color: white; clear:both; width: 100%;'>" + "<tr align='right'>"
						+ "<td style='width: 59%; '></td>" + "<td style='width: 40%; background-color: #0084ff;'>"
						+ message + "</td> </tr>" + "</table>");
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void updateChatNotify(String message) throws BadLocationException, IOException {
		appendToPane(txtDisplayChat,
				"<table class='bang' style='color: white; clear:both; width: 100%;'>" + "<tr align='right'>"
						+ "<td style='width: 59%; '></td>" + "<td style='width: 40%; background-color: #f1c40f;'>"
						+ message + "</td> </tr>" + "</table>");
	}

	public void updateSendSymbol(String message) throws BadLocationException, IOException {
		appendToPane(txtDisplayChat, "<table style='width: 100%;'>" + "<tr align='right'>"
				+ "<td style='width: 59%;'></td>" + "<td style='width: 40%;'>" + message + "</td> </tr>" + "</table>");
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	private void initialize() throws BadLocationException, IOException {
		File fileTemp = new File(URL + "/temp");
		if (!fileTemp.exists()) {
			fileTemp.mkdirs();
		}
		frameChatGui = new JFrame();
		frameChatGui.setResizable(false);
		frameChatGui.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frameChatGui.getContentPane().setBackground(Color.DARK_GRAY);
		frameChatGui.setTitle("Private Chat");
		frameChatGui.setBounds(200, 200, 505, 500);
		frameChatGui.getContentPane().setLayout(null);

		JLabel lblClientIP = new JLabel("Friend:");
		lblClientIP.setForeground(Color.GREEN);
		lblClientIP.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblClientIP.setBounds(21, 6, 50, 40);

		frameChatGui.getContentPane().add(lblClientIP);

		textName = new JTextField(nameUser);
		textName.setForeground(SystemColor.textHighlight);
		textName.setFont(new Font("MS PGothic", Font.BOLD | Font.ITALIC, 16));
		textName.setEditable(false);
		textName.setBounds(70, 11, 77, 28);
		frameChatGui.getContentPane().add(textName);
		textName.setText(nameGuest);
		textName.setColumns(10);

		panelMessage = new JPanel();
		panelMessage.setBounds(6, 277, 473, 168);
		panelMessage.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Message"));
		frameChatGui.getContentPane().add(panelMessage);
		panelMessage.setLayout(null);

		txtMessage = new JTextField("");
		txtMessage.setBounds(10, 21, 250, 62);
		panelMessage.add(txtMessage);
		txtMessage.setColumns(10);

		btnSend = new JButton("Send");
		btnSend.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnSend.setBounds(270, 21, 50, 25);
		btnSend.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelMessage.add(btnSend);

		btnChoose = new JButton("Open");
		btnChoose.setBounds(270, 89, 50, 25);
		panelMessage.add(btnChoose);
		btnChoose.setFont(new Font("Segoe UI", Font.BOLD, 13));

		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int result = fileChooser.showOpenDialog(frameChatGui);
				if (result == JFileChooser.APPROVE_OPTION) {
					isSendFile = true;
					String path_send = (fileChooser.getSelectedFile().getAbsolutePath());

					nameFile = fileChooser.getSelectedFile().getName();
					txtPath.setText(path_send);
				}
			}
		});
		btnChoose.setBorder(BorderFactory.createEmptyBorder());

		txtPath = new JTextField("");
		txtPath.setBounds(41, 89, 219, 22);
		panelMessage.add(txtPath);
		txtPath.setEditable(false);
		txtPath.setColumns(10);

		Label label = new Label("Path");
		label.setBounds(10, 89, 27, 22);
		panelMessage.add(label);
		label.setFont(new Font("Segoe UI", Font.PLAIN, 12));

		JButton btnSendLike = new JButton("Like");
		btnSendLike.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSendLike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = "<img src='" + ChatUserGui.class.getResource("/image/like.png") + "'></img>";
				try {
					chat.sendMessage(Encryption.sendMessage(message));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					updateSendSymbol(message);
				} catch (BadLocationException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSendLike.setBackground(new Color(240, 240, 240));
		btnSendLike.setBounds(270, 58, 50, 25);

		btnSendLike.setBorder(new EmptyBorder(0, 0, 0, 0));

		panelMessage.add(btnSendLike);

		progressSendFile = new JProgressBar(0, 100);
		progressSendFile.setBounds(10, 125, 250, 14);
		panelMessage.add(progressSendFile);
		progressSendFile.setStringPainted(true);

		lblReceive = new Label("download ...");
		lblReceive.setBounds(270, 125, 64, 14);
		panelMessage.add(lblReceive);
		lblReceive.setVisible(false);
		progressSendFile.setVisible(false);

		btnSend.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (isSendFile)
					try {
						chat.sendMessage(Encryption.sendFile(nameFile));
					} catch (Exception e) {
						e.printStackTrace();
					}

				if (isStop) {
					try {
						updateChatSend(txtMessage.getText().toString());
					} catch (BadLocationException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					txtMessage.setText(""); // reset text Send
					return;
				}
				String message = txtMessage.getText();
				if (message.equals(""))
					return;
				try {
					chat.sendMessage(Encryption.sendMessage(message));
					updateChatSend(message);
					txtMessage.setText("");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		txtMessage.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {

			}

			@Override
			public void keyReleased(KeyEvent arg0) {

			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					String message = txtMessage.getText();
					if (isStop) {
						try {
							updateChatSend(txtMessage.getText().toString());
						} catch (BadLocationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						txtMessage.setText("");
						return;
					}
					if (message.equals("")) {
						txtMessage.setText("");
						txtMessage.setCaretPosition(0);
						return;
					}
					try {
						chat.sendMessage(Encryption.sendMessage(message));
						updateChatSend(message);
						txtMessage.setText("");
						txtMessage.setCaretPosition(0);
					} catch (Exception e) {
						txtMessage.setText("");
						txtMessage.setCaretPosition(0);
					}
				}
			}
		});

		btnDisConnect = new JButton("Out");
		btnDisConnect.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnDisConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = Dictionary.show(frameChatGui, "Are you sure to close chat with account: " + nameGuest,
						true);
				if (result == 0) {
					try {
						isStop = true;
						frameChatGui.dispose();
						chat.sendMessage(Dictionary.CHAT_CLOSE);
						chat.stopChat();
						System.gc();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});

		btnDisConnect.setBounds(303, 18, 68, 28);
		frameChatGui.getContentPane().add(btnDisConnect);

		textState = new Label("");
		textState.setBounds(6, 570, 158, 22);
		textState.setVisible(false);
		frameChatGui.getContentPane().add(textState);

		txtDisplayChat = new JTextPane();
		txtDisplayChat.setBackground(SystemColor.scrollbar);
		txtDisplayChat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtDisplayChat.setEditable(false);
		txtDisplayChat.setContentType("text/html");
		txtDisplayChat.setMargin(new Insets(6, 6, 6, 6));
		txtDisplayChat.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true);
		txtDisplayChat.setBounds(6, 59, 670, 291);
		appendToPane(txtDisplayChat, "<div class='clear' style='background-color:black'/>");

		frameChatGui.getContentPane().add(txtDisplayChat);

		scrollPane = new JScrollPane(txtDisplayChat);
		scrollPane.setBounds(6, 59, 365, 207);
		frameChatGui.getContentPane().add(scrollPane);

		JScrollPane scrollListFriend = new JScrollPane();
		scrollListFriend.setBounds(395, 59, 68, 205);
		frameChatGui.getContentPane().add(scrollListFriend);

		JLabel lblFriend = new JLabel("Friends:");
		lblFriend.setForeground(Color.GREEN);
		lblFriend.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFriend.setBounds(395, 21, 68, 25);
		frameChatGui.getContentPane().add(lblFriend);

	}

	public void copyFileReceive(InputStream inputStr, OutputStream outputStr, String path) throws IOException {
		byte[] buffer = new byte[1024];
		int lenght;
		while ((lenght = inputStr.read(buffer)) > 0) {
			outputStr.write(buffer, 0, lenght);
		}
		inputStr.close();
		outputStr.close();
		File fileTemp = new File(path);
		if (fileTemp.exists()) {
			fileTemp.delete();
		}
	}

	// send html to pane
	/**
	 * @wbp.parser.entryPoint
	 */
	private void appendToPane(JTextPane tp, String message) throws BadLocationException, IOException {
		HTMLDocument docHtml = (HTMLDocument) tp.getDocument();
		HTMLEditorKit editorKitHtml = (HTMLEditorKit) tp.getEditorKit();

		editorKitHtml.insertHTML(docHtml, docHtml.getLength(), message, 0, 0, null);
		tp.setCaretPosition(docHtml.getLength());

	}

	public class ChatRoom extends Thread {

		private Socket connect;
		private ObjectOutputStream outPeer;
		private ObjectInputStream inPeer;
		private boolean continueSendFile = true, finishReceive = false;
		private int sizeOfSend = 0, sizeOfData = 0, sizeFile = 0, sizeReceive = 0;
		private String nameFileReceive = "";
		private InputStream inFileSend;
		private DataFile dataFile;

		public ChatRoom(Socket connection, String name, String guest) throws Exception {
			connect = new Socket();
			connect = connection;
			nameGuest = guest;
		}

		@Override
		public void run() {
			super.run();
			OutputStream out = null;
			while (!isStop) {
				try {
					inPeer = new ObjectInputStream(connect.getInputStream());
					Object obj = inPeer.readObject();
					if (obj instanceof String) {
						String messageObj = obj.toString();
						if (messageObj.equals(Dictionary.CHAT_CLOSE)) {
							isStop = true;
							Dictionary.show(frameChatGui,
									nameGuest + " closed chat with you! This windows will also be closed.", false);
							try {
								isStop = true;
								frameChatGui.dispose();
								chat.sendMessage(Dictionary.CHAT_CLOSE);
								chat.stopChat();
							} catch (Exception e) {
								e.printStackTrace();
							}
							connect.close();
							break;
						}
						if (Decryption.checkFile(messageObj)) {
							isReceiveFile = true;
							nameFileReceive = messageObj.substring(10, messageObj.length() - 11);
							int result = Dictionary.show(frameChatGui,
									nameGuest + " send file " + nameFileReceive + " for you", true);
							if (result == 0) {
								File fileReceive = new File(URL + TEMP + "/" + nameFileReceive);
								if (!fileReceive.exists()) {
									fileReceive.createNewFile();
								}
								String message = Dictionary.FILE_REQ_ACK_OPEN + Integer.toBinaryString(portServer)
										+ Dictionary.FILE_REQ_ACK_CLOSE;
								sendMessage(message);
							} else {
								sendMessage(Dictionary.FILE_REQ_NOACK);
							}
						} else if (Decryption.checkFeedBack(messageObj)) {
							btnChoose.setEnabled(false);

							new Thread(() -> {

								try {
									sendMessage(Dictionary.FILE_DATA_BEGIN);
									updateChatNotify("Sending file: " + nameFile);
									isSendFile = false;
									sendFile(txtPath.getText());
								} catch (Exception e) {
									e.printStackTrace();
								}

							}).start();
						} else if (messageObj.equals(Dictionary.FILE_REQ_NOACK)) {
							Dictionary.show(frameChatGui, nameGuest + " don't want receive file", false);
						} else if (messageObj.equals(Dictionary.FILE_DATA_BEGIN)) {
							finishReceive = false;
							lblReceive.setVisible(true);
							out = new FileOutputStream(URL + TEMP + nameFileReceive);
						} else if (messageObj.equals(Dictionary.FILE_DATA_CLOSE)) {
							updateChatReceive(
									"Receive file: " + nameFileReceive + " with size " + sizeReceive + " KB");
							sizeReceive = 0;
							out.flush();
							out.close();
							lblReceive.setVisible(false);
							new Thread(() -> {

								showSaveFile();

							}).start();
							finishReceive = true;

						} else {
							String message = Decryption.getMessage(messageObj);
							updateChatReceive(message);
						}
					} else if (obj instanceof DataFile) {
						DataFile data = (DataFile) obj;
						++sizeReceive;
						out.write(data.data);
					}
				} catch (Exception e) {
					File fileTemp = new File(URL + TEMP + nameFileReceive);
					if (fileTemp.exists() && !finishReceive) {
						fileTemp.delete();
					}
				}
			}
		}

		private void getData(String path) throws Exception {
			File fileData = new File(path);
			if (fileData.exists()) {
				sizeOfSend = 0;
				dataFile = new DataFile();
				sizeFile = (int) fileData.length();
				sizeOfData = sizeFile % 1024 == 0 ? (int) (fileData.length() / 1024)
						: (int) (fileData.length() / 1024) + 1;
				inFileSend = new FileInputStream(fileData);
			}
		}

		public void sendFile(String path) throws Exception {
			getData(path);
			textState.setVisible(true);
			if (sizeOfData > Dictionary.MAX_MSG_SIZE / 1024) {
				textState.setText("File is too huge...");
				inFileSend.close();
				txtPath.setText("");
				btnChoose.setEnabled(true);
				isSendFile = false;
				inFileSend.close();
				return;
			}

			progressSendFile.setVisible(true);
			progressSendFile.setValue(0);

			textState.setText("uploading ...");
			do {
				if (continueSendFile) {
					continueSendFile = false;

					new Thread(() -> {

						try {
							inFileSend.read(dataFile.data);
							sendMessage(dataFile);
							sizeOfSend++;
							if (sizeOfSend == sizeOfData - 1) {
								int size = sizeFile - sizeOfSend * 1024;
								dataFile = new DataFile(size);
							}
							progressSendFile.setValue((int) (sizeOfSend * 100 / sizeOfData));
							if (sizeOfSend >= sizeOfData) {
								inFileSend.close();
								isSendFile = true;
								sendMessage(Dictionary.FILE_DATA_CLOSE);
								progressSendFile.setVisible(false);
								textState.setVisible(false);
								isSendFile = false;
								txtPath.setText("");
								btnChoose.setEnabled(true);
								updateChatNotify("Completed!");
								inFileSend.close();
							}
							continueSendFile = true;
						} catch (Exception e) {
							e.printStackTrace();
						}

					}).start();
				}
			} while (sizeOfSend < sizeOfData);
		}

		private void showSaveFile() {
			while (true) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int result = fileChooser.showSaveDialog(frameChatGui);
				if (result == JFileChooser.APPROVE_OPTION) {
					File file = new File(fileChooser.getSelectedFile().getAbsolutePath() + "/" + nameFileReceive);
					if (!file.exists()) {
						try {
							file.createNewFile();
							Thread.sleep(1000);
							InputStream input = new FileInputStream(URL + TEMP + nameFileReceive);
							OutputStream output = new FileOutputStream(file.getAbsolutePath());
							copyFileReceive(input, output, URL + TEMP + nameFileReceive);
						} catch (Exception e) {
							Dictionary.show(frameChatGui, "Your file receive has error!!!", false);
						}
						break;
					} else {
						int resultContinue = Dictionary.show(frameChatGui, "File is exists. You want save file?", true);
						if (resultContinue == 0)
							continue;
						else
							break;
					}
				}
			}
		}

		// void send Message
		public synchronized void sendMessage(Object obj) throws Exception {
			outPeer = new ObjectOutputStream(connect.getOutputStream());
			// only send text
			if (obj instanceof String) {
				String message = obj.toString();
				outPeer.writeObject(message);
				outPeer.flush();
				if (isReceiveFile)
					isReceiveFile = false;
			}
			// send attach file
			else if (obj instanceof DataFile) {
				outPeer.writeObject(obj);
				outPeer.flush();
			}
		}

		public void stopChat() {
			try {
				connect.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
