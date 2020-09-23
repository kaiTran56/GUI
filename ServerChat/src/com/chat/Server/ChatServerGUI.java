package com.chat.Server;

import java.awt.Color;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author TranKai
 */
public class ChatServerGUI extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates new form ChatServerGUI
	 */
	public ChatServerGUI() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		initComponents();
	}

	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		lblServer = new javax.swing.JLabel();
		btnStart = new javax.swing.JButton();
		btnStop = new javax.swing.JButton();
		lblPort = new javax.swing.JLabel();
		txtPort = new javax.swing.JTextField();
		lblStatus = new javax.swing.JLabel();
		textPort = new javax.swing.JTextField();
		lblLog = new javax.swing.JLabel();
		txtMessage = new java.awt.TextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(204, 204, 204));

		lblServer.setBackground(new java.awt.Color(102, 102, 255));
		lblServer.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
		lblServer.setForeground(new java.awt.Color(102, 102, 255));
		lblServer.setText("SERVER ");

		btnStart.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
		btnStart.setForeground(new java.awt.Color(51, 255, 51));
		btnStart.setText("Start");

		btnStop.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
		btnStop.setForeground(new java.awt.Color(255, 51, 51));
		btnStop.setText("Stop");
		btnStop.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					server.getDiscontion();
					ChatServerGUI.updatedMessage("Stop Server!");
					lblStatus.setText("<html><font color='red'>OFF</font></html>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					ChatServerGUI.updatedMessage("Stop Server!");
					lblStatus.setText("<html><font color='red'>OFF</font></html>");
				}

			}
		});

		lblPort.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
		lblPort.setText("Port: ");

		txtPort.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
		txtPort.setText("8080");
		txtPort.setEditable(false);
		txtPort.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtPortActionPerformed(evt);
			}
		});

		lblStatus.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
		lblStatus.setText("Status: ");

		textPort.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
		textPort.setText("jTextField2");

		lblLog.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
		lblLog.setText("Log");
		lblLog.setMaximumSize(new java.awt.Dimension(30, 15));

		txtMessage.setBackground(new java.awt.Color(0, 0, 0));
		txtMessage.setForeground(new java.awt.Color(0, 255, 0));
		txtMessage.setEditable(false);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout
				.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
								layout.createSequentialGroup().addGap(0, 213, Short.MAX_VALUE).addComponent(btnStart)
										.addGap(21).addComponent(btnStop, GroupLayout.PREFERRED_SIZE, 77,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, layout.createSequentialGroup().addContainerGap()
										.addGroup(layout.createParallelGroup(Alignment.LEADING)
												.addComponent(txtMessage, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(layout.createSequentialGroup()
														.addGroup(layout.createParallelGroup(Alignment.LEADING)
																.addComponent(lblPort).addComponent(lblStatus))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(layout.createParallelGroup(Alignment.LEADING)
																.addComponent(textPort, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(txtPort, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
														.addGap(0, 244, Short.MAX_VALUE))))
								.addGroup(Alignment.TRAILING,
										layout.createSequentialGroup().addGap(21)
												.addComponent(lblLog, GroupLayout.PREFERRED_SIZE, 48,
														GroupLayout.PREFERRED_SIZE)
												.addGap(0, 238, Short.MAX_VALUE)))
						.addContainerGap())
				.addGroup(Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(171, Short.MAX_VALUE)
						.addComponent(lblServer).addGap(157)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap().addComponent(lblServer, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
				.addGap(23).addComponent(lblLog, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE).addGap(1)
				.addComponent(txtMessage, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(27)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(lblPort).addComponent(txtPort,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(lblStatus).addComponent(textPort,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnStop, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(82, Short.MAX_VALUE)));
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>

	private void txtPortActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ChatServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ChatServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ChatServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ChatServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ChatServerGUI().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton btnStart;
	private javax.swing.JButton btnStop;
	private javax.swing.JLabel lblLog;
	private javax.swing.JLabel lblPort;
	private javax.swing.JLabel lblServer;
	private javax.swing.JLabel lblStatus;
	private javax.swing.JTextField textPort;
	private static java.awt.TextArea txtMessage;
	private javax.swing.JTextField txtPort;
	// End of variables declaration
	private Server server;

	public static void updatedMessage(String msg) {
		txtMessage.append(msg + "\n");
	}

}
