package GymRats;

import java.awt.EventQueue;
import controllers.BodyProgressController;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.BodyProgress;
import models.User;
import javax.swing.JScrollPane;

public class ProgressMenu {

	JFrame frame;
	static User user;
	
	
	private static String connectionUrl = "jdbc:mysql://127.0.0.1:3306/gymrats"; // could be different
    private static String dbUsername = "root"; // replace with your username (most likely "root")
    private static String dbPassword = "@pranav123"; // replace with your password

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgressMenu window = new ProgressMenu(user);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProgressMenu(User user) {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnEntry = new JButton("New Entry");
		btnEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PEntryWindow entry = new PEntryWindow(user);
				entry.frame.setVisible(true);
			}
		});
		btnEntry.setBounds(195, 75, 97, 25);
		frame.getContentPane().add(btnEntry);

		JLabel pLbl = new JLabel(
				"Progress Page for " + user.getFName().toUpperCase() + " " + user.getLName().toUpperCase());
		pLbl.setBounds(118, 29, 263, 33);
		frame.getContentPane().add(pLbl);

		JComboBox progressBox = new JComboBox();
		progressBox.setBounds(114, 152, 286, 25);
		frame.getContentPane().add(progressBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 221, 400, 136);
		frame.getContentPane().add(scrollPane);

		JButton btnMenu = new JButton("Main Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainMenu men = new MainMenu(user);
				men.frame.setVisible(true);
			}
		});
		btnMenu.setBounds(195, 395, 97, 25);
		frame.getContentPane().add(btnMenu);
		
		BodyProgressController bodyprog = new BodyProgressController(connectionUrl,dbUsername, dbPassword);
		public void actionPerformed(ActionEvent e) {
			
			
			
			ArrayList<BodyProgress> bodyprog1 = bodyprog.getBodyProgressesForUser(user.getUId());
			
			for(int i; i < bodyprog1.size(); i++) {
				
				String[] row;
				row[0] = bodyprog1.get(0).toString();
				
				
				
				
				
				
				
			}
			
			
			
			
			
		}
		
		
		
	}
}
