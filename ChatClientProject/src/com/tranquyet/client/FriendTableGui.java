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
import javax.swing.UIManager;
import java.awt.SystemColor;

public class FriendTableGui {

	private Client clientNode;
	private static String IPClient = "", nameUser = "", dataUser = "";
	private static int portClient = 0;
	private JFrame frameFriendTable;
	private JTextField txtNameFriend;
	private JButton btnChat, btnExit;
	private JLabel lblFriend;
	private JLabel lblActiveNow;
	private static JList<String> listActive;

	static DefaultListModel<String> model = new DefaultListModel<>();
	private JLabel lblUsername;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FriendTableGui window = new FriendTableGui();
					window.frameFriendTable.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FriendTableGui(String arg, int arg1, String name, String msg) throws Exception {
		IPClient = arg;
		portClient = arg1;
		nameUser = name;
		dataUser = msg;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FriendTableGui window = new FriendTableGui();
					window.frameFriendTable.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FriendTableGui() throws Exception {
		initialize();
		clientNode = new Client(IPClient, portClient, nameUser, dataUser);
	}

	public static void updateFriendFriendTable(String msg) {
		model.addElement(msg);
	}

	public static void resetList() {
		model.clear();
	}

	private void initialize() {
		frameFriendTable = new JFrame();
		frameFriendTable.setBackground(SystemColor.controlShadow);
		frameFriendTable.getContentPane().setBackground(SystemColor.windowBorder);
		frameFriendTable.setTitle("List Friends");
		frameFriendTable.setResizable(false);
		frameFriendTable.setBounds(100, 100, 245, 540);
		frameFriendTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameFriendTable.getContentPane().setLayout(null);

		JLabel lblHello = new JLabel("Welcome: ");
		lblHello.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblHello.setBounds(12, 61, 70, 16);
		frameFriendTable.getContentPane().add(lblHello);

		JLabel lblFriendsName = new JLabel("Friend: ");
		lblFriendsName.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblFriendsName.setBounds(22, 382, 48, 16);
		frameFriendTable.getContentPane().add(lblFriendsName);

		txtNameFriend = new JTextField("");
		txtNameFriend.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtNameFriend.setColumns(10);
		txtNameFriend.setBounds(75, 377, 134, 28);
		frameFriendTable.getContentPane().add(txtNameFriend);

		btnChat = new JButton("Chat");
		btnChat.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 14));

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
				int size = Client.userList.size();
				for (int i = 0; i < size; i++) {
					if (name.equals(Client.userList.get(i).getName())) {
						try {
							clientNode.intialNewChat(Client.userList.get(i).getHost(), Client.userList.get(i).getPort(),
									name);
							return;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				Dictionary.show(frameFriendTable, "Friend is not found. Please wait to update your list friend", false);
			}
		});
		btnChat.setBounds(12, 441, 70, 38);
		frameFriendTable.getContentPane().add(btnChat);

		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 14));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = Dictionary.show(frameFriendTable, "Are you sure ?", true);
				if (result == 0) {
					try {
						clientNode.exit();
						frameFriendTable.dispose();
					} catch (Exception e) {
						frameFriendTable.dispose();
					}
				}
			}
		});
		btnExit.setBounds(152, 441, 77, 38);

		frameFriendTable.getContentPane().add(btnExit);

		lblFriend = new JLabel("List Your Freinds");
		lblFriend.setForeground(new Color(0, 255, 0));

		lblFriend.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblFriend.setBounds(44, 0, 156, 38);
		frameFriendTable.getContentPane().add(lblFriend);

		lblActiveNow = new JLabel("Now: ");
		lblActiveNow.setForeground(new Color(0, 255, 0));
		lblActiveNow.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblActiveNow.setBounds(12, 99, 48, 16);
		frameFriendTable.getContentPane().add(lblActiveNow);

		listActive = new JList<>(model);
		listActive.setBackground(SystemColor.scrollbar);
		listActive.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		listActive.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String value = (String) listActive.getModel().getElementAt(listActive.locationToIndex(arg0.getPoint()));
				txtNameFriend.setText(value);
			}
		});
		listActive.setBounds(0, 120, 239, 251);
		frameFriendTable.getContentPane().add(listActive);

		lblUsername = new JLabel(nameUser);
		lblUsername.setForeground(UIManager.getColor("Tree.selectionBackground"));
		lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblUsername.setBounds(75, 49, 126, 28);
		frameFriendTable.getContentPane().add(lblUsername);

	}

	public static int request(String msg, boolean type) {
		JFrame frameMessage = new JFrame();
		return Dictionary.show(frameMessage, msg, type);
	}
}
