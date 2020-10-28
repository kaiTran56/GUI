package com.tranquyet.client;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import com.tranquyet.dictionary.Dictionary;

public class FriendListGui {

	private Client clientNode;
	private static String IPClient = "", nameUser = "", dataUser = "";
	private static int portClient = 0;
	private JFrame frameFriendTable;
	private JTextField txtNameFriend;
	private JButton btnChat, btnExit;
	private JLabel lblLogo;
	private JLabel lblActiveNow;
	private static JList<String> listActive;

	static DefaultListModel<String> model = new DefaultListModel<>();
	private JLabel lblUsername;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {

			try {
				FriendListGui window = new FriendListGui();
				window.frameFriendTable.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
	}

	public FriendListGui(String arg, int arg1, String name, String message) throws Exception {
		IPClient = arg;
		portClient = arg1;
		nameUser = name;
		dataUser = message;
		EventQueue.invokeLater(() -> {

			try {
				FriendListGui window = new FriendListGui();
				window.frameFriendTable.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
	}

	public FriendListGui() throws Exception {
		initialize();
		clientNode = new Client(IPClient, portClient, nameUser, dataUser);
	}

	public static void updateFriendFriendTable(String message) {
		model.addElement(message);
	}

	public static void resetList() {
		model.clear();
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frameFriendTable = new JFrame();
		frameFriendTable.setResizable(false);
		frameFriendTable.setForeground(Color.BLACK);
		frameFriendTable.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		frameFriendTable.setBackground(Color.BLACK);
		frameFriendTable.getContentPane().setBackground(Color.LIGHT_GRAY);
		frameFriendTable.setTitle("Friend Table");
		frameFriendTable.setBounds(100, 100, 272, 450);
		frameFriendTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameFriendTable.getContentPane().setLayout(null);

		JLabel lblHello = new JLabel("Welcome: ");
		lblHello.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		lblHello.setBounds(12, 82, 76, 16);
		frameFriendTable.getContentPane().add(lblHello);

		JLabel lblFriendsName = new JLabel("Name: ");
		lblFriendsName.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblFriendsName.setBounds(12, 254, 110, 16);
		frameFriendTable.getContentPane().add(lblFriendsName);

		txtNameFriend = new JTextField("");
		txtNameFriend.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtNameFriend.setColumns(10);
		txtNameFriend.setBounds(64, 250, 188, 28);
		frameFriendTable.getContentPane().add(txtNameFriend);

		btnChat = new JButton("Chat");
		btnChat.setFont(new Font("SansSerif", Font.BOLD, 15));

		btnChat.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String name = txtNameFriend.getText();
				if (name.equals("") || Client.userList == null) {
					Dictionary.show(frameFriendTable, "Invaild username", false);
					return;
				}
				if (name.equals(nameUser)) {
					Dictionary.show(frameFriendTable, "This software doesn't support chat yourself function", false);
					return;
				}

				Client.userList.stream().forEach(p -> {
					if (p.getName().equals(name)) {
						try {
							clientNode.intialNewChat(p.getHost(), p.getPort(), name);
						} catch (Exception e) {
							Dictionary.show(frameFriendTable,
									"Friend is not found. Please wait to update your list friend", false);
							e.printStackTrace();
						}
					}
				});

			}
		});
		btnChat.setBounds(10, 289, 94, 44);
		frameFriendTable.getContentPane().add(btnChat);

		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = Dictionary.show(frameFriendTable, "Are you sure ?", true);
				if (result == 0) {
					try {
						clientNode.exit();
						frameFriendTable.dispose();
						System.exit(0);
					} catch (Exception e) {
						frameFriendTable.dispose();
						System.exit(0);
					}
				}
			}
		});
		btnExit.setBounds(149, 289, 104, 44);

		frameFriendTable.getContentPane().add(btnExit);

		lblLogo = new JLabel("List Friends");
		lblLogo.setForeground(Color.BLACK);

		lblLogo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogo.setBounds(87, 11, 110, 38);
		frameFriendTable.getContentPane().add(lblLogo);

		lblActiveNow = new JLabel("Friends:");
		lblActiveNow.setForeground(new Color(0, 0, 255));
		lblActiveNow.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		lblActiveNow.setBounds(10, 123, 156, 16);
		frameFriendTable.getContentPane().add(lblActiveNow);

		listActive = new JList<>(model);
		listActive.setForeground(Color.BLUE);
		listActive.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		listActive.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String value = (String) listActive.getModel().getElementAt(listActive.locationToIndex(arg0.getPoint()));
				txtNameFriend.setText(value);
			}
		});
		listActive.setBounds(12, 144, 240, 99);
		frameFriendTable.getContentPane().add(listActive);

		lblUsername = new JLabel(nameUser);
		lblUsername.setForeground(Color.RED);
		lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblUsername.setBounds(87, 72, 165, 40);
		frameFriendTable.getContentPane().add(lblUsername);

	}

	public static int request(String message, boolean type) {
		JFrame frameMessage = new JFrame();
		return Dictionary.show(frameMessage, message, type);
	}
}
