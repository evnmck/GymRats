package GymRats;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import models.User;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class MainMenu {

	JFrame frame;
	static User user = null;
	private static String connectionUrl = "jdbc:mysql://127.0.0.1:3306/gymrats"; // could be different
	private static String dbUsername = "root"; // replace with your username (most likely "root")
	private static String dbPassword = "382682498Mck!"; // replace with your password

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu(user);
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
	public MainMenu(User user) {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 525, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel mainLbl = new JLabel("WELCOME " + user.getFName().toUpperCase() + " " + user.getLName().toUpperCase());
		mainLbl.setHorizontalAlignment(SwingConstants.CENTER);
		mainLbl.setBounds(174, 28, 157, 46);
		frame.getContentPane().add(mainLbl);

		JButton addWOButton = new JButton("Workouts");
		addWOButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				// WorkoutWindow wo = new WorkoutWindow(user);
				// wo.frame.setVisible(true);
			}
		});
		addWOButton.setBounds(196, 146, 109, 25);
		frame.getContentPane().add(addWOButton);

		JButton progressButton = new JButton("Progress");
		progressButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				// ProgressMenu men = new ProgressMenu(user);
				// men.frame.setVisible(true);
			}
		});
		progressButton.setBounds(196, 195, 109, 25);
		frame.getContentPane().add(progressButton);

		JButton profileButton = new JButton("Edit Profile");
		profileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ProfileWindow pro = new ProfileWindow(user);
				// pro.frame.setVisible(true);
				frame.dispose();
			}
		});
		profileButton.setBounds(196, 245, 109, 25);
		frame.getContentPane().add(profileButton);

		JButton trainerButton = new JButton("Trainer Tab");
		if (!user.isTrainer()) {
			trainerButton.setEnabled(false);
		}

		trainerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				// TrainerMenu tMenu = new TrainerMenu(user);
				// tMenu.frame.setVisible(true);
			}
		});
		trainerButton.setBounds(196, 290, 109, 25);
		frame.getContentPane().add(trainerButton);

		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login log = null;
				try {
					log = new Login(connectionUrl, dbUsername, dbPassword);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				log.frame.setVisible(true);
			}
		});
		logoutButton.setBounds(12, 406, 109, 25);
		frame.getContentPane().add(logoutButton);
	}
}
