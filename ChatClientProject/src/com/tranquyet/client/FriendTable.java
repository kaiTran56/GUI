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

public class FriendTable {

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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FriendTable window = new FriendTable();
					window.frameFriendTable.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FriendTable(String arg, int arg1, String name, String msg) throws Exception {
		IPClient = arg;
		portClient = arg1;
		nameUser = name;
		dataUser = msg;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FriendTable window = new FriendTable();
					window.frameFriendTable.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FriendTable() throws Exception {
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
		frameFriendTable.setTitle("Menu Chat");
		frameFriendTable.setResizable(false);
		frameFriendTable.setBounds(100, 100, 500, 560);
		frameFriendTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameFriendTable.getContentPane().setLayout(null);

		JLabel lblHello = new JLabel("Welcome");
		lblHello.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblHello.setBounds(12, 82, 70, 16);
		frameFriendTable.getContentPane().add(lblHello);


		JLabel lblFriendsName = new JLabel("Name Friend: ");
		lblFriendsName.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblFriendsName.setBounds(12, 425, 110, 16);
		frameFriendTable.getContentPane().add(lblFriendsName);
		
		txtNameFriend = new JTextField("");
		txtNameFriend.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtNameFriend.setColumns(10);
		txtNameFriend.setBounds(100, 419, 384, 28);
		frameFriendTable.getContentPane().add(txtNameFriend);

		btnChat = new JButton("Chat");
		btnChat.setFont(new Font("Segoe UI", Font.PLAIN, 13));

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
							clientNode.intialNewChat(Client.userList.get(i).getHost(),Client.userList.get(i).getPort(), name);
							return;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				Dictionary.show(frameFriendTable, "Friend is not found. Please wait to update your list friend", false);
			}
		});
		btnChat.setBounds(20, 465, 129, 44);
		frameFriendTable.getContentPane().add(btnChat);
		
		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Segoe UI", Font.PLAIN, 13));
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
		btnExit.setBounds(353, 465, 129, 44);
		
		frameFriendTable.getContentPane().add(btnExit);
		
		lblLogo = new JLabel("CONNECT WITH EVERYONE IN THE WORLD");
		lblLogo.setForeground(new Color(0, 0, 205));
		
		lblLogo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogo.setBounds(51, 13, 413, 38);
		frameFriendTable.getContentPane().add(lblLogo);
		
		lblActiveNow = new JLabel("List Account Active Now");
		lblActiveNow.setForeground(new Color(100, 149, 237));
		lblActiveNow.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblActiveNow.setBounds(10, 123, 156, 16);
		frameFriendTable.getContentPane().add(lblActiveNow);
		
		listActive = new JList<>(model);
		listActive.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		listActive.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String value = (String)listActive.getModel().getElementAt(listActive.locationToIndex(arg0.getPoint()));
				txtNameFriend.setText(value);
			}
		});
		listActive.setBounds(12, 152, 472, 251);
		frameFriendTable.getContentPane().add(listActive);
		
		lblUsername = new JLabel(nameUser);
		lblUsername.setForeground(Color.RED);
		lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblUsername.setBounds(75, 76, 156, 28);
		frameFriendTable.getContentPane().add(lblUsername);
	
			
	}
		

	public static int request(String msg, boolean type) {
		JFrame frameMessage = new JFrame();
		return Dictionary.show(frameMessage, msg, type);
	}
}
