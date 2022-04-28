package GymRats;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.User;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrainerMenu {

	JFrame frame;
	private JTable table;
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
					TrainerMenu window = new TrainerMenu(user);
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
	public TrainerMenu(User user) {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 609, 619);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(216, 41, 194, 27);
		frame.getContentPane().add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(216, 90, 194, 27);
		frame.getContentPane().add(comboBox_1);

		JLabel userLabel = new JLabel("Choose user:");
		userLabel.setBounds(80, 45, 124, 16);
		frame.getContentPane().add(userLabel);

		JLabel cWorkoutLabel = new JLabel("Choose workout:");
		cWorkoutLabel.setBounds(80, 94, 124, 16);
		frame.getContentPane().add(cWorkoutLabel);

		JLabel trainLabel = new JLabel("Trainer Center");
		trainLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		trainLabel.setBounds(208, 13, 136, 16);
		frame.getContentPane().add(trainLabel);

		JButton viewButton = new JButton("View");
		viewButton.setBounds(359, 129, 117, 29);
		frame.getContentPane().add(viewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(76, 187, 400, 136);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(table);

		JLabel addCLabel = new JLabel("Add comments below:");
		addCLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		addCLabel.setBounds(74, 361, 211, 16);
		frame.getContentPane().add(addCLabel);

		JTextArea commentTA = new JTextArea();
		commentTA.setBounds(74, 389, 400, 89);
		frame.getContentPane().add(commentTA);

		JButton btnComment = new JButton("Add Comment");
		btnComment.setBounds(216, 491, 123, 25);
		frame.getContentPane().add(btnComment);

		JButton btnMenu = new JButton("Main Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainMenu men = new MainMenu(user);
				men.frame.setVisible(true);
			}
		});
		btnMenu.setBounds(216, 534, 123, 25);
		frame.getContentPane().add(btnMenu);

	}
}
